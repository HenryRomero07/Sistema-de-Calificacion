package Controlador_Notas;

import java.io.IOException;

/**
 *
 * @author Usuario iTC
 */
public class notasController {

    private utilidades u = new utilidades();
    private String file_name = "notas.txt";

    public String[][] relistar() throws IOException {
        String[][] allData = u.listAll(file_name);
        String[][] filteredData = new String[allData.length][10];
        for (int i = 0; i < allData.length; i++) {
            filteredData[i][0] = allData[i][1]; // Nombre
            filteredData[i][1] = allData[i][4]; // ACG 1
            filteredData[i][2] = allData[i][5]; // ACI 1
            filteredData[i][3] = allData[i][6]; // Examen 1
            filteredData[i][4] = allData[i][7]; // ACG 2
            filteredData[i][5] = allData[i][8]; // ACI 2
            filteredData[i][6] = allData[i][9]; // Examen 2
            filteredData[i][7] = allData[i][10]; // ACG 3
            filteredData[i][8] = allData[i][11]; // ACI 3
            filteredData[i][9] = allData[i][12]; // Examen 3
            
           
        }
        return filteredData;
    }

    public boolean guardar(Integer Cedula, String Nombres, String Correo, String Grado, Float Examen1, Float ActividadesGrupales1, Float ActividadesIndividuales1,
            Float Examen2, Float ActividadesGrupales2, Float ActividadesIndividuales2, Float Examen3, Float ActividadesGrupales3, Float ActividadesIndividuales3) {
        String data = Cedula + "\t" + Nombres + "\t" + Correo + "\t" + Grado + "\t" + Examen1 + "\t" + ActividadesGrupales1 + "\t" + ActividadesIndividuales1 + "\t" + Examen2 + "\t" + ActividadesGrupales2 + "\t" + ActividadesIndividuales2 + "\t" + Examen3 + "\t" + ActividadesGrupales3 + "\t" + ActividadesIndividuales3 + "\n";
        try {
            u.save(data, file_name);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String[][] listar() {
        try {
            return u.listAll(file_name);
        } catch (Exception e) {
            System.out.println("Error en listar " + e);
            return null;
        }

    }

}
