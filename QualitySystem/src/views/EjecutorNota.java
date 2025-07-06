package views;
import java.util.Scanner;

import controllers.modulo_notas;

public class EjecutorNota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         modulo_notas estudiante = new modulo_notas();
           System.out.println("Ingrese la nota 1:");
        float n1 = sc.nextFloat();

        System.out.println("Ingrese la nota 2:");
        float n2 = sc.nextFloat();

        System.out.println("Ingrese la nota 3:");
        float n3 = sc.nextFloat();

        // Asignar las notas al objeto
        estudiante.Asignar_Nota(n1, n2, n3);

        // Calcular y mostrar el promedio
        float promedio = estudiante.Calcular_promedio();
        System.out.printf("El promedio es: %.2f", promedio);
        sc.close();
    }
}