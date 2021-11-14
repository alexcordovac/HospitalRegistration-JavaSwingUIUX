/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.servidor;

import controladores.ControladorRegistroPaciente;
import dao.ConsultaDAO;
import formularios.GenerarDatosRandom;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import modelos.Consulta;

/**
 *
 * @author Alex
 */
public class EchoThread extends Thread {

    private final ConsultaDAO consultaDao;
    private final ControladorRegistroPaciente ctrlRegistroPaciente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
        consultaDao = new ConsultaDAO();
        ctrlRegistroPaciente = new ControladorRegistroPaciente();
    }

    @Override
    public synchronized void run() {
        String mensajeEntrada = "";
        try {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            while (!mensajeEntrada.equals("salir")) {
                mensajeEntrada = entrada.readUTF();

                switch (mensajeEntrada) {
                    case "obtenerConsultas": {
                        List<Consulta> listaConsultas = consultaDao.obtenerConsultas();
                        enviarConsultas(listaConsultas);
                        break;
                    }
                    case "registrarPaciente": {
                        GenerarDatosRandom datosRandom = new GenerarDatosRandom();

                        //Leemos el registro del paciente desde el cliente
                        Consulta consultaTmp = procesarRegistroPaciente();

                        //Pintamos una nueva solicitud procesando
                        FormProcesandoSolicitudItem form = new FormProcesandoSolicitudItem(consultaTmp.getNombrePaciente(), consultaTmp.getNss(), consultaTmp.getSintomas());
                        try {
                            ctrlRegistroPaciente.pintarNuevoRegistro(form);
                        } catch (InterruptedException ex) {
                            System.err.println("Error al pintar el registro entrante");
                            System.err.println(ex.getMessage());
                        }

                        //Aasignamos campos restantes a la consulta/registro
                        consultaTmp.setNoTurno(consultaDao.obtenerUltimoTurno() + 1);
                        consultaTmp.setNombreDoctor(datosRandom.generarNombreDoctor());
                        consultaTmp.setNoConsultorio(datosRandom.generarNumeroConsultorio());

                        //Lo guardamos en la base de datos
                        consultaDao.insertarConsulta(consultaTmp);

                        //Traemos la consulta insertada ya con el id aplicado por la BD
                        consultaTmp = consultaDao.obtenerUltimaConsulta();

                        //Enviamos la consulta ya con los datos al cliente
                        enviarRegistroPaciente(consultaTmp);

                        //Pintamos la nueva consulta/registro en el historial
                        ctrlRegistroPaciente.getListaConsultas().add(consultaTmp);
                        ctrlRegistroPaciente.pintarHistorialPacientes();

                        //Eliminar la nueva solicitud procesando
                        try {

                            ctrlRegistroPaciente.eliminarPanelProcesandoRegistro(form);
                        } catch (InterruptedException ex) {
                            System.err.println("Error al eliminar el registro entrante");
                            System.err.println(ex.getMessage());
                        }

                        break;
                    }
                    default: {
                        System.out.println("Cliente dice: " + mensajeEntrada);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error método run echothread");
            System.err.println(e);
        }
    }

    private Consulta procesarRegistroPaciente() {
        /*Leemos la consulta/registro*/
        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Consulta cons = (Consulta) objectInputStream.readObject();
            return cons;
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException al obtener consulta/registro");
        } catch (IOException ex) {
            System.err.println("IOException al obtener consulta/registro");
            ex.getMessage();
            ex.printStackTrace();
        }
        return null;
    }

    private void enviarRegistroPaciente(Consulta cons) {
        /*Enviamos el registro del paciente*/
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(cons);
            outputStream.flush();
            objectOutputStream.flush();
        } catch (IOException ex) {
            System.err.println("Error devolver registro de paciente al cliente");
        }
    }

    /*Método para obtener todas las consultas de la base de datos utilizando la clase DAO*/
    private void enviarConsultas(List<Consulta> lista) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(lista);
            outputStream.flush();
            objectOutputStream.flush();
        } catch (IOException ex) {
            System.err.println("Error al obtener consultas");
        }
    }
}
