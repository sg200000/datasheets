package com.example.datasheets;

import com.example.datasheets.component.Component;
import com.example.datasheets.component.FullReference;
import com.example.datasheets.component.Voltage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
        this.userName = "said";
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
        if (request.getParameter("action").equals("add")){
            this.insertValues(request,out);
        }

        else if (request.getParameter("action").equals("remove")) {
            try {
                this.removeComponent(request,out);
            } catch (SQLException e) {
                out.write(String.valueOf(e));
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
    }

    private void removeComponent(HttpServletRequest request, PrintWriter out) throws SQLException {
        String query = "DELETE FROM components WHERE id="+request.getParameter("idRm");
        Statement stmt = conn.createStatement();
        stmt.execute(query);
        out.write("The component with id="+request.getParameter("idRm")+" is successfully deleted");
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
    private void insertValues(HttpServletRequest request, PrintWriter out){
        FullReference fullReference = new FullReference(request.getParameter("reference"), request.getParameter("packaging"));
        Voltage voltage = new Voltage(Float.parseFloat(request.getParameter("voltage")),request.getParameter("voltage_unit"));
        Component component = new Component(fullReference,request.getParameter("category"),voltage,request.getParameter("datasheet"));

        String query = " insert into components (reference, voltage, voltage_unit, category, packaging, datasheet)" + " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conn.prepareStatement(query);
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(1, component.getFullRef().getReference());
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setFloat(2, component.getVoltage().getVoltage());
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(3, component.getVoltage().getVoltage_unit());
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(4, component.getCategory());
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(5, component.getFullRef().getPackaging());
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.setString(6, component.getDatasheet());
        } catch (SQLException e) {
            out.println(e);
        }
        try {
            preparedStmt.execute();
            out.println("Component added successfully");
        } catch (SQLException e) {
            out.println(e);
        }
    }
}
