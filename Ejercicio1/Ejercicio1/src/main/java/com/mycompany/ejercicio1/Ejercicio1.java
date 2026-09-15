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
        int numeroJugadores=0, contadorJugadores=0, jugador;
        String nombreEquipo;
        System.out.println("Estamos creando un equipo de futbol");
        System.out.println("Cuántos jugadores vas a comprar");
        numeroJugadores = sn.nextInt();
        sn.nextLine();
        System.out.println("Dame el nombre de tu equipo");
        nombreEquipo=sn.nextLine();
        //Futbolista jugador1=new Futbolista("","",0,0,0,"");
        Futbolista EquipoFutbol[]=new Futbolista[numeroJugadores];
        
        
        /*******************************?/
        System.out.println("Construyendo el equipo de futbol" + nombreEquipo);
        
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
                
                while(contadorJugadores<numeroJugadores){
                //Instanciar el objeto de cada una de las posiciones del arreglo
                EquipoFutbol[contadorJugadores]=new Futbolista("","",0,0,0,"");
                //Mandar a llamar los objetos de la clase futbolista
                
                System.out.println("Dame el nombre del futbolista");
                EquipoFutbol[contadorJugadores].setNombre(sn.nextLine());
                System.out.println("Apellido");
                EquipoFutbol[contadorJugadores].setNombre(sn.nextLine());
                System.out.println("ID");
                EquipoFutbol[contadorJugadores].setNombre(sn.nextLine());
                sn.nextLine();
                System.out.println("Edad");
                EquipoFutbol[contadorJugadores].setNombre(sn.nextLine());
                sn.nextLine();
                System.out.println("Dorsal");
                EquipoFutbol[contadorJugadores].setNombre(sn.nextLine());
                sn.nextLine();
                System.out.println("Demarcacion");
                EquipoFutbol[contadorJugadores].setNombre(sn.nextLine());
                contadorJugadores++;
                break;}
            }
            case 2: {
                System.out.println("Dime el numero de jugador que desea concentrarse");
                jugador=sn.nextInt();
                EquipoFutbol[jugador].consentrarse();
                break;
            }
            case 3:{
                System.out.println("Dime el numeor de jugador que desea que viaje");
                jugador=sn.nextInt();
                EquipoFutbol[jugador].viajar();
                break;
            }
            case 4: {
                System.out.println("Dime el numero de jugador que desea que juegue el partido");
                jugador=sn.nextInt();
                EquipoFutbol[jugador].jugarPartido();
                break;
            }
            case 5: {
                System.out.println("Dime el numero de jugador que desea que entrene");
                jugador=sn.nextInt();
                EquipoFutbol[jugador].entrenar();
                break;
            }
                
        }
        
    }
}
