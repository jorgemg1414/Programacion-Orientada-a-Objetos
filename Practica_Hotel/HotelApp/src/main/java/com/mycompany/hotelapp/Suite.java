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

//La Suite tambien hereda de Habitacion, pero esta tiene DOS atributos extra
public class Suite extends Habitacion {
    
    //Atributos extra que solo tiene la suite
    private boolean tieneJacuzzi;
    private boolean tieneVistaMar;
    
    public Suite (int numero, double precioPorNoche, boolean tieneJacuzzi, boolean tieneVistaMar){
    super(numero,precioPorNoche);
    this.tieneJacuzzi=tieneJacuzzi;
    this.tieneVistaMar=tieneVistaMar;
    }
    
    //Sobrescritura del metodo del padre
    public void mostrarInfo(){
        System.out.println("[Suite]");
        System.out.println("Habitacion #"+this.numero);
        System.out.println("  Precio por noche: $"+this.precioPorNoche);
        if(this.ocupada==true){
            System.out.println("  Estado: Ocupada");
        }else{
            System.out.println("  Estado: Libre");
        }
        //Como son boolean se usa if para que imprima Si/No en vez de true/false
        if(this.tieneJacuzzi==true){
            System.out.println("  Jacuzzi: Si");
        }else{
            System.out.println("  Jacuzzi: No");
        }
        if(this.tieneVistaMar==true){
            System.out.println("  Vista al mar: Si");
        }else{
            System.out.println("  Vista al mar: No");
        }
    }
    
}
