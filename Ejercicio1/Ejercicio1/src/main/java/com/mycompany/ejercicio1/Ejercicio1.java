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
        //Este es un escanner para poder leer todo lo que el usuario teclea al ejecutar el programa
        Scanner sn=new Scanner(System.in);
        
        //Declaramos variables
        int menu; //Esta es la opción que escoge el usuario en el menú
        //Se inicializa el numero de jugadores y el contador en 0 para que empieze a contar desde ahí
        int numeroJugadores=0, contadorJugadores=0, jugador;
        String nombreEquipo;
        String otro; //Variable que se necesita en el menú para seleccionar otro
        
        //Esto es lo que vamos a imprimir en consola
        System.out.println("Estamos creando un equipo de futbol");
        System.out.println("Cuántos jugadores vas a comprar");
        numeroJugadores = sn.nextInt();
        sn.nextLine(); //Esta función limpia el salto de linea
        System.out.println("Dame el nombre de tu equipo");
        nombreEquipo=sn.nextLine();
        //Futbolista jugador1=new Futbolista("","",0,0,0,"");
        
        //Se declara el arreglo con el tamaño que indico el usuario.
        //Ojo: esto solo reserva los espacios, todos valen null hasta que
        //cada posicion se instancie con new Futbolista(...) en el case 1.
        Futbolista EquipoFutbol[]=new Futbolista[numeroJugadores];
        
        
        /*******************************/
        System.out.println("Construyendo el equipo de futbol " + nombreEquipo);
        
        //Se usa do-while porque el menu debe mostrarse al menos una vez.
        //El ciclo se repite hasta que el usuario elija la opcion 6.*/
         
        do{
        System.out.println("");
        System.out.println("Generando un equipo de futbol");
        System.out.println("1, Capturar datos de futbolista");
        System.out.println("2. Consentrarse");
        System.out.println("3. Viajar");
        System.out.println("4. Jugar");
        System.out.println("5. Entrenar");
        System.out.println("6. Salir");
        System.out.println("Dame tu opcion: ");
        menu=sn.nextInt();
        sn.nextLine(); //consume el salto de linea que deja nextInt
        
        //Aqui se manda a la opcion que haya escogido el usuario
        switch(menu){
            case 1: {
                //Red de seguridad: si ya esta llena la plantilla, ni entra
                if(contadorJugadores>=numeroJugadores){
                    System.out.println("Ya tienes tus " + numeroJugadores + " jugadores");
                    break;
                }
                
                otro="s"; //Se le da un valor inicial porque el while de abajo la ocupa
                
                //Este do-while captura un jugador y hasta despues pregunta si quiere otro
                do{
                //Instanciar el objeto de cada una de las posiciones del arreglo
                EquipoFutbol[contadorJugadores]=new Futbolista("","",0,0,0,"");
                //Mandar a llamar los objetos de la clase futbolista
                
                System.out.println("Dame el nombre del futbolista");
                EquipoFutbol[contadorJugadores].setNombre(sn.nextLine());
                System.out.println("Apellido");
                EquipoFutbol[contadorJugadores].setApellido(sn.nextLine());
                //Estos tres son int en la clase Futbolista, por eso se convierten con parseInt
                System.out.println("ID");
                EquipoFutbol[contadorJugadores].setId(Integer.parseInt(sn.nextLine()));
                System.out.println("Edad");
                EquipoFutbol[contadorJugadores].setEdad(Integer.parseInt(sn.nextLine()));
                System.out.println("Dorsal");
                EquipoFutbol[contadorJugadores].setDorsal(Integer.parseInt(sn.nextLine()));
                System.out.println("Demarcacion");
                EquipoFutbol[contadorJugadores].setDemarcación(sn.nextLine());
                contadorJugadores++; //Se suma uno para pasar a la siguiente posicion del arreglo
                
                //Si ya se lleno la plantilla ni caso tiene preguntar
                if(contadorJugadores>=numeroJugadores){
                    System.out.println("Ya completaste la plantilla de " + numeroJugadores + " jugadores");
                    break; //este break rompe el do-while interno
                }
                
                System.out.println("¿Capturas otro jugador? (s/n)");
                otro=sn.nextLine();
                
                } while(otro.equalsIgnoreCase("s")); //equalsIgnoreCase acepta la s en mayuscula o minuscula
                
                break; //este break cierra el case 1
            }
            case 2: {
                System.out.println("Dime el numero de jugador que desea concentrarse");
                jugador=sn.nextInt();
                sn.nextLine();
                //Se revisa que la posicion exista en el arreglo y que ya tenga jugador
                //Si no, el programa truena al mandar a llamar el metodo
                if(jugador<0 || jugador>=numeroJugadores || EquipoFutbol[jugador]==null){
                    System.out.println("Ese jugador no existe o no lo has capturado");
                    break;
                }
                //Se manda a llamar el metodo de la clase Persona
                EquipoFutbol[jugador].consentrarse();
                break;
            }
            case 3:{
                System.out.println("Dime el numeor de jugador que desea que viaje");
                jugador=sn.nextInt();
                sn.nextLine();
                //La misma validacion de la posicion del arreglo
                if(jugador<0 || jugador>=numeroJugadores || EquipoFutbol[jugador]==null){
                    System.out.println("Ese jugador no existe o no lo has capturado");
                    break;
                }
                EquipoFutbol[jugador].viajar();
                break;
            }
            case 4: {
                System.out.println("Dime el numero de jugador que desea que juegue el partido");
                jugador=sn.nextInt();
                sn.nextLine();
                if(jugador<0 || jugador>=numeroJugadores || EquipoFutbol[jugador]==null){
                    System.out.println("Ese jugador no existe o no lo has capturado");
                    break;
                }
                //Este metodo si es de la clase Futbolista y adentro pide el equipo contrario
                EquipoFutbol[jugador].jugarPartido();
                break;
            }
            case 5: {
                System.out.println("Dime el numero de jugador que desea que entrene");
                jugador=sn.nextInt();
                sn.nextLine();
                if(jugador<0 || jugador>=numeroJugadores || EquipoFutbol[jugador]==null){
                    System.out.println("Ese jugador no existe o no lo has capturado");
                    break;
                }
                EquipoFutbol[jugador].entrenar();
                break;
            }
            case 6: {
                //Esta es la unica salida del programa, hace que falle la condicion del do-while
                System.out.println("Saliendo del equipo " + nombreEquipo);
                break;
            }
            default: {
                //Aqui cae cualquier numero que no sea del 1 al 6
                System.out.println("Esa opcion no existe");
            }
                
        }
        
        } while(menu!=6); //El menu se repite mientras el usuario no escoja salir
        
    }
}