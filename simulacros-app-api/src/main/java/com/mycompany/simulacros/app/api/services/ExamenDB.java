/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.services;

import com.mycompany.simulacros.app.api.bd.ConexionDB;
import com.mycompany.simulacros.app.api.models.Examen;
import com.mycompany.simulacros.app.api.models.Pregunta;
import com.mycompany.simulacros.app.api.models.PreguntaResponse;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    public Pregunta[] obtenerPreguntas(String curso, String tipo) throws SQLException {
        String query;
        int limite = (tipo.equals("Examen único")) ? 20 : 4;

        query = "SELECT id, imagen, curso, tipo, respuesta_correcta, respuesta_incorrecta1, respuesta_incorrecta2, respuesta_incorrecta3 " +
                "FROM pregunta " +
                "WHERE curso = ? AND tipo = ? " +
                "ORDER BY RAND() " +
                "LIMIT ?";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, curso);
            preparedStatement.setString(2, tipo);
            preparedStatement.setInt(3, limite);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Pregunta> preguntasList = new ArrayList<>();

            while (resultSet.next()) {
                Pregunta pregunta = new Pregunta();
                pregunta.setId(resultSet.getInt("id"));
                pregunta.setCurso(resultSet.getString("curso"));
                pregunta.setTipo(resultSet.getString("tipo"));
                pregunta.setRespuestaCorrecta(resultSet.getString("respuesta_correcta"));
                pregunta.setRespuestaIncorrecta1(resultSet.getString("respuesta_incorrecta1"));
                pregunta.setRespuestaIncorrecta2(resultSet.getString("respuesta_incorrecta2"));
                pregunta.setRespuestaIncorrecta3(resultSet.getString("respuesta_incorrecta3"));

                byte[] imagenBytes = resultSet.getBytes("imagen");
                if (imagenBytes != null) {
                    String imagenBase64 = Base64.getEncoder().encodeToString(imagenBytes);
                    pregunta.setImagen(imagenBase64);
                } else {
                    pregunta.setImagen("");
                }

                preguntasList.add(pregunta);
            }

            return preguntasList.toArray(Pregunta[]::new);
        }
    }

    public boolean respuestaCorrecta(int id, String respuesta) throws SQLException {
        String query = "SELECT respuesta_correcta FROM pregunta WHERE id = ?";

        try (Connection connection = ConexionDB.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String respuestaCorrecta = resultSet.getString("respuesta_correcta");
                    return respuestaCorrecta.equals(respuesta);
                } else {
                    return false;
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    
    public void guardarImagen(InputStream imagen, String id) throws SQLException {
        String sql = "UPDATE pregunta SET imagen = ? WHERE id = ?";

        try (Connection conexion = ConexionDB.getInstance().getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setBlob(1, imagen);
            pstmt.setInt(2, Integer.parseInt(id));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al guardar la imagen: " + e.getMessage(), e);
        }
    }
    
    public PreguntaResponse crearPregunta(Pregunta pregunta) throws SQLException {
        String sql = "INSERT INTO pregunta (curso, tipo, respuesta_correcta, respuesta_incorrecta1, respuesta_incorrecta2, respuesta_incorrecta3) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        PreguntaResponse respuesta = new PreguntaResponse();

        try (Connection conexion = ConexionDB.getInstance().getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pregunta.getCurso());
            pstmt.setString(2, pregunta.getTipo());
            pstmt.setString(3, pregunta.getRespuestaCorrecta());
            pstmt.setString(4, pregunta.getRespuestaIncorrecta1());
            pstmt.setString(5, pregunta.getRespuestaIncorrecta2());
            pstmt.setString(6, pregunta.getRespuestaIncorrecta3());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        respuesta.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("No se pudo obtener el ID de la pregunta creada.");
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al crear la pregunta: " + e.getMessage(), e);
        }

        return respuesta;
    }
}
