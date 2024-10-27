/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.services;

import com.mycompany.simulacros.app.api.bd.ConexionDB;
import com.mycompany.simulacros.app.api.models.Carrera;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mynordma
 */
public class CarreraDB {
    
    public void crearCarrera(Carrera carrera) throws SQLException {
        String sql = "INSERT INTO carrera (nombre, descripcion, division) VALUES (?, ?, ?)";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, carrera.getNombre());
            preparedStatement.setString(2, carrera.getDescripcion());
            preparedStatement.setString(3, carrera.getDivision());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al crear la carrera: " + e.getMessage());
            throw new SQLException("Error al crear la nueva carrera");
        }
    }
    
    public ArrayList<Carrera> obtenerCarreras() throws SQLException {
        String sql = "SELECT nombre, descripcion, division FROM carrera";
        ArrayList<Carrera> listaDeCarreras = new ArrayList<>();

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                String division = resultSet.getString("division");

                Carrera carrera = new Carrera(nombre, descripcion, division);
                listaDeCarreras.add(carrera);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las carreras: " + e.getMessage());
            throw new SQLException("Error al obtener las carreras");
        }

        return listaDeCarreras;
    }
    
    public Carrera[] obtenerCarreras(String division) throws SQLException {
        String query = "SELECT nombre, descripcion, division FROM carrera WHERE division = ?";
        
        List<Carrera> carreras = new ArrayList<>();
        
        try (Connection conn = ConexionDB.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, division);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String divisionDb = rs.getString("division");
                
                Carrera carrera = new Carrera(nombre, descripcion, divisionDb);
                carreras.add(carrera);
            }
        }
        
        return carreras.toArray(Carrera[]::new);
    }
}
