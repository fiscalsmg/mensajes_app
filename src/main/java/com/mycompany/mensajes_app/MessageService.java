/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 * Metodos que va recibir el menu y se van a conectar con la capa DAO
 *
 * @author Fiscal
 *
 * Capara se encarga de preguntar los datos para enviarlo a la capa de mensajes
 */
public class MessageService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensjae");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Message registro = new Message();
        registro.setMessage(mensaje);
        registro.setAuthor_message(nombre);

        //Enviar el objeto a DAO
        MessageDAO.createMessageDB(registro);
    }

    public static void listMessage() {
        MessageDAO.readMessageDB();
    }

    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje=sc.nextInt();
        MessageDAO.deleteMessageDB(id_mensaje);
    }

    public static void editMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo mensaje");
        String mensaje=sc.nextLine();
        
        System.err.println("Escribe el ID del mensaje a eliminar");
        int id_mensaje=sc.nextInt();
        Message actualizacion =new Message();
        actualizacion.setId_message(id_mensaje);
        actualizacion.setMessage(mensaje);
        MessageDAO.updateMessageDB(actualizacion);
    }
}
