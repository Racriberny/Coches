package com.cristobalbernal.coches;

import java.io.Serializable;

public class Coche implements Serializable {
    private String codigo;
    private String marca;
    private String modelo;
    private String color;
    private int ruedas;

    public Coche(String codigo, String marca, String modelo, String color, int ruedas) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ruedas = ruedas;
    }

    public String getCodigo() {
        return codigo;
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
