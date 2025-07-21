/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tables;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaNotas extends AbstractTableModel{
    private String [][] datos;
    private String[] columnas = {"MATERIA","UNIDAD 1", "UNIDAD 2", "UNIDAD 3", "PROMEDIO"};
    
    public ModeloTablaNotas (String [][] datos){
        this.datos = datos;
    }
         private double parseNota(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    @Override
    public int getRowCount() {
       return datos.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        try {
            double n1 = parseNota(datos[fila][4]);
            double n2 = parseNota(datos[fila][5]);
            double n3 = parseNota(datos[fila][6]);
            
            switch (columna){
                case 0:
                    return datos [fila][3];
                case 1:
                    return n1;
                case 2:
                    return n2;
                case 3:
                    return n3;
                case 4:
                    return String.format("%.2f",(n1 + n2 + n3) / 3);
                default:
                    return "";
             
            }
        } catch (Exception e){
            return "";
        }
    }
    @Override
    public String getColumnName(int column) {
       return columnas[column];
    }

}
