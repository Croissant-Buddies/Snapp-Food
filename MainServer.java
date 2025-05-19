package org.croissant;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class MainServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        UserDAO userDAO = new UserDAO();
        server.createContext("/v1/auth/login", new LoginHandler(userDAO));
        server.setExecutor(null);
        server.start();

        System.out.println("✅ Server started on port 8080");
    }
}


