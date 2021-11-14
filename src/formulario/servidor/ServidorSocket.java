/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ServidorSocket {

    static final int PORT = 1978;
    //static ServerSocket serverSocket;

    public ServidorSocket() {
        runServidor();
    }

    public void runServidor() {
        new Thread(() -> {
            Socket socket = null;

            try (ServerSocket serverSocket = new ServerSocket(PORT);){
                while (true) {
                    try {
                        socket = serverSocket.accept();
                        System.out.println("Cliente conectado satisfactoriamente: " + socket.getRemoteSocketAddress().toString());
                    } catch (IOException e) {
                        System.out.println("I/O error: " + e);
                    }

                    // nuevo hilo para el cliente
                    new EchoThread(socket).start();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al inicializar el socket servidor. Puede que ya haya otra instancia en ejecución", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
                e.printStackTrace();
            }

            try {

            } catch (Exception e) {
                System.err.println("Servidor se ha cerrado: \n" + e.getMessage());
            }

        }).start();
    }

}
