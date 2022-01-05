package com.example.datasheets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        init();
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
    //    out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
   //     out.println("</body></html>");
    }

    public void destroy() {
    }
}