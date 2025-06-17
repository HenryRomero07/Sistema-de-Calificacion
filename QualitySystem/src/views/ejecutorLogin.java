package views;

import java.util.Scanner;

import controllers.ModuleLogin;

public class ejecutorLogin {
     private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ModuleLogin lis = new ModuleLogin();
        System.out.println("ingrese \n 1. registarse\n 2.iniciar sesion\n 3.salir");
        int option = sc.nextInt();
        do {            
            switch (option) {
                case 1:
                    System.out.println("ingrese un usuario");
                    String usuario = sc.next();
                    System.out.println("ingrese su contraseña");
                    String con = sc.next();
                    if(lis.registrousuarios(usuario, con)){
                        System.out.println("registro guardado");
                    } else {
                        System.out.println("no se pudo completar");
                    }
                    break;
                case 2:
                    System.out.println("ingrese su usuario");
                    String usurio = sc.next();
                    System.out.println("ingrese su contraseña");
                    String contrasena = sc.next();
                    if (lis.iniciosesion(usurio, contrasena)){
                        System.out.println("se inicio sesion");
                    }else {
                        System.out.println("contraseña o usuario incorrecto");
                    }
                    break;
                case 3:
                    System.out.println("saliendo del sistema");
                    break;
                default:
                    System.out.println("numero ingresado no valido");
            }
            System.out.println("desea salir presione 3 si desea continuar presione cualquier numero");
            option = sc.nextInt();
        } while (option != 3);
        sc.close();
    }

}
