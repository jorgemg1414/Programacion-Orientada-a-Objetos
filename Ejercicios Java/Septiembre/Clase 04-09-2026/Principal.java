public class Principal {
    public static void main(String[] args) {

        System.out.println("===== PRUEBA DE LA CLASE ConsolaDeVideoJuegos =====\n");

        // Se crean los objetos usando el constructor
        ConsolaDeVideoJuegos consola1 = new ConsolaDeVideoJuegos("Sony", "PlayStation 5", 825);
        ConsolaDeVideoJuegos consola2 = new ConsolaDeVideoJuegos("Nintendo", "Switch OLED", 64);

        // Se invocan los metodos de la primera consola
        System.out.println("----- Consola 1 -----");
        consola1.encender();
        consola1.apagar();

        // Se invocan los metodos de la segunda consola
        System.out.println("----- Consola 2 -----");
        consola2.encender();
        consola2.apagar();

        System.out.println("===== FIN DEL PROGRAMA =====");
    }
}