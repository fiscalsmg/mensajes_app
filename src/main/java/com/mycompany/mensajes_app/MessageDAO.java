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
 *Data Acces Object
 * Se crean 4 metodos que no van a devolver nada
 * @author Fiscal
 */
public class MessageDAO {
    /*Crear mensajes*/
    public static void createMessageDB(Message message){
        Conexion dbConect=new Conexion();
        try(Connection conexion=dbConect.get_connection()) {
            //Try para generar la insercion de los datos
            PreparedStatement ps=null;
            try {
                String query="INSERT INTO `mensajes` (mensaje, autor_mensaje) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                //parametros que seran enviados a la base de datos
                ps.setString(1,message.getMessage());//el mensaje es el atributo mensaje del objeto mensaje
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
    
    public static void readMessageDB(){
        
    }
    public static void deleteMessageDB(int id_message){
        
    }
    public static void updateMessageDB(Message message){
        
    }
}
