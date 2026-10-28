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

/*Esta es la clase BASE (o padre) de todos los tipos de cuarto.
 * Es abstracta, igual que FigurasGeometricas: no se puede hacer new Cuarto(...),
 * solo new CuartoSimple(...), new CuartoDoble(...) o new CuartoMatrimonial(...).
 *
 * Para agregar un tipo nuevo de cuarto (por ejemplo una Suite):
 *   1. Se crea class Suite extends Cuarto y se le ponen sus metodos abstractos
 *   2. Se agrega su opcion en elegirTipo() y sus cuartos en cargarDatosDeEjemplo() de Hotel_Nodora
 */
public abstract class Cuarto {

    //protected: las clases hijas los pueden usar directo, pero el resto del programa no
    protected int numero;    //Numero del cuarto, ej. 101
    protected double precio; //Precio por noche

    /*Constructor*/
    public Cuarto(int numero, double precio){
        this.numero=numero;
        this.precio=precio;
    }

    /*Metodos abstractos
     * Aqui solo se declaran, sin cuerpo. Cada clase hija esta OBLIGADA a escribir su
     * propia version (con @Override). Gracias a esto el hotel trata a todos los cuartos
     * igual, aunque cada tipo conteste diferente (polimorfismo).
     */
    public abstract String getTipo();   //Nombre del tipo: "Simple", "Doble" o "Matrimonial"
    public abstract int getCapacidad(); //Maximo de huespedes que caben
    public abstract void dibujar();     //La "foto" del cuarto hecha con caracteres

    //Este metodo NO es abstracto porque es igual para todos los cuartos, asi que los hijos lo heredan tal cual.
    //String.format("%.2f", ...) deja el precio con 2 decimales, ej. 800.0 -> 800.00
    public void mostrarInfo(){
        System.out.println("Cuarto #"+this.numero+" | "+getTipo()+" | capacidad: "+getCapacidad()
                +" | $"+String.format("%.2f", this.precio)+" por noche");
    }

    /*Getters y setters*/
    public int getNumero(){
        return this.numero;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setPrecio(double precio){
        this.precio=precio;
    }
}
