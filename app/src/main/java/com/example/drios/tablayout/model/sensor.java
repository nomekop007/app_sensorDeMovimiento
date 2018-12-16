package com.example.drios.tablayout.model;

public class sensor {
    public int id;
    public String name;
    public int sensor1;
    public String fecha;

    public sensor() {

    }

    public sensor(int id, String name, int sensor1, String fecha) {
        this.id = id;
        this.name = name;
        this.sensor1 = sensor1;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        String s = "";
        s = s.concat(name+"\n");
        s = s.concat(sensor1+"\n");
        s = s.concat(fecha+"\n");
        return s;
    }
}
