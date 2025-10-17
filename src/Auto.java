public class Auto extends Vehiculo {

    //Atributos
    private int cilindrada;
    private int puertas;
    private String combustible;

    //Constructor


    public Auto(Marca marca, String modelo, int anio, String color, String precio, boolean enStock, int cilindrada, int puertas, String combustible) {
        super(marca, modelo, anio, color, precio, enStock);
        this.cilindrada = cilindrada;
        this.puertas = puertas;
        this.combustible = combustible;
    }

    public Auto()
    {}

    //Getters and Setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    //Métodos
    @Override
    public String acelerar() {
        return "El auto está acelerando.";
    }

    @Override
    public String frenar() {
        return "El auto está frenando.";

    }

    @Override
    public String encender() {
        return "Encendiendo el auto.";
    }

    @Override
    public String apagar() {
        return "Apagando el auto.";
    }
}
