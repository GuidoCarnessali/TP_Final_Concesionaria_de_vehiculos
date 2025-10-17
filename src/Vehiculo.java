public abstract class Vehiculo {

    //Atributos
    private Marca marca;
    private String modelo;
    private int anio;
    private String color;
    private String precio;
    private boolean enStock;


    //Constructor
    public Vehiculo(Marca marca, String modelo, int anio, String color, String precio, boolean enStock) {
        this.marca = marca ;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.precio = precio;
        this.enStock = enStock;
    }

    public Vehiculo()
    {}

    //Getters and Setters
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public boolean isEnStock() {
        return enStock;
    }

    public void setEnStock(boolean enStock) {
        this.enStock = enStock;
    }

    //Métodos
    public String mostrarVehiculo()
    {
        return "Vehiculo: " +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nAño: " + anio +
                "\nColor: " + color +
                "\nPrecio: " + precio;
    }


    //Métodos abstractos
    public abstract String encender();
    public abstract String apagar();
    public abstract String acelerar();
    public abstract String frenar();


}
