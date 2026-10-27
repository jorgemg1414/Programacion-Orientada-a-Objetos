/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel_nodora;
import java.util.*;

/**
 *
 * @author jorge
 */

//Equipo: De Anda Gomez Santiago, Martin Gomez Jorge, Martin Valencia Oscar Jesus, Yanez Sanchez Eduardo

/*Esta clase es el "cerebro" del sistema: guarda todos los datos del hotel y tiene un
 * metodo por cada operacion que piden el recepcionista, el administrador y el cliente.
 * Los menus (en Hotel_Nodora) solo piden los datos por teclado y mandan llamar estos metodos.
 *
 * Para agregar una consulta nueva se agrega aqui un metodo y en el menu una opcion que lo llame.
 */
public class Hotel {

    private String nombre;

    //Lista de cuartos. Es de tipo Cuarto (el padre), asi que caben simples, dobles,
    //matrimoniales y cualquier tipo nuevo que se cree despues.
    private ArrayList<Cuarto> cuartos=new ArrayList<>();

    //Diccionario de clientes habituales (socios): la CLAVE es la CURP y el VALOR son los datos del cliente.
    //Con la CURP se encuentra al cliente directo, sin tener que recorrer una lista.
    private HashMap<String, Cliente> clientesHabituales=new HashMap<>();

    //Reservaciones que existen ahorita. Cada cuarto puede tener maximo una.
    private ArrayList<Reservacion> reservaciones=new ArrayList<>();

    /*Constructor*/
    public Hotel(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    /************************ CUARTOS ************************/

    public void agregarCuarto(Cuarto cuarto){
        cuartos.add(cuarto);
    }

    //Regresa el cuarto con ese numero, o null si no existe
    public Cuarto buscarCuarto(int numero){
        for(Cuarto c : cuartos){
            if(c.getNumero()==numero){
                return c;
            }
        }
        return null;
    }

    //Regresa los nombres de los tipos de cuarto que tiene el hotel, sin repetir.
    //Con esto los menus se arman solos: si se agrega un tipo nuevo, aparece automaticamente.
    public ArrayList<String> getTipos(){
        ArrayList<String> tipos=new ArrayList<>();
        for(Cuarto c : cuartos){
            //contains revisa si el tipo ya estaba en la lista para no repetirlo
            if(!tipos.contains(c.getTipo())){
                tipos.add(c.getTipo());
            }
        }
        return tipos;
    }

    //Regresa el primer cuarto de ese tipo. Como el precio y el dibujo son iguales para
    //todos los cuartos del mismo tipo, con uno basta para consultarlos o cambiarlos.
    public Cuarto buscarCuartoDeTipo(String tipo){
        for(Cuarto c : cuartos){
            if(c.getTipo().equals(tipo)){
                return c;
            }
        }
        return null;
    }

    //Un cuarto esta disponible si no tiene ninguna reservacion
    public boolean estaDisponible(Cuarto cuarto){
        return buscarReservacion(cuarto.getNumero())==null;
    }

    //RECEPCIONISTA: listado de cuartos disponibles de un tipo
    public void listarDisponibles(String tipo){
        boolean hayAlguno=false;
        System.out.println("Cuartos de tipo "+tipo+" disponibles:");
        for(Cuarto c : cuartos){
            if(c.getTipo().equals(tipo) && estaDisponible(c)){
                c.mostrarInfo();
                hayAlguno=true;
            }
        }
        if(!hayAlguno){
            System.out.println("No hay cuartos de tipo "+tipo+" disponibles");
        }
    }

    //Todos los cuartos disponibles de cualquier tipo (se muestran antes de reservar)
    public void listarTodosDisponibles(){
        boolean hayAlguno=false;
        for(Cuarto c : cuartos){
            if(estaDisponible(c)){
                c.mostrarInfo();
                hayAlguno=true;
            }
        }
        if(!hayAlguno){
            System.out.println("El hotel está lleno, no hay cuartos disponibles");
        }
    }

    //RECEPCIONISTA: precio por noche de un tipo de cuarto
    public double getPrecioDelTipo(String tipo){
        return buscarCuartoDeTipo(tipo).getPrecio();
    }

    //ADMINISTRADOR: cambiar el precio de un tipo de cuarto.
    //Basta con cambiarselo a un cuarto porque el precio es static y lo comparten todos los de su tipo.
    public void cambiarPrecioDelTipo(String tipo, double nuevoPrecio){
        buscarCuartoDeTipo(tipo).setPrecio(nuevoPrecio);
    }

    //RECEPCIONISTA: dibujar la foto de un tipo de cuarto
    public void dibujarTipo(String tipo){
        //dibujar() es polimorfico: cada tipo de cuarto hace su propio dibujo
        buscarCuartoDeTipo(tipo).dibujar();
    }

    /************************ CLIENTES ************************/

    //CLIENTE: registrarse como cliente habitual (socio).
    //Regresa false si esa CURP ya estaba registrada, para no repetirla.
    public boolean registrarClienteHabitual(ClienteHabitual cliente){
        //containsKey revisa si la CURP ya existe como clave en el diccionario
        if(clientesHabituales.containsKey(cliente.getCurp())){
            return false;
        }
        //put guarda en el diccionario: clave = CURP, valor = el cliente
        clientesHabituales.put(cliente.getCurp(), cliente);
        return true;
    }

    //Busca un socio por su CURP en el diccionario. Si no es socio, get regresa null.
    public Cliente buscarClienteHabitual(String curp){
        return clientesHabituales.get(curp);
    }

    //Muestra todos los socios registrados
    public void listarClientesHabituales(){
        if(clientesHabituales.isEmpty()){
            System.out.println("No hay clientes habituales registrados");
            return; //return termina el metodo aqui
        }
        System.out.println("Clientes habituales (socios):");
        //values() regresa todos los valores del diccionario (los clientes) para poder recorrerlos
        for(Cliente c : clientesHabituales.values()){
            c.mostrarInfo();
        }
    }

    //RECEPCIONISTA: precio total para un cliente dado, segun su CURP, el tipo de cuarto y las noches
    public double calcularPrecioTotal(String curp, String tipo, int noches){
        //Si la CURP esta en el diccionario es socio; si no, se cobra como cliente esporadico
        Cliente cliente=buscarClienteHabitual(curp);
        if(cliente==null){
            System.out.println("La CURP "+curp+" no es de un socio, se cobra como cliente esporádico");
            cliente=new ClienteEsporadico(curp, "Cliente no registrado");
        }else{
            System.out.println("Cliente: "+cliente.getNombre()+" - cliente "+cliente.getTipo());
        }

        double precioNoche=getPrecioDelTipo(tipo);
        double subtotal=precioNoche*noches;
        //aplicarDescuento() es polimorfico: a cada tipo de cliente le quita su propio descuento
        double total=cliente.aplicarDescuento(subtotal);

        System.out.println("Cuarto "+tipo+": "+String.format("$%.2f", precioNoche)+" x "+noches
                +" noche(s) = "+String.format("$%.2f", subtotal));
        System.out.println("Descuento del "+cliente.getDescuento()+"%: -"+String.format("$%.2f", subtotal-total));
        System.out.println("Precio total: "+String.format("$%.2f", total));
        return total;
    }

    /************************ RESERVACIONES ************************/

    //Regresa la reservacion que tiene el cuarto con ese numero, o null si el cuarto esta libre
    public Reservacion buscarReservacion(int numeroCuarto){
        for(Reservacion r : reservaciones){
            if(r.getCuarto().getNumero()==numeroCuarto){
                return r;
            }
        }
        return null;
    }

    //RECEPCIONISTA y CLIENTE: reservar un cuarto.
    //Regresa la reservacion nueva, o null si no se pudo hacer.
    public Reservacion reservar(Cuarto cuarto, Cliente cliente, int dia, int mes, int anio, int noches, int huespedes){
        //Red de seguridad: no se reserva un cuarto ocupado ni con mas huespedes de los que caben
        if(!estaDisponible(cuarto) || huespedes>cuarto.getCapacidad()){
            return null;
        }
        Reservacion nueva=new Reservacion(cliente, cuarto, dia, mes, anio, noches, huespedes);
        reservaciones.add(nueva);
        return nueva;
    }

    //RECEPCIONISTA: eliminar una reservacion con el numero del cuarto.
    //Regresa false si ese cuarto no tenia reservacion.
    public boolean eliminarReservacion(int numeroCuarto){
        Reservacion r=buscarReservacion(numeroCuarto);
        if(r==null){
            return false;
        }
        reservaciones.remove(r);
        return true;
    }

    //CLIENTE: anular una reservacion propia. Solo se borra si la reservacion
    //de ese cuarto es de esa CURP, para que nadie anule la de otra persona.
    public boolean anularReservacion(String curp, int numeroCuarto){
        Reservacion r=buscarReservacion(numeroCuarto);
        if(r==null || !r.getCliente().getCurp().equals(curp)){
            return false;
        }
        reservaciones.remove(r);
        return true;
    }

    //Muestra las reservaciones de una CURP y regresa cuantas encontro
    public int listarReservacionesDe(String curp){
        int cuantas=0;
        for(Reservacion r : reservaciones){
            if(r.getCliente().getCurp().equals(curp)){
                r.mostrarInfo();
                cuantas++;
            }
        }
        return cuantas;
    }

    //Muestra todas las reservaciones del hotel
    public void listarReservaciones(){
        if(reservaciones.isEmpty()){
            System.out.println("No hay reservaciones");
            return;
        }
        System.out.println("Reservaciones actuales:");
        for(Reservacion r : reservaciones){
            r.mostrarInfo();
        }
    }

    //ADMINISTRADOR: ganancias que tendra el hotel en un mes (todos los meses de 30 dias).
    //De cada reservacion se cobran solo las noches que caen en ese mes.
    public double calcularGanancias(int mes, int anio){
        double total=0;
        boolean hayAlguna=false; //Para saber si alguna reservacion tiene noches en ese mes
        for(Reservacion r : reservaciones){
            int noches=r.nochesEnMes(mes, anio);
            if(noches>0){
                double ganancia=noches*r.getPrecioPorNoche();
                System.out.println("Cuarto #"+r.getCuarto().getNumero()+" ("+r.getCliente().getNombre()+"): "
                        +noches+" noche(s) x "+String.format("$%.2f", r.getPrecioPorNoche())
                        +" = "+String.format("$%.2f", ganancia));
                total=total+ganancia;
                hayAlguna=true;
            }
        }
        if(!hayAlguna){
            System.out.println("Ninguna reservación tiene noches en ese mes");
        }
        return total;
    }
}
