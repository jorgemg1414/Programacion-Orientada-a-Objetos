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
public class Futbolista extends Persona {
    private int dorsal;
    private String demarcación;
    
    public Futbolista (String nombre, String apellido, int id, int edad, int dorsal, String demarcación){
    super(nombre,apellido,id,edad);
    this.dorsal=dorsal;
    this.demarcación=demarcación;
    }
    
    public void jugarPartido(){
        String equipoC;
        System.out.println("Jugar partido");
        Scanner sn = new Scanner (System.in);
        System.out.println("Dime contra qeu equipo es el partido");
        equipoC=sn.nextLine();
        System.out.println("El equipo está jugando contra"+equipoC+"\n");
        
    }
    
    public void entrenar(){
        System.out.println("Equipo en entrenamiento");
    }

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
