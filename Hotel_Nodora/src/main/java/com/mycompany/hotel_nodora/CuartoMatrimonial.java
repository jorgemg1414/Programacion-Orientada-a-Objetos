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

    public CuartoMatrimonial(int numero, double precio){
        super(numero,precio);
    }

    @Override
    public String getTipo(){
        return "Matrimonial";
    }

    //Una cama king size, caben 2 personas
    @Override
    public int getCapacidad(){
        return 2;
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
