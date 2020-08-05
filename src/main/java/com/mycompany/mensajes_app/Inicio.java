/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Fiscal
 */
public class Inicio {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("------------");
            System.out.println("Message Aplication");
            System.out.println("1. Create Message");
            System.out.println("2. List to message");
            System.out.println("3. Edit Message");
            System.out.println("4. Delete Message");
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
