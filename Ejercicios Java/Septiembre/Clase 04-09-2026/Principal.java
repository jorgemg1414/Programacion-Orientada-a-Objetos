public class Principal {
    public static void main(String[] args) {

        System.out.println("Clase ConsolaDeVideoJuegos\n");

        ConsolaDeVideoJuegos consola1 = new ConsolaDeVideoJuegos("Sony", "PlayStation 5", 825);
        ConsolaDeVideoJuegos consola2 = new ConsolaDeVideoJuegos("Nintendo", "Switch OLED", 64);

        System.out.println("Consola 1");
        consola1.encender();
        consola1.apagar();

        System.out.println("Consola 2");
        consola2.encender();
        consola2.apagar();
    }
}