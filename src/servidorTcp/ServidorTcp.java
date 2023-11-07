/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorTcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ServidorTcp {
    
    public static void main(String[] args) {
            ServerSocket servidor = null;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
            
            final int PUERTO = 5000;
            
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor Iniciado");
              
            while(true){
                sc = servidor.accept();
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();
                
                System.out.println(mensaje);
                
                out.writeUTF("Hola mundo desde el servidor");
                
//                sc.close();
                System.out.println("Cliente desconectado");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorTcp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
