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
 * Para agregar un tipo nuevo de cuarto (por ejemplo una Suite) NO se cambia nada de esta clase:
 *   1. Se crea class Suite extends Cuarto y se le ponen sus metodos abstractos
 *   2. Se dan de alta sus cuartos en cargarDatosDeEjemplo() de Hotel_Nodora
 * Los menus que preguntan el tipo de cuarto se arman solos con los tipos que tenga el hotel.
 */
public abstract class Cuarto {

    //protected: las clases hijas lo pueden usar directo, pero el resto del programa no
    protected int numero; //Numero del cuarto, ej. 101

    /*Constructor*/
    public Cuarto(int numero){
        this.numero=numero;
    }

    /*Metodos abstractos
     * Aqui solo se declaran, sin cuerpo. Cada clase hija esta OBLIGADA a escribir su
     * propia version (con @Override). Gracias a esto el hotel trata a todos los cuartos
     * igual, aunque cada tipo conteste diferente (polimorfismo).
     */
    public abstract String getTipo();                  //Nombre del tipo: "Simple", "Doble", ...
    public abstract double getPrecio();                //Precio por noche del tipo de cuarto
    public abstract void setPrecio(double nuevoPrecio); //Cambia el precio de TODOS los cuartos de ese tipo
    public abstract int getCapacidad();                //Maximo de huespedes que caben
    public abstract String getCamas();                 //Que camas tiene
    public abstract void dibujar();                    //La "foto" del cuarto hecha con caracteres

    //Este metodo NO es abstracto porque es igual para todos los cuartos, asi que los hijos lo heredan tal cual.
    //Adentro llama a los metodos abstractos y cada hijo contesta con sus propios datos.
    //String.format("$%.2f", ...) deja el precio con 2 decimales, ej. 800.0 -> $800.00
    public void mostrarInfo(){
        System.out.println("Cuarto #"+this.numero+" | "+getTipo()+" | "+getCamas()
                +" | capacidad: "+getCapacidad()+" | "+String.format("$%.2f", getPrecio())+" por noche");
    }

    //Getter del numero (no lleva setter porque el numero de un cuarto no cambia)
    public int getNumero(){
        return this.numero;
    }
}
