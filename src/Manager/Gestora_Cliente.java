package Manager;

import Classes.Cliente;
import Classes.Empleado;
import Classes.Vehiculo;

import java.util.HashMap;
import java.util.Map;

public class Gestora_Cliente {

    private Map<String, Cliente> clientes;

    //Constructor
    public Gestora_Cliente() {
        this.clientes = new HashMap<>(); //es un hashmap
    }

    //Getters
    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Cliente
    public boolean addCliente(Cliente c)
    {
        if(c != null && !clientes.containsKey(c.getDni())) //Si el cliente no es nulo y no está en la lista de clientes según el dni lo agrego
        {
            clientes.put(c.getDni(), c);                   //Agrego el cliente al mapa con su dni como key y el cliente como valor
            return true;
        }

        return false;
    }

    public boolean removeCliente (Cliente c)
    {
        if(c != null && clientes.containsKey(c.getDni())) //Si el cliente no es nulo y está en la lista de clientes según el dni lo elimino
        {
            clientes.remove(c.getDni());                   //Elimino el cliente del mapa según su dni
            return true;
        }

        return false;
    }

    public void modifyCliente(Cliente c, String nombre, String apellido, String dni, String email, String telefono, boolean activo)
    {
        if(c != null && clientes.containsKey(c.getDni())) //Si el cliente no es nulo y está en la lista de clientes según el dni lo modifico
        {
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setDni(dni);
            c.setEmail(email);
            c.setTelefono(telefono);
        }
    }

    public Cliente searchCliente(Cliente c)
    {
        if(c != null && clientes.containsKey(c.getDni())) //Si el cliente no es nulo y está en la lista de clientes según el dni lo devuelvo
        {
            return clientes.get(c.getDni());              //Devuelvo el cliente del mapa según su dni
        }

        return null;
    }

    public void showClientes()
    {
        for(Cliente c : clientes.values())               //Recorro el mapa de clientes y muestro los valores (clientes)
        {
            System.out.println("--------------------");
            System.out.println(c.toString());
        }
    }




}
