/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.DivisionController;
import com.mycompany.simulacros.app.api.models.Division;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 *
 * @author mynordma
 */
@Path("division")
public class DivisionResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearDivision(Division division){
        DivisionController divisionController = new DivisionController();
        return divisionController.crearDivision(division) ? Response.status(Response.Status.CREATED).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerDivisiones(){
        DivisionController divisionController = new DivisionController();
        Division[] divisiones = divisionController.obtenerDivisiones();
        return divisiones != null ? Response.ok(divisiones).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
