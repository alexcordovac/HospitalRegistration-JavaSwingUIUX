/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Consulta;

/**
 *
 * @author Alex
 */
public class ConsultaDAO {

    public ConsultaDAO() {
    }
    
    public static List<Consulta> obtenerConsultas(){
        Connection con;
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM consultas";
        List<Consulta> lista = new ArrayList<>();
        
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                int idConsulta = rs.getInt(1);
                String nombrePaciente = rs.getString(2);
                String nss = rs.getString(3);
                String sintomas = rs.getString(4);
                int noTurno = rs.getInt(5);
                String nombreDoctor = rs.getString(6);
                int noConsultorio = rs.getInt(7);
                Consulta tmpConsulta = new Consulta(idConsulta, nombrePaciente, nss, sintomas, noTurno, nombreDoctor, noConsultorio);
                lista.add(tmpConsulta);
            }
            Conexion.desconectar();
            con.close();
            st.close();
            rs.close();
            return lista; 
        } catch (SQLException e) {
            System.err.println("Error al obtener la lista de consultas de la DB");
            e.printStackTrace();
        }
        return null;
    }
    
    public static int insertarConsulta(Consulta consulta){
        Connection con;
        PreparedStatement st;
        String query = "INSERT INTO consultas(nombrePaciente, nss, sintomas, noTurno, nombreDoctor, noConsultorio) VALUES (?,?,?,?,?,?);";
        
        try {
            con = Conexion.conectar();
            st = con.prepareStatement(query);
            
            //Consulta
            st.setString(1, consulta.getNombrePaciente());
            st.setString(2, consulta.getNss());
            st.setString(3, consulta.getSintomas());
            st.setInt(4, consulta.getNoTurno());
            st.setString(5, consulta.getNombreDoctor());
            st.setInt(6, consulta.getNoConsultorio());
            
            //Ejecutar consulta
            int filas = st.executeUpdate();
            System.out.println("Servidor: consulta insertada correctamente: "+consulta.getNombrePaciente());
            
            //Desconectar
            Conexion.desconectar();
            con.close();
            st.close();
            return filas;
        } catch (SQLException e) {
            System.err.println("Error al insertar consulta en la DB");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }
    
    public static int obtenerUltimoTurno(){
        Connection con;
        Statement st;
        ResultSet rs;
        String query = "SELECT noTurno FROM consultas ORDER BY noTurno DESC LIMIT 1;";
        
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                return rs.getInt(1);
            }
            
            Conexion.desconectar();
            con.close();
            st.close();
            rs.close();
        } catch (Exception e) {
        }
        return -1;
    }
    
     public static Consulta obtenerUltimaConsulta(){
        Connection con;
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM consultas ORDER BY idConsulta DESC LIMIT 1;";
        
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            Consulta cons = null;
            while(rs.next()){
                int idConsulta = rs.getInt(1);
                String nombrePaciente = rs.getString(2);
                String nss = rs.getString(3);
                String sintomas = rs.getString(4);
                int noTurno = rs.getInt(5);
                String nombreDoctor = rs.getString(6);
                int noConsultorio = rs.getInt(7);
                cons = new Consulta(idConsulta, nombrePaciente, nss, sintomas, noTurno, nombreDoctor, noConsultorio);
            }
            
            Conexion.desconectar();
            con.close();
            st.close();
            rs.close();
            return cons;
        } catch (Exception e) {
        }
        return null;
    } 
}
