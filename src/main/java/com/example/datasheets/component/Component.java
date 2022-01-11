package com.example.datasheets.component;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Component {
    int id;
    String category, datasheet;
    FullReference fullRef;
    Voltage voltage;
    HashMap<String, String> caracteristics;

    public Component(int id, FullReference fullRef, String category, Voltage voltage, String datasheet){
        this.id = id;
        this.fullRef = fullRef;
        this.category = category;
        this.voltage = voltage;
        this.datasheet = datasheet;
        this.caracteristics.put("id",String.valueOf(id));
        this.caracteristics.put("reference", fullRef.getReference());
        this.caracteristics.put("packaging", fullRef.getPackaging());
        this.caracteristics.put("voltage", String.valueOf(voltage.getVoltage()));
        this.caracteristics.put("voltage_unit", voltage.getVoltage_unit());
        this.caracteristics.put("category",category);
        this.caracteristics.put("datasheet",datasheet);
    }

    public Component(FullReference fullRef, String category, Voltage voltage, String datasheet){
        this.fullRef = fullRef;
        this.category = category;
        this.voltage = voltage;
        this.datasheet = datasheet;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public FullReference getFullRef() {
        return fullRef;
    }

    public String getDatasheet() {
        return datasheet;
    }

    public Voltage getVoltage() {
        return voltage;
    }

    public HashMap<String, String> getCaracteristics() {
        return caracteristics;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setVoltage(Voltage voltage) {
        this.voltage = voltage;
    }

    public void setDatasheet(String datasheet) {
        this.datasheet = datasheet;
    }

    public void setFullRef(FullReference fullRef) {
        this.fullRef = fullRef;
    }

    public void setCaracteristics(HashMap<String, String> caracteristics) {
        this.caracteristics = caracteristics;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                "\"category\":\"" + category + '\"' +
                ", \"datasheet\":\"" + datasheet + '\"' +
                ", \"reference\":\"" + fullRef.getReference() + '\"' +
                ", \"packaging\":'" + fullRef.getPackaging() + '\"' +
                ", \"voltage\":\"" + voltage.getVoltage() + '\"' +
                ", \"voltage_unit\":\"" + voltage.getVoltage_unit() + '\"' +
                "}";
    }
}
