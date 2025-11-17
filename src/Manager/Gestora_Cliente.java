package Manager;

import Classes.Cliente;
import Classes.Empleado;
import Classes.Factura;
import Classes.Vehiculo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Gestora_Cliente {

    private HashMap<String, Cliente> clientes;

    //Constructor
    public Gestora_Cliente() {
        this.clientes = new HashMap<>(); //es un hashmap
    }

    //Getters
    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
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
            clientes.remove(c.getDni());   //Elimino el cliente del mapa según su dni
            return true;
        }

        return false;
    }

    public void modifyCliente(String dniViejo)
    {
        Scanner scan = new Scanner(System.in);
        Cliente c = new Cliente();
        if (clientes.containsKey(dniViejo)) {

            clientes.remove(dniViejo);
            System.out.println("Ingrese el nombre del cliente: ");
            c.setNombre(scan.nextLine());
            System.out.println("Ingrese el apellido del cliente: ");
            c.setApellido(scan.nextLine());
            System.out.println("Ingrese el DNI del cliente: ");
            c.setDni(scan.nextLine());
            System.out.println("Ingrese el email del cliente: ");
            c.setEmail(scan.nextLine());
            System.out.println("Ingrese el teléfono del cliente: ");
            c.setTelefono(scan.nextLine());
            System.out.println("Ingrese el sexo del cliente (M/F): ");
            String sexoInput = scan.nextLine();
            c.setSexo(sexoInput.charAt(0));
            System.out.println("Ingrese la edad del cliente: ");
            c.setEdad(scan.nextInt());
            scan.nextLine();

            clientes.put(c.getDni(), c);
        }else {
            System.err.println("No hay ningun cliente con ese DNI");
        }
    }

    public String searchCliente(String dni)
    {
        if(clientes.containsKey(dni)){
            return clientes.get(dni).toString();
        }
        return "No se ha encontrado un cliente con ese DNI. ";
    }

    public void showClientes()
    {
        for(Cliente c : clientes.values())               //Recorro el mapa de clientes y muestro los valores (clientes)
        {
            System.out.println("--------------------");
            System.out.println(c.toString());
        }
    }

    public void listaDeserializadaToClientes (Map<String, Cliente> clientesB) {

        clientes.putAll(clientesB);

    }


}
