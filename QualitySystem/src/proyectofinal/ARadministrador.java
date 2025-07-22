/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author franz
 */
public class ARadministrador {
    Utilidades u = new Utilidades();
    private String namefile = "Administrador"; 
    public boolean registrarAdm(String cedula, String Nombres,String Apellidos,String telefono,String correo){
        String data = cedula+"\t"+Nombres+"\t"+Apellidos+"\t"+telefono+"\t"+correo+"\n";
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
    public boolean verificarcedula(String cedula) {
        boolean usuar = false;
        String[][] usuarios = listar();
        if (usuarios != null) {
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i][0].equals(cedula)) {
                    usuar = true;
                    break;
                }
            }
        }
        return usuar;
    }
}

