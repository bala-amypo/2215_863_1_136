package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/status")
public class SimpleStatusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setStatus(200);
        res.getWriter().write("OK");
    }
}
