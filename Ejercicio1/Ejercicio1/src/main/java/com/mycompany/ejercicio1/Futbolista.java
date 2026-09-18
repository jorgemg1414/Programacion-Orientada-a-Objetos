/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;
import java.util.*;

/**
 *
 * @author jorge
 */

//Esta clase hereda de Persona, o sea que ya trae el nombre, apellido, id y edad
//Aqui nada mas se le agrega lo que es propio de un futbolista
public class Futbolista extends Persona {
    
    //Los atributos van privados para que nadie los modifique directo desde afuera
    //Solo se pueden tocar con los get y set de abajo
    private int dorsal;
    private String demarcación; //La posicion en la que juega (portero, defensa, etc)
    
    //Este es el constructor, se manda a llamar con new Futbolista
    public Futbolista (String nombre, String apellido, int id, int edad, int dorsal, String demarcación){
    //super manda los 4 primeros datos al constructor de la clase Persona
    super(nombre,apellido,id,edad);
    //Estos dos si son de esta clase, por eso se asignan aqui
    //El this sirve para diferenciar el atributo del parametro, porque se llaman igual
    this.dorsal=dorsal;
    this.demarcación=demarcación;
    }
    
    //Metodo propio del futbolista, pide el equipo contrario y lo imprime
    public void jugarPartido(){
        String equipoC;
        System.out.println("Jugar partido");
        //Se necesita otro Scanner porque el del main no llega hasta aca
        Scanner sn = new Scanner (System.in);
        System.out.println("Dime contra qeu equipo es el partido");
        equipoC=sn.nextLine();
        System.out.println("El equipo está jugando contra"+equipoC+"\n");
        
    }
    
    //Este metodo nada mas imprime un mensaje, no pide datos
    public void entrenar(){
        System.out.println("Equipo en entrenamiento");
    }

    //De aqui para abajo van los get y set de los atributos privados
    //El get regresa el valor y el set lo cambia
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getDemarcación() {
        return demarcación;
    }

    public void setDemarcación(String demarcación) {
        this.demarcación = demarcación;
    }
    
}