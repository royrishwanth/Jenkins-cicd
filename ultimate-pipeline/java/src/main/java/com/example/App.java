package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RootHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("✅ Server started at http://localhost:8080");
    }

    static class RootHandler implements HttpHandler {
        public void handle(HttpExchange exchange) {
            try {
                String response = """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Java Hello App</title>
                    </head>
                    <body>
                        <h1>🚀 Hello World from a Java 17 Web App!</h1>
                        <p>✅ Built with Maven</p>
                        <p>🔁 Running through a CI/CD pipeline!</p>
                        <p>📦 Ready to ship!</p>
                    </body>
                    </html>
                    """;

                exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                exchange.sendResponseHeaders(200, response.getBytes("UTF-8").length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes("UTF-8"));
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
