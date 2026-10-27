/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel_nodora;

/**
 *
 * @author jorge
 */

//Equipo: De Anda Gomez Santiago, Martin Gomez Jorge, Martin Valencia Oscar Jesus, Yanez Sanchez Eduardo

/*Clase BASE (padre) de los tipos de cliente.
 * Es abstracta porque todo cliente tiene que ser de algun tipo: habitual (socio) o esporadico.
 *
 * Para agregar un tipo nuevo de cliente (por ejemplo un ClienteVIP con mas descuento)
 * solo se crea class ClienteVIP extends Cliente y se sobrescribe getDescuento().
 * El resto del programa funciona igual porque siempre trabaja con variables de tipo Cliente.
 */
public abstract class Cliente {

    //Datos que tiene cualquier cliente
    protected String curp;
    protected String nombre;

    /*Constructor*/
    public Cliente(String curp, String nombre){
        this.curp=curp;
        this.nombre=nombre;
    }

    /*Metodos abstractos: cada tipo de cliente da su propia respuesta*/
    public abstract String getTipo();   //"habitual (socio)" o "esporadico"
    public abstract int getDescuento(); //Porcentaje de descuento que recibe (10 = 10%)

    //Le quita a un precio el descuento que le toca a ESTE cliente.
    //Ej: 1000 con 10% de descuento -> 1000 - 1000*10/100 = 900
    //Como getDescuento() es abstracto, se ejecuta la version del tipo de cliente que sea (polimorfismo)
    public double aplicarDescuento(double precio){
        return precio-precio*getDescuento()/100;
    }

    public void mostrarInfo(){
        System.out.println(this.nombre+" | CURP: "+this.curp+" | cliente "+getTipo());
    }

    /*Getters (no hay setters porque la CURP y el nombre no se cambian en el programa)*/
    public String getCurp(){
        return this.curp;
    }

    public String getNombre(){
        return this.nombre;
    }
}
