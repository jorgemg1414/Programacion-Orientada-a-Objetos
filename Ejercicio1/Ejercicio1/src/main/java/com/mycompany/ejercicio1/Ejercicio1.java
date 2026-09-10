/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

/**
 *
 * @author jorge
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        
        /*Creamos dos objetos de la clase Persona usando el constructor*/
        Persona persona1 = new Persona("Jorge", "Martinez", 20, 1);
        Persona persona2 = new Persona("Ana", "Lopez", 25, 2);
        
        /*USO DE GETTERS: leer los atributos
         * El getter devuelve el valor del atributo y lo podemos usar en un
         * println, guardarlo en una variable, compararlo, etc.
         */
        System.out.println("--- Datos de persona 1 (getters) ---");
        System.out.println("Id: " + persona1.getId());
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Apellido: " + persona1.getApellido());
        System.out.println("Edad: " + persona1.getEdad() + "\n");
        
        System.out.println("--- Datos de persona 2 (getters) ---");
        System.out.println("Id: " + persona2.getId());
        System.out.println("Nombre: " + persona2.getNombre());
        System.out.println("Apellido: " + persona2.getApellido());
        System.out.println("Edad: " + persona2.getEdad() + "\n");
        
        /*USO DE SETTERS: modificar los atributos
         * El setter recibe el nuevo valor y lo guarda en el atributo.
         * Aqui persona 2 se cambia el apellido y cumple anios.
         */
        System.out.println("--- Modificando persona 2 (setters) ---");
        persona2.setApellido("Garcia");
        persona2.setEdad(persona2.getEdad() + 1); //getter y setter juntos
        
        /*Comprobamos con los getters que el cambio se aplico*/
        System.out.println("Nombre: " + persona2.getNombre());
        System.out.println("Apellido: " + persona2.getApellido());
        System.out.println("Edad: " + persona2.getEdad() + "\n");
        
        /*VENTAJA DEL SETTER: validar datos
         * Intentamos guardar una edad invalida. Como el setter la valida,
         * el atributo NO cambia y se conserva el valor anterior.
         */
        System.out.println("--- Validacion en el setter ---");
        persona1.setEdad(-5);
        System.out.println("Edad de persona 1 sigue siendo: " + persona1.getEdad());
        
        /*El id no tiene setter, asi que persona1.setId(...) daria error
         * de compilacion. Solo se puede leer con getId().
         */
    }
}
