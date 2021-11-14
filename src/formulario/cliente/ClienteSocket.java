/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelos.Consulta;

/**
 *
 * @author Alex
 */
public class ClienteSocket {

    public static boolean estadoConexion = false;
    protected static Socket socket;
    private static DataInputStream entrada;
    private static DataOutputStream salida;

    public ClienteSocket() {

    }

    /*Método para conectar al servidor*/
    public static boolean conectar() {
        try {
            socket = new Socket("localhost", 1978);
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            estadoConexion = true;
        } catch (IOException ex) {
            System.err.println("Error conectando al servidor");
        }
        return estadoConexion;
    }

    public static void desconectar() {
        try {
            socket.close();
            estadoConexion = false;
        } catch (IOException ex) {
            System.err.println("Error desconectando del servidor");
        }
    }

    /*Método para comprobar si el socket cliente sigue conectado al servidor*/
    public static boolean ping() {
        String mensajeSalida = "ping";
        try {
            salida.writeUTF(mensajeSalida);
            salida.flush();
            return true;
        } catch (IOException e) {
            System.err.println("Error haciendo ping al servidor");
        }
        //Si no se pudo hacer el ping, el estado de la conexión es falso (desconectado)
        estadoConexion = false;
        return false;
    }

    public static Consulta registrarPaciente(Consulta consulta) {
        /*Indicamos al servidor que le mandaremos un registro de paciente*/
        String mensajeSalida = "registrarPaciente";
        try {
            salida.writeUTF(mensajeSalida);
            salida.flush();
        } catch (IOException e) {
            System.err.println("IOException al registrar paciente");
        }
        
        /*Enviamos el registro del paciente*/
        try{
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(consulta);
            outputStream.flush();
            objectOutputStream.flush();
        } catch (IOException ex) {
            System.err.println("Error al obtener consultas");
        }
        
        /*Leemos el registro ya con los datos llenados*/
        try{
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Consulta cons = (Consulta) objectInputStream.readObject();
            return cons;
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException al registrar paciente");
        } catch (IOException ex) {
            System.err.println("IOException al registrar paciente");
            ex.getMessage();
            ex.printStackTrace();
        }
        
        return null;
    }

    public static List<Consulta> obtenerConsultas() {
        List<Consulta> lista = new ArrayList<>();

        /*Indicamos al servidor que solicitamos las consultas*/
        String mensajeSalida = "obtenerConsultas";
        try {
            salida.writeUTF(mensajeSalida);
            salida.flush();
        } catch (IOException e) {
            System.err.println("IOException al obtener consultas");
        }

        /*Leemos las consultas las consultas*/
        try{
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            lista = (List<Consulta>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException al obtener consultas");
        } catch (IOException ex) {
            System.err.println("IOException al obtener consultas");
            ex.getMessage();
            ex.printStackTrace();
        }

        return lista;
    }
}
