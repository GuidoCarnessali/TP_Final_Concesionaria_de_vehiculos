package Classes;
import Enums.Marca;

import java.util.Objects;

public abstract class Vehiculo {

    //Atributos
    private Marca marca;
    private String modelo;
    private int anio;
    private String color;
    private double precio;
    private boolean enStock;


    //Constructor
    public Vehiculo(Marca marca, String modelo, int anio, String color, double precio, boolean enStock) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEnStock() {
        return enStock;
    }

    public void setEnStock(boolean enStock) {
        this.enStock = enStock;
    }



    //Métodos
    public String toString()
    {
        return "Vehiculo: " +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nAño: " + anio +
                "\nColor: " + color +
                "\nPrecio: " + precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return marca == vehiculo.marca && Objects.equals(modelo, vehiculo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }

    //Métodos abstractos
    public abstract String encender();
    public abstract String apagar();
    public abstract String acelerar();
    public abstract String frenar();


}
