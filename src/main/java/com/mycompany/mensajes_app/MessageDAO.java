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
 * Data Acces Object Se crean 4 metodos que no van a devolver nada
 *
 * @author Fiscal
 */
public class MessageDAO {

    /*Crear mensajes*/
    public static void createMessageDB(Message message) {
        Conexion dbConect = new Conexion();
        try (Connection conexion = dbConect.get_connection()) {
            //Try para generar la insercion de los datos
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `mensajes` (mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                //parametros que seran enviados a la base de datos
                ps.setString(1, message.getMessage());//el mensaje es el atributo mensaje del objeto mensaje
                ps.setString(2, message.getAuthor_message());
                ps.executeUpdate();
                System.out.println("Mensaje Creado");

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void readMessageDB() {
        Conexion dbConect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = dbConect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();//executeQuery solo pedimos datos != executeUpdate

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }

    public static void deleteMessageDB(int id_message) {
        Conexion dbConect = new Conexion();
        PreparedStatement ps = null;

        try (Connection conexion = dbConect.get_connection()) {

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_message);
                //statement.executeUpdate() retorna la cantidad de filas affectadas por la consulta.
                int countRowsUpdated = ps.executeUpdate();
                if (countRowsUpdated != 0) {
                    System.err.println("El mensaje ha sido borrado");
                }else{
                    System.err.println("No encuentra el ID del mensaje");
                }
                    
                

            } catch (SQLException e) {
                System.err.println(e);
                System.err.println("No se puedo borrar el mensaje");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void updateMessageDB(Message message) {

    }
}
