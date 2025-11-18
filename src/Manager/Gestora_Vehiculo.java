package Manager;

import Classes.*;
import Enums.Marca;

import java.util.*;

public class Gestora_Vehiculo {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();                //Hacerlo Hashset ya que no importa el orden y no se repiten

    public Gestora_Vehiculo() {
        this.vehiculos = vehiculos;
    }

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
        Vehiculo viejo = null;

        for (Vehiculo v : vehiculos) {
            if (v.getModelo().equalsIgnoreCase(modeloViejo)) {
                viejo = v;
                break;
            }
        }

        if (viejo == null) {
            System.err.println("No existe ningún vehículo con ese modelo.");
            return;
        }

        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Auto");
        System.out.println("2. Camioneta");
        System.out.println("3. Camión");
        System.out.println("4. Moto");

        int opcionTipo = 0;
        while (true) {
            try {
                System.out.print("Ingrese opción: ");
                opcionTipo = scan.nextInt();
                scan.nextLine();
                if (opcionTipo >= 1 && opcionTipo <= 4) break;
                System.err.println("Opción inválida, debe ser entre 1 y 4.");
            } catch (InputMismatchException e) {
                System.err.println("Error: debe ingresar un número entero.");
                scan.nextLine();
            }
        }

        Vehiculo nuevo = switch (opcionTipo) {
            case 1 -> new Auto();
            case 2 -> new Camioneta();
            case 3 -> new Camión();
            case 4 -> new Moto();
            default -> null;
        };

        vehiculos.remove(viejo);

        Marca[] marcas = Marca.values();

        System.out.println("Seleccione la marca del vehículo:");
        for (int i = 0; i < marcas.length; i++) {
            System.out.println((i + 1) + ". " + marcas[i]);
        }

        Marca marcaSeleccionada = null;
        while (marcaSeleccionada == null) {
            try {
                System.out.print("Ingrese número de marca (1-15): ");
                int op = scan.nextInt();
                scan.nextLine();
                if (op >= 1 && op <= marcas.length) {
                    marcaSeleccionada = marcas[op - 1];
                } else {
                    System.err.println("Número inválido.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: ingrese un entero.");
                scan.nextLine();
            }
        }

        nuevo.setMarca(marcaSeleccionada);

        System.out.print("Ingrese modelo: ");
        nuevo.setModelo(scan.nextLine());

        while (true) {
            try {
                System.out.print("Ingrese año: ");
                int anio = scan.nextInt();
                scan.nextLine();
                if (anio > 0) {
                    nuevo.setAnio(anio);
                    break;
                }
                System.err.println("El año debe ser mayor a 0.");
            } catch (InputMismatchException e) {
                System.err.println("Error: debe ingresar un número entero.");
                scan.nextLine();
            }
        }

        System.out.print("Ingrese color: ");
        nuevo.setColor(scan.nextLine());

        while (true) {
            try {
                System.out.print("Ingrese precio: ");
                double precio = scan.nextDouble();
                scan.nextLine();
                if (precio > 0) {
                    nuevo.setPrecio(precio);
                    break;
                }
                System.err.println("El precio debe ser mayor a 0.");
            } catch (InputMismatchException e) {
                System.err.println("Error: debe ingresar un número decimal.");
                scan.nextLine();
            }
        }

        while (true) {
            System.out.print("¿Está en stock? (true/false): ");
            String bool = scan.nextLine().toLowerCase();
            if (bool.equals("true") || bool.equals("false")) {
                nuevo.setEnStock(Boolean.parseBoolean(bool));
                break;
            }
            System.err.println("Error: debe ingresar true o false.");
        }

        if (nuevo instanceof Auto auto) {

            while (true) {
                try {
                    System.out.print("Ingrese cilindrada: ");
                    int cil = scan.nextInt();
                    scan.nextLine();
                    if (cil > 0) {
                        auto.setCilindrada(cil);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Ingrese cantidad de puertas: ");
                    int puertas = scan.nextInt();
                    scan.nextLine();
                    if (puertas > 0) {
                        auto.setPuertas(puertas);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }

            System.out.print("Ingrese combustible: ");
            auto.setCombustible(scan.nextLine());
        }

        else if (nuevo instanceof Camioneta cam) {

            while (true) {
                try {
                    System.out.print("Ingrese cilindrada: ");
                    int cil = scan.nextInt();
                    scan.nextLine();
                    if (cil > 0) {
                        cam.setCilindrada(cil);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Ingrese cantidad de puertas: ");
                    int puertas = scan.nextInt();
                    scan.nextLine();
                    if (puertas > 0) {
                        cam.setPuertas(puertas);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }

            System.out.print("Ingrese combustible: ");
            cam.setCombustible(scan.nextLine());

            while (true) {
                try {
                    System.out.print("Ingrese ancho de la caja: ");
                    double ancho = scan.nextDouble();
                    if (ancho > 0) {
                        cam.setAnchoCaja(ancho);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un número decimal.");
                    scan.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Ingrese largo de la caja: ");
                    double largo = scan.nextDouble();
                    scan.nextLine();
                    if (largo > 0) {
                        cam.setLargoCaja(largo);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un número decimal.");
                    scan.nextLine();
                }
            }
        }

        else if (nuevo instanceof Camión cami) {

            while (true) {
                try {
                    System.out.print("Ingrese cilindrada: ");
                    int cil = scan.nextInt();
                    scan.nextLine();
                    if (cil > 0) {
                        cami.setCilindrada(cil);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Ingrese cantidad de puertas: ");
                    int puertas = scan.nextInt();
                    scan.nextLine();
                    if (puertas > 0) {
                        cami.setPuertas(puertas);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }

            System.out.print("Ingrese combustible: ");
            cami.setCombustible(scan.nextLine());

            while (true) {
                try {
                    System.out.print("Ingrese largo del chasis: ");
                    double largo = scan.nextDouble();
                    if (largo > 0) {
                        cami.setLargoChasis(largo);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un double.");
                    scan.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Ingrese ancho del chasis: ");
                    double ancho = scan.nextDouble();
                    scan.nextLine();
                    if (ancho > 0) {
                        cami.setAnchoChasis(ancho);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un double.");
                    scan.nextLine();
                }
            }
        }

        else if (nuevo instanceof Moto moto) {

            while (true) {
                try {
                    System.out.print("Ingrese cilindrada: ");
                    int cil = scan.nextInt();
                    scan.nextLine();
                    if (cil > 0) {
                        moto.setCilindrada(cil);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Ingrese capacidad de pasajeros: ");
                    int cap = scan.nextInt();
                    scan.nextLine();
                    if (cap > 0) {
                        moto.setCapacidadPasajeros(cap);
                        break;
                    }
                    System.err.println("Debe ser mayor a 0.");
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar un entero.");
                    scan.nextLine();
                }
            }
        }

        vehiculos.add(nuevo);
        System.out.println("Vehículo modificado correctamente.");
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

            if (v.getModelo().equalsIgnoreCase(modelo)) {

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


            }
        }

        System.out.println("No se encontró ningún vehículo con modelo: " + modelo);
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

    public void buyVehicle (Cliente c, Vehiculo v, Empleado e, Gestora_Factura gestoraFactura)
    {
        if (v != null && e != null)
        {
            if (vehiculos.contains(v) && v.isEnStock())
            {
                removeVehiculo(v);

                Factura factura = new Factura(v.getPrecio(), c, e, v);

                gestoraFactura.addFactura(factura);
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

