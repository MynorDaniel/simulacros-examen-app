/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.controllers;

import com.mycompany.simulacros.app.api.models.Curso;
import com.mycompany.simulacros.app.api.services.CursoDB;
import java.sql.SQLException;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

/**
 *
 * @author Cristian, Eduardo
 */
public class CursoController {
 
    
    public Curso[] obtenerCursos() {
        try {
            CursoDB cursoDB = new CursoDB();
            Curso[] cursos = (Curso[]) cursoDB.obtenerCursos().toArray();
            return cursos;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean crearCurso(Curso curso) {
        if (curso == null
                || curso.getNombre() == null
                || curso.getCarrera() == null
                || curso.getDivision() == null
                || curso.getDescripcion() == null) {
            return false;
        }
        
        if (curso.getNombre().isEmpty() || 
            curso.getCarrera().isEmpty() || 
            curso.getDivision().isEmpty() || 
            curso.getDescripcion().isEmpty()) {
            return false;
        }
        
        if (curso.getNombre().length() > 99 || 
            curso.getCarrera().length() > 99 || 
            curso.getDivision().length() > 99) {
            return false;
        }
        
        try {
                CursoDB cursoDB = new CursoDB();
                cursoDB.crearCurso(curso);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean actualizarImagen(String nombre, String carrera, FormDataBodyPart part) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
