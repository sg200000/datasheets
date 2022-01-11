package com.example.datasheets.search;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Search {
    String keyword;
    Connection connection;
    String table;
    String attribute;
    String query;
    Search(Connection connection, String keyword, String table, String attribute){
        this.keyword = keyword;
        this.connection = connection;
        this.table = table;
        this.attribute = attribute;
        query = "SELECT * FROM "+table+" WHERE "+ attribute +" LIKE '%"+keyword+"%'";

    }

    public String getQuery() {
        return query;
    }

    public String getKeyword() {
        return keyword;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getTable() {
        return table;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Search{" +
                "keyword='" + keyword + '\'' +
                '}';
    }
}
