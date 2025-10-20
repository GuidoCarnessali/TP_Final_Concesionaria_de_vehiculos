package Manager;

import Classes.Auto;
import Classes.Moto;
import Classes.Vehiculo;
import Enums.Marca;

import java.util.HashSet;
import java.util.Set;

public class Gestora_Vehiculo {

    private Set<Vehiculo> vehiculos;                    //Hacerlo Hashset ya que no importa el orden y no se repiten
    private Set<Vehiculo> noStockVehiculos;             //Hacerlo Hashset ya que no importa el orden y no se repiten

    public Gestora_Vehiculo() {
        this.vehiculos = new HashSet<>();
        this.noStockVehiculos = new HashSet<>();
    }

    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Set<Vehiculo> getNoStockVehiculos() {
        return noStockVehiculos;
    }

    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Vehiculo
    public boolean addVehiculo(Vehiculo v)
    {
        if(v != null) //Si el vehículo no es nulo lo agrego a la lista de vehículos en stock
        {
            vehiculos.add(v);
            return true;
        }
        return false;


    }

    public boolean removeVehiculo(Vehiculo v)
    {
        if(v != null && vehiculos.contains(v))  //Si el vehículo no es nulo y está en la lista de vehículos en stock lo elimino
        {                                       //Ademas lo paso a la lista de vehículos no en stock
            vehiculos.remove(v);
            noStockVehiculos.add(v);
            v.setEnStock(false);
            return true;
        }
        return false;
    }

    public void modifyVehiculo(Vehiculo v, Marca marca, String modelo, int anio, String color, double precio, boolean enStock)
    {
        if(v != null && vehiculos.contains(v)) //Si el vehículo no es nulo y está en la lista de vehículos en stock lo modifico
        {
            v.setMarca(marca);
            v.setModelo(modelo);
            v.setAnio(anio);
            v.setColor(color);
            v.setPrecio(precio);
            v.setEnStock(enStock);
        }
    }

    public Vehiculo searchVehiculo(Vehiculo v)
    {
        if(v != null && vehiculos.contains(v)) //Si el vehículo no es nulo y está en la lista de vehículos en stock lo devuelvo
        {
            return v;
        }

        return null;

    }

    public void showVehiculos() {
        for (Vehiculo v : vehiculos) {
            if (v instanceof Auto) {
                System.out.println("--------------------");
                System.out.println(v.toString());
            }


        }

        for (Vehiculo v : vehiculos) {
            if (v instanceof Moto) {
                System.out.println("--------------------");
                System.out.println(v.toString());
            }

        }
    }

        public int contarStock (String modelo)
        {
            int stock = 0;

            for (Vehiculo v : vehiculos)
            {
                if(v.getModelo().equalsIgnoreCase(modelo))
                {
                    stock++;
                }
            }

            return stock;
        }



}
