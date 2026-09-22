package com.mycompany.figurasgeometricas;

import java.util.*;

/**
 *
 * @author jorge
 */
public abstract class FigurasGeometricas {
    protected String nombre, color;
    int grosorBorde;

    //Aqui haremos un constructor para nuestros atributos
    public FigurasGeometricas(String nombre, String color, int grosorBorde) {
        this.nombre = nombre;
        this.color = color;
        this.grosorBorde = grosorBorde;
    }

    public abstract void dibujar();
    public abstract void area();
    public abstract void perimetro();

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int menu;
        System.out.println("Figuras Geometricas");
        System.out.println("!. Cuadrado");
        System.out.println("2. Triangulo");
        System.out.println("3. Circulo");
        System.out.println("Teclea una opcion");

        menu = sn.nextInt();
        switch (menu) {
            case 1: {
                Cuadrado micuadrado = new Cuadrado(0, "Cuadrado", "Rosa", 1);
                System.out.println("Pedir datos");
                System.out.println("Dame las medidas del lado");
                micuadrado.lado = sn.nextInt();
                micuadrado.dibujar();
                micuadrado.perimetro();
                micuadrado.area();
                break;
            }
            
            case 2: {
                Triangulo mitriangulo = new Triangulo(0, 0, "Triangulo", "Azul", 1);
                System.out.println("Pedir datos");
                System.out.println("Dame la base");
                mitriangulo.base = sn.nextInt();
                System.out.println("Dame la altura");
                mitriangulo.altura = sn.nextInt();
                mitriangulo.dibujar();
                mitriangulo.perimetro();
                mitriangulo.area();
                break;
            }
            
            case 3: {
                Circulo micirculo = new Circulo(0, "Circulo", "Verde", 1);
                System.out.println("Pedir datos");
                System.out.println("Dame el radio");
                micirculo.radio = sn.nextInt();
                micirculo.dibujar();
                micirculo.perimetro();
                micirculo.area();
                break;
            }
        }
    }
}
