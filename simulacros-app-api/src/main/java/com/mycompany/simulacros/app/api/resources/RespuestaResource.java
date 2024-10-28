/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.ExamenController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 *
 * @author mynordma
 */
@Path("respuesta")
public class RespuestaResource {
    
    @GET
    @Path("/{id}/{respuesta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response respuesta(@PathParam("id") String id, @PathParam("respuesta") String respuesta) {
        ExamenController examenController = new ExamenController();
        boolean respuestaCorrecta = examenController.obtenerRespuesta(id, respuesta);
        return respuestaCorrecta ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
