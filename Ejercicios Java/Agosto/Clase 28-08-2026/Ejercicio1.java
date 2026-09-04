import java.util.*;

public class Ejercicio1{
    public static class Usuarios { 

        // Atributos de la clase 
        private String nombre;
        private String apellido;
        private String id;
        private String contraseña;
        private String tipo;

        // Métodos de la clase
        public void registro (){
            System.out.println("Registrando usuario");
        }

        public void mostrarDatos () {
            System.out.println("nombre: "+nombre+" \n");
            System.out.println("apellido: "+apellido+" \n");
            System.out.println("id: "+id+" \n");
            System.out.println("contraseña: "+contraseña+" \n");
            System.out.println("tipo: "+tipo+" \n");
        }

        // construir metodo para iniciar sesion
        public boolean inicioSesion(String id, String contraseña) {
            if(this.id.equals(id) && this.contraseña.equals(contraseña)) 
                return true;
            else
                return false;
        }

        // Constructor de la clase
        Usuarios (String n, String a, String i, String c, String t){
            this.nombre = n;
            this.apellido = a;
            this.id = i;
            this.contraseña = c;
            this.tipo = t;
        }
    }
    public static void main (String [ ] arg){
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Clase usuarios \n");
        // Instanciacion de objetos

        Usuarios estudiantex=new 
        Usuarios("Jorge", "Martin", "jorge@gmail.com", "1234","estudiante");

        // Ingresando al sistema
        String id, contraseña;
        System.out.println("Inicio de sesión \n");
        System.out.println("Ingrese su id: ");
        id = lecturaTeclado.nextLine();
        System.out.println("Ingrese su contraseña: ");
        contraseña = lecturaTeclado.nextLine();
        // Mostrar datos de usuario
        if(estudiantex.inicioSesion(id, contraseña)==true){
            System.out.println("Inicio de sesion exitoso");
        } else {
            System.out.println("Inicio de sesion fallido");
        }

        estudiantex.mostrarDatos();
    }
}