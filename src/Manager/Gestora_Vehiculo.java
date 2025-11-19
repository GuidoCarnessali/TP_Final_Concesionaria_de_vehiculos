package Manager;

import Classes.*;
import Enums.Marca;

import java.util.*;

public class Gestora_Vehiculo {

    //atributos
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();                //Hacerlo Hashset ya que no importa el orden y no se repiten

    //contructor
    public Gestora_Vehiculo() {
        this.vehiculos = vehiculos;
    }

    //getter y setter
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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

    public boolean removeVehiculo(String modelo, int anio, String color)
    {
        Vehiculo encontrado = null;

        for (Vehiculo v : vehiculos) {
            if (v.getModelo().equalsIgnoreCase(modelo) &&
                    v.getAnio() == anio &&
                    v.getColor().equalsIgnoreCase(color))
            {
                encontrado = v;
                break;
            }
        }

        if (encontrado == null) {
            return false;
        }

        vehiculos.remove(encontrado);
        encontrado.setEnStock(false);
        vehiculos.add(encontrado);

        return true;
    }

    public boolean removeVehiculo(Vehiculo v) {
        if(v != null && vehiculos.contains(v))
        {  vehiculos.remove(v);
            v.setEnStock(false);
            vehiculos.add(v);
            return true;
        } return false;
    }



    public void modifyVehiculo(String modeloViejo) {
        Scanner scan = new Scanner(System.in);
        Vehiculo v = null;

        for (Vehiculo x : vehiculos) {
            if (x.getModelo().equalsIgnoreCase(modeloViejo)) {
                v = x;
                break;
            }
        }

        if (v == null) {
            System.err.println("No existe un vehículo con ese modelo.");
            return;
        }

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Modificar todos los campos");
            System.out.println("2. Modificar marca");
            System.out.println("3. Modificar modelo");
            System.out.println("4. Modificar año");
            System.out.println("5. Modificar color");
            System.out.println("6. Modificar precio");
            System.out.println("7. Modificar stock");
            System.out.println("8. Modificar campos específicos del tipo");
            System.out.println("9. Salir");

            int op = 0;
            while (true) {

                try {
                    op = scan.nextInt();
                    scan.nextLine();
                    if (op >= 1 && op <= 9) break;
                    System.err.println("Opción inválida.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un número entero.");
                    scan.nextLine();
                }
            }

            if (op == 9) break;

            switch (op) {

                case 1 -> {
                    Marca[] marcas = Marca.values();
                    System.out.println("Seleccione la marca:");
                    for (int i = 0; i < marcas.length; i++) {
                        System.out.println((i + 1) + ". " + marcas[i]);
                    }
                    Marca seleccion = null;
                    while (seleccion == null) {
                        try {
                            int m = scan.nextInt();
                            scan.nextLine();
                            if (m >= 1 && m <= marcas.length) {
                                seleccion = marcas[m - 1];
                            } else {
                                System.err.println("Número inválido.");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Ingrese un número entero.");
                            scan.nextLine();
                        }
                    }
                    v.setMarca(seleccion);

                    System.out.print("Ingrese modelo: ");
                    v.setModelo(scan.nextLine());

                    while (true) {
                        try {
                            System.out.print("Ingrese año: ");
                            int anio = scan.nextInt();
                            scan.nextLine();
                            if (anio > 0) {
                                v.setAnio(anio);
                                break;
                            }
                            System.err.println("Debe ser mayor a 0.");
                        } catch (InputMismatchException e) {
                            System.err.println("Ingrese un entero.");
                            scan.nextLine();
                        }
                    }

                    System.out.print("Ingrese color: ");
                    v.setColor(scan.nextLine());

                    while (true) {
                        try {
                            System.out.print("Ingrese precio: ");
                            double precio = scan.nextDouble();
                            scan.nextLine();
                            if (precio > 0) {
                                v.setPrecio(precio);
                                break;
                            }
                            System.err.println("Debe ser mayor a 0.");
                        } catch (InputMismatchException e) {
                            System.err.println("Debe ingresar un número decimal.");
                            scan.nextLine();
                        }
                    }

                    while (true) {
                        System.out.print("¿Está en stock? (true/false): ");
                        String s = scan.nextLine().toLowerCase();
                        if (s.equals("true") || s.equals("false")) {
                            v.setEnStock(Boolean.parseBoolean(s));
                            break;
                        }
                        System.err.println("Debe ingresar true o false.");
                    }

                    modificarEspecificos(v, scan);
                    System.out.println("Modificación completa.");
                }

                case 2 -> {
                    Marca[] marcas = Marca.values();
                    System.out.println("Seleccione la marca:");
                    for (int i = 0; i < marcas.length; i++) {
                        System.out.println((i + 1) + ". " + marcas[i]);
                    }
                    Marca seleccion = null;
                    while (seleccion == null) {
                        try {
                            int m = scan.nextInt();
                            scan.nextLine();
                            if (m >= 1 && m <= marcas.length) {
                                seleccion = marcas[m - 1];
                            } else {
                                System.err.println("Número inválido.");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Ingrese un entero.");
                            scan.nextLine();
                        }
                    }
                    v.setMarca(seleccion);
                }

                case 3 -> {
                    System.out.print("Ingrese modelo nuevo: ");
                    v.setModelo(scan.nextLine());
                }

                case 4 -> {
                    while (true) {
                        try {
                            System.out.print("Ingrese año nuevo: ");
                            int anio = scan.nextInt();
                            scan.nextLine();
                            if (anio > 0) {
                                v.setAnio(anio);
                                break;
                            }
                            System.err.println("Debe ser mayor a 0.");
                        } catch (InputMismatchException e) {
                            System.err.println("Ingrese un entero.");
                            scan.nextLine();
                        }
                    }
                }

                case 5 -> {
                    System.out.print("Ingrese color nuevo: ");
                    v.setColor(scan.nextLine());
                }

                case 6 -> {
                    while (true) {
                        try {
                            System.out.print("Ingrese precio nuevo: ");
                            double precio = scan.nextDouble();
                            scan.nextLine();
                            if (precio > 0) {
                                v.setPrecio(precio);
                                break;
                            }
                            System.err.println("Debe ser mayor a 0.");
                        } catch (InputMismatchException e) {
                            System.err.println("Ingrese un número decimal.");
                            scan.nextLine();
                        }
                    }
                }

                case 7 -> {
                    while (true) {
                        System.out.print("¿Está en stock? (true/false): ");
                        String s = scan.nextLine().toLowerCase();
                        if (s.equals("true") || s.equals("false")) {
                            v.setEnStock(Boolean.parseBoolean(s));
                            break;
                        }
                        System.err.println("Debe ingresar true o false.");
                    }
                }

                case 8 -> {
                    modificarEspecificos(v, scan);
                }
            }
        }

        System.out.println("Modificación finalizada.");
    }

    private void modificarEspecificos(Vehiculo v, Scanner scan) {

        if (v instanceof Auto a) {
            while (true) {
                try {
                    System.out.print("Cilindrada: ");
                    int c = scan.nextInt();
                    scan.nextLine();
                    if (c > 0) {
                        a.setCilindrada(c);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Puertas: ");
                    int p = scan.nextInt();
                    scan.nextLine();
                    if (p > 0) {
                        a.setPuertas(p);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            System.out.print("Combustible: ");
            a.setCombustible(scan.nextLine());
        }

        else if (v instanceof Camioneta c) {
            while (true) {
                try {
                    System.out.print("Cilindrada: ");
                    int ci = scan.nextInt();
                    scan.nextLine();
                    if (ci > 0) {
                        c.setCilindrada(ci);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Puertas: ");
                    int p = scan.nextInt();
                    scan.nextLine();
                    if (p > 0) {
                        c.setPuertas(p);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            System.out.print("Combustible: ");
            c.setCombustible(scan.nextLine());

            while (true) {
                try {
                    System.out.print("Ancho caja: ");
                    double an = scan.nextDouble();
                    if (an > 0) {
                        c.setAnchoCaja(an);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Largo caja: ");
                    double la = scan.nextDouble();
                    scan.nextLine();
                    if (la > 0) {
                        c.setLargoCaja(la);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
        }

        else if (v instanceof Camión c) {
            while (true) {
                try {
                    System.out.print("Cilindrada: ");
                    int ci = scan.nextInt();
                    scan.nextLine();
                    if (ci > 0) {
                        c.setCilindrada(ci);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Puertas: ");
                    int p = scan.nextInt();
                    scan.nextLine();
                    if (p > 0) {
                        c.setPuertas(p);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            System.out.print("Combustible: ");
            c.setCombustible(scan.nextLine());

            while (true) {
                try {
                    System.out.print("Largo chasis: ");
                    double la = scan.nextDouble();
                    if (la > 0) {
                        c.setLargoChasis(la);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Ancho chasis: ");
                    double an = scan.nextDouble();
                    scan.nextLine();
                    if (an > 0) {
                        c.setAnchoChasis(an);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
        }

        else if (v instanceof Moto m) {
            while (true) {
                try {
                    System.out.print("Cilindrada: ");
                    int ci = scan.nextInt();
                    scan.nextLine();
                    if (ci > 0) {
                        m.setCilindrada(ci);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Capacidad pasajeros: ");
                    int ca = scan.nextInt();
                    scan.nextLine();
                    if (ca > 0) {
                        m.setCapacidadPasajeros(ca);
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
        }
    }


    public void showMotos(){
        for (Vehiculo v : vehiculos){
            if (v instanceof Moto) {
                System.out.println("--------------------");
                System.out.println(v.toString());
            }
        }
    }

    public void showAutos(){
        for (Vehiculo v : vehiculos){
            if (v instanceof Auto) {
                System.out.println("--------------------");
                System.out.println(v.toString());
            }
        }
    }

    public void showCamion(){
        for (Vehiculo v : vehiculos){
            if (v instanceof Camión) {
                System.out.println("--------------------");
                System.out.println(v.toString());

            }
        }
    }

    public void showCamionetas(){
        for (Vehiculo v : vehiculos){
            if (v instanceof Camioneta) {
                System.out.println("--------------------");
                System.out.println(v.toString());
            }
        }
    }




    public void searchVehiculo(String modelo)
    {
        for (Vehiculo v : vehiculos) {

            if (v.getModelo().equalsIgnoreCase(modelo))
            {

                System.out.println("=== Vehículo encontrado ===");
                System.out.println("Modelo: " + v.getModelo());
                System.out.println("Marca: " + v.getMarca());
                System.out.println("Año: " + v.getAnio());
                System.out.println("Precio: " + v.getPrecio());


                if (v instanceof Auto) {
                    Auto a = (Auto) v;
                    System.out.println("Tipo: Auto");
                    System.out.println("Cilindrada: " + a.getCilindrada());
                    System.out.println("Puertas: " + a.getPuertas());
                    System.out.println("Combustible: " + a.getCombustible());
                }


                else if (v instanceof Moto) {
                    Moto m = (Moto) v;
                    System.out.println("Tipo: Moto");
                    System.out.println("Cilindrada: " + m.getCilindrada());
                    System.out.println("Capacidad de pasajeros: " + m.getCapacidadPasajeros());
                }


                else if (v instanceof Camioneta) {
                    Camioneta c = (Camioneta) v;
                    System.out.println("Tipo: Camioneta");
                    System.out.println("Cilindrada: " + c.getCilindrada());
                    System.out.println("Puertas: " + c.getPuertas());
                    System.out.println("Combustible: " + c.getCombustible());
                    System.out.println("Ancho caja: " + c.getAnchoCaja());
                    System.out.println("Largo caja: " + c.getLargoCaja());
                }

                // ---------- CAMIÓN ----------
                else if (v instanceof Camión) {
                    Camión cam = (Camión) v;
                    System.out.println("Tipo: Camión");
                    System.out.println("Cilindrada: " + cam.getCilindrada());
                    System.out.println("Puertas: " + cam.getPuertas());
                    System.out.println("Combustible: " + cam.getCombustible());
                    System.out.println("Largo chasis: " + cam.getLargoChasis());
                    System.out.println("Ancho chasis: " + cam.getAnchoChasis());
                }

                break;

            }
        }

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

        for (Vehiculo v : vehiculos){
            if(v instanceof Camión){
                System.out.println("--------------------");
                System.out.println(v.toString());
            }
        }

        for (Vehiculo v : vehiculos){
            if(v instanceof Camioneta){
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

        public void listaDeserializadaToVehiculos (ArrayList<Vehiculo> vehiculosB){

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
                    System.out.println("--------------");
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
                System.out.println("--------------");
                System.out.println(v.toString());
            }
        }
    }

    public void buyVehicle (Cliente c, Vehiculo v, Empleado e, Gestora_Factura gestoraFactura, Gestora_Cliente gestoraCliente)
    {
        if (v != null && e != null)
        {
            if (vehiculos.contains(v) && v.isEnStock())
            {
                removeVehiculo(v);

                Factura factura = new Factura(v.getPrecio(), c, e, v);

                gestoraFactura.addFactura(factura);
                gestoraCliente.addCliente(c);
            }else {
                System.out.println("El vehiculo no esta disponible");
            }

        }
    }

    public Vehiculo filtrarVehiculo (String modelo, int anio, String color){

        for (Vehiculo v : vehiculos)
        {
            if(v.getModelo().equalsIgnoreCase(modelo) && v.getAnio() == anio && v.getColor().equalsIgnoreCase(color))
            {
                return v;
            }
        }

        return null;
    }


    public void createVehiculo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Seleccione el tipo de vehículo a crear:");
        System.out.println("1. Auto");
        System.out.println("2. Camioneta");
        System.out.println("3. Camión");
        System.out.println("4. Moto");

        int opcionTipo = 0;
        while (true) {
            try {
                opcionTipo = scan.nextInt();
                if (opcionTipo >= 1 && opcionTipo <= 4) break;
                System.out.println("Opción inválida. Seleccione entre 1 y 4.");
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese solo números enteros.");
                scan.nextLine();
            }
        }
        scan.nextLine();

        Vehiculo nuevo = switch (opcionTipo) {
            case 1 -> new Auto();
            case 2 -> new Camioneta();
            case 3 -> new Camión();
            case 4 -> new Moto();
            default -> null;
        };

        Marca[] marcas = Marca.values();
        System.out.println("Seleccione la marca del vehículo:");

        for (int i = 0; i < marcas.length; i++) {
            System.out.println((i + 1) + ". " + marcas[i]);
        }

        Marca marcaSeleccionada = null;

        while (marcaSeleccionada == null) {
            System.out.print("Ingrese número de marca: ");

            try {
                int op = scan.nextInt();
                if (op >= 1 && op <= marcas.length) {
                    marcaSeleccionada = marcas[op - 1];
                } else {
                    System.out.println("Número inválido. Debe estar entre 1 y " + marcas.length + ".");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese solo números enteros.");
            }
            scan.nextLine();
        }

        nuevo.setMarca(marcaSeleccionada);

        System.out.println("Ingrese el modelo: ");
        nuevo.setModelo(scan.nextLine());

        int anio = 0;
        while (true) {
            try {
                System.out.println("Ingrese el año del vehículo: ");
                anio = scan.nextInt();
                if (anio > 0) break;
                System.out.println("El año debe ser mayor a 0.");
            } catch (InputMismatchException e) {
                System.out.println("Error: solo puede ingresar números enteros.");
            }
            scan.nextLine();
        }
        nuevo.setAnio(anio);

        System.out.println("Ingrese el color: ");
        scan.nextLine();
        nuevo.setColor(scan.nextLine());

        double precio = 0;
        while (true) {
            try {
                System.out.println("Ingrese el precio del vehículo: ");
                precio = scan.nextDouble();
                if (precio > 0) break;
                System.out.println("El precio debe ser mayor a 0.");
            } catch (InputMismatchException e) {
                System.out.println("Error: solo puede ingresar números válidos.");
            }
            scan.nextLine();
        }
        nuevo.setPrecio(precio);

        nuevo.setEnStock(true);

        if (nuevo instanceof Auto auto) {
            int cil = 0;
            while (true) {
                try {
                    System.out.println("Ingrese cilindrada: ");
                    cil = scan.nextInt();
                    if (cil > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            auto.setCilindrada(cil);

            int puertas = 0;
            while (true) {
                try {
                    System.out.println("Ingrese cantidad de puertas: ");
                    puertas = scan.nextInt();
                    if (puertas > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            auto.setPuertas(puertas);

            scan.nextLine();
            System.out.println("Ingrese combustible: ");
            auto.setCombustible(scan.nextLine());
        }

        else if (nuevo instanceof Camioneta cam) {
            int cil = 0;
            while (true) {
                try {
                    System.out.println("Ingrese cilindrada: ");
                    cil = scan.nextInt();
                    if (cil > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            cam.setCilindrada(cil);

            int puertas = 0;
            while (true) {
                try {
                    System.out.println("Ingrese cantidad de puertas: ");
                    puertas = scan.nextInt();
                    if (puertas > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            cam.setPuertas(puertas);

            scan.nextLine();
            System.out.println("Ingrese combustible: ");
            cam.setCombustible(scan.nextLine());

            double ancho = 0;
            while (true) {
                try {
                    System.out.println("Ingrese ancho de la caja: ");
                    ancho = scan.nextDouble();
                    if (ancho > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números válidos.");
                }
                scan.nextLine();
            }
            cam.setAnchoCaja(ancho);

            double largo = 0;
            while (true) {
                try {
                    System.out.println("Ingrese largo de la caja: ");
                    largo = scan.nextDouble();
                    if (largo > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números válidos.");
                }
                scan.nextLine();
            }
            cam.setLargoCaja(largo);
        }

        else if (nuevo instanceof Camión cami) {
            int cil = 0;
            while (true) {
                try {
                    System.out.println("Ingrese cilindrada: ");
                    cil = scan.nextInt();
                    if (cil > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            cami.setCilindrada(cil);

            int puertas = 0;
            while (true) {
                try {
                    System.out.println("Ingrese cantidad de puertas: ");
                    puertas = scan.nextInt();
                    if (puertas > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            cami.setPuertas(puertas);

            scan.nextLine();
            System.out.println("Ingrese combustible: ");
            cami.setCombustible(scan.nextLine());

            double largo = 0;
            while (true) {
                try {
                    System.out.println("Ingrese largo del chasis: ");
                    largo = scan.nextDouble();
                    if (largo > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números válidos.");
                }
                scan.nextLine();
            }
            cami.setLargoChasis(largo);

            double ancho = 0;
            while (true) {
                try {
                    System.out.println("Ingrese ancho del chasis: ");
                    ancho = scan.nextDouble();
                    if (ancho > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números válidos.");
                }
                scan.nextLine();
            }
            cami.setAnchoChasis(ancho);
        }

        else if (nuevo instanceof Moto moto) {
            int cil = 0;
            while (true) {
                try {
                    System.out.println("Ingrese cilindrada: ");
                    cil = scan.nextInt();
                    if (cil > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            moto.setCilindrada(cil);

            int cap = 0;
            while (true) {
                try {
                    System.out.println("Ingrese capacidad de pasajeros: ");
                    cap = scan.nextInt();
                    if (cap > 0) break;
                    System.out.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: solo números enteros.");
                }
                scan.nextLine();
            }
            moto.setCapacidadPasajeros(cap);
        }

        vehiculos.add(nuevo);

        System.out.println("Vehículo creado exitosamente.");
    }



}

