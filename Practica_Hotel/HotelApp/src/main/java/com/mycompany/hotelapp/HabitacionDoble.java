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

//Hereda de Habitacion igual que la sencilla, la unica diferencia es el atributo extra
public class HabitacionDoble extends Habitacion {
    
    //Atributo extra que solo tiene la doble
    private int camasDobles;
    
    public HabitacionDoble (int numero, double precioPorNoche, int camasDobles){
    //Lo general se lo mandamos al padre
    super(numero,precioPorNoche);
    //Lo particular se guarda aqui
    this.camasDobles=camasDobles;
    }
    
    //Sobrescritura del metodo del padre (mismo nombre y mismos parametros)
    public void mostrarInfo(){
        System.out.println("[Habitacion Doble]");
        System.out.println("Habitacion #"+this.numero);
        System.out.println("  Precio por noche: $"+this.precioPorNoche);
        if(this.ocupada==true){
            System.out.println("  Estado: Ocupada");
        }else{
            System.out.println("  Estado: Libre");
        }
        System.out.println("  Camas dobles: "+this.camasDobles);
    }
    
}
