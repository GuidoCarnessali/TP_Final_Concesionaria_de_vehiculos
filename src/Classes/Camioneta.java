package Classes;

import Classes.Interfaces.iVehiculoDeCarga;
import Enums.Marca;

public class Camioneta extends Vehiculo implements iVehiculoDeCarga {


    private int cilindrada;
    private int puertas;
    private String combustible;
    private double anchoCaja;
    private double largoCaja;

    public Camioneta(Marca marca, String modelo, int anio, String color, double precio, boolean enStock, int cilindrada, int puertas, String combustible, double anchoCaja, double largoCaja) {
        super(marca, modelo, anio, color, precio, enStock);
        this.cilindrada = cilindrada;
        this.puertas = puertas;
        this.combustible = combustible;
        this.anchoCaja = anchoCaja;
        this.largoCaja = largoCaja;
    }

    public Camioneta() {
    }

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

    public double getAnchoCaja() {
        return anchoCaja;
    }

    public void setAnchoCaja(double anchoCaja) {
        this.anchoCaja = anchoCaja;
    }

    public double getLargoCaja() {
        return largoCaja;
    }

    public void setLargoCaja(double largoCaja) {
        this.largoCaja = largoCaja;
    }

    @Override
    public String encender() {
        return "Encendiendo la camioneta.";
    }

    @Override
    public String apagar() {
        return "Apagando la camioneta.";
    }

    @Override
    public String acelerar() {
        return "La camioneta está acelerando.";
    }

    @Override
    public String frenar() {
        return "La camioneta está frenando.";
    }

    @Override
    public double calcularDimension() {
        return largoCaja*anchoCaja;
    }
}
