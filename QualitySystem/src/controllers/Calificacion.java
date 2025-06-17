package controllers;

import java.time.LocalDate;

public class Calificacion {
    private Materia materia;
    private String descripcion;
    private double nota;
    private LocalDate fecha;

    public Calificacion(Materia materia, String descripcion, double nota, LocalDate fecha) {
        this.materia = materia;
        this.descripcion = descripcion;
        this.nota = nota;
        this.fecha = fecha;
    }

    public Materia getMateria() { return materia; }
    public String getDescripcion() { return descripcion; }
    public double getNota() { return nota; }
    public LocalDate getFecha() { return fecha; }
}