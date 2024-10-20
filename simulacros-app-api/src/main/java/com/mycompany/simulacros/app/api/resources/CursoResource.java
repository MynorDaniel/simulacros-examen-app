/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.app.api.resources;

import com.mycompany.simulacros.app.api.models.Curso;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 *
 * @author mynordma
 */
@Path("curso")
public class CursoResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearCurso(Curso curso){
        
        return null;
        
    }
}
