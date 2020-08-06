/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Fiscal
 */
public class UserService {

    public static void createUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu correo");
        String correo = sc.nextLine();

        System.out.println("Escribe tu clave");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);

        System.out.println("Escribe tu Nombre");
        String nombre = sc.nextLine();

        User registro = new User(correo, clave, nombre);
        UserDAO.createUserDB(registro);
    }

    public static String cifrarMD5(String clave) {
        String md5Hex = DigestUtils.md5Hex(clave);
        return md5Hex;
    }

    public static User sessionStart() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu correo");
        String correo = sc.nextLine();

        System.out.println("Escribe tu clave");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);

        User login = new User(correo, clave);
        User resultado = UserDAO.sessionStartDB(login);

        return resultado;
    }
    
    public static void listUser(){
         UserDAO.readUSerDB();
    }
}
