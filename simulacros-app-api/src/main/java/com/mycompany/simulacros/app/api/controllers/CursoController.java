/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.controllers;

import com.mycompany.simulacros.app.api.models.Curso;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cristian, Eduardo
 */
public class CursoController {

    /*
    public Curso[] obtenerCursos() {
        try {
            ArrayList<Curso> listaDeCursos = CursoDB.obtenerCursos();
            Curso[] cursos = listaDeCursos.toArray(new Curso[listaDeCursos.size()]);
            return cursos;
        } catch (SQLException e) {
            return null;
        }
    }
    */
    
    public boolean recibirCurso(Curso curso) {
        if (curso == null
                || curso.getNombre() == null
                || curso.getCarrera() == null
                || curso.getDivision() == null
                || curso.getDescripcion() == null) {
            return false;
        }

        if (curso.getNombre().isEmpty()
                || curso.getCarrera().isEmpty()
                || curso.getDivision().isEmpty()
                || curso.getDescripcion().isEmpty()) {
            return false;
        }

        if (curso.getNombre().length() > 99
                || curso.getCarrera().length() > 99
                || curso.getDivision().length() > 99) {
            return false;
        }

        /*try {
                CursoDB cursoDB = new CursoDB();
                cursoDB.crearCurso(curso);
        } catch (SQLException e) {
            return false;
        }*/
        return true;
    }
}
