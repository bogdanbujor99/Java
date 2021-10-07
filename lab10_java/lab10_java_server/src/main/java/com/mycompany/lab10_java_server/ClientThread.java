/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab10_java_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Bogdan
 */
public class ClientThread extends Thread{

    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Hello chose login or register!";
            out.println(raspuns);
            out.flush();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            while(!response.contains("login") && !response.contains("register") ){
                System.out.println(response);
                raspuns = "gresit";
                out.println(raspuns);
                out.flush();
                response = in.readLine();
            }
            raspuns = "Chose a command!";
            out.println(raspuns);
            out.flush();
            response = in.readLine();
            while(!response.contains("exit")){
                if(response.contains("friend")){
                    raspuns = "Server received the request friend";
                    out.println(raspuns);
                    out.flush();
                }
                else if(response.contains("send")){
                    raspuns = "Server received the request send";
                    out.println(raspuns);
                    out.flush();
                }
                else if(response.contains("read")){
                    raspuns = "Server received the request read";
                    out.println(raspuns);
                    out.flush();
                }
                else if(response.contains("stop")){
                    raspuns = "stop";
                    out.println(raspuns);
                    out.flush();
                    System.exit(0);
                }
                else {
                    raspuns = "I don't know this command";
                    out.println(raspuns);
                    out.flush();
                }
                response = in.readLine();
            }
        } catch(IOException e){
            System.err.println("Error: " + e);
        }
        finally {
            try{
                socket.close();
            } catch(IOException e) {
                System.err.println(e);
            }
        }
    }
    
}
