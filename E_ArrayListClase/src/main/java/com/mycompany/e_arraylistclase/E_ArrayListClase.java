/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.e_arraylistclase;
import java.util.*;

/**
 *
 * @author jorge
 */
public class E_ArrayListClase {

    public static void main(String[] args) {
        //lista dinamica donde se van a guardar los objetos de tipo Usuario
        ArrayList <Usuario> listaUsuarios=new ArrayList <> ();
        //scanner para leer lo que escribe el usuario
        Scanner sn=new Scanner (System.in);
        //variable para guardar la opcion del menu
        int opc=0;

        //el menu se repite mientras la opcion sea 1, 2 o 3
        do {
            System.out.println("Menú");
            System.out.println("1. - Agregar usuarios");
            System.out.println("2. - Mostrar lista");
            System.out.println("3. - Buscar elemento");
            System.out.println("4. - Salir");
            opc=sn.nextInt();
            //limpia el salto de linea que deja el nextInt
            sn.nextLine();

            switch(opc){
                //opcion 1: registrar un nuevo usuario
                case 1:{
                    //pruebas que hice antes de pedir los datos por teclado
                    //System.out.println("Ingresa el correo");
                    //listaUsuarios.add(
                    //new Usuario("jorge@gmail.com", "1,2,3"));

                    //listaUsuarios.add(
                    //new Usuario(sn.nextLine(),sn.nextLine()));

                    String usuario, contraseña;
                    System.out.println("Ingresa el correo");
                    usuario=sn.nextLine();

                    //validar formato del correo
                    //revisa que tenga texto, luego @, luego el dominio y al final un punto con minimo 2 letras (.com, .mx, etc)
                    if (!usuario.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        System.out.println("El correo no es válido");
                        //si no es valido se sale del case y regresa al menu
                        break;
                    }

                    //validar que el correo no este repetido
                    //recorre la lista y compara cada correo con el que se escribio
                    boolean repetido=false;
                    for (Usuario x : listaUsuarios) {
                        //equalsIgnoreCase para que no importen mayusculas y minusculas
                        if (x.getCorreo().equalsIgnoreCase(usuario)) {
                            repetido=true;
                        }
                    }
                    if (repetido) {
                        System.out.println("El correo ya está registrado");
                        break;
                    }

                    //validar contraseña
                    //se repite hasta que la contraseña cumpla con todo
                    boolean valida=false;
                    do {
                        System.out.println("Ingresa la contraseña");
                        contraseña=sn.nextLine();
                        try {
                            //minimo 8 caracteres, si no se lanza la excepcion con el mensaje
                            if (contraseña.length()<8) {
                                throw new Exception("La contraseña debe tener mínimo 8 caracteres");
                            }
                            //banderas para saber si tiene numero y caracter especial
                            boolean numero=false, especial=false;
                            //recorre la contraseña caracter por caracter
                            for (int i=0; i<contraseña.length(); i++) {
                                char c=contraseña.charAt(i);
                                //revisa si el caracter es un numero
                                if (Character.isDigit(c)) {
                                    numero=true;
                                }
                                //revisa si el caracter esta en la lista de especiales
                                //indexOf regresa -1 si no lo encuentra
                                if ("@#$%&".indexOf(c)>=0) {
                                    especial=true;
                                }
                            }
                            if (!numero) {
                                throw new Exception("La contraseña debe tener al menos un número");
                            }
                            if (!especial) {
                                throw new Exception("La contraseña debe tener al menos un carácter especial (@, #, $, % o &)");
                            }
                            //si llego hasta aqui es porque cumple con todo
                            valida=true;
                        } catch (Exception e) {
                            //muestra el mensaje de lo que le falto a la contraseña
                            System.out.println(e.getMessage());
                        }
                    } while (!valida);

                    //si el correo y la contraseña pasaron las validaciones se agrega el usuario a la lista
                    listaUsuarios.add(
                    new Usuario(usuario, contraseña));
                    System.out.println("Usuario agregado");
                break;}

                //opcion 2: mostrar todos los usuarios registrados
                case 2:{
                    System.out.println("Arreglo de la lista de usuarios");
                    System.out.println(listaUsuarios);
                break;}

                //opcion 3: buscar un usuario por su correo
                case 3: {
                    //bandera para saber si se encontro o no
                    boolean encontrado = false;
                    System.out.println("Ingresa el usuario a buscar");
                    String usuario = sn.nextLine();
                    //recorre la lista buscando el correo
                    for (Usuario x : listaUsuarios) {
                        if (x.getCorreo().equalsIgnoreCase(usuario)) {
                            //si lo encuentra muestra sus datos
                            System.out.println("Usuario  "+x.getCorreo());
                            System.out.println("Contraseña  "+x.getContraseña());
                            encontrado = true;
                        }
                    }
                    //si termino de recorrer la lista y no lo encontro
                    if (!encontrado) {
                        System.out.println("El usuario no existe");
                    }
                    break;
                }
            }

        //opcion 4 (o cualquier otro numero) termina el programa
        } while((opc>0)&&(opc<4));
    }
}