/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.CarreraController;
import com.mycompany.simulacros.app.api.models.Carrera;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 *
 * @author mynordma
 */
@Path("carrera")
public class CarreraResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearCarrera(Carrera carrera){
        CarreraController carreraController = new CarreraController();
        return carreraController.crearCarrera(carrera) ? Response.status(Response.Status.CREATED).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerCarreras(){
        CarreraController carreraController = new CarreraController();
        Carrera[] carreras = carreraController.obtenerCarreras();
        return carreras != null ? Response.ok(carreras).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
