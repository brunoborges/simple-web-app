package com.example;

import static java.lang.System.out;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class App {
    public static void main(String[] args) throws IOException {
        var port = 8080;
        var server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/").setHandler(e -> {
            var message = "Hello world!";
            e.sendResponseHeaders(200, message.getBytes().length);
            try (var os = e.getResponseBody()) {
                os.write(message.getBytes());
            }
        });
        server.start();
        out.println("Server is up and running.");
    }
}
