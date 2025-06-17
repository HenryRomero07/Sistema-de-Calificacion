package controllers;

import java.util.ArrayList;

public class ModuleLogin{
    ArrayList<UsuarioRE> Listusuario;
    public ModuleLogin(){
    this.Listusuario = new ArrayList<>();
}
    
    public boolean UseAcce(String usuario) {
            for (UsuarioRE us : Listusuario) {
                if (us.getNombreUsuario().equals(usuario)) {
                    return true;
                }
            }
            return false;
        }
    public boolean registrousuarios(String usuario, String contra) {
        if (UseAcce(usuario)) {
            System.out.println("usuario existente");
            return false;
        }else {
            Listusuario.add(new UsuarioRE(usuario, contra));
            return true;
        }
    }
    public boolean iniciosesion(String usuario, String contra){
        for (UsuarioRE us: Listusuario){
            if(us.getNombreUsuario().equals(usuario)&&us.getContrasena().equals(contra)){
                return true;
            }
        }
        return false;
    }
}
