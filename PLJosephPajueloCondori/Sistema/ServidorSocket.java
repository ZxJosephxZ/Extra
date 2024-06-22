/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Joseph
 */
//COPIAR TODO
public class ServidorSocket {
    private static final int PUERTO = 12345;
    private GUI gui;

    public ServidorSocket(GUI gui) {
        this.gui = gui;
    }

    public void iniciar() {
        //INICIAR INTERFAZ POR HILO SEPARADO
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);
            }
        });
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado y escuchando en el puerto " + PUERTO);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
                    
                    //String mejoresTiempos = (String) in.readObject();
                    List<Resultado> mejoresTiempos = (List<Resultado>) in.readObject();
                    System.out.println("Mejores tiempos recibidos: " + mejoresTiempos); // Imprimir en consola para depuración
                    gui.actualizarMejoresTiempos(mejoresTiempos);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        ServidorSocket servidor = new ServidorSocket(gui);
        servidor.iniciar();
    }
}