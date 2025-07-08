/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */

public class ModeloTabla extends AbstractTableModel {
    private String[][] data;
    private String[] columnNames = {"ID", "Nombre", "Unidad 1", "Unidad 2", "Unidad 3", "Promedio Final"};

    public void setData(String[][] data) {
        this.data = data;
        fireTableDataChanged(); 
    }

    @Override
    public int getRowCount() {
        return (data == null) ? 0 : data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
