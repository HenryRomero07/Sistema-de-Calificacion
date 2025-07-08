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
    AREstudiantes est = new AREstudiantes();
    ARdocentes doc = new ARdocentes();
    Utilidades u = new Utilidades();
    private String namefile = "Administrador"; 
    public boolean registrarAd(String usuario, String correo, String contrasena){
        String data = usuario+"\t"+correo+"\t"+contrasena+"\n";
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
            System.out.println("error en lista");
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
    public int verificarUsuarios(String usuario, String contrasena){
        int dato = 0;
        if((verificarUsuario(usuario)&&verificarcontraseña(contrasena))){
            return 1;
        }else if(est.verificarUsuario(usuario)&&est.verificarcontraseña(contrasena)){
            return 2;
        }else if(doc.verificarUsuario(usuario)&&doc.verificarcontraseña(contrasena)){
            return 3;
        }
        return dato;
    }
    
}

