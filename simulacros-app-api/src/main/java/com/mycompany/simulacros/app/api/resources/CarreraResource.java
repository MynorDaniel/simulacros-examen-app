/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.models.Carrera;
import com.mycompany.simulacros.app.api.services.CarreraDB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;

/**
 *
 * @author mynordma
 */
@Path("carrera")
public class CarreraResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearDivision(Carrera carrera){
//        CarreraController carreraController = new CarreraController();
        
//        try {
//            carreraController.crearCarrera(carrera);
//        } catch (SQLException ex) {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
        
        return Response.status(Response.Status.CREATED).build();
    }
}
