/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

/**
 *
 * @author jorge
 */

public class Persona {
    /*Atributos
     * Son protected (encapsulamiento): no son publicos, asi que el resto del
     * programa no deberia leerlos ni cambiarlos directamente.
     * Para eso existen los metodos getter y setter.
     */
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected int id;
    
    /*Constructor*/
    Persona(String nombre, String apellido, int edad, int id){
    this.nombre=nombre;
    this.apellido=apellido;
    this.id=id;
    this.edad=edad;
    }
    
    /*Metodos getter y setter
     *
     * Que son:
     *   - Getter: metodo publico que DEVUELVE el valor de un atributo.
     *     Se nombra get + NombreDelAtributo, no recibe parametros
     *     y su tipo de retorno es el mismo tipo del atributo.
     *   - Setter: metodo publico que MODIFICA el valor de un atributo.
     *     Se nombra set + NombreDelAtributo, recibe el nuevo valor
     *     como parametro y no devuelve nada (void).
     *
     * Para que sirven:
     *   - Son la "puerta de entrada" a los atributos encapsulados: desde
     *     otras clases (como Ejercicio1) se lee con el getter y se cambia
     *     con el setter, sin tocar el atributo directamente.
     *   - Dentro del setter podemos validar el dato antes de guardarlo
     *     (ejemplo: no aceptar una edad negativa).
     *   - Si a un atributo solo le ponemos getter y no setter, queda de
     *     solo lectura (ejemplo: el id no deberia cambiar nunca).
     */
    
    /*Getter y setter de nombre*/
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    /*Getter y setter de apellido*/
    public String getApellido(){
        return this.apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    /*Getter y setter de edad*/
    public int getEdad(){
        return this.edad;
    }
    
    /*Este setter valida el dato: si la edad es negativa no la guarda.
     * Esto no se podria controlar si cambiaramos el atributo directamente.
     */
    public void setEdad(int edad){
        if(edad>=0){
            this.edad=edad;
        }else{
            System.out.println("Edad invalida, no se puede guardar un valor negativo.");
        }
    }
    
    /*Solo getter de id: el id identifica a la persona y no debe cambiar,
     * por eso NO tiene setter (atributo de solo lectura desde fuera).
     */
    public int getId(){
        return this.id;
    }
}
