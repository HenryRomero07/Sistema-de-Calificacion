package controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class moduleNotas {
    private static final int MAX_NOTAS = 5;
    private static Scanner scanner = new Scanner(System.in);

    // Clase interna para agrupar nombre y lista de notas
    public static class EstudianteNotas {
        public String nombre;
        public List<Double> notas;

        public EstudianteNotas(String nombre, List<Double> notas) {
            this.nombre = nombre;
            this.notas = notas;
        }
    }

    // Método para ingresar datos y devolver el resultado
    public static EstudianteNotas agregarNotasEstudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine().trim();
        List<Double> notas = new ArrayList<>();

        for (int i = 0; i < MAX_NOTAS; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + " (o -1 para terminar): ");
            double nota = scanner.nextDouble();
            if (nota == -1) {
                break;
            }
            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida, ingrese entre 0 y 10.");
                i--;
            } else {
                notas.add(nota);
            }
        }

        scanner.nextLine(); // limpiar buffer
        return new EstudianteNotas(nombre, notas);
    }

    // Método que genera un reporte
    public static void generarReporte(String nombre, List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            System.out.println("No hay notas registradas para " + nombre);
            return;
        }

        System.out.println("\nReporte de notas para: " + nombre);
        System.out.println("----------------------------------");
        for (int i = 0; i < notas.size(); i++) {
            System.out.printf("Nota %d: %.2f%n", i + 1, notas.get(i));
        }

        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        double promedio = suma / notas.size();
        System.out.printf("Promedio: %.2f%n", promedio);
    }
}
