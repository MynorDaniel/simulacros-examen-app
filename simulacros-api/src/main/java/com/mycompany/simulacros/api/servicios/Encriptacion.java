/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacros.api.servicios;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author mynordma
 */
public class Encriptacion {
    
    public String encriptar(String palabra) {
        byte[] palabraBytes = palabra.getBytes(StandardCharsets.UTF_8);
        String palabraEncriptada = Base64.getEncoder().encodeToString(palabraBytes);
        return palabraEncriptada;
    }
}
