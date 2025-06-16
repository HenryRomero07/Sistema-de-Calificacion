package controllers;

import java.util.Scanner;

public class ModuleMaterias {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        String[] materias = new String[10];
        String[][] criterios = new String[10][5];
        double[][] porcentajes = new double[10][5];
        int cantidadMaterias = 0;

        System.out.println(" MATERIAS Y SUS CRITERIOS DE EVALUACIÓN ");

        String continuarMateria = "si";
        while (continuarMateria.equalsIgnoreCase("si") && cantidadMaterias < 10) {
            System.out.print("Ingrese el nombre de la materia: ");
            materias[cantidadMaterias] = sc.nextLine();

            int cantidadCriterios = 0;
            double suma = 0;
            String continuarCriterio = "si";

            while (continuarCriterio.equalsIgnoreCase("si") && cantidadCriterios < 5) {
                System.out.print("Ingrese el criterio a evaluar: ");
                criterios[cantidadMaterias][cantidadCriterios] = sc.nextLine();

                System.out.print("Ingrese el porcentaje del criterio a evaluar (sin %): ");
                porcentajes[cantidadMaterias][cantidadCriterios] = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                suma += porcentajes[cantidadMaterias][cantidadCriterios];

                if (suma > 100) {
                    System.out.println("La suma de los porcentajes no puede superar 100%. vuelva a iniciar.\n");
                    cantidadCriterios = 0;
                    suma = 0;
                    continue;
                }

                cantidadCriterios++;

                if (cantidadCriterios < 5) {
                    System.out.print("¿Quieres ingresar otro criterio? (si/no): ");
                    continuarCriterio = sc.nextLine();
                } else {
                    break;
                }
            }

            cantidadMaterias++;

            System.out.print("¿ Quieres ingresar otra materia? (si/no): ");
            continuarMateria = sc.nextLine();
        }

        // Mostrar resultados
        System.out.println("\n LISTA DE MATERIAS CON SUS CRITERIOS DE EVALUACIÓN ");
        for (int i = 0; i < cantidadMaterias; i++) {
            System.out.println("Materia: " + materias[i]);
            for (int j = 0; j < 5; j++) {
                if (criterios[i][j] != null) {
                    System.out.println("  - " + criterios[i][j] + ": " + porcentajes[i][j] + "%");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}