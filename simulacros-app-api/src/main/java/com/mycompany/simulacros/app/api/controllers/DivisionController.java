/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.controllers;

import com.mycompany.simulacros.app.api.services.DivisionDB;
import java.sql.SQLException;
import com.mycompany.simulacros.app.api.models.Division;
import java.util.ArrayList;

/**
 *
 * @author mynordma
 */
public class DivisionController {

    private final DivisionDB divisionDB;

    public DivisionController() {
        this.divisionDB = new DivisionDB();
    }

    public boolean crearDivision(Division division) {
        if (division.getNombre().length() > 99) {
            return false;
        } else {
            try {
                divisionDB.crearDivision(division);
            } catch (SQLException e) {
                return false;
            }
        }
        return true;
    }

    
    public Division[] obtenerDivisiones() {
        try {
            ArrayList<Division> divisionesList = divisionDB.obtenerDivisiones();
            Division[] divisiones = new Division[divisionesList.size()];
            for (int i = 0; i < divisionesList.size(); i++) {
                divisiones[i] = divisionesList.get(i);
            }
            return divisiones;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
