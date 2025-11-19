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


    public Cliente crearCliente ()
    {
        Scanner scan= new Scanner(System.in);
        Cliente c = new Cliente();

        String nombre;
        while (true) {
            System.out.println("Nombre: ");
            nombre = scan.nextLine();
            if (nombre.matches("[a-zA-Z ]+")) {
                c.setNombre(nombre);
                break;
            } else {
                System.out.println("Error: El nombre solo puede contener letras y espacios.");
            }
        }

        String apellido;
        while (true) {
            System.out.println("Apellido: ");
            apellido = scan.nextLine();
            if (apellido.matches("[a-zA-Z ]+")) {
                c.setApellido(apellido);
                break;
            } else {
                System.out.println("Error: El apellido solo puede contener letras y espacios.");
            }
        }

        String dni;
        while (true) {
            System.out.println("DNI: ");
            dni = scan.nextLine();
            if (dni.matches("\\d+")) {
                c.setDni(dni);
                break;
            } else {
                System.out.println("Error: El DNI solo puede contener números.");
            }
        }

        System.out.println("Email: ");
        c.setEmail(scan.nextLine());

        String telefono;
        while (true) {
            System.out.println("Telefono: ");
            telefono = scan.nextLine();
            if (telefono.matches("[0-9\\-]+")) {
                c.setTelefono(telefono);
                break;
            } else {
                System.out.println("Error: El teléfono solo puede contener números y guiones.");
            }
        }

        char sexo;
        while (true) {
            System.out.println("Sexo (M/F/O): ");
            String input = scan.nextLine().toUpperCase();
            if (input.matches("[MFO]")) {
                sexo = input.charAt(0);
                c.setSexo(sexo);
                break;
            } else {
                System.out.println("Error: Sexo válido: M, F u O.");
            }
        }

        int edad;
        while (true) {
            System.out.println("Edad: ");
            if (scan.hasNextInt()) {
                edad = scan.nextInt();
                if (edad > 0) {
                    c.setEdad(edad);
                    scan.nextLine();
                    break;
                } else {
                    System.out.println("Error: La edad debe ser un entero positivo.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número entero.");
                scan.nextLine();
            }
        }
        return c;
    }

    public boolean addCliente(Cliente c)
    {
        if(c != null && !clientes.containsKey(c.getDni())) //Si el cliente no es nulo y no está en la lista de clientes según el dni lo agrego
        {
            clientes.put(c.getDni(), c);                   //Agrego el cliente al mapa con su dni como key y el cliente como valor
            return true;
        }


        return false;
    }

    public boolean removeCliente (String dniViejo)
    {
        for(Cliente c: clientes.values())
        {
            if(c.getDni().equalsIgnoreCase(dniViejo))
            {
                clientes.remove(c);
                c.setActivo(false);
                clientes.put(c.getDni(), c);
                return true;
            }
        }

        return false;

    }

    public void modifyCliente(String dniViejo) {

        Scanner scan = new Scanner(System.in);

        if (!clientes.containsKey(dniViejo)) {
            System.err.println("No hay ningún cliente con ese DNI.");
            return;
        }

        Cliente c = clientes.get(dniViejo);

        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Modificar todo");
            System.out.println("2. Modificar nombre");
            System.out.println("3. Modificar apellido");
            System.out.println("4. Modificar DNI");
            System.out.println("5. Modificar email");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Modificar sexo");
            System.out.println("8. Modificar edad");
            System.out.println("9. Modificar estado activo");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scan.nextInt();
                scan.nextLine(); // limpiar buffer
                if (opcion >= 1 && opcion <= 9) {
                    opcionValida = true;
                } else {
                    System.out.println("Opción fuera de rango.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                scan.nextLine(); // limpiar buffer
            }
        }

        switch (opcion) {
            case 1:
                // nombre
                while (true) {
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scan.nextLine();
                    if (nombre.matches("[a-zA-Z ]+")) {
                        c.setNombre(nombre);
                        break;
                    } else {
                        System.err.println("Error: el nombre solo puede contener letras.");
                    }
                }

                // apellido
                while (true) {
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido = scan.nextLine();
                    if (apellido.matches("[a-zA-Z ]+")) {
                        c.setApellido(apellido);
                        break;
                    } else {
                        System.err.println("Error: el apellido solo puede contener letras.");
                    }
                }

                // dni
                System.out.print("Ingrese el DNI del cliente: ");
                String dniNuevo = scan.nextLine();
                clientes.remove(dniViejo); // quitar clave vieja
                c.setDni(dniNuevo);

                // email
                System.out.print("Ingrese el email del cliente: ");
                c.setEmail(scan.nextLine());

                // teléfono
                System.out.print("Ingrese el teléfono del cliente: ");
                c.setTelefono(scan.nextLine());

                // sexo
                while (true) {
                    System.out.print("Ingrese el sexo (M/F): ");
                    String sexoInput = scan.nextLine().trim().toUpperCase();
                    if (sexoInput.equals("M") || sexoInput.equals("F")) {
                        c.setSexo(sexoInput.charAt(0));
                        break;
                    } else {
                        System.err.println("Error: solo puede ingresar 'M' o 'F'.");
                    }
                }

                // edad
                while (true) {
                    try {
                        System.out.print("Ingrese la edad del cliente: ");
                        int edad = scan.nextInt();
                        scan.nextLine();
                        c.setEdad(edad);
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Error: la edad debe ser un número entero.");
                        scan.nextLine();
                    }
                }

                // activo
                while (true) {
                    System.out.print("¿Está activo? (true/false): ");
                    String activoInput = scan.nextLine().trim().toLowerCase();
                    if (activoInput.equals("true")) {
                        c.setActivo(true);
                        break;
                    } else if (activoInput.equals("false")) {
                        c.setActivo(false);
                        break;
                    } else {
                        System.err.println("Debe ingresar true o false.");
                    }
                }

                clientes.put(c.getDni(), c);
                System.out.println("Cliente modificado completamente.");
                break;

            case 2:
                while (true) {
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scan.nextLine();
                    if (nombre.matches("[a-zA-Z ]+")) {
                        c.setNombre(nombre);
                        break;
                    } else {
                        System.err.println("Error: el nombre solo puede contener letras.");
                    }
                }
                System.out.println("Nombre modificado.");
                break;

            case 3:
                while (true) {
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido = scan.nextLine();
                    if (apellido.matches("[a-zA-Z ]+")) {
                        c.setApellido(apellido);
                        break;
                    } else {
                        System.err.println("Error: el apellido solo puede contener letras.");
                    }
                }
                System.out.println("Apellido modificado.");
                break;

            case 4:
                System.out.print("Ingrese el nuevo DNI: ");
                String dniNuevo2 = scan.nextLine();
                clientes.remove(dniViejo);
                c.setDni(dniNuevo2);
                clientes.put(c.getDni(), c);
                System.out.println("DNI modificado.");
                break;

            case 5:
                System.out.print("Ingrese el nuevo email: ");
                c.setEmail(scan.nextLine());
                System.out.println("Email modificado.");
                break;

            case 6:
                System.out.print("Ingrese el nuevo teléfono: ");
                c.setTelefono(scan.nextLine());
                System.out.println("Teléfono modificado.");
                break;

            case 7:
                while (true) {
                    System.out.print("Ingrese el sexo (M/F): ");
                    String sexoInput2 = scan.nextLine().trim().toUpperCase();
                    if (sexoInput2.equals("M") || sexoInput2.equals("F")) {
                        c.setSexo(sexoInput2.charAt(0));
                        break;
                    } else {
                        System.err.println("Error: solo puede ingresar 'M' o 'F'.");
                    }
                }
                System.out.println("Sexo modificado.");
                break;

            case 8:
                while (true) {
                    try {
                        System.out.print("Ingrese la edad del cliente: ");
                        int edad = scan.nextInt();
                        scan.nextLine();
                        c.setEdad(edad);
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Error: la edad debe ser un número entero.");
                        scan.nextLine();
                    }
                }
                System.out.println("Edad modificada.");
                break;

            case 9:
                while (true) {
                    System.out.print("¿Está activo? (true/false): ");
                    String activoInput2 = scan.nextLine().trim().toLowerCase();
                    if (activoInput2.equals("true")) {
                        c.setActivo(true);
                        break;
                    } else if (activoInput2.equals("false")) {
                        c.setActivo(false);
                        break;
                    } else {
                        System.err.println("Debe ingresar true o false.");
                    }
                }
                System.out.println("Estado activo modificado.");
                break;
        }


        if (!clientes.containsKey(c.getDni())) {
            clientes.put(c.getDni(), c);
        }
    }

    public Cliente modifyClienteFactura(String dniViejo) {

        Scanner scan = new Scanner(System.in);

        if (!clientes.containsKey(dniViejo)) {
            System.err.println("No hay ningún cliente con ese DNI.");
            return null;
        }

        Cliente c = clientes.get(dniViejo);

        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Modificar todo");
            System.out.println("2. Modificar nombre");
            System.out.println("3. Modificar apellido");
            System.out.println("4. Modificar DNI");
            System.out.println("5. Modificar email");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Modificar sexo");
            System.out.println("8. Modificar edad");
            System.out.println("9. Modificar estado activo");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scan.nextInt();
                scan.nextLine();
                if (opcion >= 1 && opcion <= 9) {
                    opcionValida = true;
                } else {
                    System.out.println("Opción fuera de rango.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                scan.nextLine();
            }
        }

        switch (opcion) {
            case 1:
                while (true) {
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scan.nextLine();
                    if (nombre.matches("[a-zA-Z ]+")) {
                        c.setNombre(nombre);
                        break;
                    } else {
                        System.err.println("Error: el nombre solo puede contener letras.");
                    }
                }

                while (true) {
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido = scan.nextLine();
                    if (apellido.matches("[a-zA-Z ]+")) {
                        c.setApellido(apellido);
                        break;
                    } else {
                        System.err.println("Error: el apellido solo puede contener letras.");
                    }
                }

                System.out.print("Ingrese el DNI del cliente: ");
                String dniNuevo = scan.nextLine();
                clientes.remove(dniViejo);
                c.setDni(dniNuevo);

                System.out.print("Ingrese el email del cliente: ");
                c.setEmail(scan.nextLine());

                System.out.print("Ingrese el teléfono del cliente: ");
                c.setTelefono(scan.nextLine());

                while (true) {
                    System.out.print("Ingrese el sexo (M/F): ");
                    String sexoInput = scan.nextLine().trim().toUpperCase();
                    if (sexoInput.equals("M") || sexoInput.equals("F")) {
                        c.setSexo(sexoInput.charAt(0));
                        break;
                    } else {
                        System.err.println("Error: solo puede ingresar 'M' o 'F'.");
                    }
                }

                while (true) {
                    try {
                        System.out.print("Ingrese la edad del cliente: ");
                        int edad = scan.nextInt();
                        scan.nextLine();
                        c.setEdad(edad);
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Error: la edad debe ser un número entero.");
                        scan.nextLine();
                    }
                }

                while (true) {
                    System.out.print("¿Está activo? (true/false): ");
                    String activoInput = scan.nextLine().trim().toLowerCase();
                    if (activoInput.equals("true")) {
                        c.setActivo(true);
                        break;
                    } else if (activoInput.equals("false")) {
                        c.setActivo(false);
                        break;
                    } else {
                        System.err.println("Debe ingresar true o false.");
                    }
                }

                clientes.put(c.getDni(), c);
                System.out.println("Cliente modificado completamente.");
                return c;

            case 2:
                while (true) {
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre2 = scan.nextLine();
                    if (nombre2.matches("[a-zA-Z ]+")) {
                        c.setNombre(nombre2);
                        break;
                    } else {
                        System.err.println("Error: el nombre solo puede contener letras.");
                    }
                }
                System.out.println("Nombre modificado.");
                return c;

            case 3:
                while (true) {
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido2 = scan.nextLine();
                    if (apellido2.matches("[a-zA-Z ]+")) {
                        c.setApellido(apellido2);
                        break;
                    } else {
                        System.err.println("Error: el apellido solo puede contener letras.");
                    }
                }
                System.out.println("Apellido modificado.");
                return c;

            case 4:
                System.out.print("Ingrese el nuevo DNI: ");
                String dniNuevo2 = scan.nextLine();
                clientes.remove(dniViejo);
                c.setDni(dniNuevo2);
                clientes.put(c.getDni(), c);
                System.out.println("DNI modificado.");
                return c;

            case 5:
                System.out.print("Ingrese el nuevo email: ");
                c.setEmail(scan.nextLine());
                System.out.println("Email modificado.");
                return c;

            case 6:
                System.out.print("Ingrese el nuevo teléfono: ");
                c.setTelefono(scan.nextLine());
                System.out.println("Teléfono modificado.");
                return c;

            case 7:
                while (true) {
                    System.out.print("Ingrese el sexo (M/F): ");
                    String sexoInput2 = scan.nextLine().trim().toUpperCase();
                    if (sexoInput2.equals("M") || sexoInput2.equals("F")) {
                        c.setSexo(sexoInput2.charAt(0));
                        break;
                    } else {
                        System.err.println("Error: solo puede ingresar 'M' o 'F'.");
                    }
                }
                System.out.println("Sexo modificado.");
                return c;

            case 8:
                while (true) {
                    try {
                        System.out.print("Ingrese la edad del cliente: ");
                        int edad2 = scan.nextInt();
                        scan.nextLine();
                        c.setEdad(edad2);
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Error: la edad debe ser un número entero.");
                        scan.nextLine();
                    }
                }
                System.out.println("Edad modificada.");
                return c;

            case 9:
                while (true) {
                    System.out.print("¿Está activo? (true/false): ");
                    String activoInput2 = scan.nextLine().trim().toLowerCase();
                    if (activoInput2.equals("true")) {
                        c.setActivo(true);
                        break;
                    } else if (activoInput2.equals("false")) {
                        c.setActivo(false);
                        break;
                    } else {
                        System.err.println("Debe ingresar true o false.");
                    }
                }
                System.out.println("Estado activo modificado.");
                return c;
        }

        return c;
    }


    public String searchCliente(String dni)
    {
        if(clientes.containsKey(dni)){
            return clientes.get(dni).toString();
        }
        return "No se ha encontrado un cliente con ese DNI. ";
    }

    public Cliente searchClienteFactura(String dni)
    {
        if (clientes.containsKey(dni)) {
            return clientes.get(dni);
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

    public void listaDeserializadaToClientes (Map<String, Cliente> clientesB) {

        clientes.putAll(clientesB);

    }


}
