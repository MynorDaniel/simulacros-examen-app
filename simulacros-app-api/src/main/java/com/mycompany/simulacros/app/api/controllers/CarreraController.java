/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.controllers;

import com.mycompany.simulacros.app.api.models.Carrera;
import com.mycompany.simulacros.app.api.services.CarreraDB;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mynordma
 */
public class CarreraController {

    CarreraDB carreraDB = new CarreraDB();

    /**
     * Método encargado de verificar si el nombre de la carrera o de la división
     * son aceptables, de serlos crea una carrera con el nombre
     *
     * @param nombreCarrera Nombre que recibirá la carrera.
     * @param nombreDivision Nombre que recibirá la división a la que pertenece
     * la carrera.
     * @return true si se crea la carrera, false si no se creó.
     * @throws SQLException Si ocurrió un error al crear la carrera en la clase
     * CarreraDB.
     */
    public boolean crearCarrera(String nombreCarrera, String nombreDivision) throws SQLException {
        if (nombreCarrera.length() > 99 || nombreDivision.length() > 99) {
            return false;
        }
        try {
            carreraDB.crearCarrera(nombreCarrera);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /*
     * Método encargado de retornar las carreras existentes.
     *
     * @return carrerasDisponibles : Un arreglo con las carreras creadas.
    public Carrera[] obtenerCarreras() {
        Carrera[] carrerasDisponibles;
        try {
            ArrayList<Carrera> listaCarreras = carreraDB.obtenerCarreras();
            carrerasDisponibles = listaCarreras.toArray(new Carrera[listaCarreras.size()]);
            return carrerasDisponibles;
        } catch (SQLException e) {
            return null;
        }
    }
     */
}
