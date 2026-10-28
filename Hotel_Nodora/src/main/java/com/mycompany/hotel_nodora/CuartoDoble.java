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

//Hereda de Cuarto igual que el simple; cambia el tipo, la capacidad y el dibujo
public class CuartoDoble extends Cuarto {

    public CuartoDoble(int numero, double precio){
        super(numero,precio);
    }

    @Override
    public String getTipo(){
        return "Doble";
    }

    //Dos camas matrimoniales, caben 2 personas en cada una
    @Override
    public int getCapacidad(){
        return 4;
    }

    //Dibujo del cuarto visto desde arriba: dos camas con un buro en medio
    @Override
    public void dibujar(){
        System.out.println("  +--------------[ ventana ]---------------+");
        System.out.println("  |                                        |");
        System.out.println("  |  +-----------+  [buro]  +-----------+  |");
        System.out.println("  |  | (  ) (  ) |          | (  ) (  ) |  |");
        System.out.println("  |  |           |          |           |  |");
        System.out.println("  |  |           |          |           |  |");
        System.out.println("  |  |           |          |           |  |");
        System.out.println("  |  +-----------+          +-----------+  |");
        System.out.println("  |                                        |");
        System.out.println("  | [ closet ]       [ TV ]       [ baño ] |");
        System.out.println("  +---------------[ puerta ]---------------+");
    }
}
