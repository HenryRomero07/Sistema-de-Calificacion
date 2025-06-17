package views;

import controllers.*;
import java.time.LocalDate;

public class EjecutorAlumnos {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("001", "Josue Torres", "josue@unl.edu.ec", "096josu", "Sistemas", 3);
        
        Materia prog = new Materia("MAT001", "Programación");
        Materia redes = new Materia("MAT002", "Redes");

        estudiante.agregarCalificacion(new Calificacion(prog, "Parcial", 88, LocalDate.of(2025,5,10)));
        estudiante.agregarCalificacion(new Calificacion(prog, "Final", 92, LocalDate.of(2025,6,1)));
        estudiante.agregarCalificacion(new Calificacion(redes, "Proyecto", 75, LocalDate.of(2025,6,8)));

        EstudianteView.mostrarMenuEstudiante(estudiante);
    }
}