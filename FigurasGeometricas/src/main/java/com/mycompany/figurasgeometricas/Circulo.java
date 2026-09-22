/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figurasgeometricas;

/**
 *
 * @author jorge
 */
public class Circulo extends FigurasGeometricas {

    int radio;

    public Circulo(int radio, String nombre, String color, int grosorBorde) {
        super(nombre, color, grosorBorde);
        this.radio = radio;
    }

    @Override
    public void dibujar() {
        //Dibujar un circulo con *
        System.out.println("   ***  ");
        System.out.println(" ******* ");
        System.out.println("*********");
        System.out.println(" ******* ");
        System.out.println("   ***  ");
    }

    @Override
    public void area() {
        System.out.println("area = " + (3.1416 * radio * radio));
    }

    @Override
    public void perimetro() {
        System.out.println("perimetro = " + (2 * 3.1416 * radio));
    }
}
