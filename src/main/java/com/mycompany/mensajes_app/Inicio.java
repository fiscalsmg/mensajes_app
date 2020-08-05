/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;

/**
 *
 * @author Fiscal
 */
public class Inicio {
    public static void main (String args []){
        Conexion conexion =new Conexion();
        try(Connection con = conexion.get_connection()) {
            
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }
}
