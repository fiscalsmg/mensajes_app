/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fiscal
 */
public class Conexion {
    
    //metodo que debuelve un metodo de tipo connection 
    public Connection get_connection(){
        Connection conection =null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            
                  
        }catch(SQLException e){
            System.out.println(e);
        }
        return conection;
    }
}
