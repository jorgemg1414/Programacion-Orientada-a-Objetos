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
        int menu = 0;
        boolean valido;
        System.out.println("Figuras Geometricas");
        System.out.println("!. Cuadrado");
        System.out.println("2. Triangulo");
        System.out.println("3. Circulo");
        
        
         do {
        System.out.println("Teclea una opcion");
        try {
            menu = sn.nextInt();
            valido = true;
        } catch (InputMismatchException e) {
            System.out.println("Error: debes teclear un numero");
            sn.nextLine();
            valido = false;
        }
    } while (!valido);
        
        

        //menu = sn.nextInt();
        switch (menu) {
    case 1: {
        Cuadrado micuadrado = new Cuadrado(0, "Cuadrado", "Rosa", 1);
        System.out.println("Pedir datos");
        do {
            System.out.println("Dame las medidas del lado");
            try {
                micuadrado.lado = sn.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debes teclear un numero");
                sn.nextLine();
                valido = false;
            }
        } while (!valido);
        micuadrado.dibujar();
        micuadrado.perimetro();
        micuadrado.area();
        break;
    }

    case 2: {
        Triangulo mitriangulo = new Triangulo(0, 0, "Triangulo", "Azul", 1);
        System.out.println("Pedir datos");
        do {
            System.out.println("Dame la base");
            try {
                mitriangulo.base = sn.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debes teclear un numero");
                sn.nextLine();
                valido = false;
            }
        } while (!valido);
        do {
            System.out.println("Dame la altura");
            try {
                mitriangulo.altura = sn.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debes teclear un numero");
                sn.nextLine();
                valido = false;
            }
        } while (!valido);
        mitriangulo.dibujar();
        mitriangulo.perimetro();
        mitriangulo.area();
        break;
    }

    case 3: {
        Circulo micirculo = new Circulo(0, "Circulo", "Verde", 1);
        System.out.println("Pedir datos");
        do {
            System.out.println("Dame el radio");
            try {
                micirculo.radio = sn.nextInt();
                valido = true;
                    } catch (InputMismatchException e) {
                System.out.println("Error: debes teclear un numero");
                sn.nextLine();
                valido = false;
                }
            } while (!valido);
            micirculo.dibujar();
            micirculo.perimetro();
            micirculo.area();
            break;
            }

        default:
        System.out.println("Opcion no valida");
        }
    }
}

/*
 * EXCEPCIONES DEL CATCH
 *
 * InputMismatchException: la que se usa en este programa. Ocurre cuando
 * el Scanner espera un numero (nextInt) y el usuario teclea letras,
 * simbolos o un decimal.
 *
 * Otras excepciones comunes:
 *
 * ArithmeticException: ocurre en operaciones matematicas invalidas,
 * como dividir un entero entre cero.
 *
 * NumberFormatException: ocurre al convertir un texto a numero con
 * Integer.parseInt() y el texto no es un numero valido.
 *
 * NullPointerException: ocurre al usar un objeto que vale null, es
 * decir, que no fue creado con new.
 *
 * ArrayIndexOutOfBoundsException: ocurre al acceder a una posicion
 * de un arreglo que no existe.
 *
 * Exception: es la excepcion general, atrapa cualquier tipo de error.
 */
