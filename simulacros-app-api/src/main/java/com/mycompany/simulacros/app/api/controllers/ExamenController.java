/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.controllers;

import com.mycompany.simulacros.app.api.models.Examen;
import com.mycompany.simulacros.app.api.models.Pregunta;
import com.mycompany.simulacros.app.api.models.PreguntaResponse;
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

    public Pregunta[] obtenerPreguntas(String curso, String tipo) {
        try {
            ExamenDB examenDB = new ExamenDB();
            return examenDB.obtenerPreguntas(curso, tipo);
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean guardarPregunta(InputStream imagen, String id) {
        ExamenDB examenDB = new ExamenDB();
        try {
            examenDB.guardarImagen(imagen, id);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public PreguntaResponse crearPregunta(Pregunta pregunta) {
        ExamenDB examenDB = new ExamenDB();
        PreguntaResponse pr;
        try {
            pr = examenDB.crearPregunta(pregunta);
        } catch (SQLException e) {
            return null;
        }
        return pr;
    }

    public boolean obtenerRespuesta(String id, String respuesta) {
        ExamenDB examenDB = new ExamenDB();
        boolean respuestaCorrecta;
        try {
            respuestaCorrecta = examenDB.respuestaCorrecta(Integer.parseInt(id), respuesta);
        } catch (SQLException e) {
            return false;
        }
        return respuestaCorrecta;
    }
}
