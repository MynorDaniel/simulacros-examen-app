/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.ExamenController;
import com.mycompany.simulacros.app.api.models.Respuesta;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 *
 * @author mynordma
 */
@Path("respuesta")
public class RespuestaResource {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response respuesta(Respuesta respuesta) {
        ExamenController examenController = new ExamenController();
        boolean respuestaCorrecta = examenController.obtenerRespuesta(respuesta);
        return respuestaCorrecta ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
