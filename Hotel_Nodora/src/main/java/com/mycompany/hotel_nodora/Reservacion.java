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
    private int dia, mes, anio; //Fecha de comienzo (llegada)
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
        //Precio del tipo de cuarto menos el descuento de este cliente (si es esporadico le quita 0)
        this.precioPorNoche=cliente.aplicarDescuento(cuarto.getPrecio());
    }

    //Total a pagar por toda la estancia
    public double calcularTotal(){
        return this.precioPorNoche*this.noches;
    }

    /*Regresa cuantas noches de esta reservacion caen dentro del mes que se pide.
     * Como el enunciado dice que todos los meses tienen 30 dias, cada fecha se puede
     * convertir a un "numero de dia" (anio*360 + (mes-1)*30 + (dia-1)) y asi se comparan facil.
     *
     * Ejemplo: llega el 28/10 y se queda 5 noches -> duerme el 28, 29 y 30 de octubre
     * y el 1 y 2 de noviembre. En octubre cuentan 3 noches y en noviembre 2.
     */
    public int nochesEnMes(int mesBuscado, int anioBuscado){
        int llegada=this.anio*360+(this.mes-1)*30+(this.dia-1); //Primera noche de la reservacion
        int salida=llegada+this.noches;                         //Dia en que se va (esa noche ya no cuenta)
        int inicioMes=anioBuscado*360+(mesBuscado-1)*30;        //Dia 1 del mes buscado
        int finMes=inicioMes+30;                                //Dia 1 del mes siguiente

        //Las noches que cuentan son las que estan en los dos rangos al mismo tiempo
        int desde=Math.max(llegada, inicioMes); //Math.max regresa el mayor de los dos
        int hasta=Math.min(salida, finMes);     //Math.min regresa el menor de los dos
        if(hasta>desde){
            return hasta-desde;
        }else{
            return 0; //La reservacion no toca ese mes
        }
    }

    //Fecha de llegada como texto dd/mm/aaaa
    //String.format("%02d", 5) pone un cero a la izquierda: 05
    public String getFechaLlegada(){
        return String.format("%02d/%02d/%d", this.dia, this.mes, this.anio);
    }

    //Fecha de salida = llegada + noches, tambien con meses de 30 dias
    public String getFechaSalida(){
        int dias=(this.dia-1)+this.noches;  //Dias contados desde el dia 1 del mes de llegada
        int diaSalida=dias%30+1;            //% da el residuo: los dias que sobran despues de los meses completos
        int mesSalida=this.mes+dias/30;     //Cada 30 dias se pasa un mes
        int anioSalida=this.anio;
        //Si se pasa de diciembre se cambia de anio
        while(mesSalida>12){
            mesSalida=mesSalida-12;
            anioSalida++;
        }
        return String.format("%02d/%02d/%d", diaSalida, mesSalida, anioSalida);
    }

    public void mostrarInfo(){
        System.out.println("Cuarto #"+this.cuarto.getNumero()+" ("+this.cuarto.getTipo()+") | "
                +this.cliente.getNombre()+" | CURP: "+this.cliente.getCurp()+" | cliente "+this.cliente.getTipo());
        System.out.println("   Llega "+getFechaLlegada()+", sale "+getFechaSalida()+" ("+this.noches+" noches) | "
                +this.huespedes+" huésped(es) | "+String.format("$%.2f", this.precioPorNoche)+" por noche | Total: "
                +String.format("$%.2f", calcularTotal()));
    }

    /*Getters*/
    public Cliente getCliente(){
        return this.cliente;
    }

    public Cuarto getCuarto(){
        return this.cuarto;
    }

    public int getNoches(){
        return this.noches;
    }

    public int getHuespedes(){
        return this.huespedes;
    }

    public double getPrecioPorNoche(){
        return this.precioPorNoche;
    }
}
