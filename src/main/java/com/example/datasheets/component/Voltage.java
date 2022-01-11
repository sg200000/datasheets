package com.example.datasheets.component;

public class Voltage {
    float voltage;
    String voltage_unit;

    public Voltage(float voltage, String voltage_unit){
        this.voltage = voltage;
        this.voltage_unit = voltage_unit;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public String getVoltage_unit() {
        return voltage_unit;
    }

    public void setVoltage_unit(String voltage_unit) {
        this.voltage_unit = voltage_unit;
    }

    @Override
    public String toString() {
        return voltage+" "+voltage_unit;
    }
}
