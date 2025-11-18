package Classes;

import Classes.Interfaces.iVehiculoDeCarga;
import Enums.Marca;

public class Camión extends Vehiculo implements iVehiculoDeCarga {

    //Atributos
    private int cilindrada;
    private int puertas;
    private String combustible;
    private double largoChasis;
    private double anchoChasis;


    //Constructor
    public Camión(Marca marca, String modelo, int anio, String color, double precio, boolean enStock, int cilindrada, int puertas, String combustible, double largoChasis, double anchoChasis) {
        super(marca, modelo, anio, color, precio, enStock);
        this.cilindrada = cilindrada;
        this.puertas = puertas;
        this.combustible = combustible;
        this.largoChasis = largoChasis;
        this.anchoChasis = anchoChasis;
    }

    public Camión() {
    }


    //Getters y Setters
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

    public double getLargoChasis() {
        return largoChasis;
    }

    public void setLargoChasis(double largoChasis) {
        this.largoChasis = largoChasis;
    }

    public double getAnchoChasis() {
        return anchoChasis;
    }

    public void setAnchoChasis(double anchoChasis) {
        this.anchoChasis = anchoChasis;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cilindrada: =" + cilindrada + "\n" +
                "Puertas: " + puertas + "\n" +
                "Combustible: " + combustible + '\'' +
                "Largo del chasis: " + largoChasis + "\n" +
                "Ancho del chasis: " + anchoChasis + "\n" +
                "Superficie: " + calcularDimension() + " cm2";
    }

    //Métodos
    @Override
    public String encender() {
        return "Encendiendo el camión.";
    }

    @Override
    public String apagar() {
        return "Apagando el camión.";
    }

    @Override
    public String acelerar() {
        return "El camion está acelerando.";
    }

    @Override
    public String frenar() {
        return "El camión está frenando.";
    }

    @Override
    public double calcularDimension() {
        return anchoChasis*largoChasis;
    }
}