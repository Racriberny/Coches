package com.cristobalbernal.coches;

import java.io.Serializable;

public class Coche implements Serializable {
    private String marca;
    private String modelo;
    private String color;
    private int ruedas;

    public Coche(String marca, String modelo, String color, int ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ruedas = ruedas;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getRuedas() {
        return ruedas;
    }
}
