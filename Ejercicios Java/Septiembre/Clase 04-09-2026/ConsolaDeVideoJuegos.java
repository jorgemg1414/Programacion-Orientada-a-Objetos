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

    // ------------------- Métodos -------------------
    public void encender() {
        System.out.println("Encendiendo la consola...");
        System.out.println("   Marca: " + this.marca);
        System.out.println("   Modelo: " + this.modelo);
        System.out.println("   Almacenamiento: " + this.almacenamiento + " GB");
        System.out.println("La consola " + this.marca + " " + this.modelo + " ya esta lista para jugar.\n");
    }

    public void apagar() {
        System.out.println("Apagando la consola...");
        System.out.println("   Marca: " + this.marca);
        System.out.println("   Modelo: " + this.modelo);
        System.out.println("   Almacenamiento: " + this.almacenamiento + " GB");
        System.out.println("La consola " + this.marca + " " + this.modelo + " se ha apagado correctamente.\n");
    }

    // ------------------- Getters y Setters -------------------
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
}