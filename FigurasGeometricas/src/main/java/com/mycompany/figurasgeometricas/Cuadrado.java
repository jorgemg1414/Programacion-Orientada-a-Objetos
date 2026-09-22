/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figurasgeometricas;

/**
 *
 * @author jorge
 */

//Esta es la clase
public class Cuadrado extends FigurasGeometricas{

    int lado;

    public Cuadrado(int lado, String nombre, String color, int grosorBorde) {
        super(nombre, color, grosorBorde);
        this.lado = lado;
    }
    
    @Override
    public void dibujar() {
        //Dibujar un cuadrado con *
        for (int j = 0; j < lado; j++){
            
           for (int i = 0; i < lado; i++){
            System.out.print("*");
        } 
            System.out.println("");
        }
        
    }

    @Override
    public void area() {
        System.out.println("area = "+ lado * lado);
    }

    @Override
    public void perimetro() {
        System.out.println("perimétro = "+ lado * 4);
    }
    
}
