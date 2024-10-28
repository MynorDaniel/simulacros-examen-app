/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.models;

/**
 *
 * @author mynordma
 */
public class Examen {
    
    private String nombre;       
    private String curso;         
    private String descripcion;  
    private int tiempo;      
    private int preguntas;

    public Examen(String nombre, String curso, String descripcion, int tiempo, int preguntas) {
        this.nombre = nombre;
        this.curso = curso;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.preguntas = preguntas;
    }

    public Examen() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(int preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
