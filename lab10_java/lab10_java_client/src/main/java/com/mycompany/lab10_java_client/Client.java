/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab10_java_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Bogdan
 */
public class Client {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader (
            new InputStreamReader(socket.getInputStream())) ) {
            System.out.println(in.readLine());
            String response;
        do{    
            Scanner keyboard = new Scanner(System.in);
            String s = keyboard.next();
            out.println(s);
            response = in.readLine();
        }
        while(response.equals("gresit"));
        System.out.println(response);
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.next();
        out.println(s);
        while(!s.contains("exit")){
            response = in.readLine();
            System.out.println(response);
            if(response.contains("stop"))break;
            keyboard = new Scanner(System.in);
            s = keyboard.next();
            out.println(s);
        }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
