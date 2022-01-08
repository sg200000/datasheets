package com.example.datasheets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.write(request.getParameter("component"));
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void destroy() {
    }
}