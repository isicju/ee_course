package com.course.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerWithHttpResponse {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println("HTTP/1.1 200 Ok\n" +
                "Location: http://www.google.com/\n" +
                "Content-Type: text/html; charset=UTF-8\n" +
                "Cache-Control: public, max-age=2592000\n" +
                "Server: gws\n" +
                "X-XSS-Protection: 0\n" +
                "X-Frame-Options: SAMEORIGIN\n" +
                "\n" +
                "<HTML><HEAD><meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">\n" +
                "<TITLE>200 Ok</TITLE></HEAD><BODY>\n" +
                "<iframe width=\"420\" height=\"345\" src=\"https://www.youtube.com/embed/ZoHdzGLboZw\">\n" +
                "</iframe>\n" +
                "</BODY></HTML>");
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        TCPServerWithHttpResponse server=new TCPServerWithHttpResponse();
        server.start(8484);
    }


}
