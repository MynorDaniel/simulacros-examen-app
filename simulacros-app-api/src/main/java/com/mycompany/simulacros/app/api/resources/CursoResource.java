/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.CursoController;
import com.mycompany.simulacros.app.api.models.Curso;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

/**
 *
 * @author mynordma
 */
@Path("curso")
public class CursoResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearCurso(Curso curso){
        CursoController cursoController = new CursoController();
        return cursoController.crearCurso(curso) ? Response.status(Response.Status.CREATED).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerCursos(){
        CursoController cursoController = new CursoController();
        Curso[] cursos = cursoController.obtenerCursos();
        return cursos != null ? Response.ok(cursos).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @PATCH
    @Path("/{nombre}/{carrera}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response actualizarImagen(FormDataMultiPart multipart, @PathParam("nombre") String nombre, @PathParam("carrera") String carrera){
        FormDataBodyPart part = multipart.getField("fileObject");
        CursoController cursoController = new CursoController();
        return cursoController.actualizarImagen(nombre, carrera, part) ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Path("/{carrera}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerCarreraPorDivision(@PathParam("carrera") String carrera){
        CursoController cursoController = new CursoController();
        Curso[] cursos = cursoController.obtenerCursos(carrera);
        return cursos != null ? Response.ok(cursos).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}