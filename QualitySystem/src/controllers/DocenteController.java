
package controllers;

import java.io.IOException;

/**
 *
 * @author HenryRomero
 */
public class DocenteController {

    private Utiles u = new Utiles();

    String name_file = "estudiantes.txt";

    public String[][] listar() throws IOException {
        String[][] allData = u.listAll(name_file); 
        String[][] filteredData = new String[allData.length][6]; 
        for (int i = 0; i < allData.length; i++) {
            filteredData[i][0] = allData[i][0]; // ID
            filteredData[i][1] = allData[i][1]; // Nombres de estudiante
            filteredData[i][2] = allData[i][4]; // Nota de unidad 1
            filteredData[i][3] = allData[i][5]; // Nota de unidad 2
            filteredData[i][4] = allData[i][6]; // Nota de unidad 3
            filteredData[i][5] = allData[i][7]; // Promedio
        }
        return filteredData; 
    }
    
    

    public String[][] listarPorMateria(String materia) throws IOException {
        String[][] allData = u.listAll(name_file); 
        int count = 0;
        
        for (String[] row : allData) {
            if (row[3].equalsIgnoreCase(materia)) { 
                count++;
            }
        }

        
        String[][] filteredData = new String[count][6]; 

        
        int index = 0;
        for (String[] row : allData) {
            if (row[3].equalsIgnoreCase(materia)) {
                filteredData[index][0] = row[0]; // ID
                filteredData[index][1] = row[1]; // Nombres del estudiante
                filteredData[index][2] = row[4]; // Nota de unidad 1
                filteredData[index][3] = row[5]; // Nota de unidad 2
                filteredData[index][4] = row[6]; // Nota de unidad 3
                filteredData[index][5] = row[7]; // Promedio 
                index++;
            }
        }

        return filteredData; 
    }

    
}
