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

//Esta clase hereda de Cuarto, o sea que ya trae el numero, el precio, mostrarInfo() y los getters.
//Aqui nada mas se pone lo que es propio de un cuarto simple.
public class CuartoSimple extends Cuarto {

    //Este es el constructor, se manda a llamar con new CuartoSimple(101, 800)
    public CuartoSimple(int numero, double precio){
        //super manda los datos al constructor de la clase Cuarto
        super(numero,precio);
    }

    //De aqui para abajo se SOBRESCRIBEN los metodos abstractos del padre
    @Override
    public String getTipo(){
        return "Simple";
    }

    //Una cama individual, cabe una persona
    @Override
    public int getCapacidad(){
        return 1;
    }

    //Dibujo del cuarto visto desde arriba: una cama individual con su buro
    @Override
    public void dibujar(){
        System.out.println("  +--------------[ ventana ]---------------+");
        System.out.println("  |                                        |");
        System.out.println("  |   +---------+                          |");
        System.out.println("  |   |  (   )  |   [buro]                 |");
        System.out.println("  |   |         |                          |");
        System.out.println("  |   |         |                [ mesa  ] |");
        System.out.println("  |   |         |                [ silla ] |");
        System.out.println("  |   +---------+                          |");
        System.out.println("  |                                        |");
        System.out.println("  | [ closet ]                    [ baño ] |");
        System.out.println("  +---------------[ puerta ]---------------+");
    }
}
