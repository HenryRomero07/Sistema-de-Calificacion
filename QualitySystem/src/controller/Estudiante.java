/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Usuario iTC
 */
public class Estudiante {
    private String nombre;
    private String correo;
    private Materia[] materias;
    private int cantidadMaterias;

    public Estudiante(String nombre, String correo, int maxMaterias) {
        this.nombre = nombre;
        this.correo = correo;
        this.materias = new Materia[maxMaterias];
        this.cantidadMaterias = 0;
    }

    public void agregarMateria(Materia materia) {
        if (cantidadMaterias < materias.length) {
            materias[cantidadMaterias] = materia;
            cantidadMaterias++;
        }
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }
}
