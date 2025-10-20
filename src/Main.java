import Classes.*;
import Enums.Marca;
import Manager.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        //Testeo de clases y clases gestoras


        Empleado empleado1 = new Empleado("Juan", "Pérez", "12345678A", 2500.50, "Desarrollador", 30, 5, "juan.perez@email.com", "123-456-7890", true);
        Empleado empleado2 = new Empleado("Ana", "Gómez", "23456789B", 3000.75, "Gerente", 40, 10, "ana.gomez@email.com", "987-654-3210", true);
        Empleado empleado3 = new Empleado("Carlos", "López", "34567890C", 1800.00, "Auxiliar", 25, 2, "carlos.lopez@email.com", "456-789-0123", false);
        Empleado empleado4 = new Empleado("María", "Rodríguez", "45678901D", 3200.25, "Analista", 35, 7, "maria.rodriguez@email.com", "321-654-9870", true);
        Empleado empleado5 = new Empleado("Pedro", "Sánchez", "56789012E", 2800.00, "Supervisor", 45, 15, "pedro.sanchez@email.com", "654-321-0987", true);

        Auto auto1 = new Auto(Marca.TOYOTA, "Corolla", 2020, "Blanco", 20000, true, 1800, 4, "Gasolina");
        Auto auto2 = new Auto(Marca.HONDA, "Civic", 2022, "Negro", 22500, true, 2000, 4, "Gasolina");
        Auto auto3 = new Auto(Marca.FORD, "Focus", 2019, "Azul", 18000, false, 1600, 4, "Diésel");
        Auto auto4 = new Auto(Marca.CHEVROLET, "Cruze", 2021, "Rojo", 21000, true, 1800, 4, "Gasolina");
        Auto auto5 = new Auto(Marca.NISSAN, "Altima", 2023, "Plata", 25000, true, 2500, 4, "Gasolina");
        Moto moto1 = new Moto(Marca.YAMAHA, "YZF-R3", 2021, "Azul", 5000, true, 321, 2);
        Moto moto2 = new Moto(Marca.HONDA, "CBR500R", 2020, "Rojo", 6500, true, 471, 2);
        Moto moto3 = new Moto(Marca.SUZUKI, "GSX250R", 2019, "Negro", 4200, false, 248, 2);

        Cliente cliente1 = new Cliente("Juan", "Pérez", "12345678A", "juan.perez@email.com", "123-456-7890", 'M', 30);
        Cliente cliente2 = new Cliente("Ana", "Gómez", "23456789B", "ana.gomez@email.com", "987-654-3210", 'F', 25);
        Cliente cliente3 = new Cliente("Carlos", "López", "34567890C", "carlos.lopez@email.com", "456-789-0123", 'M', 40);
        Cliente cliente4 = new Cliente("María", "Rodríguez", "45678901D", "maria.rodriguez@email.com", "321-654-9870", 'F', 35);
        Cliente cliente5 = new Cliente("Pedro", "Sánchez", "56789012E", "pedro.sanchez@email.com", "654-321-0987", 'M', 50);

        Proveedor proveedor1 = new Proveedor("Juan Pérez", "Autoparts S.A.", "Av. Libertador 1234", "112-233-4455", "juan.perez@autoparts.com", Marca.TOYOTA, true);
        Proveedor proveedor2 = new Proveedor("Ana Gómez", "MotoDistribuidores", "Calle Ficticia 5678", "223-344-5566", "ana.gomez@motodistribuidores.com", Marca.YAMAHA, true);
        Proveedor proveedor3 = new Proveedor("Carlos López", "Vehículos Globales", "Av. 9 de Julio 1010", "334-455-6677", "carlos.lopez@vehiculosglobales.com", Marca.FORD, false);

        Factura factura1 = new Factura(25000.00, cliente1, empleado1, auto1);
        Factura factura2 = new Factura(30000.00, cliente2, empleado2, auto2);
        Factura factura3 = new Factura(18000.00, cliente3, empleado3, auto3);
        Factura factura4 = new Factura(21000.00, cliente4, empleado4, auto4);
        Factura factura5 = new Factura(35000.00, cliente5, empleado5, auto5);


        System.out.println("---GESTORÍA DE CONCESIONARIO DE AUTOS---\n");
        System.out.println("---EMPLEADOS---");

        Gestora_Empleado gestoraEmpleado = new Gestora_Empleado();
        gestoraEmpleado.addEmpleado(empleado1);
        gestoraEmpleado.addEmpleado(empleado2);
        gestoraEmpleado.addEmpleado(empleado3);
        gestoraEmpleado.addEmpleado(empleado4);
        gestoraEmpleado.addEmpleado(empleado5);
        gestoraEmpleado.showEmpleados();

        System.out.println("\n");
        System.out.println("---VEHÍCULOS---");
        System.out.println("\n\n");
        Gestora_Vehiculo gestoraVehiculo = new Gestora_Vehiculo();
        gestoraVehiculo.addVehiculo(auto1);
        gestoraVehiculo.addVehiculo(auto2);
        gestoraVehiculo.addVehiculo(auto3);
        gestoraVehiculo.addVehiculo(auto4);
        gestoraVehiculo.addVehiculo(auto5);
        gestoraVehiculo.addVehiculo(moto1);
        gestoraVehiculo.addVehiculo(moto2);
        gestoraVehiculo.addVehiculo(moto3);
        gestoraVehiculo.showVehiculos();

        System.out.println("\n");
        System.out.println("---CLIENTES---");
        System.out.println("\n");

        Gestora_Cliente gestoraCliente = new Gestora_Cliente();
        gestoraCliente.addCliente(cliente1);
        gestoraCliente.addCliente(cliente2);
        gestoraCliente.addCliente(cliente3);
        gestoraCliente.addCliente(cliente4);
        gestoraCliente.addCliente(cliente5);
        gestoraCliente.showClientes();

        System.out.println("\n");
        System.out.println("---PROVEEDORES---");
        System.out.println("\n");

        Gestora_Proveedor gestoraProveedor = new Gestora_Proveedor();
        gestoraProveedor.addProveedor(proveedor1);
        gestoraProveedor.addProveedor(proveedor2);
        gestoraProveedor.addProveedor(proveedor3);
        gestoraProveedor.showProveedores();

        System.out.println("\n");
        System.out.println("---FACTURAS---");
        System.out.println("\n");

        Gestora_Factura gestoraFactura = new Gestora_Factura();
        gestoraFactura.addFactura(factura1);
        gestoraFactura.addFactura(factura2);
        gestoraFactura.addFactura(factura3);
        gestoraFactura.addFactura(factura4);
        gestoraFactura.addFactura(factura5);
        gestoraFactura.showFacturas();

        Camioneta miCamioneta = new Camioneta(Marca.FORD, "Ranger", 2024, "Blanco", 45000, true, 3200, 4, "Diésel", 1.8, 2.2);
        Camión miCamion = new Camión(Marca.VOLKSWAGEN, "TGX", 2023, "Rojo", 120000, true, 10000, 2, "Diésel", 7.5, 2.5);


        System.out.printf("\nDimension mionca: " + "%.2f", miCamion.calcularDimension());
        System.out.printf("\nDimension chata: " + "%.2f",  miCamioneta.calcularDimension());


    }
}