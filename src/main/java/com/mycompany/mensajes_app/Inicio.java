/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 * Menu que se conecta a la capa de servicios, y esta capa se conecta a la capa
 * DAO Serie de capas para tener el flujo de informacion
 *
 * @author Fiscal
 */
public class Inicio {

    public static void main(String args[]) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in);  
        int opcion = 0;  

        //primer menú
        do{
            System.out.println("===================");
            System.out.println("\n Mini red social \n");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. salir \n");
            //leemos la opción del usuario
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                   UserService.createUser();
                    break;
                case 2:
                   /* User resultado = UsuarioService.iniciarSesion();
                    if(resultado.getId_usuario() > 0){
                        menuSesion(resultado);
                    }*/   
                    break;
                default:
                    break;
            }
        }while(opcion != 3);
    }

    public static void menuSesion(User user) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("------------");
            System.out.println("Message Aplication");
            System.out.println("1. Create Message");
            System.out.println("2. List to message");
            System.out.println("3. Delete Message");
            System.out.println("4. Edit Message");
            System.out.println("5. salir");
            //leemos la opcion del usuario 
            option = sc.nextInt();

            switch (option) {
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.deleteMessage();
                    break;
                case 4:
                    MessageService.editMessage();
                    break;
                default:
                    break;

            }

        } while (option != 5);
    }
}
