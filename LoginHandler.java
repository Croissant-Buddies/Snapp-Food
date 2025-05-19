package org.croissant;

import com.sun.net.httpserver.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class LoginHandler implements HttpHandler {

    private final UserDAO userDAO;

    public LoginHandler(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!"POST".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            return;
        }

        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            body.append(line);
        }

        JSONObject json = new JSONObject(body.toString());
        String phone = json.getString("phone");
        String password = json.getString("password");

        User user = userDAO.login(phone, password);

        String response;
        int status;

        if (user != null) {
            response = "{\"message\":\"Login successful\"}";
            status = 200;
        } else {
            response = "{\"error\":\"Invalid credentials\"}";
            status = 401;
        }

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

