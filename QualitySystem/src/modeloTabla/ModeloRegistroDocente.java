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
public class ModeloRegistroDocente extends AbstractTableModel {
    private String[][] docentes;

    public String[][] getDocentes() {
        return docentes;
    }

    public void setDocentes(String[][] docentes) {
        this.docentes = docentes;
    }
    
    @Override
    public int getRowCount() {
        return docentes.length;
    }

    @Override
    public int getColumnCount() {
        return docentes[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(docentes!=null){
            return docentes[rowIndex][columnIndex]; 
        }else{
            return null;
        }
    }
    
}
