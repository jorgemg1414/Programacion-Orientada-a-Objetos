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

//Esta clase hereda de Cuarto, o sea que ya trae el numero, mostrarInfo() y getNumero().
//Aqui nada mas se pone lo que es propio de un cuarto simple.
public class CuartoSimple extends Cuarto {

    /*El precio es static porque es del TIPO de cuarto y no de cada cuarto:
     * todos los cuartos simples comparten esta misma variable, asi que cuando el
     * administrador la cambia, cambia para todos los simples al mismo tiempo.
     */
    private static double precio=800.0;

    //Este es el constructor, se manda a llamar con new CuartoSimple(101)
    public CuartoSimple(int numero){
        //super manda el numero al constructor de la clase Cuarto
        super(numero);
    }

    //De aqui para abajo se SOBRESCRIBEN los metodos abstractos del padre
    @Override
    public String getTipo(){
        return "Simple";
    }

    @Override
    public double getPrecio(){
        return precio;
    }

    //Aunque se mande llamar desde un solo cuarto, como precio es static
    //cambia el precio de TODOS los cuartos simples
    @Override
    public void setPrecio(double nuevoPrecio){
        precio=nuevoPrecio;
    }

    @Override
    public int getCapacidad(){
        return 1;
    }

    @Override
    public String getCamas(){
        return "1 cama individual";
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
