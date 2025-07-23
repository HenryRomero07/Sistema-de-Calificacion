/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;
import java.io.*;
/**
 *
 * @author Usuario iTC
 */
public class Utilidades {
    public String [][ ] listAll(String fileName) throws IOException {
        int lineCount = 0;
        BufferedReader br = new BufferedReader (new FileReader (fileName));
        while (br.readLine() != null){
            lineCount ++;
        }
        br.close();
        
        String [][] datos = new String [lineCount][];
        br = new BufferedReader (new FileReader(fileName));
        int index = 0;
        String linea;
        while ((linea = br.readLine())!= null){
            datos[index++] = linea.split("\t");
        }
        br.close();
        return datos;
    }
}

