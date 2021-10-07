/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab10_java_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Bogdan
 */
public class Server {
    public static final int PORT = 8100;

    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while(true) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        }
        catch (IOException e){
            System.err.println("Error: " + e);
        }
        finally{
            serverSocket.close();
        }
    }
    public static void main ( String [] args ) throws IOException {
        Server server = new Server ();
    }
}
