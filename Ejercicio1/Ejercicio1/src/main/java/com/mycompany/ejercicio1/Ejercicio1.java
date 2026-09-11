/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;
import java.util.*;

/**
 *
 * @author jorge
 */
public class Ejercicio1 {

    
    
    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        int menu;
        Futbolista jugador1=new Futbolista("","",0,0,0,"");
        System.out.println("Generando un equipo de futbol");
        System.out.println("1, Capturar datos de futbolista");
        System.out.println("2. Consentrarse");
        System.out.println("3. Viajar");
        System.out.println("4. Jugar");
        System.out.println("5. Entrenar");
        System.out.println("Dame tu opcion: ");
        menu=sn.nextInt();
        sn.nextLine(); //consume el salto de linea que deja nextInt
        switch(menu){
            case 1: {
                System.out.println("Dame el nombre del futbolista");
                jugador1.setNombre(sn.nextLine());
                System.out.println("Apellido");
                jugador1.setApellido(sn.nextLine());
                System.out.println("ID");
                jugador1.setId(sn.nextInt());
                sn.nextLine();
                System.out.println("Edad");
                jugador1.setEdad(sn.nextInt());
                sn.nextLine();
                System.out.println("Dorsal");
                jugador1.setDorsal(sn.nextInt());
                sn.nextLine();
                System.out.println("Demarcacion");
                jugador1.setDemarcación(sn.nextLine());
            }
            case 2: 
                jugador1.consentrarse();
            case 3:
                jugador1.viajar();
            case 4: 
                jugador1.jugarPartido();
            case 5: 
                jugador1.entrenar();
        }
        
    }
}
