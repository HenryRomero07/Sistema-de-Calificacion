package Modelo_Tabla;

import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Usuario iTC
 */
public class modelo_tabla extends AbstractTableModel{
private String data [][];
private String header [] = { "Nombres", "Examen1","ACG1", "AGI2" ,"Examen2", "ACG2","ACI2","Examen3"," ACG3", "ACG3"};
    public String[][] getData() {
        return data;
    }

    public void setData(String[][] Data) {
        this.data = Data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
         return (data == null)? 0:data.length;
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return header.length;
           }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return data [rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        
         return header[column];
    }
    
}

