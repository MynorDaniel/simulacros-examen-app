/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.models;

/**
 *
 * @author mynordma
 */
public class Carrera {

    private String nombre;
    private String descripcion;
    private String division;

    public Carrera(String nombre, String descripcion, String division) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.division = division;
    }

    public Carrera() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
    
    
}
