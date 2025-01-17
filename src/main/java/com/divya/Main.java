package com.divya;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        //Creating HTTP server that listens to port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        //Creating endpoints, if no handlers are found for the http paths, then 404 status code gets returned by java
        server.createContext("/api/tasks",new TaskHandler());
        server.createContext("/api/tasks/",new SingleTaskHandler());

        //Start the server

        server.setExecutor(null);
        server.start();
        System.out.println("Server has been started on port 8080");

        }
    }
}