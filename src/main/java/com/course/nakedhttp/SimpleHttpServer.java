package com.course.nakedhttp;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class SimpleHttpServer {


  private static final int PORT = 9999;

  private HttpServer server;

  public static void main(String[] args) throws Exception {
    SimpleHttpServer server = new SimpleHttpServer();
    server.start();
  }

  void start() throws IOException {
    System.out.println("Server has started..");
    server = HttpServer.create(new InetSocketAddress(PORT), 0);
    server.createContext("", new StaticFileHandler());
    server.start();
  }

  public void stop() {
    server.stop(0);
  }
}
