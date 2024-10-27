/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.services;

import com.mycompany.simulacros.app.api.bd.ConexionDB;
import com.mycompany.simulacros.app.api.models.Examen;
import java.io.InputStream;
import java.sql.*;

/**
 *
 * @author mynordma
 */
public class ExamenDB {
    
    public Examen[] obtenerExamenes(String curso) throws SQLException {
        String sql = "SELECT nombre, curso, descripcion, tiempo, preguntas FROM examen WHERE curso = ?";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, curso);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                java.util.List<Examen> examenesList = new java.util.ArrayList<>();

                while (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String cursoResult = resultSet.getString("curso");
                    String descripcion = resultSet.getString("descripcion");
                    int tiempo = resultSet.getInt("tiempo");
                    int preguntas = resultSet.getInt("preguntas");

                    Examen examen = new Examen(nombre, cursoResult, descripcion, tiempo, preguntas);
                    examenesList.add(examen);
                }

                return examenesList.toArray(Examen[]::new);
            }
        } catch (SQLException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
            throw new SQLException("Error al obtener los exámenes");
        }
    }

    public InputStream[] obtenerPreguntas(String curso, String tipo) throws SQLException {
        return null;
    }


}
