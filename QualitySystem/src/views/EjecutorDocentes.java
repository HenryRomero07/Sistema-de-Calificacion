/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import static controllers.ModuleDocentes.cargarDatos;
import static controllers.ModuleDocentes.guardarDato;
import static controllers.ModuleDocentes.mostrarLista;
import static controllers.ModuleDocentes.seleccionarDeLista;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class EjecutorDocentes {
    static ArrayList<String> materias = new ArrayList<>();
    static ArrayList<String> estudiantes = new ArrayList<>();
    static ArrayList<String> notas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        cargarDatos("data/materias.txt", materias);
        cargarDatos("data/estudiantes.txt", estudiantes);
        cargarDatos("data/notas.txt", notas);

        int opcion;
        do {
            System.out.println("\n--- MÓDULO DOCENTE ---");
            System.out.println("1. Agregar materia");
            System.out.println("2. Ver materias");
            System.out.println("3. Agregar estudiante");
            System.out.println("4. Ver estudiantes");
            System.out.println("5. Registrar nota");
            System.out.println("6. Ver notas registradas");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre de la materia: ");
                    String materia = sc.nextLine();
                    if (!materias.contains(materia)) {
                        materias.add(materia);
                        guardarDato("data/materias.txt", materia);
                        System.out.println("Materia agregada.");
                    } else {
                        System.out.println("Esa materia ya existe.");
                    }
                }
                case 2 -> mostrarLista("Materias", materias);
                case 3 -> {
                    System.out.print("Nombre del estudiante: ");
                    String estudiante = sc.nextLine();
                    if (!estudiantes.contains(estudiante)) {
                        estudiantes.add(estudiante);
                        guardarDato("data/estudiantes.txt", estudiante);
                        System.out.println("Estudiante agregado.");
                    } else {
                        System.out.println("Ese estudiante ya fue agregado.");
                    }
                }
                case 4 -> mostrarLista("Estudiantes", estudiantes);
                case 5 -> {
                    if (materias.isEmpty() || estudiantes.isEmpty()) {
                        System.out.println("Debe haber al menos una materia y un estudiante para registrar notas.");
                        break;
                    }

                    int estIndex = seleccionarDeLista("estudiante", estudiantes, sc);
                    if (estIndex == -1) break;

                    int matIndex = seleccionarDeLista("materia", materias, sc);
                    if (matIndex == -1) break;

                    System.out.print("Ingrese nota: ");
                    double nota = sc.nextDouble();
                    sc.nextLine();

                    String registro = estudiantes.get(estIndex) + " | " + materias.get(matIndex) + " | Nota: " + nota;
                    notas.add(registro);
                    guardarDato("data/notas.txt", registro);
                    System.out.println("Nota registrada.");
                }
                case 6 -> mostrarLista("Notas registradas", notas);
                case 0 -> System.out.println("Saliendo del módulo docente...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}
