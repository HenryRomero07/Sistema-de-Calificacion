
package Tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HenryRomero
 */

public class ModeloTabla extends AbstractTableModel {
    private String[][] data;
    private String[] columnNames = { "Nombre", "Parcial 1", "Parcial 2", "Parcial 3", "Promedio Final"};

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
