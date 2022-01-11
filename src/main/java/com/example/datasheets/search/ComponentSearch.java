package com.example.datasheets.search;

import com.example.datasheets.component.Component;
import com.example.datasheets.component.FullReference;
import com.example.datasheets.component.Voltage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComponentSearch extends Search{
    ArrayList<Component> components;

    public ComponentSearch(Connection conn, String keyword) throws SQLException {
        super(conn,keyword,"components","reference");
        components = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet results = stmt.executeQuery(this.getQuery());
            while (results.next()){
                int id = results.getInt("id");
                String reference =results.getString("reference");
                float voltage = results.getFloat("voltage");
                String voltage_unit =results.getString("voltage_unit");
                String category =results.getString("category");
                String packaging =results.getString("packaging");
                String datasheet = results.getString("datasheet");
                Component component = new Component(id,new FullReference(reference,packaging),category,new Voltage(voltage,voltage_unit),datasheet);

                components.add(component);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder jsonStringBuilder = new StringBuilder();
        jsonStringBuilder.append("{"+this.components.get(0));
        for (int i=1;i<this.components.size();i++){
            jsonStringBuilder.append(","+this.components.get(i));
        }
        jsonStringBuilder.append("}");
        String jsonString = jsonStringBuilder.toString();
        return jsonString;
    }

    public String toJSON() throws ParseException {
        JSONArray json = new JSONArray();
        for (int i=0;i<components.size();i++){
            JSONObject subJson = new JSONObject();
            subJson.put("id", components.get(i).getCaracteristics().get("id"));
            subJson.put("category",components.get(i).getCaracteristics().get("category"));
            subJson.put("voltage",components.get(i).getCaracteristics().get("voltage"));
            subJson.put("voltage_unit",components.get(i).getCaracteristics().get("voltage_unit"));
            subJson.put("reference",components.get(i).getCaracteristics().get("reference"));
            subJson.put("packaging",components.get(i).getCaracteristics().get("packaging"));
            subJson.put("datasheet", components.get(i).getCaracteristics().get("datasheet"));
            json.add(subJson);
        }
        return json.toJSONString();
    }
}
