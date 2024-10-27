/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.services;

import com.mycompany.simulacros.app.api.bd.ConexionDB;
import com.mycompany.simulacros.app.api.models.Curso;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mynordma
 */
public class CursoDB {

    public void crearCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO curso (nombre, carrera, division, descripcion) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, curso.getNombre());
            preparedStatement.setString(2, curso.getCarrera());
            preparedStatement.setString(3, curso.getDivision());
            preparedStatement.setString(4, curso.getDescripcion());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
            throw new SQLException("Error al crear el curso");
        }
    }

    public ArrayList<Curso> obtenerCursos() throws SQLException {
        ArrayList<Curso> listaDeCursos = new ArrayList<>();
        String sql = "SELECT nombre, carrera, division, descripcion FROM curso";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String carrera = resultSet.getString("carrera");
                String division = resultSet.getString("division");
                String descripcion = resultSet.getString("descripcion");

                Curso curso = new Curso(nombre, carrera, division, descripcion);
                listaDeCursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
            throw new SQLException("Error al obtener los cursos");
        }

        return listaDeCursos;
    }
    
    public void actualizarImagen(String nombre, String carrera, InputStream imagen) throws SQLException {
        String sqlUpdate = "UPDATE curso SET imagen = ? WHERE nombre = ? AND carrera = ?";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate)) {

            updateStatement.setBlob(1, imagen);
            updateStatement.setString(2, nombre);
            updateStatement.setString(3, carrera);

            int rowsUpdated = updateStatement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("No se encontró un curso con el nombre y carrera especificados.");
            }
        } catch (SQLException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
            throw new SQLException("Error al actualizar la imagen del curso: " + e.getMessage());
        }
    }
    
    public Curso[] obtenerCursos(String carrera) throws SQLException {
        String query = "SELECT nombre, carrera, division, descripcion FROM curso WHERE carrera = ?";

        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConexionDB.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, carrera);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String carreraDb = rs.getString("carrera");
                String division = rs.getString("division");
                String descripcion = rs.getString("descripcion");

                Curso curso = new Curso(nombre, carreraDb, division, descripcion);
                cursos.add(curso);
            }
        }

        return cursos.toArray(Curso[]::new);
    }
}