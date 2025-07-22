/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author franz
 */
public class ControllerLogin {
    Utilidades u = new Utilidades();
    private String namefile = "Cuentas"; 
    public boolean registrarCu(String cedula, String correo, String contrasena,String telefono){
        String data = cedula+"\t"+correo+"\t"+contrasena+"\t"+telefono+"\t"+true+"\n";
        try {
            u.save(data, namefile);
            return true;
        } catch (Exception e) {
            System.out.println("e");
            return false;
        }
    }
    public String[][] listar(){
        try {
            return u.listAll(namefile);
        } catch (Exception e) {
            return null;
        }
    }
    public boolean CoincidirCorreo(String correo, String correon) {
        boolean usuar = false;
        if (correo.equals(correon)) {
            usuar = true;
        }
        return usuar;
    }
    public boolean verifiCorreo(String correo) {
        boolean usuar = false;
        String[][] contrasenas = listar();
        if (contrasenas != null) {
            for (int i = 0; i < contrasenas.length; i++) {
                if (contrasenas[i][1].equals(correo)) {
                    usuar = true;
                    break;
                }
            }
        }
        return usuar;
    }
     public boolean verificarTelefono(String telefono) {
        boolean usuar = false;
        String[][] contrasenas = listar();
        if (contrasenas != null) {
            for (int i = 0; i < contrasenas.length; i++) {
                if (contrasenas[i][3].equals(telefono)) {
                    usuar = true;
                    break;
                }
            }
        }
        return usuar;
    }
    public boolean verificarCedula(String cedula) {
        boolean usuar = false;
        String[][] contrasenas = listar();
        if (contrasenas != null) {
            for (int i = 0; i < contrasenas.length; i++) {
                if (contrasenas[i][0].equals(cedula)) {
                    usuar = true;
                    break;
                }
            }
        }
        return usuar;
    }
    public String[] verificarCorreo(String correo) {
        String[][] data = listar();
        if (data != null) {
            String[] usuar = new String[data[0].length];
            Integer cont = -1;
            for (int i = 0; i < data.length; i++) {
                if (correo.equals(data[i][1])) {
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
    public String[] verificarcontraseña(String correo, String contrasena) {
        String[] data = verificarCorreo(correo);
        if (data!= null) {
            if (data[2].equals(contrasena)) {
                if (Boolean.parseBoolean(data[4])) {
                    return data;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return null;
    }
}

