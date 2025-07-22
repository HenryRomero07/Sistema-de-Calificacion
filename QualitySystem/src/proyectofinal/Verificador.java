/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author franz
 */
public class Verificador {
    public String[] verificarCedula(String correo,String[][] listar) {
        String[][] data = listar;
        if (data != null) {
            String[] usuar = new String[data[0].length];
            Integer cont = -1;
            for (int i = 0; i < data.length; i++) {
                if (correo.equals(data[i][4])) {
                    cont = i;
                    break;
                }
            }
            if (cont>= 0){
                for (int i = 0; i < usuar.length; i++) {
                    usuar[i] = data[cont][i];
                }
            }else {
                usuar = null;
            }
            return usuar;
        }
        return null;
    }
    public String[] verificarcontraseña(String correo, String cedula, String[][] listar) {
        String[] verifica = verificarCedula(correo, listar);
        if (verifica != null) {
            if (verifica[0].equals(cedula)) {
                return verifica;
            } else {
                return null;
            }
        }
        return null;
    }
}
