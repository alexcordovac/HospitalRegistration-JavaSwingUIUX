/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.servidor;

import controladores.*;
import dao.ConsultaDAO;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.util.HashMap;
import recursos.iconos.GoogleMaterialDesignIcons;
import formularios.MenuItem;

/**
 * Controla la vista del cuerpo de la pantalla principal.
 * 1-Primera implementacion guardando las vistas en un hashmap, revalidando y repintando el cuerpo.
 * 2-(actual) Usando cardlayout en el cuerpo de la pantalla principal.
 *   Para eliminar esta opcion, borrar las lineas con el comentario test
 *   Opcionalmente cambiar el layout del panel cuerpo a grid layout con 1 columna
 *   Descomentar aquí en el mouselistener donde se llama el metodo controlarVista
 *   Descomentar en el método controlarVista las líneas comentadas
 * @author Alex
 */
public class ControladorMenuServidor {

    private final FormPrincipalServidor vista;
    private HashMap<MenuItem, JPanel> menusVistas;
    private MenuItem menuSeleccionado;

    public ControladorMenuServidor(FormPrincipalServidor vista) {
        this.vista = vista;
        iniMenus();
    }

    /*Función para crear y pintar los menus en el panelMenus de la vista principal*/
    private void iniMenus() {
        menusVistas = new HashMap<>();
        
        //Menu items
        MenuItem asignarTrabajo = new MenuItem(GoogleMaterialDesignIcons.PERSON_ADD, "Registros de pacientes");
        
        //Vistas
        FormRegistroPaciente formRegitroPaciente = new FormRegistroPaciente();
        
        /*Controladores*/
        //Controlador del formulario FormRegistroPaciente, meto en controlador en un thread por si la conexion
        //a la db no está funcional la vista cargue normal.
        ControladorRegistroPaciente ctrlRegistroPaciente = new ControladorRegistroPaciente(formRegitroPaciente);
        
        new Thread( () -> {
            try{
                ctrlRegistroPaciente.actualizarListaConsultas();
                ctrlRegistroPaciente.pintarHistorialPacientes();
            }catch(NullPointerException ex){
                System.err.println("Error al actualizar la lista de consultas/registros en el CONTROLADOR REGISTRO PACIENTE");
            }
        }).start();
        
        
        //Los guardamos en el hashmap con su respectivo formulario
        //menusVistas.put(asignarTrabajo, panelTrabajadorLayout);
       //menusVistas.put(recordsObtenidos , formRecordObtenidos);
        
        //Pintamos la lista de menus
        pintarMenuItems(asignarTrabajo);
        
        //test
        vista.getPanelCuerpo().add(formRegitroPaciente, asignarTrabajo.getName());
        vista.getPanelCuerpo().revalidate();
        //test
        //Pinto de color este menu (clickedao) porque es el que se muestra por default al iniciar
        asignarTrabajo.setColor();
        
        menuSeleccionado = asignarTrabajo;
    }
    
    private void pintarMenuItems(MenuItem... menu) {
        JPanel panelMenus = vista.getPanelMenuContenedor();
        MouseListener mouseListener = iniMouseListener();
        for (int i = 0; i < menu.length; i++) {
            panelMenus.add(menu[i]);
            menu[i].addMouseListener(mouseListener);
        }
        panelMenus.revalidate();
        panelMenus.repaint();
    }

    private MouseListener iniMouseListener() {
        MouseListener mouseListenerPanel = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controlarVista(e);
                
                //test
                ((CardLayout) vista.getPanelCuerpo().getLayout()).show(vista.getPanelCuerpo(), ((MenuItem) e.getSource()).getName());
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
        };

        return mouseListenerPanel;
    }

    private void controlarVista(MouseEvent e) {
        MenuItem tmp = (MenuItem) e.getSource();

        if (tmp != this.menuSeleccionado) {

            if (this.menuSeleccionado != null) {
                this.menuSeleccionado.resetColor();
            }

            tmp.setColor();
            this.menuSeleccionado = tmp;

            //Si el menu ya está registrado en el hashmap con su JPanel lo traemos y lo pintamos
//            JPanel hashFound = this.menusVistas.get(tmp);
//            if (hashFound != null) {
//                JPanel panel = vista.getPanelCuerpo();
//                panel.removeAll();
//                panel.add(hashFound);
//                panel.repaint();
//                panel.revalidate();
//            }
        }
    }

}
