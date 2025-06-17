package controllers;

import java.util.*;
import java.time.LocalDate;

public class EstudianteView {
    private static final Scanner sc = new Scanner(System.in);

    public static void VerMisCalificaciones(Estudiante estudiante){
        List<Calificacion> calificaciones = estudiante.getCalificaciones();
        if (calificaciones.isEmpty()) {
            System.out.println("No tiene calificaciones registradas.");
            return;
        }
        System.out.println("-- Mis calificaciones --");
        for (Calificacion cal : calificaciones) {
            String materia = cal.getMateria().getNombre();
            String descripcion = cal.getDescripcion();
            double nota = cal.getNota();
            String letra = convertirNotaLetra(nota);
            String fecha = cal.getFecha().toString();
            System.out.printf("Materia: %s | %s | Nota: %.2f (%s) | Fecha: %s\n", materia, descripcion, nota, letra, fecha);
        }
    }

    public static void verPromedioGeneral(Estudiante estudiante) {
        double promedio = estudiante.obtenerPromedio();
        String letra = convertirNotaLetra(promedio);
        System.out.printf("Estudiante: %s\nCarrera: %s | Semestre: %d\n", estudiante.getNombre(), estudiante.getCarrera(), estudiante.getSemestre());
        System.out.printf("Promedio General: %.2f (%s)\n", promedio, letra);
    }

    public static void verCalificacionesPorMateriaEstudiante(Estudiante estudiante) {
        Map<String, List<Calificacion>> agrupadas = new HashMap<>();
        for (Calificacion cal : estudiante.getCalificaciones()){
            String codigo = cal.getMateria().getCodigo();
            agrupadas.computeIfAbsent(codigo, k -> new ArrayList<>()).add(cal);
        }
        if(agrupadas.isEmpty()) {
            System.out.println("No hay calificaciones para mostrar.");
            return;
        }
        for (String codigo : agrupadas.keySet()) {
            List<Calificacion> lista = agrupadas.get(codigo);
            String nombreMateria = lista.get(0).getMateria().getNombre();
            System.out.println("Materia: "+ nombreMateria);
            double suma = 0;
            for (Calificacion cal : lista) {
                System.out.printf(" - %s | Nota: %.2f | Fecha: %s\n", cal.getDescripcion(), cal.getNota(), cal.getFecha().toString());
                suma += cal.getNota();
            }
            double promedio = suma / lista.size();
            String letra = convertirNotaLetra(promedio);
            System.out.printf(" Promedio: %.2f (%s)\n", promedio, letra);
        }
    }

    public static void mostrarMenuEstudiante(Estudiante estudiante) {
        int option;
        do { 
            System.out.println("\n --- Menú Estudiante ---");
            System.out.println("1. Ver calificaciones");
            System.out.println("2. Ver promedio general");
            System.out.println("3. Ver calificaciones por materia");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!sc.hasNextInt()){
                System.out.println("Entrada inválida.\nIngrese un número: ");
                sc.nextLine();
            }
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: 
                    VerMisCalificaciones(estudiante);
                    break;
                case 2:
                    verPromedioGeneral(estudiante);
                    break;
                case 3: 
                    verCalificacionesPorMateriaEstudiante(estudiante);
                    break;
                case 0: 
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida"); 
                    break;
            }

        } while (option != 0);
    }

    private static String convertirNotaLetra(double nota) {
        if (nota >= 90) return "A";
        else if (nota >= 80) return "B";
        else if (nota >= 70) return "C";
        else if (nota >= 60) return "D";
        else return "F";
    }
}