/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int result = 1;
        System.out.println("Ingrese el numero");
        int num = sc.nextInt();
        for (int i = 2; i <= num; i ++){
            result = result * i;
        }
        System.out.println("El factorial de "+num+" es: "+result);
    }
}


