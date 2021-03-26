package com.course.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
    public static void main(String[] args) throws Exception {
        GreetServer server = new GreetServer();
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while (true) {
            System.out.println(in.readLine());
        }
    }
}