/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelapp;
import java.util.*;

/**
 *
 * @author jorge
 */

//Equipo 4: Martin Gomez Jorge, Hernandez Martinez Sofia Rosita, Sigala Garcia Ulises
public class HotelApp {

    
    
    public static void main(String[] args) {
        //Este es un escanner para poder leer todo lo que el usuario teclea al ejecutar el programa
        Scanner sn=new Scanner(System.in);
        
        //Declaramos variables
        int menu; //Esta es la opción que escoge el usuario en el menú
        int numeroHabitaciones=5; //Cuantas habitaciones tiene el hotel
        int numero; //Numero de habitacion que teclea el usuario
        int noches; //Cuantas noches se va a quedar
        int posicion; //Posicion del arreglo donde esta la habitacion que busco el usuario
        int i; //Contador para recorrer el arreglo
        
        //Se declara el arreglo de objetos.
        //Como las tres clases hijas heredan de Habitacion, todas caben en el mismo arreglo.
        Habitacion habitaciones[]=new Habitacion[numeroHabitaciones];
        
        //Se crean 5 habitaciones de diferentes tipos (2 sencillas, 1 doble y 2 suites)
        habitaciones[0]=new HabitacionSencilla(101,800.0,1);
        habitaciones[1]=new HabitacionSencilla(102,950.0,2);
        habitaciones[2]=new HabitacionDoble(201,1500.0,2);
        habitaciones[3]=new Suite(301,3500.0,true,false);
        habitaciones[4]=new Suite(302,4200.0,true,true);
        
        /*******************************/
        System.out.println("Sistema de reservaciones del hotel");
        
        //Se recorre el arreglo y se imprime la info de cada habitacion.
        //Aunque el arreglo es de tipo Habitacion, cada objeto ejecuta SU version de
        //mostrarInfo() (la de Sencilla, Doble o Suite segun sea)
        for(i=0; i<numeroHabitaciones; i++){
            habitaciones[i].mostrarInfo();
            System.out.println("");
        }
        
        //Se usa do-while porque el menu debe mostrarse al menos una vez.
        //El ciclo se repite hasta que el usuario elija la opcion 5.
         
        do{
        System.out.println("");
        System.out.println("MENU");
        System.out.println("1. Reservar una habitacion");
        System.out.println("2. Calcular el costo total de una estancia");
        System.out.println("3. Mostrar el costo de todas las habitaciones por X noches");
        System.out.println("4. Liberar una habitacion");
        System.out.println("5. Salir");
        System.out.println("Dame tu opcion: ");
        menu=sn.nextInt();
        sn.nextLine(); //consume el salto de linea que deja nextInt
        
        //Aqui se manda a la opcion que haya escogido el usuario
        switch(menu){
            case 1: {
                System.out.println("Dame el numero de la habitacion a reservar");
                numero=sn.nextInt();
                sn.nextLine();
                
                //Se busca en el arreglo la habitacion que tenga ese numero.
                //posicion empieza en -1 que significa "no la encontre"
                posicion=-1;
                for(i=0; i<numeroHabitaciones; i++){
                    if(habitaciones[i].getNumero()==numero){
                        posicion=i;
                    }
                }
                
                //Red de seguridad: si no existe la habitacion el programa truena
                if(posicion==-1){
                    System.out.println("No existe la habitacion #"+numero);
                    break;
                }
                //El metodo reservar() se hereda del padre
                habitaciones[posicion].reservar();
                break;
            }
            case 2: {
                System.out.println("Dame el numero de la habitacion");
                numero=sn.nextInt();
                sn.nextLine();
                
                //La misma busqueda en el arreglo
                posicion=-1;
                for(i=0; i<numeroHabitaciones; i++){
                    if(habitaciones[i].getNumero()==numero){
                        posicion=i;
                    }
                }
                
                if(posicion==-1){
                    System.out.println("No existe la habitacion #"+numero);
                    break;
                }
                
                System.out.println("Cuantas noches?");
                noches=sn.nextInt();
                sn.nextLine();
                
                //calcularCosto tambien se hereda del padre
                System.out.println("Costo total por "+noches+" noches: $"+habitaciones[posicion].calcularCosto(noches));
                break;
            }
            case 3: {
                System.out.println("Cuantas noches?");
                noches=sn.nextInt();
                sn.nextLine();
                
                //Se recorre todo el arreglo y se imprime el costo de cada habitacion
                System.out.println("Costo de cada habitacion por "+noches+" noches:");
                for(i=0; i<numeroHabitaciones; i++){
                    System.out.println("  Habitacion #"+habitaciones[i].getNumero()+": $"+habitaciones[i].calcularCosto(noches));
                }
                break;
            }
            case 4: {
                System.out.println("Dame el numero de la habitacion a liberar");
                numero=sn.nextInt();
                sn.nextLine();
                
                posicion=-1;
                for(i=0; i<numeroHabitaciones; i++){
                    if(habitaciones[i].getNumero()==numero){
                        posicion=i;
                    }
                }
                
                if(posicion==-1){
                    System.out.println("No existe la habitacion #"+numero);
                    break;
                }
                habitaciones[posicion].liberar();
                break;
            }
            case 5: {
                //Esta es la unica salida del programa, hace que falle la condicion del do-while
                System.out.println("Saliendo del sistema");
                break;
            }
            default: {
                //Aqui cae cualquier numero que no sea del 1 al 5
                System.out.println("Esa opcion no existe");
            }
                
        }
        
        } while(menu!=5); //El menu se repite mientras el usuario no escoja salir
        
    }
}
