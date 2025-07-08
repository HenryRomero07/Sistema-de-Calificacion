/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Usuario iTC
 */
public class Materia {
    private String nombre;
    private double[] notas;  
    private Docente docente;

 
    public Materia(String nombre, Docente docente) {
        this.nombre = nombre;
        this.notas = new double[3];  
        this.docente = docente;
    }

 
    public void agregarNota(int unidad, double nota) {
        if (unidad >= 1 && unidad <= 3) {
            notas[unidad - 1] = nota;
        }
    }

    public double[] getNotas() {
        return notas;
    }

    public double obtenerPromedio() {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }

    public String getNombre() {
        return nombre;
    }

    public Docente getDocente() {
        return docente;
    }
}
