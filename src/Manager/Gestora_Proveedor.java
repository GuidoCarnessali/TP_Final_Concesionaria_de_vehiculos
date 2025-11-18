package Manager;

import Classes.Proveedor;
import Classes.Vehiculo;
import Enums.Marca;

import java.util.*;

public class Gestora_Proveedor {

    private List<Proveedor> proveedores;                //Hacerlo arraylist ya que no importa el orden y no se repiten


    public Gestora_Proveedor() {
        this.proveedores = new ArrayList<>();
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Proveedor
    public boolean addProveedor(Proveedor p)
    {
        if(p != null) //Si el proveedor no es nulo y no está en la lista de proveedores lo agrego
        {

            if (proveedores.contains(p)){

                if (p.isActivo() == false){
                    proveedores.remove(p);
                    p.setActivo(true);
                    proveedores.add(p);
                    return true;
                }


            }else {
                proveedores.add(p);                   //Agrego el proveedor a la lista
                return true;
            }

        }
        return false;
    }

    public boolean removeProveedor(String nombre) {

        for (Proveedor p : proveedores) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {

                proveedores.remove(p);
                p.setActivo(false);
                proveedores.add(p);

                return true;
            }
        }

        return false; // No se encontró ningún proveedor con ese nombre
    }


    public void modifyProveedor(String nombreViejo) {

        Scanner scan = new Scanner(System.in);
        Proveedor p = null;

        for (Proveedor prov : proveedores) {
            if (prov.getNombre().equalsIgnoreCase(nombreViejo)) {
                p = prov;
                proveedores.remove(prov);
                break;
            }
        }

        if (p != null) {


            String nombre;
            while (true) {
                System.out.println("Ingrese el nombre del proveedor: ");
                nombre = scan.nextLine();

                if (nombre.matches("[a-zA-Z ]+")) {
                    p.setNombre(nombre);
                    break;
                } else {
                    System.err.println("Error: el nombre solo puede contener letras A-Z o a-z.");
                }
            }


            System.out.println("Ingrese la empresa del proveedor: ");
            p.setEmpresa(scan.nextLine());


            System.out.println("Ingrese la dirección del proveedor: ");
            p.setDireccion(scan.nextLine());


            String telefono;
            while (true) {
                System.out.println("Ingrese el teléfono del proveedor (solo números y guiones): ");
                telefono = scan.nextLine();

                if (telefono.matches("[0-9-]+")) {
                    p.setTelefono(telefono);
                    break;
                } else {
                    System.err.println("Error: solo se permiten números y guiones. Ej: 123-456-789");
                }
            }


            Marca[] marcas = Marca.values();

            System.out.println("Seleccione la marca que provee:");

            for (int i = 0; i < marcas.length; i++) {
                System.out.println((i + 1) + ". " + marcas[i]);
            }

            Marca marcaSeleccionada = null;

            while (marcaSeleccionada == null) {
                try {
                    System.out.print("Ingrese número de marca: ");
                    int op = scan.nextInt();
                    scan.nextLine();

                    if (op >= 1 && op <= marcas.length) {
                        marcaSeleccionada = marcas[op - 1];
                        p.setMarcaQueProvee(marcaSeleccionada);
                    } else {
                        System.err.println("Número inválido. Debe estar entre 1 y " + marcas.length + ".");
                    }

                } catch (InputMismatchException e) {
                    System.err.println("Error: debe ingresar un número entero.");
                    scan.nextLine();
                }
            }


            System.out.println("¿El proveedor está activo? (true/false): ");
            while (true) {
                String boolInput = scan.nextLine().trim().toLowerCase();

                if (boolInput.equals("true") || boolInput.equals("false")) {
                    p.setActivo(Boolean.parseBoolean(boolInput));
                    break;
                } else {
                    System.err.println("Error: debe ingresar 'true' o 'false'.");
                }
            }

            proveedores.add(p);

            System.out.println("Proveedor modificado correctamente.");

        } else {
            System.err.println("No se ha encontrado ningún proveedor con ese nombre.");
        }
    }

    public String searchProveedor(String nombre) {
        for (Proveedor p : proveedores) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p.toString();
            }
        }
        return "No se ha encontrado un proveedor con ese nombre";
    }


    public void showProveedores()
    {
        for(Proveedor p : proveedores)            //Recorro la lista de proveedores y muestro los proveedores
        {
            System.out.println("-------------------");
            System.out.println(p.toString());
        }
    }

    public void listaDeserializadaToProveedores (List<Proveedor> proveedoresB){

        for (Proveedor p: proveedoresB)
        {
            proveedores.add(p); //lo agregamos con el .add(p)
        }
    }

    public void showProveedoresActivos (){

       for (Proveedor p: proveedores)
       {
           if(p.isActivo())
           {
               System.out.println(p.toString());
           }
       }
    }

    public void showProveedoresInactivos (){

        for (Proveedor p: proveedores)
        {
            if(!p.isActivo())
            {
                System.out.println(p.toString());
            }
        }
    }

    public void crearProveedor() {
        Scanner scan = new Scanner(System.in);
        Proveedor p = new Proveedor();

        // --- NOMBRE ---
        String nombre;
        while (true) {
            System.out.println("Ingrese el nombre del proveedor: ");
            nombre = scan.nextLine();
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) break;
            System.out.println("Solo se permiten letras y espacios.");
        }
        p.setNombre(nombre);

        // --- EMPRESA ---
        String empresa;
        while (true) {
            System.out.println("Ingrese la empresa del proveedor: ");
            empresa = scan.nextLine();
            if (empresa.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ .,-]+")) break;
            System.out.println("Nombre de empresa inválido.");
        }
        p.setEmpresa(empresa);

        // --- DIRECCIÓN ---
        String direccion;
        while (true) {
            System.out.println("Ingrese la dirección del proveedor: ");
            direccion = scan.nextLine();
            if (!direccion.isEmpty()) break;
            System.out.println("La dirección no puede estar vacía.");
        }
        p.setDireccion(direccion);

        // --- TELÉFONO ---
        String telefono;
        while (true) {
            System.out.println("Ingrese el teléfono del proveedor: ");
            telefono = scan.nextLine();
            if (telefono.matches("[0-9()+ -]+")) break;
            System.out.println("El teléfono solo puede contener números y símbolos (+ - () ).");
        }
        p.setTelefono(telefono);

        // --- EMAIL ---
        String email;
        while (true) {
            System.out.println("Ingrese el email del proveedor: ");
            email = scan.nextLine();
            if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) break;
            System.out.println("Email inválido.");
        }
        p.setEmail(email);

        // --- MARCA (ENUM) ---
        Marca marca = null;

        while (true) {
            System.out.println("Seleccione la marca que provee:");

            Marca[] marcas = Marca.values();

            // Mostrar todas enumeradas
            for (int i = 0; i < marcas.length; i++) {
                System.out.println((i + 1) + ". " + marcas[i]);
            }

            System.out.println("Ingrese el número correspondiente: ");
            String input = scan.nextLine();

            // Validar que sea número
            if (!input.matches("[0-9]+")) {
                System.out.println("Debe ingresar solo números.");
                continue;
            }

            int opcion = Integer.parseInt(input);

            // Validar rango
            if (opcion < 1 || opcion > marcas.length) {
                System.out.println(" Número fuera de rango.");
                continue;
            }

            marca = marcas[opcion - 1];
            break;
        }
        // --- BOOLEAN ACTIVO ---
        Boolean activo = null;
        while (activo == null) {
            System.out.println("¿El proveedor está activo? (true/false): ");
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("true")) activo = true;
            else if (input.equalsIgnoreCase("false")) activo = false;
            else System.out.println("Debe ingresar true o false.");
        }
        p.setActivo(activo);

        // --- AGREGAR A LISTA ---
        proveedores.add(p);

        System.out.println("✔ Proveedor creado correctamente.");
    }




}
