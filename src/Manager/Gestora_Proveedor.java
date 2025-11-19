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

        if (p == null) {
            System.err.println("No se ha encontrado ningún proveedor con ese nombre.");
            return;
        }

        System.out.println("Qué desea modificar?");
        System.out.println("1. Modificar todos los atributos");
        System.out.println("2. Nombre");
        System.out.println("3. Empresa");
        System.out.println("4. Dirección");
        System.out.println("5. Teléfono");
        System.out.println("6. Marca que provee");
        System.out.println("7. Activo");

        int opcion = 0;
        while (true) {
            try {
                opcion = Integer.parseInt(scan.nextLine());
                if (opcion >= 1 && opcion <= 7) break;
                else System.out.println("Ingrese un número entre 1 y 7.");
            } catch (NumberFormatException ex) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }

        Marca[] marcas = Marca.values();

        switch (opcion) {
            case 1:
                while (true) {
                    System.out.println("Ingrese el nombre del proveedor: ");
                    String n = scan.nextLine();
                    if (n.matches("[A-Za-z ]+")) {
                        p.setNombre(n);
                        break;
                    } else System.out.println("El nombre solo puede contener letras y espacios.");
                }

                System.out.println("Ingrese la empresa del proveedor: ");
                p.setEmpresa(scan.nextLine());

                System.out.println("Ingrese la dirección del proveedor: ");
                p.setDireccion(scan.nextLine());

                while (true) {
                    System.out.println("Ingrese el teléfono del proveedor (solo números y guiones): ");
                    String t = scan.nextLine();
                    if (t.matches("[0-9-]+")) {
                        p.setTelefono(t);
                        break;
                    } else System.out.println("Solo se permiten números y guiones.");
                }

                Marca marcaSeleccionada = null;
                while (marcaSeleccionada == null) {
                    System.out.println("Seleccione la marca que provee:");
                    for (int i = 0; i < marcas.length; i++) {
                        System.out.println((i + 1) + ". " + marcas[i]);
                    }
                    try {
                        int op = Integer.parseInt(scan.nextLine());
                        if (op >= 1 && op <= marcas.length) {
                            marcaSeleccionada = marcas[op - 1];
                            p.setMarcaQueProvee(marcaSeleccionada);
                        } else System.out.println("Número inválido. Debe estar entre 1 y " + marcas.length + ".");
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un número entero válido.");
                    }
                }

                while (true) {
                    System.out.println("¿El proveedor está activo? (true/false): ");
                    String input = scan.nextLine().trim().toLowerCase();
                    if (input.equals("true") || input.equals("false")) {
                        p.setActivo(Boolean.parseBoolean(input));
                        break;
                    } else System.out.println("Debe ingresar 'true' o 'false'.");
                }

                proveedores.add(p);
                break;

            case 2:
                while (true) {
                    System.out.println("Ingrese el nombre del proveedor: ");
                    String n = scan.nextLine();
                    if (n.matches("[A-Za-z ]+")) {
                        p.setNombre(n);
                        break;
                    } else System.out.println("El nombre solo puede contener letras y espacios.");
                }
                proveedores.add(p);
                break;

            case 3:
                System.out.println("Ingrese la empresa del proveedor: ");
                p.setEmpresa(scan.nextLine());
                proveedores.add(p);
                break;

            case 4:
                System.out.println("Ingrese la dirección del proveedor: ");
                p.setDireccion(scan.nextLine());
                proveedores.add(p);
                break;

            case 5:
                while (true) {
                    System.out.println("Ingrese el teléfono del proveedor (solo números y guiones): ");
                    String t = scan.nextLine();
                    if (t.matches("[0-9-]+")) {
                        p.setTelefono(t);
                        break;
                    } else System.out.println("Solo se permiten números y guiones.");
                }
                proveedores.add(p);
                break;

            case 6:
                Marca marca = null;
                while (marca == null) {
                    System.out.println("Seleccione la marca que provee:");
                    for (int i = 0; i < marcas.length; i++) {
                        System.out.println((i + 1) + ". " + marcas[i]);
                    }
                    try {
                        int op = Integer.parseInt(scan.nextLine());
                        if (op >= 1 && op <= marcas.length) {
                            marca = marcas[op - 1];
                            p.setMarcaQueProvee(marca);
                            break;
                        } else System.out.println("Número inválido. Debe estar entre 1 y " + marcas.length + ".");
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un número entero válido.");
                    }
                }
                proveedores.add(p);
                break;

            case 7:
                while (true) {
                    System.out.println("¿El proveedor está activo? (true/false): ");
                    String input = scan.nextLine().trim().toLowerCase();
                    if (input.equals("true") || input.equals("false")) {
                        p.setActivo(Boolean.parseBoolean(input));
                        break;
                    } else System.out.println("Debe ingresar 'true' o 'false'.");
                }
                proveedores.add(p);
                break;
        }

        System.out.println("Proveedor modificado correctamente.");
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
               System.out.println("--------------");
               System.out.println(p.toString());
           }
       }
    }

    public void showProveedoresInactivos (){

        for (Proveedor p: proveedores)
        {
            if(!p.isActivo())
            {
                System.out.println("--------------");
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

            for (int i = 0; i < marcas.length; i++) {
                System.out.println((i + 1) + ". " + marcas[i]);
            }

            System.out.println("Ingrese el número correspondiente: ");
            String input = scan.nextLine();

            if (!input.matches("[0-9]+")) {
                System.out.println("Debe ingresar solo números.");
                continue;
            }

            int opcion = Integer.parseInt(input);

            if (opcion < 1 || opcion > marcas.length) {
                System.out.println("Número fuera de rango.");
                continue;
            }

            marca = marcas[opcion - 1];
            break;
        }

        p.setMarcaQueProvee(marca);

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
