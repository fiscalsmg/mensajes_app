/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static User sessionStartDB(User user) {
        Conexion dbConect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = dbConect.get_connection()) {
            try {
                String query = "SELECT * FROM `usuarios` WHERE correo=? AND clave=?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, user.getCorreo());
                ps.setString(2, user.getClave());
                rs = ps.executeQuery();

                User login = new User();
                if (rs.next()) {
                    System.out.println("login correcto!");
                    login.setId_user(rs.getInt("id_usuario"));
                    login.setCorreo(rs.getString("correo"));
                    login.setNombre_completo(rs.getString("nombre_completo"));
                } else {
                    System.out.println("login failed");
                }
                //retornamos el objeto usuario con los datos o vacío
                return login;

            } catch (SQLException e) {
                System.err.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void readUSerDB() {
        Conexion dbConect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = dbConect.get_connection()) {
            
            String query = "SELECT * FROM usuarios";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_usuario"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Clave: " + rs.getString("clave"));
                System.out.println("Nombre: " + rs.getString("nombre_completo"));
                System.out.println("");
            }
            
        } catch (SQLException e) {
            System.out.println("Error verifique ");
            System.out.println(e);
        }
    }
}
