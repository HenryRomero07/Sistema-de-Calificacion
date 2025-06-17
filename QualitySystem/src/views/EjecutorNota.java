package views;

import java.util.List;
import java.util.Scanner;
import controllers.moduleNotas;
public class EjecutorNota {
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    moduleNotas.agregarNotasEstudiante();  // Ingresar datos
        moduleNotas.generarReporte(null, null);          
}
}
