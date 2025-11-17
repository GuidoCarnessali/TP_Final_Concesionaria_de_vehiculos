package Manager;

import Classes.Factura;
import Classes.Proveedor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Gestora_Factura {

    //Atributos
    private Map<Integer, Factura> facturas;               //Hacerlo TreeMap (numeroFactura, factura) ya que importa el orden (Ordenación) y no se repiten

    //Constructor
    public Gestora_Factura() {
        this.facturas = new TreeMap<>();
    }

    //Getters
    public Map<Integer, Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Map<Integer, Factura> facturas) {
        this.facturas = facturas;
    }

    //ABMCL
    //Alta, Baja, Modificación, Consulta y Listado
    //Factura
    public boolean addFactura(Factura f)
    {
        if(f != null && !facturas.containsKey(f.getNumeroFactura())) //Si la factura no es nula y no está en la lista de facturas según el número de factura lo agrego
        {
            facturas.put(f.getNumeroFactura(), f);                   //Agrego la factura al mapa con su número de factura como key y la factura como valor
            return true;
        }
        return false;
    }

    //Se pueden eliminar facturas, aunque no le vemos un uso cotidiano
    public boolean removeFactura(Factura f)
    {
        if(f != null && facturas.containsKey(f.getNumeroFactura())) //Si la factura no es nula y está en la lista de facturas según el número de factura lo elimino
        {
            facturas.remove(f.getNumeroFactura());                   //Elimino la factura del mapa según su número de factura
            return true;
        }
        return false;
    }

    //No hicimos la modificación de facturas, ya que no le vemos un uso cotidiano a eso


    public String searchFactura(int numeroDeFactura)
    {
        if(facturas.containsKey(numeroDeFactura)) //Si la factura no es nula y está en la lista de facturas según el número de factura lo devuelvo
        {
            return facturas.get(numeroDeFactura).toString();              //Devuelvo la factura del mapa según su número de factura
        }

        return "No se ha encontrado una factura con ese numero. ";
    }

    public void showFacturas()
    {

        for (Factura f : facturas.values())
        {
            System.out.println("-------------------");
            System.out.println(f.toString());
        }

    }

    public void listaDeserializadaToFacturas (Map<Integer, Factura> facturasB) {

        facturas.putAll(facturasB);

    }

    public void filtrarPorDni (String dni)
    {
        for (Factura f: facturas.values())
        {
            if (f.getCliente().getDni().equalsIgnoreCase(dni))
            {
                System.out.println(f.toString());
            }
        }
    }







}
