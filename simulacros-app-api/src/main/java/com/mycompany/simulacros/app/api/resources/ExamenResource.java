/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.ExamenController;
import com.mycompany.simulacros.app.api.models.Examen;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.io.*;


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
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public Response obtenerExamen(@PathParam("curso") String curso, @PathParam("tipo") String tipo) {
        ExamenController examenController = new ExamenController();
        InputStream[] imagenes = examenController.obtenerPreguntas(curso, tipo);
        
        if(imagenes == null){return Response.status(Response.Status.BAD_REQUEST).build();}

        StreamingOutput output = (OutputStream outputStream) -> {
            for (InputStream imagen : imagenes) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = imagen.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
                imagen.close();
            }
        };

        return Response.ok(output).type(MediaType.APPLICATION_OCTET_STREAM).build();
    }
}