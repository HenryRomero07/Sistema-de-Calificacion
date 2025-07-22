/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author franz
 */
public class AREstudiantes {
    Utilidades u = new Utilidades();
    private String namefile = "Estudiantes"; 
    public boolean registrarEst(String cedula, String Nombres,String Apellidos,String telefono,String correo, String curso){
        String data = cedula+"\t"+Nombres+"\t"+Apellidos+"\t"+telefono+"\t"+correo+"\t"+curso+"\t"+"--"+"\t"+"--"+"\t"+"--"+"\n";
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
    public boolean verificarUsuario(String usuario) {
        boolean usuar = false;
        String[][] usuarios = listar();
        if (usuarios != null) {
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i][1].equals(usuario)) {
                    usuar = true;
                    break;
                }
            }
        }
        return usuar;
    }
    public boolean verificarcontraseña(String contrasena) {
        boolean usuar = false;
        String[][] contrasenas = listar();
        if (contrasenas != null) {
            for (int i = 0; i < contrasenas.length; i++) {
                if (contrasenas[i][2].equals(contrasena)) {
                    usuar = true;
                    break;
                }
            }
        }
        return usuar;
    }
}

