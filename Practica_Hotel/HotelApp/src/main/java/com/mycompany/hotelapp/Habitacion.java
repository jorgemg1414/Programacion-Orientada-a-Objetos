/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelapp;

/**
 *
 * @author jorge
 */

//Equipo 4: Martin Gomez Jorge, Hernandez Martinez Sofia Rosita, Sigala Garcia Ulises

//Esta es la clase BASE (o padre). De aqui van a heredar los tres tipos de habitacion.
public class Habitacion {
    /*Atributos
     * Son protected (encapsulamiento): el resto del programa no los lee directo,
     * pero las clases hijas si los pueden usar porque heredan de esta.
     */
    protected int numero;           //Numero de la habitacion
    protected double precioPorNoche; //Lo que cuesta la habitacion por una noche
    protected boolean ocupada;       //true = ocupada, false = libre
    
    /*Constructor*/
    Habitacion(int numero, double precioPorNoche){
    this.numero=numero;
    this.precioPorNoche=precioPorNoche;
    //Toda habitacion empieza libre, por eso no se pide como parametro
    this.ocupada=false;
    }
    
    //Muestra la informacion general de la habitacion.
    //Las clases hijas lo van a SOBRESCRIBIR para agregar sus datos particulares.
    public void mostrarInfo(){
        System.out.println("Habitacion #"+this.numero);
        System.out.println("  Precio por noche: $"+this.precioPorNoche);
        if(this.ocupada==true){
            System.out.println("  Estado: Ocupada");
        }else{
            System.out.println("  Estado: Libre");
        }
    }
    
    //Marca la habitacion como ocupada
    public void reservar(){
        this.ocupada=true;
        System.out.println("La habitacion #"+this.numero+" quedo reservada");
    }
    
    //Marca la habitacion como libre
    public void liberar(){
        this.ocupada=false;
        System.out.println("La habitacion #"+this.numero+" quedo libre");
    }
    
    //Regresa el costo total de la estancia: precio por noche * noches.
    //Ejemplo: si cuesta 1000 por noche y son 3 noches, regresa 3000.
    public double calcularCosto(int noches){
        return this.precioPorNoche*noches;
    }
    
    /*Getters: se necesitan para que HotelApp pueda leer el numero y el precio
     * sin tocar los atributos directamente
     */
    public int getNumero(){
        return this.numero;
    }
    
    public double getPrecioPorNoche(){
        return this.precioPorNoche;
    }
}
