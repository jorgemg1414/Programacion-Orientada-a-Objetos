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

//Cliente habitual = socio del hotel. Es el cliente que se guarda en el diccionario (HashMap)
//del hotel con su CURP como clave, y por ser socio recibe descuento.
public class ClienteHabitual extends Cliente {

    //Datos personales extra que solo se le piden al socio cuando se registra
    private String telefono;
    private String correo;

    /*El descuento es static porque es el MISMO para todos los socios:
     * si el administrador lo cambia, les cambia a todos al mismo tiempo.
     * Es un porcentaje: 10 quiere decir 10%.
     */
    private static int porcentajeDescuento=10;

    public ClienteHabitual(String curp, String nombre, String telefono, String correo){
        //La CURP y el nombre se los mandamos al padre
        super(curp,nombre);
        //Lo particular del socio se guarda aqui
        this.telefono=telefono;
        this.correo=correo;
    }

    @Override
    public String getTipo(){
        return "habitual (socio)";
    }

    @Override
    public int getDescuento(){
        return porcentajeDescuento;
    }

    //Sobrescribe el mostrarInfo() del padre para agregar los datos que solo tiene el socio
    @Override
    public void mostrarInfo(){
        //super.mostrarInfo() ejecuta primero la version del padre (nombre, CURP y tipo)
        super.mostrarInfo();
        System.out.println("   Tel: "+this.telefono+" | Correo: "+this.correo+" | Descuento: "+porcentajeDescuento+"%");
    }

    /*Metodos static: se mandan llamar con el nombre de la clase, sin necesitar un objeto.
     * Ej: ClienteHabitual.getPorcentajeDescuento()
     * Asi se puede consultar o cambiar el descuento aunque todavia no haya ningun socio.
     */
    public static int getPorcentajeDescuento(){
        return porcentajeDescuento;
    }

    public static void setPorcentajeDescuento(int nuevoPorcentaje){
        porcentajeDescuento=nuevoPorcentaje;
    }

    /*Getters de los datos del socio*/
    public String getTelefono(){
        return this.telefono;
    }

    public String getCorreo(){
        return this.correo;
    }
}
