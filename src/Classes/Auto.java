package Classes;

import Enums.Marca;

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

    public String toString()
    {
        return "Auto: " +
                "\nMarca: " + this.getMarca() +
                "\nModelo: " + this.getModelo() +
                "\nAño: " + this.getAnio() +
                "\nColor: " + this.getColor() +
                "\nPrecio: " + this.getPrecio() +
                "\nCilindrada: " + this.getCilindrada() +
                "\nPuertas: " + this.getPuertas() +
                "\nCombustible: " + this.getCombustible() +
                "\nEn Stock: " + this.isEnStock();
    }


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
