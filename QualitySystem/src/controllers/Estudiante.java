package controllers;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
    private final String carrera;
    private final int semestre;
    private final List<Calificacion> calificaciones;

    public Estudiante(String id, String nombre, String email, String password, String carrera, int semestre){
        super(id, nombre, email, password);
        this.carrera = carrera;
        this.semestre = semestre;
        this.calificaciones = new ArrayList<>();
    }

    public void agregarCalificacion(Calificacion calificacion){
        calificaciones.add(calificacion);
    }

    public double obtenerPromedio() {
        if (calificaciones.isEmpty()) return 0.0;
        double suma = 0;
        for (Calificacion c : calificaciones) suma += c.getNota();
        return suma / calificaciones.size();
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public List<Calificacion> getCalificacionesPorMateria(String codigoMateria) {
        List<Calificacion> filtradas = new ArrayList<>();
        for (Calificacion c: calificaciones) {
            if (c.getMateria().getCodigo().equals(codigoMateria)) {
                filtradas.add(c);
            }
        }
        return filtradas;
    }

    public String getCarrera() { return carrera; }
    public int getSemestre() { return semestre; }
}