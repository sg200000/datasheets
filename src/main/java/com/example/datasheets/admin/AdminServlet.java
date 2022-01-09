package com.example.datasheets.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String userName, password, dbms;
    private String serverName;
    private int portNumber;
    private String dbName;
    private Connection conn;

    @Override
    public void init() throws ServletException {
        super.init();
        this.dbms = "mysql";
        this.serverName = "localhost";
        this.portNumber = 3306;
        this.dbName = "alldatasheets";
        this.userName = "root";
        this.password = "saidfadelreda";
        try {
            conn = this.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String query = " insert into components (reference, voltage, voltage_unit, category, packaging, datasheet)" + " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conn.prepareStatement(query);
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(1, request.getParameter("reference"));
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setFloat(2, Float.parseFloat(request.getParameter("voltage")));
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(3, request.getParameter("voltage_unit"));
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(4, request.getParameter("category"));
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(5, request.getParameter("packaging"));
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(6, request.getParameter("datasheet"));
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.execute();
        } catch (SQLException e) {
            out.println(e);
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public Connection getConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);
        conn = DriverManager.getConnection(
                "jdbc:" + this.dbms + "://" +
                        this.serverName +
                        ":" + this.portNumber + "/" + this.dbName,
                connectionProps);
        System.out.println("Connected to database");
        return conn;
    }
}
