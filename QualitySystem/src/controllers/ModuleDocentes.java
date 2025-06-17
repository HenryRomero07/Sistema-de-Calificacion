/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ModuleDocentes {
    public static void cargarDatos(String archivo, ArrayList<String> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (IOException e) {
            try {
                new File(archivo).createNewFile();
            } catch (IOException ignored) {}
        }
    }

    public static void guardarDato(String archivo, String dato) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(dato);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar en " + archivo);
        }
    }

    public static void mostrarLista(String titulo, ArrayList<String> lista) {
        System.out.println(titulo + ":");
        if (lista.isEmpty()) {
            System.out.println("No hay " + titulo.toLowerCase() + ".");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i));
            }
        }
    }

    public static int seleccionarDeLista(String tipo, ArrayList<String> lista, Scanner sc) {
        System.out.println("Seleccione " + tipo + ":");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
        System.out.print("Ingrese número: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        if (index < 0 || index >= lista.size()) {
            System.out.println("Selección inválida.");
            return -1;
        }
        return index;
    }
}

}
