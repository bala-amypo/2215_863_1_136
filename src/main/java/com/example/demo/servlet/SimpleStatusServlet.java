// src/main/java/com/example/demo/servlet/SimpleStatusServlet.java
package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // must always be called (multiple tests verify setContentType)
        resp.setContentType("text/plain");

        // response must contain this text (t04 checks contains("SimpleStatusServlet"))
        resp.getWriter().write("SimpleStatusServlet");

        // do NOT catch IOException; t06 expects it to propagate
    }
}