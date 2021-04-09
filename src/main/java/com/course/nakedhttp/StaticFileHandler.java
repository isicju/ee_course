package com.course.nakedhttp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class StaticFileHandler implements HttpHandler {

  public StaticFileHandler() {
  }

  @Override
  public void handle(HttpExchange ex) throws IOException {
    URI uri = ex.getRequestURI();
    String name = new File(uri.getPath()).getName();
    File path = new File(System.getProperty("user.dir") + "target/classes/" + name);
    Headers h = ex.getResponseHeaders();
    h.add("Content-Type", "text/html");

    OutputStream out = ex.getResponseBody();

    if (path.exists()) {
      ex.sendResponseHeaders(200, path.length());
      out.write(Files.readAllBytes(path.toPath()));
    } else {
      System.err.println("File not found: " + path.getAbsolutePath());

      ex.sendResponseHeaders(404, 0);
      out.write("404 File not found.".getBytes());
    }

    out.close();
  }

}
