public class Ejercicio1{
    public class Usuarios { 

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
        System.out.println("Clase usuarios");
        // Instanciacion de objetos

        Usuarios estudiantex=new 
        Usuarios("Jorge", "Martin", "jorge@gmail.com", "estudiante");
        estudiantex.registro();
    }
}