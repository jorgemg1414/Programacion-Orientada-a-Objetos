/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicioarraylist;
import java.util.*;

/**
 *
 * @author jorge
 */
public class EjercicioArraylist {
    

    public static void main(String[] args) {
        Scanner sn= new Scanner (System.in);
        ArrayList tareas=new ArrayList();
        
        for (int a=0; a<3; a++){
        System.out.println("Agrega una tarea");
        tareas.add(sn.nextLine());
        }
        System.out.println("Mostrar tareas");
        System.out.println(tareas);
    }
}
