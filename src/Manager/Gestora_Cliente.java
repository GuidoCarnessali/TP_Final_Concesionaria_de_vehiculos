package Manager;

import Classes.Cliente;
import Classes.Empleado;
import Classes.Factura;
import Classes.Vehiculo;

import java.util.*;

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


            String nombre;
            while (true) {
                System.out.println("Ingrese el nombre del cliente: ");
                nombre = scan.nextLine();

                if (nombre.matches("[a-zA-Z ]+")) {
                    c.setNombre(nombre);
                    break;
                } else {
                    System.err.println("Error: el nombre solo puede contener letras A-Z o a-z.");
                }
            }


            String apellido;
            while (true) {
                System.out.println("Ingrese el apellido del cliente: ");
                apellido = scan.nextLine();

                if (apellido.matches("[a-zA-Z ]+")) {
                    c.setApellido(apellido);
                    break;
                } else {
                    System.err.println("Error: el apellido solo puede contener letras A-Z o a-z.");
                }
            }


            System.out.println("Ingrese el DNI del cliente: ");
            c.setDni(scan.nextLine());


            System.out.println("Ingrese el email del cliente: ");
            c.setEmail(scan.nextLine());


            System.out.println("Ingrese el teléfono del cliente: ");
            c.setTelefono(scan.nextLine());


            String sexoInput;
            while (true) {
                System.out.println("Ingrese el sexo del cliente (M/F): ");
                sexoInput = scan.nextLine().trim().toUpperCase();

                if (sexoInput.equals("M") || sexoInput.equals("F")) {
                    c.setSexo(sexoInput.charAt(0));
                    break;
                } else {
                    System.err.println("Error: solo puede ingresar 'M' o 'F'.");
                }
            }


            while (true) {
                try {
                    System.out.println("Ingrese la edad del cliente: ");
                    int edad = scan.nextInt();
                    scan.nextLine();
                    c.setEdad(edad);
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Error: la edad debe ser un número entero.");
                    scan.nextLine(); // limpiar buffer
                }
            }

            clientes.put(c.getDni(), c);
            System.out.println("Cliente modificado correctamente.");

        } else {
            System.err.println("No hay ningún cliente con ese DNI");
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
