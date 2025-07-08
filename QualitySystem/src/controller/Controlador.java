/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.*;
import javax.swing.table.DefaultTableModel;
import view.Sistemalumnos;

public class Controlador {

    public void cargarDatos(Sistemalumnos vista) {
    try {
        InputStream input = getClass().getResourceAsStream("/notas_estudiantes.txt");
        if (input == null) {
            throw new FileNotFoundException("No se encontró el archivo notas_estudiantes.txt");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String linea;

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"MATERIA", "UNIDAD 1", "UNIDAD 2", "UNIDAD 3", "PROMEDIO"}, 0);
        Estudiante estudiante = new Estudiante("Juan Pérez", "juanperez@example.com", 4);

        vista.setNombreEstudiante(estudiante.getNombre());
        vista.setCorreoEstudiante(estudiante.getCorreo());

        double promedioTotal = 0;
        int cantidadMaterias = 0;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            String correoEstudiante = datos[0];
            String nombreMateria = datos[1];
            String nombreDocente = datos[2];
            double[] notas = new double[3];
            notas[0] = Double.parseDouble(datos[3]);
            notas[1] = Double.parseDouble(datos[4]);
            notas[2] = Double.parseDouble(datos[5]);

            if (estudiante.getCorreo().equals(correoEstudiante)) {
                Docente docente = new Docente(nombreDocente);
                Materia materia = new Materia(nombreMateria, docente);

                for (int i = 0; i < 3; i++) {
                    materia.agregarNota(i + 1, notas[i]);
                }
                estudiante.agregarMateria(materia);

                double promedioMateria = materia.obtenerPromedio();

                model.addRow(new Object[]{
                    nombreMateria,
                    notas[0],
                    notas[1],
                    notas[2],
                    promedioMateria
                });

                promedioTotal += promedioMateria;
                cantidadMaterias++;
            }
        }

        br.close();

        double promedioFinalTotal = promedioTotal / cantidadMaterias;
        vista.setPromedioFinal(promedioFinalTotal);
        vista.setTableModel(model);

    } catch (IOException e) {
        System.out.println("Error al leer el archivo");
        e.printStackTrace();
    }
}
}