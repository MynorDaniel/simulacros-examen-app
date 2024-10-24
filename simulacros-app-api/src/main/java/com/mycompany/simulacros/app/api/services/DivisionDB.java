/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.services;

import com.mycompany.simulacros.app.api.bd.ConexionDB;
import com.mycompany.simulacros.app.api.models.Division;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mynordma
 */
public class DivisionDB {
    
    public void crearDivision(Division division) throws SQLException {
        String sql = "INSERT INTO division (nombre, descripcion) VALUES (?, ?)";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, division.getNombre());
            preparedStatement.setString(2, division.getDescripcion());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
            throw new SQLException("Error al crear la nueva división");
        }
    }
    
    public ArrayList<Division> obtenerDivisiones() throws SQLException {
        String sql = "SELECT nombre, descripcion FROM division";
        ArrayList<Division> divisiones = new ArrayList<>();

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                Division division = new Division(nombre, descripcion);
                divisiones.add(division);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las divisiones: " + e.getMessage());
            throw new SQLException("Error al recuperar las divisiones");
        }

        return divisiones;
    }
}
