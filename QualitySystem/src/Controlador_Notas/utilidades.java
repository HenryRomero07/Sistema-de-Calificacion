package Controlador_Notas;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
/** 
 *
 * @author darkj
 */
public class utilidades {
    private String path = "data";
    public void save(String text, String name_file) throws IOException{
        FileWriter file = new FileWriter(path+File.separatorChar+name_file, true);
        file.write(text);
        file.close();
        
    }
    public String[][] listAll(String name_file) throws IOException{
        String [][] data = null;       
        Integer filas = countRegister(name_file);
        if(filas > 0) {
            Integer col = countColumn(name_file);
            System.out.println("Columnas "+col);
            data = new String[filas][col];
            FileReader file = new FileReader(path+File.separatorChar+name_file);
            BufferedReader br = new BufferedReader(file);
            String linea = br.readLine();
            int fil = 0;
            while(linea != null) {
                String[] columas = linea.split("\t");
                for(int j = 0; j < columas.length; j++){
                    data[fil][j] = columas[j];
                }
                fil++;
                linea = br.readLine();
            }
            file.close();
            br.close();
        }
        
        System.out.println();
        return data;
    }
    
    private int countRegister(String name_file) throws  IOException {
        FileReader file = new FileReader(path+File.separatorChar+name_file);
        BufferedReader br = new BufferedReader(file);        
        int lines = (int)br.lines().count();
        file.close();
        br.close();
        return lines;
    }
    
    private int countColumn(String name_file) throws  IOException {
        FileReader file = new FileReader(path+File.separatorChar+name_file);
        BufferedReader br = new BufferedReader(file);        
        String line = br.readLine();
        file.close();
        br.close();
        return line.split("\t").length;
    }
    
}














}
