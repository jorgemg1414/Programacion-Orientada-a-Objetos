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

//Guarda los datos de una reservacion: quien reservo, que cuarto, desde que fecha,
//cuantas noches y cuantos huespedes.
public class Reservacion {

    //Los atributos son private: el resto del programa solo los puede leer con los getters
    private Cliente cliente;    //Puede ser un ClienteHabitual o un ClienteEsporadico
    private Cuarto cuarto;      //Puede ser cualquier tipo de cuarto
    private int dia, mes, anio; //Fecha de llegada
    private int noches;         //Numero de dias que se va a ocupar el cuarto
    private int huespedes;
    /*Precio por noche que se le respeta al cliente, ya con su descuento.
     * Se calcula al momento de reservar para que, si despues el administrador
     * cambia los precios, las reservaciones que ya estaban hechas no cambien.
     */
    private double precioPorNoche;

    /*Constructor*/
    public Reservacion(Cliente cliente, Cuarto cuarto, int dia, int mes, int anio, int noches, int huespedes){
        this.cliente=cliente;
        this.cuarto=cuarto;
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
        this.noches=noches;
        this.huespedes=huespedes;
        //Precio del cuarto menos el descuento de este cliente (si es esporadico le quita 0)
        this.precioPorNoche=cliente.aplicarDescuento(cuarto.getPrecio());
    }

    //Total a pagar por toda la estancia
    public double calcularTotal(){
        return this.precioPorNoche*this.noches;
    }

    /*Cuenta cuantas noches de esta reservacion caen en el mes que se pide.
     * Se recorre la reservacion noche por noche, como si se fueran pasando las hojas
     * de un calendario donde todos los meses tienen 30 dias (asi lo dice el enunciado).
     *
     * Ejemplo: llega el 28/10 y se queda 5 noches -> duerme el 28, 29 y 30 de octubre
     * y el 1 y 2 de noviembre. En octubre cuentan 3 noches y en noviembre 2.
     */
    public int nochesEnMes(int mesBuscado, int anioBuscado){
        //Fecha de la noche que se esta revisando; empieza en la fecha de llegada
        int d=this.dia;
        int m=this.mes;
        int a=this.anio;
        int contador=0;

        for(int i=0; i<this.noches; i++){
            //Si esta noche cae en el mes buscado, se cuenta
            if(m==mesBuscado && a==anioBuscado){
                contador++;
            }
            //Se pasa al dia siguiente
            d++;
            if(d>30){ //Se acabo el mes
                d=1;
                m++;
                if(m>12){ //Se acabo el anio
                    m=1;
                    a++;
                }
            }
        }
        return contador;
    }

    public void mostrarInfo(){
        System.out.println("Cuarto #"+this.cuarto.getNumero()+" ("+this.cuarto.getTipo()+") | "
                +this.cliente.getNombre()+" | CURP: "+this.cliente.getCurp()+" | cliente "+this.cliente.getTipo());
        System.out.println("   Llega el "+this.dia+"/"+this.mes+"/"+this.anio+" | "+this.noches+" noche(s) | "
                +this.huespedes+" huésped(es) | $"+String.format("%.2f", this.precioPorNoche)+" por noche | Total: $"
                +String.format("%.2f", calcularTotal()));
    }

    /*Getters*/
    public Cliente getCliente(){
        return this.cliente;
    }

    public Cuarto getCuarto(){
        return this.cuarto;
    }

    public double getPrecioPorNoche(){
        return this.precioPorNoche;
    }
}
