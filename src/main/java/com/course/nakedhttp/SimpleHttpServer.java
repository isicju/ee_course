package com.course.nakedhttp;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class SimpleHttpServer {

  private static String BASEDIR;

  private static final int PORT = 9999;

  private HttpServer server;

  public static void main(String[] args) throws Exception {
    if(args.length == 0) {
      System.out.println("Please specify resource location as param");
      System.exit(0);
    }
    BASEDIR = args[0];
    SimpleHttpServer server = new SimpleHttpServer();
    server.start();
  }

  void start() throws IOException {
    server = HttpServer.create(new InetSocketAddress(PORT), 0);
    server.createContext("/static", new StaticFileHandler(BASEDIR));
    server.start();
  }

  public void stop() {
    server.stop(0);
  }
}
