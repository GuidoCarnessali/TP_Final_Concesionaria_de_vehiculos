package Manager;

import Classes.*;

import java.time.LocalDateTime;
import java.util.*;

public class Gestora_Factura {

    //Atributos
    private Map<Integer, Factura> facturas;               //Hacerlo TreeMap (numeroFactura, factura) ya que importa el orden (Ordenación) y no se repiten

    //Constructor
    public Gestora_Factura() {
        this.facturas = new TreeMap<>();
    }

    //Getters
    public Map<Integer, Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Map<Integer, Factura> facturas) {
        this.facturas = facturas;
    }

    //ABMCL
    //Alta, Baja, Modificación, Consulta y Listado
    //Factura


    public void crearFactura (Cliente c, Vehiculo v, Empleado e, Gestora_Factura gestoraFactura,Gestora_Vehiculo gestoraVehiculo, Gestora_Cliente gestoraCliente)
    {
        if (v != null && e != null)
        {
            if (gestoraVehiculo.getVehiculos().contains(v) && v.isEnStock())
            {
                gestoraVehiculo.removeVehiculo(v);

                Factura factura = new Factura(v.getPrecio(), c, e, v);

                gestoraFactura.addFactura(factura);
                gestoraCliente.addCliente(c);
            }else {
                System.out.println("El vehiculo no esta disponible");
            }

        }
    }

    public Factura modifyFactura(int numeroFactura, Gestora_Cliente gestoraCliente, Gestora_Empleado gestoraEmpleado, Gestora_Vehiculo gestoraVehiculo) {

        Factura f = null;
        for (Factura fac : facturas.values()) {
            if (fac.getNumeroFactura() == numeroFactura) {
                f = fac;
                break;
            }
        }

        if (f == null) {
            System.err.println("No existe una factura con ese número.");
            return null;
        }

        Scanner scan = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Seleccione qué desea modificar:");
        System.out.println("1. Cliente");
        System.out.println("2. Empleado");
        System.out.println("3. Vehículo");
        System.out.println("4. Monto total");
        System.out.println("5. Cancelar");

        while (true) {
            try {
                System.out.print("Opción: ");
                opcion = scan.nextInt();
                scan.nextLine();
                if (opcion >= 1 && opcion <= 5) break;
                System.err.println("Número inválido.");
            } catch (InputMismatchException e) {
                System.err.println("Ingrese un número entero.");
                scan.nextLine();
            }
        }

        switch (opcion) {

            case 1:
                Cliente cli = null;
                while (cli == null) {
                    cli = gestoraCliente.modifyClienteFactura(f.getCliente().getDni());
                    if (cli == null) System.out.println("No se pudo modificar el cliente.");
                }
                f.setCliente(cli);
                break;

            case 2:
                Empleado emp = null;
                while (emp == null) {
                    emp = gestoraEmpleado.modifyEmpleadoFactura(f.getEmpleado().getDni());
                    if (emp == null) System.out.println("No se pudo modificar el empleado.");
                }
                f.setEmpleado(emp);
                break;

            case 3:
                Vehiculo veh = null;
                while (veh == null) {
                    veh = gestoraVehiculo.modifyVehiculoFactura(f.getVehiculo().getModelo());
                    if (veh == null) System.out.println("No se pudo modificar el vehículo.");
                }
                f.setVehiculo(veh);
                break;

            case 4:
                while (true) {
                    try {
                        System.out.print("Nuevo monto total: ");
                        double m = scan.nextDouble();
                        scan.nextLine();
                        if (m > 0) {
                            f.setMontoTotal(m);
                            break;
                        }
                        System.err.println("Debe ser mayor a 0.");
                    } catch (InputMismatchException e) {
                        System.err.println("Ingrese un número decimal.");
                        scan.nextLine();
                    }
                }
                break;

            case 5:
                return f;
        }

        System.out.println("Factura modificada correctamente.");
        return f;
    }



    public boolean addFactura(Factura f)
    {
        if(f != null && !facturas.containsKey(f.getNumeroFactura())) //Si la factura no es nula y no está en la lista de facturas según el número de factura lo agrego
        {
            facturas.put(f.getNumeroFactura(), f);                   //Agrego la factura al mapa con su número de factura como key y la factura como valor
            return true;
        }
        return false;
    }

    //Se pueden eliminar facturas, aunque no le vemos un uso cotidiano
    public boolean removeFactura(Factura f)
    {
        if(f != null && facturas.containsKey(f.getNumeroFactura())) //Si la factura no es nula y está en la lista de facturas según el número de factura lo elimino
        {
            facturas.remove(f.getNumeroFactura());                   //Elimino la factura del mapa según su número de factura
            return true;
        }
        return false;
    }

    public boolean removeFactura(int numeroFactura) {

        for (Factura f : facturas.values()) {
            if (f.getNumeroFactura() == numeroFactura) {

                facturas.remove(numeroFactura);
                f.setActivo(false);
                facturas.put(f.getNumeroFactura(), f);

                return true;
            }
        }

        return false; // No se encontró ninguna factura con ese número
    }

    //No hicimos la modificación de facturas, ya que no le vemos un uso cotidiano a eso


    public String searchFactura(int numeroDeFactura)
    {
        if(facturas.containsKey(numeroDeFactura)) //Si la factura no es nula y está en la lista de facturas según el número de factura lo devuelvo
        {
            return facturas.get(numeroDeFactura).toString();              //Devuelvo la factura del mapa según su número de factura
        }

        return "No se ha encontrado una factura con ese numero. ";
    }

    public void showFacturas()
    {

        for (Factura f : facturas.values())
        {
            System.out.println("-------------------");
            System.out.println(f.toString());
        }

    }

    public void listaDeserializadaToFacturas (Map<Integer, Factura> facturasB) {

        facturas.putAll(facturasB);

    }

    public void filtrarPorDni (String dni)
    {
        for (Factura f: facturas.values())
        {
            if (f.getCliente().getDni().equalsIgnoreCase(dni))
            {
                System.out.println(f.toString());
            }
        }
    }







}
