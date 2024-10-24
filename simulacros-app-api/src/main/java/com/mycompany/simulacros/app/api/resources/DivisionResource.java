/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.controllers.DivisionController;
import com.mycompany.simulacros.app.api.models.Division;
import com.mycompany.simulacros.app.api.services.DivisionDB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;

/**
 *
 * @author mynordma
 */
@Path("division")
public class DivisionResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearDivision(Division division){
//        DivisionController divisionController = new DivisionController();
        
//        try {
//            divisionController.crearDivision(division);
//        } catch (SQLException ex) {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
        
        return Response.status(Response.Status.CREATED).build();
    }
    
}
