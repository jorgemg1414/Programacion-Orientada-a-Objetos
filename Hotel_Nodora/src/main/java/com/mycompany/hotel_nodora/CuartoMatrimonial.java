/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel_nodora;

/**
 *
 * @author jorge
 */

//Equipo: De Anda Gomez Santiago, Martin Gomez Jorge, Martin Valencia Oscar Jesus, Yanez Sanchez Eduardo

//Hereda de Cuarto; es el cuarto para pareja, con una sola cama grande
public class CuartoMatrimonial extends Cuarto {

    //Precio compartido por todos los cuartos matrimoniales
    private static double precio=1200.0;

    public CuartoMatrimonial(int numero){
        super(numero);
    }

    @Override
    public String getTipo(){
        return "Matrimonial";
    }

    @Override
    public double getPrecio(){
        return precio;
    }

    //Cambia el precio de todos los matrimoniales
    @Override
    public void setPrecio(double nuevoPrecio){
        precio=nuevoPrecio;
    }

    @Override
    public int getCapacidad(){
        return 2;
    }

    @Override
    public String getCamas(){
        return "1 cama king size";
    }

    //Dibujo del cuarto visto desde arriba: una cama grande con un buro de cada lado
    @Override
    public void dibujar(){
        System.out.println("  +--------------[ ventana ]---------------+");
        System.out.println("  |                                        |");
        System.out.println("  |  [buro] +-----------------+ [buro]     |");
        System.out.println("  |         | (   )     (   ) |            |");
        System.out.println("  |         |                 |            |");
        System.out.println("  |         |       <3        |            |");
        System.out.println("  |         |                 |   [ sofa ] |");
        System.out.println("  |         +-----------------+            |");
        System.out.println("  |                                        |");
        System.out.println("  | [ closet ]       [ TV ]       [ baño ] |");
        System.out.println("  +---------------[ puerta ]---------------+");
    }
}
