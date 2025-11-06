package Manager;

import Classes.Auto;
import Classes.Moto;
import Classes.Vehiculo;
import Enums.Marca;

import java.util.HashSet;
import java.util.Set;

public class Gestora_Vehiculo {

    private Set<Vehiculo> vehiculos;                    //Hacerlo Hashset ya que no importa el orden y no se repiten

    public Gestora_Vehiculo() {
        this.vehiculos = new HashSet<>();
    }

    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }


    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Vehiculo
    public boolean addVehiculo(Vehiculo v)
    {
        if(v != null) //Si el vehículo no es nulo lo agrego a la lista de vehículos en stock
        {
            if(vehiculos.contains(v))
            {
                if (v.isEnStock() == false)
                {
                    vehiculos.remove(v);
                    v.setEnStock(true);
                    vehiculos.add(v);
                    return true;
                }
            }else {
                vehiculos.add(v);
                return true;
            }
        }
        return false;
    }

    public boolean removeVehiculo(Vehiculo v)
    {
        if(v != null && vehiculos.contains(v))  //Si el vehículo no es nulo y está en la lista de vehículos en stock lo elimino
        {                                       //Ademas lo paso a la lista de vehículos no en stock
           vehiculos.remove(v);
           v.setEnStock(false);
           vehiculos.add(v);

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

        public void listaDeserializadaToVehiculos (Set<Vehiculo> vehiculosB){

            for (Vehiculo v: vehiculosB)
            {
                vehiculos.add(v);
            }
        }

        public void showVehiculosActivos ()
        {
            for(Vehiculo v: vehiculos)
            {
                if (v.isEnStock())
                {
                    System.out.println(v.toString());
                }
            }
        }


    public void showVehiculosInactivos ()
    {
        for(Vehiculo v: vehiculos)
        {
            if (!v.isEnStock())
            {
                System.out.println(v.toString());
            }
        }
    }


}
