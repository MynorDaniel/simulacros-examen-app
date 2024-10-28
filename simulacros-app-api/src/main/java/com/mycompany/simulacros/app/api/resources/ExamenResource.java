/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.ExamenController;
import com.mycompany.simulacros.app.api.models.Examen;
import com.mycompany.simulacros.app.api.models.Pregunta;
import com.mycompany.simulacros.app.api.models.PreguntaResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.io.*;
import org.glassfish.jersey.media.multipart.FormDataParam;


/**
 *
 * @author mynordma
 */
@Path("examen")
public class ExamenResource {
    
    @GET
    @Path("/{curso}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerExamenInfo(@PathParam("curso") String curso){
        ExamenController examenController = new ExamenController();
        Examen[] examenes = examenController.obtenerExamenes(curso);
        return examenes != null ? Response.ok(examenes).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Path("/{curso}/{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPreguntas(@PathParam("curso") String curso, @PathParam("tipo") String tipo) {
        ExamenController examenController = new ExamenController();
        Pregunta[] preguntas = examenController.obtenerPreguntas(curso, tipo);

        if (preguntas == null || preguntas.length == 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("No se encontraron preguntas").build();
        }

        return Response.ok(preguntas).build();
    }
    
    @PATCH
    @Path("/imagen/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response subirImagen(@FormDataParam("file") InputStream imagenInputStream, @PathParam("id") String id) {
        ExamenController examenController = new ExamenController();
        return examenController.guardarPregunta(imagenInputStream, id) ? Response.status(Response.Status.CREATED).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearPregunta(Pregunta pregunta){
        ExamenController examenController = new ExamenController();
        PreguntaResponse pr = examenController.crearPregunta(pregunta);
        return pr != null ? Response.ok(pr).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}