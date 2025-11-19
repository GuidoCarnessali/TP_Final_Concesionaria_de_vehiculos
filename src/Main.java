import Classes.*;
import Enums.Marca;
import Manager.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        //Testeo de clases y clases gestoras
        //Gestoras:


        Gestora_Empleado gestoraEmpleado = new Gestora_Empleado();
        Gestora_Vehiculo gestoraVehiculo = new Gestora_Vehiculo();
        Gestora_Cliente gestoraCliente = new Gestora_Cliente();
        Gestora_Proveedor gestoraProveedor = new Gestora_Proveedor();
        Gestora_Factura gestoraFactura = new Gestora_Factura();
        Gestora_JSON gestoraJSON = new Gestora_JSON();
        Gestora_Usuario gestoraUsuario = new Gestora_Usuario();
        Gestora_Admin gestoraAdmin = new Gestora_Admin();


        Menu menu = new Menu();
        //menu.desplegarMenuAdmin(gestoraUsuario, gestoraFactura, gestoraVehiculo, gestoraCliente, gestoraEmpleado, gestoraJSON, gestoraProveedor, gestoraAdmin);
        Admin admin = new Admin("manu", "1234");
        gestoraAdmin.addAdmin(admin);
        //menu.desplegarMenuUsuario(gestoraUsuario, gestoraFactura, gestoraVehiculo, gestoraCliente, gestoraEmpleado, gestoraJSON, gestoraProveedor, gestoraAdmin);
        menu.iniciarSistema(gestoraUsuario, gestoraFactura, gestoraVehiculo, gestoraCliente, gestoraEmpleado, gestoraJSON, gestoraProveedor, gestoraAdmin);


    }
            //commit 15: casi desaprobamosxd




}

