package com.example.datasheets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = "SELECT * FROM components WHERE reference LIKE '%"+request.getParameter("component")+"%'";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONArray obj = new JSONArray();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                JSONObject subObj = new JSONObject();
                subObj.put("id",rs.getInt("id"));
                subObj.put("reference",rs.getString("reference"));
                subObj.put("voltage",rs.getString("voltage"));
                subObj.put("voltage_unit",rs.getString("voltage_unit"));
                subObj.put("category",rs.getString("category"));
                subObj.put("packaging",rs.getString("packaging"));
                subObj.put("datasheet",rs.getString("datasheet"));
                obj.add(subObj);
            }
            out.write(obj.toJSONString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
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