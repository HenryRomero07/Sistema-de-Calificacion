package controllers;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String password;
    
    public Usuario(String id, String nombre, String email, String password){
        this.id = id;
        this.nombre = nombre; 
        this.email = email;
        this.password = password;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}