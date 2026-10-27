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

//Cliente esporadico = el que reserva sin estar registrado como socio.
//No se guarda en el diccionario del hotel y no tiene descuento.
public class ClienteEsporadico extends Cliente {

    public ClienteEsporadico(String curp, String nombre){
        super(curp,nombre);
    }

    @Override
    public String getTipo(){
        return "esporádico";
    }

    //No tiene descuento, por eso regresa 0
    @Override
    public int getDescuento(){
        return 0;
    }
}
