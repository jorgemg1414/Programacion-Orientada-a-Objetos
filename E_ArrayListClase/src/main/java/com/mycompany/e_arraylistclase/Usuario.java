/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e_arraylistclase;

/**
 *
 * @author jorge
 */
//clase que representa a cada usuario que se guarda en la lista
public class Usuario {
    //atributos: el correo y la contraseña del usuario
    String correo, contraseña;

    //constructor que recibe el correo y la contraseña para crear el objeto
    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    //getters y setters para obtener y cambiar los atributos
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //constructor vacio
    public Usuario() {
    }


}