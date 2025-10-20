package Classes;

import Enums.Marca;

public class Moto extends Vehiculo {

    //Atributos
    private int cilindrada;
    private int capacidadPasajeros;

    //Constructor


    public Moto(Marca marca, String modelo, int anio, String color, double precio, boolean enStock, int cilindrada, int capacidadPasajeros) {
        super(marca, modelo, anio, color, precio, enStock);
        this.cilindrada = cilindrada;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public Moto() {
    }

    //Getters and Setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    //Métodos

    public String toString() {
        return "Moto: " +
                "\nMarca: " + this.getMarca() +
                "\nModelo: " + this.getModelo() +
                "\nAño: " + this.getAnio() +
                "\nColor: " + this.getColor() +
                "\nPrecio: " + this.getPrecio() +
                "\nCilindrada: " + this.getCilindrada() +
                "\nCapacidad de Pasajeros: " + this.getCapacidadPasajeros() +
                "\nEn Stock: " + this.isEnStock();
    }



    @Override
    public String acelerar() {
        return "La moto está acelerando.";

    }

    @Override
    public String frenar() {
        return "La moto está frenando.";
    }

    @Override
    public String encender() {
        return "Encendiendo la moto.";
    }

    @Override
    public String apagar() {
        return "Apagando la moto.";
    }


}
