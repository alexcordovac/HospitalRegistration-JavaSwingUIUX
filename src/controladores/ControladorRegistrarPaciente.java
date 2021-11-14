/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import formulario.cliente.ClienteSocket;
import formulario.cliente.FormConsultaItem;
import formulario.cliente.FormRegistrarPaciente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import jiconfont.swing.IconFontSwing;
import modelos.Consulta;
import recursos.iconos.GoogleMaterialDesignIcons;
import utiles.Constantes;

/**
 *
 * @author Alex
 */
public class ControladorRegistrarPaciente {

    //Vista
    FormRegistrarPaciente vista;
    //Timer para conectar automáticamente al servidor al inicio del programa
    Timer timerConectar;
    //Timner para hacer un "ping" al servidor y comproba la conexión si sigue activa
    Timer timerTestConexion;
    //Mouselistener para el botón conectar
    MouseListener mlbtnConectar;
    //Lista de consultas
    List<Consulta> lista;

    public ControladorRegistrarPaciente() {
    }

    public ControladorRegistrarPaciente(FormRegistrarPaciente vista) {
        this.vista = vista;
        iniComponentes();

        //Intentamos conectar cada 5 segundos
        iniConexion();
    }

    /*Función para pintar el historial de registros*/
    public void pintarHistorialPacientes() {
        JPanel panel = vista.getPanelHistorialPacientes();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        for (int i = lista.size() - 1; i >= 0; i--) {
            FormConsultaItem itemConsulta = new FormConsultaItem(lista.get(i));
            panel.add(itemConsulta);
            panel.add(Box.createRigidArea(new Dimension(5, 15)));
        }
        panel.revalidate();
    }

    /*Método para inicializar algunos componentes de la vista*/
    private void iniComponentes() {
        /*Inicializa lista de consultas/registros*/
        lista = new ArrayList<>();
        
        //Eventos del panel del estado de conexión al servidor
        mlbtnConectar = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                conectarDesconectarCliente();
                
                /*Activamos botón registrar y limpiamos el formulario*/
                vista.getBtnRegistrar().setEnabled(true);
                vista.limpiarFormulario();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (ClienteSocket.estadoConexion) {
                    ((JPanel) e.getSource()).setBackground(new Color(0, 153, 89));
                } else {
                    ((JPanel) e.getSource()).setBackground(new Color(255, 90, 17));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (ClienteSocket.estadoConexion) {
                    ((JPanel) e.getSource()).setBackground(new Color(0, 181, 105));
                } else {
                    ((JPanel) e.getSource()).setBackground(new Color(255, 55, 0));
                }
            }
        };
        vista.getjPanel8().addMouseListener(mlbtnConectar);

        /*Eventos del botón detener conexión automática*/
        vista.getLblDetenerConexionAutomaticaIcono().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (timerConectar != null) {
                    timerConectar.stop();
                }
                vista.getLblMensajeServidor().setText("");
                vista.getLblDetenerConexionAutomaticaIcono().setIcon(null);
                vista.getLblDetenerConexionAutomaticaIcono().removeMouseListener(this);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        /*Evento del botón registrar paciente*/
        vista.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thTmp = new Thread(new Runnable() {
                    @Override
                    public synchronized void run() {
                        if (vista.getTxtNombrePaciente().getText().isEmpty()
                                || vista.getTxtNss().getText().isEmpty()
                                || vista.getTxtRegistrarSintomas().getText().isEmpty()
                                || !ClienteSocket.estadoConexion) {
                            JOptionPane.showMessageDialog(null, "Ingrese todo los datos o verfique conexion con el servidor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        //Desactivar botón registrar
                        vista.getBtnRegistrar().setEnabled(false);
                        
                        //Pintamos el spinner en el formulario de registrar paciente
                        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/recursos/iconos/spinner.gif"));
                        ImageIcon imagen2 = new ImageIcon(imagen1.getImage().getScaledInstance(vista.getLblSpinner().getWidth(), vista.getLblSpinner().getHeight(), Image.SCALE_DEFAULT));
                        vista.getLblSpinner().setIcon(imagen2);

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                        }

                        //Creamos el registro con los datos del formulario
                        String nombrePaciente = vista.getTxtNombrePaciente().getText();
                        String nss = vista.getTxtNss().getText();
                        String sintomas = vista.getTxtRegistrarSintomas().getText();
                        Consulta cons = new Consulta(nombrePaciente, nss, sintomas);

                        //Enviamos al servidor
                        Consulta respuesta = ClienteSocket.registrarPaciente(cons);
                        
                        //La agregamos a la lista
                        lista.add(respuesta);

                        //Repintamos el historial
                        pintarHistorialPacientes();

                        //Limpiamos el formulario
                        vista.limpiarFormulario();

                        //Detenemos el spinner
                        vista.getLblSpinner().setIcon(null);
                        
                        //Activamos el botón registrar
                        vista.getBtnRegistrar().setEnabled(true);
                        
                        //Mensaje de agregado correctamente
                        JOptionPane.showMessageDialog(null, "Paciente registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                thTmp.start();

            }//ActionPerformed
        });//ActionListener
    }

    /*Método para controlar el botón conectar y desconectar el cliente*/
    private void conectarDesconectarCliente() {
        new Thread(() -> {
            vista.getjPanel8().setEnabled(false);

            /*Si hay una conexión desconectamos*/
            if (ClienteSocket.estadoConexion) {
                desconectarCliente();
            } else {

                conectarCliente();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            vista.getjPanel8().setEnabled(true);
            vista.getLblMensajeServidor().setText("");

        }).start();

    }

    private void desconectarCliente() {
        ClienteSocket.desconectar();
        /*Si logró desconectar, pintamos el panel como desconectado*/
        if (!ClienteSocket.estadoConexion) {
            servidorDesconectadoPanel();
        } else {
            /*Si no logró desconectar, lo ponemos como conectado*/
            servidorConectadoPanel();
        }

    }

    private synchronized void conectarCliente() {
        vista.getLblMensajeServidor().setText("Conectando...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        /*Si no está conectado, intenamos conectar*/
        if (ClienteSocket.conectar()) {
            /*Si logró conectar, pintamos el panel  (boton de estado de conexion) como conectado*/
            servidorConectadoPanel();

            /*Obtenemos la lista de consultas*/
            List<Consulta> listaTmp = ClienteSocket.obtenerConsultas();

            /*Si la lista nueva contiene nuevos elementos
            la repintamos ya que se actualizó la lista*/
            if(lista.size() != listaTmp.size()){
                lista = listaTmp;
                pintarHistorialPacientes();
            }

            /*Si el timer está intentado conectar también lo detenemos*/
            if (timerConectar != null) {
                timerConectar.stop();
            }

            /*Quitamos el botón detener conexión automática*/
            vista.getLblDetenerConexionAutomaticaIcono().setIcon(null);

            /*Prueba de conexión cada 10s (nunca se termina de repetir)*/
            testConexion();

        } else {
            vista.getLblMensajeServidor().setText("Error al conectar...");
            servidorDesconectadoPanel();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        vista.getLblMensajeServidor().setText("");
    }

    private void iniConexion() {
        timerConectar = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread newTh = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        conectarCliente();
                        if (ClienteSocket.estadoConexion) {
                            vista.getLblDetenerConexionAutomaticaIcono().setIcon(null);
                            vista.getLblDetenerConexionAutomaticaIcono().removeMouseListener(mlbtnConectar);
                            timerConectar.stop();
                        }
                    }
                });
                newTh.start();
            }
        });
        timerConectar.start();
    }

    /*Método para testear la conexión cada 10 segundos, a partir desde 
    que se haya conectado correctamente el cliente al servidor*/
    private void testConexion() {

        timerTestConexion = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Si el ping no sale bien, se desconecta*/
                boolean isPing = false;
                try {
                    isPing = ClienteSocket.ping();
                } catch (Exception ex) {
                }
                if (!isPing) {
                    desconectarCliente();
                    ClienteSocket.estadoConexion = false;
                    timerTestConexion.stop();
                }
            }
        });
        timerTestConexion.start();
    }

    private void servidorDesconectadoPanel() {
        vista.getjPanel8().setBackground(new Color(255, 55, 0));
        vista.getLblServidorEstadoIcono().setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.REPORT_PROBLEM, 30, Constantes.COLOR_BLANCO));
        vista.getLblServidorEstado().setText("¡Desconectado!");
    }

    private void servidorConectadoPanel() {
        vista.getjPanel8().setBackground(new Color(0, 181, 105));
        vista.getLblServidorEstadoIcono().setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.DONE, 30, Constantes.COLOR_BLANCO));
        vista.getLblServidorEstado().setText("Conectado...");
    }

    /*GETTERS Y SETTERS*/
    public FormRegistrarPaciente getVista() {
        return vista;
    }

    public void setVista(FormRegistrarPaciente vista) {
        this.vista = vista;
    }

}
