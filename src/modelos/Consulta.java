/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class Consulta implements Serializable{
    private int idConsulta;
    private String nombrePaciente;
    private String nss;
    private String sintomas;
    private int noTurno;
    private String nombreDoctor;
    private int noConsultorio;

    public Consulta() {
    }
    
    public Consulta(String nombrePaciente, String nss, String sintomas) {
        this.nombrePaciente = nombrePaciente;
        this.nss = nss;
        this.sintomas = sintomas;
    }

    
    public Consulta(String nombrePaciente, String nss, String sintomas, int noTurno, String nombreDoctor, int noConsultorio) {
        this.nombrePaciente = nombrePaciente;
        this.nss = nss;
        this.sintomas = sintomas;
        this.noTurno = noTurno;
        this.nombreDoctor = nombreDoctor;
        this.noConsultorio = noConsultorio;
    }

    public Consulta(int idConsulta, String nombrePaciente, String nss, String sintomas, int noTurno, String nombreDoctor, int noConsultorio) {
        this.idConsulta = idConsulta;
        this.nombrePaciente = nombrePaciente;
        this.nss = nss;
        this.sintomas = sintomas;
        this.noTurno = noTurno;
        this.nombreDoctor = nombreDoctor;
        this.noConsultorio = noConsultorio;
    }

    /*TOSTRING*/

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", nombrePaciente=" + nombrePaciente + ", nss=" + nss + ", sintomas=" + sintomas + ", noTurno=" + noTurno + ", nombreDoctor=" + nombreDoctor + ", noConsultorio=" + noConsultorio + '}';
    }
    
    /*GETTER Y SETTERS*/

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public int getNoTurno() {
        return noTurno;
    }

    public void setNoTurno(int noTurno) {
        this.noTurno = noTurno;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public int getNoConsultorio() {
        return noConsultorio;
    }

    public void setNoConsultorio(int noConsultorio) {
        this.noConsultorio = noConsultorio;
    }
    
    
}
