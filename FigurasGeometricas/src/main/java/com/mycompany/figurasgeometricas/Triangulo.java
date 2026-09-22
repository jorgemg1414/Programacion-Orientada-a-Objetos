/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figurasgeometricas;

/**
 *
 * @author jorge
 */
public class Triangulo extends FigurasGeometricas {
    int base, altura;

    public Triangulo(int base, int altura, String nombre, String color, int grosorBorde) {
        super(nombre, color, grosorBorde);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void dibujar() {
        //Dibujar un triangulo con *
        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    @Override
    public void area() {
        System.out.println("area = " + (base * altura / 2.0));
    }

    @Override
    public void perimetro() {
        System.out.println("perimetro = " + (base * 3));
    }
    
    
    
}
