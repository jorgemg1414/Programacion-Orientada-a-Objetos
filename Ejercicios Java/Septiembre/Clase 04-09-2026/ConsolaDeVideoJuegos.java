public class ConsolaDeVideoJuegos {

    //Atributos de la clase
    private String marca;
    private String modelo;
    private int almacenamiento;

    //Constructor de la clase
    public ConsolaDeVideoJuegos(String marca, String modelo, int almacenamiento) {
        this.marca = marca;
        this.modelo = modelo;
        this.almacenamiento = almacenamiento;
    }

    //Metodos de la clase
    public void encender() {
        System.out.println("Encendiendo la consola");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Almacenamiento: " + this.almacenamiento + " GB");
        System.out.println("La consola ya esta lista para jugar.\n");
    }

    public void apagar() {
        System.out.println("Apagando la consola");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Almacenamiento: " + this.almacenamiento + " GB");
        System.out.println("La consola se ha apagado correctamente.\n");
    }
}