package views;

import controllers.moduleNotas;
import controllers.moduleNotas.EstudianteNotas;

public class EjecutorNota {
    public static void main(String[] args) {
        EstudianteNotas estudiante = moduleNotas.agregarNotasEstudiante();
        moduleNotas.generarReporte(estudiante.nombre, estudiante.notas);
    }
}