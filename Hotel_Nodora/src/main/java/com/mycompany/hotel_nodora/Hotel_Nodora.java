/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotel_nodora;
import java.util.*;

/**
 *
 * @author jorge
 */

//Equipo: De Anda Gomez Santiago, Martin Gomez Jorge, Martin Valencia Oscar Jesus, Yanez Sanchez Eduardo

/*Clase principal: aqui esta el main y los menus de cada actor (recepcionista, administrador y cliente).
 * Los menus solo piden datos por teclado y le piden al objeto hotel que haga el trabajo.
 */
public class Hotel_Nodora {

    //Scanner para leer todo lo que se teclea. Es static para que lo usen todos los metodos de esta clase
    //(asi no hay que crear un Scanner nuevo en cada metodo)
    static Scanner sn=new Scanner(System.in);

    public static void main(String[] args) {
        //Se crea el hotel y se le cargan cuartos, socios y reservaciones de ejemplo
        Hotel hotel=new Hotel("Hotel Nodora");
        cargarDatosDeEjemplo(hotel);

        int opcion; //Opcion que escoge el usuario en el menu

        System.out.println("=========================================");
        System.out.println("       BIENVENIDO AL HOTEL NODORA");
        System.out.println("=========================================");

        //Se usa do-while porque el menu debe mostrarse al menos una vez.
        //Se repite hasta que el usuario elija la opcion 4 (Salir).
        do{
            System.out.println("");
            System.out.println("========== MENÚ PRINCIPAL ==========");
            System.out.println("¿Quién va a usar el sistema?");
            System.out.println("1. Recepcionista");
            System.out.println("2. Administrador");
            System.out.println("3. Cliente");
            System.out.println("4. Salir");
            opcion=leerEntero("Dame tu opción:");

            switch(opcion){
                case 1: {
                    menuRecepcionista(hotel);
                    break;
                }
                case 2: {
                    menuAdministrador(hotel);
                    break;
                }
                case 3: {
                    menuCliente(hotel);
                    break;
                }
                case 4: {
                    System.out.println("Gracias por usar el sistema del Hotel Nodora");
                    break;
                }
                default: {
                    //Aqui cae cualquier numero que no sea del 1 al 4
                    System.out.println("Esa opción no existe");
                }
            }
        } while(opcion!=4);
    }

    /*Datos con los que arranca el programa.
     * Como no se guardan en un archivo, se vuelven a crear cada vez que se abre el programa.
     */
    static void cargarDatosDeEjemplo(Hotel hotel){
        //Cuartos con su numero y su precio por noche, como en HotelApp:
        //piso 1 simples, piso 2 dobles y piso 3 matrimoniales.
        //Todos se guardan en la misma lista porque todos heredan de Cuarto.
        hotel.agregarCuarto(new CuartoSimple(101, 800));
        hotel.agregarCuarto(new CuartoSimple(102, 800));
        hotel.agregarCuarto(new CuartoSimple(103, 800));
        hotel.agregarCuarto(new CuartoDoble(201, 1500));
        hotel.agregarCuarto(new CuartoDoble(202, 1500));
        hotel.agregarCuarto(new CuartoDoble(203, 1500));
        hotel.agregarCuarto(new CuartoMatrimonial(301, 1200));
        hotel.agregarCuarto(new CuartoMatrimonial(302, 1200));
        hotel.agregarCuarto(new CuartoMatrimonial(303, 1200));

        //Clientes habituales (socios) que ya estan en el diccionario del hotel
        ClienteHabitual ana=new ClienteHabitual("LORA900514MJCPZN03", "Ana Lopez Ruiz", "3312345678");
        ClienteHabitual carlos=new ClienteHabitual("RATC851102HJCMRRA5", "Carlos Ramirez Torres", "3398765432");
        hotel.registrarClienteHabitual(ana);
        hotel.registrarClienteHabitual(carlos);

        //Reservaciones de ejemplo (cliente, cuarto, dia, mes, anio, noches, huespedes).
        //La de Ana empieza en octubre y termina en noviembre, para probar las ganancias por mes.
        ClienteEsporadico luis=new ClienteEsporadico("HEDL920730HJCRZS07", "Luis Hernandez Diaz");
        hotel.agregarReservacion(new Reservacion(ana, hotel.buscarCuarto(101), 28, 10, 2026, 5, 1));
        hotel.agregarReservacion(new Reservacion(luis, hotel.buscarCuarto(201), 10, 11, 2026, 3, 3));
        hotel.agregarReservacion(new Reservacion(carlos, hotel.buscarCuarto(302), 15, 11, 2026, 2, 2));
    }

    /************************ MENU DEL RECEPCIONISTA ************************/
    static void menuRecepcionista(Hotel hotel){
        int opcion;
        do{
            System.out.println("");
            System.out.println("---------- MENÚ RECEPCIONISTA ----------");
            System.out.println("1. Ver cuartos disponibles por tipo");
            System.out.println("2. Consultar el precio de un tipo de cuarto");
            System.out.println("3. Consultar el descuento de los clientes habituales");
            System.out.println("4. Calcular el precio total para un cliente");
            System.out.println("5. Ver la foto de un tipo de cuarto");
            System.out.println("6. Hacer una reservación");
            System.out.println("7. Eliminar una reservación");
            System.out.println("8. Ver todas las reservaciones");
            System.out.println("9. Ver los clientes habituales");
            System.out.println("10. Regresar al menú principal");
            opcion=leerEntero("Dame tu opción:");

            switch(opcion){
                case 1: {
                    String tipo=elegirTipo();
                    hotel.listarDisponibles(tipo);
                    break;
                }
                case 2: {
                    String tipo=elegirTipo();
                    System.out.println("El cuarto "+tipo+" cuesta $"+String.format("%.2f", hotel.getPrecioDelTipo(tipo))+" por noche");
                    break;
                }
                case 3: {
                    //getPorcentajeDescuento() es static: se llama con el nombre de la clase, sin crear un objeto
                    System.out.println("Los clientes habituales tienen "+ClienteHabitual.getPorcentajeDescuento()+"% de descuento");
                    break;
                }
                case 4: {
                    String curp=leerCurp("CURP del cliente:");
                    String tipo=elegirTipo();
                    int noches=leerEntero("Número de noches:", 1, 365);
                    hotel.calcularPrecioTotal(curp, tipo, noches);
                    break;
                }
                case 5: {
                    String tipo=elegirTipo();
                    System.out.println("Así se ve un cuarto "+tipo+" (vista desde arriba):");
                    hotel.dibujarTipo(tipo);
                    break;
                }
                case 6: {
                    hacerReservacion(hotel);
                    break;
                }
                case 7: {
                    int numero=leerEntero("Número del cuarto de la reservación que se va a eliminar:");
                    if(hotel.eliminarReservacion(numero)){
                        System.out.println("Reservación eliminada, el cuarto #"+numero+" quedó disponible");
                    }else{
                        System.out.println("El cuarto #"+numero+" no tiene reservación");
                    }
                    break;
                }
                case 8: {
                    hotel.listarReservaciones();
                    break;
                }
                case 9: {
                    hotel.listarClientesHabituales();
                    break;
                }
                case 10: {
                    System.out.println("Regresando al menú principal");
                    break;
                }
                default: {
                    System.out.println("Esa opción no existe");
                }
            }
        } while(opcion!=10);
    }

    /************************ MENU DEL ADMINISTRADOR ************************/
    static void menuAdministrador(Hotel hotel){
        int opcion;
        do{
            System.out.println("");
            System.out.println("---------- MENÚ ADMINISTRADOR ----------");
            System.out.println("1. Cambiar el precio de un tipo de cuarto");
            System.out.println("2. Cambiar el descuento de los clientes habituales");
            System.out.println("3. Calcular las ganancias de un mes");
            System.out.println("4. Regresar al menú principal");
            opcion=leerEntero("Dame tu opción:");

            switch(opcion){
                case 1: {
                    String tipo=elegirTipo();
                    System.out.println("Precio actual del cuarto "+tipo+": $"+String.format("%.2f", hotel.getPrecioDelTipo(tipo)));
                    int nuevoPrecio=leerEntero("Nuevo precio por noche:", 1, 100000);
                    hotel.cambiarPrecioDelTipo(tipo, nuevoPrecio);
                    System.out.println("Listo, ahora todos los cuartos "+tipo+" cuestan $"+nuevoPrecio+" por noche");
                    System.out.println("(las reservaciones que ya estaban hechas conservan su precio)");
                    break;
                }
                case 2: {
                    System.out.println("Descuento actual: "+ClienteHabitual.getPorcentajeDescuento()+"%");
                    int nuevoDescuento=leerEntero("Nuevo descuento en porcentaje (0 a 100):", 0, 100);
                    //setPorcentajeDescuento() es static: le cambia el descuento a TODOS los socios
                    ClienteHabitual.setPorcentajeDescuento(nuevoDescuento);
                    System.out.println("Listo, ahora los clientes habituales tienen "+nuevoDescuento+"% de descuento");
                    break;
                }
                case 3: {
                    int mes=leerEntero("Mes (1-12):", 1, 12);
                    int anio=leerEntero("Año:", 2000, 2100);
                    System.out.println("Ganancias de "+mes+"/"+anio+" (todos los meses de 30 días):");
                    double total=hotel.calcularGanancias(mes, anio);
                    System.out.println("Total de ganancias del mes: $"+String.format("%.2f", total));
                    break;
                }
                case 4: {
                    System.out.println("Regresando al menú principal");
                    break;
                }
                default: {
                    System.out.println("Esa opción no existe");
                }
            }
        } while(opcion!=4);
    }

    /************************ MENU DEL CLIENTE ************************/
    static void menuCliente(Hotel hotel){
        int opcion;
        do{
            System.out.println("");
            System.out.println("---------- MENÚ CLIENTE ----------");
            System.out.println("1. Registrarme como cliente habitual (socio)");
            System.out.println("2. Reservar una habitación");
            System.out.println("3. Anular una reservación");
            System.out.println("4. Regresar al menú principal");
            opcion=leerEntero("Dame tu opción:");

            switch(opcion){
                case 1: {
                    String curp=leerCurp("Tu CURP:");
                    //Red de seguridad: la CURP es la clave del diccionario, no se puede repetir
                    if(hotel.buscarClienteHabitual(curp)!=null){
                        System.out.println("Esa CURP ya está registrada como cliente habitual");
                        break;
                    }
                    System.out.println("Tu nombre completo:");
                    String nombre=sn.nextLine();
                    System.out.println("Tu teléfono:");
                    String telefono=sn.nextLine();
                    hotel.registrarClienteHabitual(new ClienteHabitual(curp, nombre, telefono));
                    System.out.println("¡Listo, "+nombre+"! Ya eres cliente habitual y tienes "
                            +ClienteHabitual.getPorcentajeDescuento()+"% de descuento en tus reservaciones");
                    break;
                }
                case 2: {
                    hacerReservacion(hotel);
                    break;
                }
                case 3: {
                    String curp=leerCurp("Tu CURP:");
                    System.out.println("Tus reservaciones:");
                    //Se le muestran sus reservaciones para que vea el numero de cuarto
                    if(hotel.listarReservacionesDe(curp)==0){
                        System.out.println("No tienes reservaciones");
                        break;
                    }
                    int numero=leerEntero("Número de cuarto de la reservación que quieres anular:");
                    //anularReservacion revisa que la reservacion de ese cuarto sea de esta CURP
                    if(hotel.anularReservacion(curp, numero)){
                        System.out.println("Reservación anulada");
                    }else{
                        System.out.println("No tienes una reservación en el cuarto #"+numero);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Regresando al menú principal");
                    break;
                }
                default: {
                    System.out.println("Esa opción no existe");
                }
            }
        } while(opcion!=4);
    }

    /************************ OPERACIONES COMPARTIDAS ************************/

    //Reservar una habitacion. La usan el recepcionista y el cliente,
    //por eso esta en un metodo aparte y no repetida en los dos menus.
    static void hacerReservacion(Hotel hotel){
        System.out.println("Cuartos disponibles:");
        hotel.listarTodosDisponibles();

        int numero=leerEntero("Número de cuarto a reservar:");
        Cuarto cuarto=hotel.buscarCuarto(numero);
        //Red de seguridad: el cuarto tiene que existir y estar libre
        if(cuarto==null){
            System.out.println("No existe el cuarto #"+numero);
            return; //return termina el metodo aqui
        }
        if(!hotel.estaDisponible(cuarto)){
            System.out.println("El cuarto #"+numero+" ya está reservado");
            return;
        }

        String curp=leerCurp("CURP del cliente:");
        //Se busca la CURP en el diccionario de socios
        Cliente cliente=hotel.buscarClienteHabitual(curp);
        if(cliente!=null){
            System.out.println("Cliente habitual: "+cliente.getNombre()+" (tiene "+cliente.getDescuento()+"% de descuento)");
        }else{
            //Si no es socio se le pide el nombre y se crea como cliente esporadico
            System.out.println("Nombre del cliente:");
            String nombre=sn.nextLine();
            cliente=new ClienteEsporadico(curp, nombre);
        }

        int huespedes=leerEntero("Número de huéspedes (máximo "+cuarto.getCapacidad()+"):", 1, cuarto.getCapacidad());
        System.out.println("Fecha de llegada (todos los meses tienen 30 días):");
        int dia=leerEntero("Día (1-30):", 1, 30);
        int mes=leerEntero("Mes (1-12):", 1, 12);
        int anio=leerEntero("Año:", 2000, 2100);
        int noches=leerEntero("Número de noches:", 1, 365);

        //Se crea la reservacion y se guarda en el hotel
        Reservacion nueva=new Reservacion(cliente, cuarto, dia, mes, anio, noches, huespedes);
        hotel.agregarReservacion(nueva);
        System.out.println("¡Reservación hecha!");
        nueva.mostrarInfo();
    }

    //Muestra los tipos de cuarto y regresa el que se escoja.
    //Si se agrega un tipo nuevo de cuarto (ej. Suite), aqui se le agrega su opcion.
    static String elegirTipo(){
        System.out.println("Tipos de cuarto:");
        System.out.println("1. Simple");
        System.out.println("2. Doble");
        System.out.println("3. Matrimonial");
        int opcion=leerEntero("Elige el tipo:", 1, 3);
        if(opcion==1){
            return "Simple";
        }else if(opcion==2){
            return "Doble";
        }else{
            return "Matrimonial";
        }
    }

    /************************ LECTURA DE DATOS ************************/

    /*Pide un numero entero y no deja avanzar hasta que se teclee uno.
     * Se lee toda la linea y se convierte con Integer.parseInt; si lo que se tecleo no es
     * un numero se lanza NumberFormatException, el catch la atrapa y se vuelve a pedir
     * (igual que en FigurasGeometricas, pero sin que se quede el salto de linea del nextInt).
     */
    static int leerEntero(String mensaje){
        int numero=0;
        boolean valido;
        do{
            System.out.println(mensaje);
            try{
                numero=Integer.parseInt(sn.nextLine().trim());
                valido=true;
            }catch(NumberFormatException e){
                System.out.println("Error: debes teclear un número entero");
                valido=false;
            }
        } while(!valido);
        return numero;
    }

    //Sobrecarga del metodo de arriba (mismo nombre, diferentes parametros):
    //ademas revisa que el numero este entre min y max
    static int leerEntero(String mensaje, int min, int max){
        int numero;
        do{
            numero=leerEntero(mensaje);
            if(numero<min || numero>max){
                System.out.println("Error: el número debe estar entre "+min+" y "+max);
            }
        } while(numero<min || numero>max);
        return numero;
    }

    //Pide una CURP y la vuelve a pedir hasta que tenga 18 caracteres.
    //Se pasa a mayusculas para aceptarla aunque la escriban en minusculas.
    static String leerCurp(String mensaje){
        String curp;
        do{
            System.out.println(mensaje);
            curp=sn.nextLine().trim().toUpperCase();
            if(curp.length()!=18){
                System.out.println("La CURP debe tener 18 caracteres");
            }
        } while(curp.length()!=18);
        return curp;
    }
}
