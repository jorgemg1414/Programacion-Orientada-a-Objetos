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
        ArrayList <Usuario> listaUsuarios=new ArrayList <> ();
        Scanner sn=new Scanner (System.in);
        int opc=0;
        do {
            System.out.println("Menú");
            System.out.println("1. - Agregar usuarios");
            System.out.println("2. - Mostrar lista");
            System.out.println("3. - Buscar elemento");
            System.out.println("4. - Salir");
            opc=sn.nextInt();
            sn.nextLine();
            switch(opc){
                case 1:{
                    //System.out.println("Ingresa el correo");
                    //listaUsuarios.add(
                    //new Usuario("jorge@gmail.com", "1,2,3"));
                    
                    //listaUsuarios.add(
                    //new Usuario(sn.nextLine(),sn.nextLine()));
                    
                    String usuario, contraseña;
                    System.out.println("Ingresa el correo");       
                    usuario=sn.nextLine();
                    
                    //validar formato del correo
                    if (!usuario.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        System.out.println("El correo no es válido");
                        break;
                    }
                    
                    //validar que el correo no este repetido
                    boolean repetido=false;
                    for (Usuario x : listaUsuarios) {
                        if (x.getCorreo().equalsIgnoreCase(usuario)) {
                            repetido=true;
                        }
                    }
                    if (repetido) {
                        System.out.println("El correo ya está registrado");
                        break;
                    }
                    
                    //validar contraseña
                    boolean valida=false;
                    do {
                        System.out.println("Ingresa la contraseña");
                        contraseña=sn.nextLine();
                        try {
                            if (contraseña.length()<8) {
                                throw new Exception("La contraseña debe tener mínimo 8 caracteres");
                            }
                            boolean numero=false, especial=false;
                            for (int i=0; i<contraseña.length(); i++) {
                                char c=contraseña.charAt(i);
                                if (Character.isDigit(c)) {
                                    numero=true;
                                }
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
                            valida=true;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!valida);
                    
                    listaUsuarios.add(
                    new Usuario(usuario, contraseña));
                    System.out.println("Usuario agregado");
                break;}
                
                case 2:{
                    System.out.println("Arreglo de la lista de usuarios");
                    System.out.println(listaUsuarios);
                break;}
                
                case 3: {
                    boolean encontrado = false;
                    System.out.println("Ingresa el usuario a buscar");
                    String usuario = sn.nextLine();
                    for (Usuario x : listaUsuarios) {
                        if (x.getCorreo().equalsIgnoreCase(usuario)) {
                            
                            System.out.println("Usuario  "+x.getCorreo());
                            System.out.println("Contraseña  "+x.getContraseña());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El usuario no existe");
                    }
                    break;
                }
            }
            
        } while((opc>0)&&(opc<4));
    }
}