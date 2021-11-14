/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ConsultaDAO;
import formulario.cliente.FormConsultaItem;
import formulario.servidor.FormRegistroPaciente;
import formulario.servidor.FormProcesandoSolicitudItem;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JPanel;
import modelos.Consulta;

/**
 *
 * @author Alex
 */
public class ControladorRegistroPaciente {

    static FormRegistroPaciente  vista;
    static List<Consulta> listaConsultas;
    
    public ControladorRegistroPaciente() {
    }

    public ControladorRegistroPaciente(FormRegistroPaciente vista) {
        this.vista = vista;
    }
    
    /*Iniciar componentes*/
    private void iniComponentes(){
        listaConsultas = new ArrayList<>();
    }
    
    /*Función para actualizar la lista*/
    public void actualizarListaConsultas(){
        listaConsultas = ConsultaDAO.obtenerConsultas();
    }
    
    /*Función para pintar el historial de registros*/
    public void pintarHistorialPacientes() {
        JPanel panel = vista.getPanelHistorialPacientes();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        for (int i = listaConsultas.size() - 1; i >= 0; i--) {
            FormConsultaItem itemConsulta = new FormConsultaItem(listaConsultas.get(i));
            panel.add(itemConsulta);
            panel.add(Box.createRigidArea(new Dimension(5, 15)));
        }
        panel.revalidate();
    }
    
    /*Función para pintar nuevo registro a procesar en el panel de "Procesando registros*/
    public void pintarNuevoRegistro(FormProcesandoSolicitudItem form) throws InterruptedException{
        vista.getPanelProcesandoRegistros().add(form);
        vista.getPanelProcesandoRegistros().revalidate();
        vista.getPanelProcesandoRegistros().repaint();
        Thread.sleep(2000);
    }
    
    /*Función para eliminar de la vista un registro a procesar en el panel de "Procesando registros*/
    public void eliminarPanelProcesandoRegistro(FormProcesandoSolicitudItem form) throws InterruptedException{
        vista.getPanelProcesandoRegistros().remove(form);
        vista.getPanelProcesandoRegistros().revalidate();
        vista.getPanelProcesandoRegistros().repaint();
        Thread.sleep(2000);
    }
    
    /*GETTER Y SETTERS*/

    public List<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
    
}
