/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloTabla;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author franz
 */
public class ModeloRegistroEstudiante extends AbstractTableModel {
    private String[][] estudiantes;

    public String[][] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(String[][] estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    @Override
    public int getRowCount() {
        return estudiantes.length;
    }

    @Override
    public int getColumnCount() {
        return estudiantes[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(estudiantes!=null){
             return estudiantes[rowIndex][columnIndex];
        }else {
            return null;
        }
    }
    
}
