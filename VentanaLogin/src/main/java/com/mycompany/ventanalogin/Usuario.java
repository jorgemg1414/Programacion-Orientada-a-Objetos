package com.mycompany.ventanalogin;

/**
 *
 * @author jorge
 */
public class Usuario {

    //Atributos
    private String usuario;
    private String contrasena;

    //Constructor
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //Constructor vacio
    public Usuario() {
    }

    //Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}