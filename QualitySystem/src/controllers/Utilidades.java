/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author franz
 */
public class Utilidades {
    private String path = "data";
    public void save(String text, String nameFile) throws IOException {
        FileWriter file = new FileWriter(path + File.separatorChar + nameFile, true);
        file.write(text);
        file.close();
    }
    public String[][] listAll(String nameFile) throws IOException{
        String [][] data = null;       
        Integer filas = numLine(nameFile);
        if(filas > 0) {
            Integer col = numColum(nameFile);
            System.out.println("Columnas "+col);
            data = new String[filas][col];
            FileReader file = new FileReader(path+File.separatorChar+nameFile);
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
    private int numLine(String nameFile) throws IOException{
        FileReader file = new FileReader(path+File.separatorChar+nameFile);
        BufferedReader br = new BufferedReader(file);
        int lines = (int)br.lines().count();
        file.close();
        br.close();
        return lines;
    }
    private int numColum(String nameFile) throws IOException{
        FileReader file = new FileReader(path+File.separatorChar+nameFile);
        BufferedReader br = new BufferedReader(file);
        String line = br.readLine();
        file.close();
        br.close();
        return line.split("\t").length;
    }

}
