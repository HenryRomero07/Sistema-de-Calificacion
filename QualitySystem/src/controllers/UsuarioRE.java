package controllers;

public class UsuarioRE {
    private String nombreUsuario;
    private String contrasena;

    public UsuarioRE(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Getters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

}
