package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Factura {

    //Atributos
    private static int contadorFacturas = 0;
    private int numeroFactura;
    private LocalDateTime fecha;
    private double montoTotal;
    private Cliente cliente;
    private Empleado empleado; //El empleado no deberia ser random, sino un vendedor de la concesionaria
    private Vehiculo vehiculo;
    private boolean activo=true;

    //Constructor
    public Factura(double montoTotal, Cliente cliente, Empleado empleado, Vehiculo vehiculo) {

        this.numeroFactura = ++contadorFacturas;
        this.fecha = LocalDateTime.now();
        this.montoTotal = montoTotal;
        this.cliente = cliente;
        this.empleado = empleado;
        this.vehiculo = vehiculo;
        this.activo=true;
    }

    public Factura(double montoTotal, Cliente cliente, Empleado empleado, Vehiculo vehiculo, boolean activo) {

        this.numeroFactura = ++contadorFacturas;
        this.fecha = LocalDateTime.now();
        this.montoTotal = montoTotal;
        this.cliente = cliente;
        this.empleado = empleado;
        this.vehiculo = vehiculo;
        this.activo=activo;
    }

    public Factura(){
        this.numeroFactura = ++contadorFacturas;
        this.fecha = LocalDateTime.now();
    }




    //Getters

    public static int getContadorFacturas() {
        return contadorFacturas;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public boolean isActivo() {
        return activo;
    }

    //Setters
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

//Métodos

    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy --- HH:mm:ss");
        return "Factura N°: " + this.numeroFactura +
                "\nFecha y Hora: " + this.fecha.format(formatter) +
                "\nMonto Total: $" + this.montoTotal +
                "\nCliente: " + this.cliente.getNombre() + " " + this.cliente.getApellido() +
                "\nEmpleado: " + this.empleado.getNombre() + " " + this.empleado.getApellido() +
                "\nVehículo: " + this.vehiculo.getMarca() + " " + this.vehiculo.getModelo() + " " + this.vehiculo.getAnio()+
                "\nActivo:"+ activo;
    }

}

