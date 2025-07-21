/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.utiles.Utilidades;
public class AlumnosController {
    private Utilidades util = new Utilidades();
    private String archivo = "src/data/notas_estudiantes.txt";
    
    public String [][] buscarPorcorreo (String correo){
        try {
            String [][] todos = util.listAll(archivo);
            
            int count = 0;
            for (int i = 0; i < todos.length; i++){
                if(todos[i][2].equalsIgnoreCase(correo)){
                    count ++;
                }
            }
            String [][] filtrado = new String [count][];
            int pos = 0;
            for (int i = 0; i < todos.length; i ++){
                if (todos [i][2].equalsIgnoreCase(correo)){
                    filtrado[pos++] = todos [i];
                }
            }
            return filtrado;
        } catch (Exception e){
            System.out.println("Error al buscar: "+ e);
            return new String [0][];
        }
    }
}
