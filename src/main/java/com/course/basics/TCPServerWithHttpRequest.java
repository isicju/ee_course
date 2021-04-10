package com.course.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerWithHttpRequest {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8282);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int value = 0;
        while (in.ready()) {
            value = in.read();
            char char1 = (char) value;
            System.out.print(char1);
        }
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}