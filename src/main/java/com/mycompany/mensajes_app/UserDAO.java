/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fiscal
 */
public class UserDAO {

    public static void createUserDB(User user) {
        Conexion dbConect = new Conexion();
        try (Connection conexion = dbConect.get_connection()) {
            //Try para generar la insercion de los datos
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `usuarios` (correo, clave, nombre_completo) VALUES (?,?,?)";
                ps = conexion.prepareStatement(query);
                //parametros que seran enviados a la base de datos
                ps.setString(1, user.getCorreo());//el mensaje es el atributo mensaje del objeto mensaje
                ps.setString(2, user.getClave());
                ps.setString(3, user.getNombre_completo());
                ps.executeUpdate();
                System.out.println("Usuario Creado");

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
     public static void sessionStartDB(){
        
    }
}
