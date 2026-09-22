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

//Esta clase hereda de Habitacion, o sea que ya trae el numero, el precio por noche,
//si esta ocupada, y todos los metodos (reservar, liberar, calcularCosto)
//Aqui nada mas se le agrega lo que es propio de una habitacion sencilla
public class HabitacionSencilla extends Habitacion {
    
    //Atributo extra que solo tiene la sencilla
    private int camasIndividuales;
    
    //Este es el constructor, se manda a llamar con new HabitacionSencilla
    public HabitacionSencilla (int numero, double precioPorNoche, int camasIndividuales){
    //super manda los 2 primeros datos al constructor de la clase Habitacion
    super(numero,precioPorNoche);
    //Este si es de esta clase, por eso se asigna aqui
    this.camasIndividuales=camasIndividuales;
    }
    
    //Este metodo SOBRESCRIBE el mostrarInfo() del padre: tiene el mismo nombre y
    //los mismos parametros, asi que cuando se llama en un objeto de esta clase
    //se ejecuta esta version y no la de Habitacion.
    //Como los atributos del padre son protected, aqui si se pueden usar directo.
    public void mostrarInfo(){
        System.out.println("[Habitacion Sencilla]");
        System.out.println("Habitacion #"+this.numero);
        System.out.println("  Precio por noche: $"+this.precioPorNoche);
        if(this.ocupada==true){
            System.out.println("  Estado: Ocupada");
        }else{
            System.out.println("  Estado: Libre");
        }
        //Y ya despues se agrega lo propio de esta clase
        System.out.println("  Camas individuales: "+this.camasIndividuales);
    }
    
}
