/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.controllers;

import com.mycompany.simulacros.app.api.models.Examen;
import com.mycompany.simulacros.app.api.services.ExamenDB;
import java.io.InputStream;
import java.sql.SQLException;

/**
 *
 * @author mynordma
 */
public class ExamenController {
    
    public Examen[] obtenerExamenes(String curso){
        try {
            ExamenDB examenDB = new ExamenDB();
            return examenDB.obtenerExamenes(curso);
        } catch (SQLException e) {
            return null;
        }
    }

    public InputStream[] obtenerPreguntas(String curso, String tipo) {
        try {
            ExamenDB examenDB = new ExamenDB();
            return examenDB.obtenerPreguntas(curso, tipo);
        } catch (SQLException e) {
            return null;
        }
    }
}
