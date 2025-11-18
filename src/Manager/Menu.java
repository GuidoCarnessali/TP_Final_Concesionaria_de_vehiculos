package Manager;

import Classes.Cliente;
import Classes.Empleado;
import Classes.Vehiculo;
import Manager.Exceptions.IncorrectUserNameOrPasswordException;
import Manager.Exceptions.UserAlreadyExistsException;

import java.util.Scanner;

public class Menu {

    public void iniciarSistema (Gestora_Usuario gestoraUsuario, Gestora_Factura gestoraFactura, Gestora_Vehiculo gestoraVehiculo, Gestora_Cliente gestoraCliente, Gestora_Empleado gestoraEmpleado, Gestora_JSON gestoraJson, Gestora_Proveedor gestoraProveedor, Gestora_Admin gestoraAdmin)
    {
        gestoraJson.archivoToConcesionaria(gestoraUsuario, gestoraFactura, gestoraVehiculo, gestoraCliente, gestoraEmpleado, gestoraProveedor, gestoraAdmin);

        int opcion = -1;
        boolean salir = false;
        Scanner scan = new Scanner(System.in);

        while (!salir)
        {
            System.out.println("--------------");
            System.out.printf("1. Iniciar sesion como usuario. ");
            System.out.println("\n2. Registrar usuario. ");
            System.out.println("3. Iniciar sesion como administrador. ");
            System.out.println("4. Salir. ");
            System.out.println("--------------");
            System.out.println();

            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion)
            {
                case 1: //Iniciar sesion como usuario


                    String name;
                    String password;

                    System.out.println("Ingrese su nombre de usuario: ");
                    name = scan.nextLine();

                    System.out.println("Ingrese su contrasenia: ");
                    password = scan.nextLine();

                    try {
                        gestoraUsuario.login(name, password);
                        desplegarMenuUsuario(gestoraUsuario, gestoraFactura, gestoraVehiculo, gestoraCliente, gestoraEmpleado, gestoraJson, gestoraProveedor, gestoraAdmin);

                    }catch (IncorrectUserNameOrPasswordException e ){
                        System.err.println(e.getMessage());

                    }


                    break;

                case 2: //Registrar usuario

                    String name2;
                    String password2;

                    System.out.println("Ingrese su nombre de usuario: ");
                    name2 = scan.nextLine();
                    System.out.println("Ingrese su contrasenia: ");
                    password2 = scan.nextLine();

                    try {
                        gestoraUsuario.signUp(name2, password2);

                    }catch (UserAlreadyExistsException e ){
                        System.err.println(e.getMessage());

                    }


                    break;

                case 3: //Iniciar sesion como administrador

                    String name3;
                    String password3;

                    System.out.println("Ingrese su nombre de admin: ");
                    name3 = scan.nextLine();
                    System.out.println("Ingrese su contrasenia: ");
                    password3 = scan.nextLine();

                    try {
                        gestoraAdmin.login(name3, password3);
                        try {
                            System.out.println("CARGANDO . . .");
                            Thread.sleep(2000); // 2 segundos
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        desplegarMenuAdmin(gestoraUsuario, gestoraFactura, gestoraVehiculo, gestoraCliente, gestoraEmpleado, gestoraJson, gestoraProveedor, gestoraAdmin);
                    }catch (IncorrectUserNameOrPasswordException e ){
                        System.err.println(e.getMessage());

                    }



                    break;

                case 4: //Salir del sistema

                    int verificarSalida;

                    System.out.println("--------------");
                    System.out.println("Estas a punto de salir, estas seguro? ");
                    System.out.println("1. Si. ");
                    System.out.println("2. No. ");
                    System.out.println("--------------");
                    verificarSalida = scan.nextInt();
                    scan.nextLine();

                    if(verificarSalida == 1)
                    {
                        gestoraJson.concesionariaToArchivo(gestoraUsuario, gestoraFactura, gestoraVehiculo, gestoraCliente, gestoraEmpleado, gestoraProveedor, gestoraAdmin);
                        salir = true;

                    }

                    break;


                default:

                    System.err.println("Opcion invalida! ");

                    break;

            }
        }
    }

    public void desplegarMenuUsuario (Gestora_Usuario gestoraUsuario, Gestora_Factura gestoraFactura, Gestora_Vehiculo gestoraVehiculo, Gestora_Cliente gestoraCliente, Gestora_Empleado gestoraEmpleado, Gestora_JSON gestoraJson, Gestora_Proveedor gestoraProveedor, Gestora_Admin gestoraAdmin){

        int opcion = -1;
        boolean salir = false;
        Scanner scan = new Scanner(System.in);

        while (!salir)
        {
            System.out.println("--------------");
            System.out.printf("1. Ver vehiculos. ");
            System.out.printf("\n2. Ver moto. ");
            System.out.printf("\n3. Ver autos. ");
            System.out.printf("\n4. Ver camiones. ");
            System.out.printf("\n5. Ver camionetas. ");
            System.out.printf("\n6. Comprar vehiculo. ");
            System.out.println("\n7. Ver mi facturas. ");
            System.out.println("\n8. Cerrar sesion. ");
            System.out.println("--------------");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion)
            {
                case 1:

                    gestoraVehiculo.showVehiculosActivos();

                    break;

                case 2:
                    gestoraVehiculo.showMotos();
                    break;
                case 3:
                    gestoraVehiculo.showAutos();
                    break;
                case 4:
                    gestoraVehiculo.showCamion();
                    break;
                case 5:
                    gestoraVehiculo.showCamionetas();
                    break;

                case 6:

                    String modelo;
                    int anio;
                    String color;

                    System.out.println("Ingrese el modelo a buscar: ");
                    modelo = scan.nextLine();
                    System.out.println("Ingrese el anio a buscar: ");
                    anio = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese el color a buscar: ");
                    color = scan.nextLine();


                    Vehiculo vehiculoAcomprar = gestoraVehiculo.filtrarVehiculo(modelo, anio, color);

                    if(vehiculoAcomprar != null)
                    {

                        System.out.println("Para continuar la compra, necesitamos sus datos: ");
                        Cliente c = new Cliente();
                        System.out.println("Nombre: ");
                        c.setNombre(scan.nextLine());
                        System.out.println("Apellido: ");
                        c.setApellido(scan.nextLine());
                        System.out.println("Dni: ");
                        c.setDni(scan.nextLine());
                        System.out.println("Email: ");
                        c.setEmail(scan.nextLine());
                        System.out.println("Telefono: ");
                        c.setTelefono(scan.nextLine());
                        System.out.println("Sexo: ");
                        c.setSexo(scan.nextLine().charAt(0));
                        System.out.println("Edad: ");
                        c.setEdad(scan.nextInt());
                        scan.nextLine();

                        gestoraVehiculo.buyVehicle(c, vehiculoAcomprar, gestoraEmpleado.obtenerEmpleadoRandom(), gestoraFactura);
                    }

                    break;

                case 7:

                    System.out.println("Ingrese su dni: ");
                    String dni = scan.nextLine();

                   gestoraFactura.filtrarPorDni(dni);

                    break;

                case 8:

                    int verificarSalida;

                    System.out.println("--------------");
                    System.out.println("Estas a punto de cerrar sesion, estas seguro? ");
                    System.out.println("1. Si. ");
                    System.out.println("2. No. ");
                    System.out.println("--------------");
                    verificarSalida = scan.nextInt();
                    scan.nextLine();

                    if(verificarSalida == 1)
                    {
                        salir = true;
                    }

                    break;

                default:

                    System.out.println("Opcion invalida. ");

                    break;


            }
        }
    }

    public void desplegarMenuAdmin (Gestora_Usuario gestoraUsuario, Gestora_Factura gestoraFactura, Gestora_Vehiculo gestoraVehiculo, Gestora_Cliente gestoraCliente, Gestora_Empleado gestoraEmpleado, Gestora_JSON gestoraJson, Gestora_Proveedor gestoraProveedor, Gestora_Admin gestoraAdmin)
    {
        int opcion = -1;
        boolean salir = false;
        Scanner scan = new Scanner(System.in);

        while (!salir)
        {
            System.out.println("--------------");
            System.out.println("1. Gestionar usuarios. ");
            System.out.println("2. Gestionar administradores. ");
            System.out.println("3. Gestionar clientes. ");
            System.out.println("4. Gestionar empleados. ");
            System.out.println("5. Gestionar facturas. ");
            System.out.println("6. Gestionar proveedores. ");
            System.out.println("7. Gestionar vehiculos. ");
            System.out.println("8. Salir. ");
            System.out.println("--------------");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion)
            {
                case 1:

                    boolean salir1 = false;
                    int opcion1 = -1;
                    while (!salir1) {
                        System.out.println(" 1. Ver usuarios. ");
                        System.out.println("2. Crear un usuario. ");
                        System.out.println("3. Volver al menu principal ↩.");
                        opcion1 = scan.nextInt();
                        scan.nextLine();
                        switch (opcion1) {
                            case 1:
                                gestoraUsuario.showUsuarios();
                                break;
                            case 2:
                                gestoraUsuario.crearUsuario();
                                break;
                            case 3:
                                salir1 = true;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }
                    }
                    break;

                case 2:
                    boolean salir2 = false;
                    int opcion2 = -1;
                    while(!salir2) {
                    System.out.println(" 1. Ver admins. ");
                    System.out.println("2. Crear un admin. ");
                    System.out.println("3. Volver al menu principal ↩.");

                        opcion2 = scan.nextInt();
                        scan.nextLine();
                        switch (opcion2) {
                            case 1:
                                gestoraAdmin.showAdmins();
                                break;
                            case 2:
                                gestoraAdmin.crearAdmin();
                                break;
                            case 3:
                                salir2 = true;
                                break;

                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                        break;


                case 3:
                    boolean salir3 = false;
                    int opcion3 = -1;
                    while (!salir3) {
                        System.out.println(" 1. Ver clientes. ");
                        System.out.println("2. Modificar cliente ");
                        System.out.println("3. Buscar cliente");
                        System.out.println("4. Volver al menu principal ↩.");
                        opcion3 = scan.nextInt();
                        scan.nextLine();
                        switch (opcion3) {
                            case 1:
                                gestoraCliente.showClientes();
                                break;
                            case 2:

                                String dni;
                                System.out.println("Ingrese el DNI del cliente a modificar: ");
                                dni = scan.nextLine();
                                gestoraCliente.modifyCliente(dni);

                                break;
                            case 3:
                                String dni2;
                                System.out.println("Ingrese el DNI a buscar: ");
                                dni2 = scan.nextLine();
                                System.out.println(gestoraCliente.searchCliente(dni2));

                                break;
                            case 4:
                                salir3 = true;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }

                    }
                        break;

                case 4:
                    boolean salir4 = false;
                    int opcion4 = -1;
                    while (!salir4) {
                        System.out.println(" 1. Ver empleados. ");
                        System.out.println("2. Ver solo empleados activos.  ");
                        System.out.println("3. Ver solo empleados inactivos. ");
                        System.out.println("4. Crear empleado. ");
                        System.out.println("5. Modificar empleados ");
                        System.out.println("6. Buscar empleados");
                        System.out.println("7. Volver al menu principal ↩. ");
                        opcion4 = scan.nextInt();
                        scan.nextLine();

                        switch (opcion4) {

                            case 1:
                                gestoraEmpleado.showEmpleados();
                                break;
                            case 2:
                                gestoraEmpleado.showEmpleadosActivos();
                                break;
                            case 3:
                                gestoraEmpleado.showEmpleadosInactivos();
                                break;

                            case 4:

                                gestoraEmpleado.crearEmpleado();

                                break;

                            case 5:
                                System.out.println("Ingrese el dni del empleado a modificar: ");
                                String dnia = scan.nextLine();
                                gestoraEmpleado.modifyEmpleado(dnia);
                                break;
                            case 6:
                                System.out.println("Ingrese el dni a buscar");
                                String dnib = scan.nextLine();
                                gestoraEmpleado.modifyEmpleado(dnib);
                                break;
                            case 7:
                                salir4 = true;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                        break;


                case 5: //facturas
                    boolean salir5 = false;
                    int opcion5 = -1;
                    while (!salir5) {
                        System.out.println(" 1. Ver facturas. ");
                        System.out.println("2. Buscar facturas");
                        System.out.println("3. Volver al menu principal ↩. ");
                        opcion5 = scan.nextInt();
                        scan.nextLine();

                        switch (opcion5) {

                            case 1:
                                gestoraFactura.showFacturas();
                                break;
                            case 2:
                                System.out.println("Ingrese el numero de factura a buscar: ");
                                int numfactura = scan.nextInt();
                                scan.nextLine();
                                System.out.println(gestoraFactura.searchFactura(numfactura));
                                break;
                            case 3:
                                salir5 = true;
                                break;
                            default:
                                System.out.println("Opcion invalida");

                        }
                    }
                        break;


                case 6: //proveedores
                    boolean salir6 = false;
                    int opcion6 = -1;
                    while (!salir6) {
                        System.out.println(" 1. Ver proveedores. ");
                        System.out.println("2. Ver proveedores activos. ");
                        System.out.println("3. Ver proveedores inactivos. ");
                        System.out.println("4. Crear proveedor. ");
                        System.out.println("5. Modificar proveedor. ");
                        System.out.println("6. Buscar proveedores. ");
                        System.out.println("7. Eliminar proveedor. ");
                        System.out.println("8. Volver al menu principal ↩. ");
                        opcion6 = scan.nextInt();
                        scan.nextLine();

                        switch (opcion6) {
                            case 1:
                                gestoraProveedor.showProveedores();
                                break;
                            case 2:
                                gestoraProveedor.showProveedoresActivos();
                                break;
                            case 3:
                                gestoraProveedor.showProveedoresInactivos();
                                break;
                            case 4:
                                gestoraProveedor.crearProveedor();
                                break;
                            case 5:
                                System.out.println("Ingrese el nombre del proveedor a modificar: ");
                                String nombreViejo = scan.nextLine();
                                gestoraProveedor.modifyProveedor(nombreViejo);
                                break;
                            case 6:
                                System.out.println("Ingrese el nombre del proveedor a buscar: ");
                                String nombreAbuscar = scan.nextLine();
                                System.out.println(gestoraProveedor.searchProveedor(nombreAbuscar));
                                break;
                            case 7:
                                System.out.println("Ingrese el nombre del proveedor a eliminar: ");
                                String nombreAeliminar = scan.nextLine();
                                gestoraProveedor.removeProveedor(nombreAeliminar);
                                break;
                            case 8:
                                salir6 = true;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }

                    }
                        break;


                case 7: //vehiculos
                    boolean salir7 = false;
                    int opcion7 = -1;
                    while (!salir7) {
                        System.out.println(" 1. Ver vehiculos. ");
                        System.out.println("2. Ver vehiculos en stock. ");
                        System.out.println("3. Ver vehiculos fuera de stock ");
                        System.out.println("4. Crear vehiculo. ");
                        System.out.println("5. Modificar vehiculo. ");
                        System.out.println("6. Buscar vehiculo. ");
                        System.out.println("7. Eliminar vehiculo. ");
                        System.out.println("8. Volver al menu principal ↩. ");
                        opcion7 = scan.nextInt();
                        scan.nextLine();

                        switch (opcion7) {

                            case 1:

                                gestoraVehiculo.showVehiculos();

                                break;
                            case 2:

                                gestoraVehiculo.showVehiculosActivos();

                                break;
                            case 3:

                                gestoraVehiculo.showVehiculosInactivos();

                                break;
                            case 4:
                                gestoraVehiculo.createVehiculo();
                                break;
                            case 5:
                                System.out.println("Ingrese el nombre del modelo a modificar: ");
                                String modeloviejo = scan.nextLine();

                                gestoraVehiculo.modifyVehiculo(modeloviejo);
                                break;
                            case 6:
                                System.out.println("Ingrese el nombre del modelo a buscar: ");
                                String modeloAbuscar = scan.nextLine();
                                gestoraVehiculo.searchVehiculo(modeloAbuscar);

                                break;
                            case 7:
                                System.out.println("Ingrese el nombre del modelo a eliminar: ");
                                String modeloAeliminar = scan.nextLine();
                                System.out.println("Ingrese el color del modelo a eliminar: ");
                                String colorAeliminar = scan.nextLine();
                                System.out.println("Ingrese el anio del modelo a eliminar: ");
                                int anioAeliminar = scan.nextInt();
                                scan.nextLine();
                                gestoraVehiculo.removeVehiculo(modeloAeliminar, anioAeliminar, colorAeliminar);


                                break;
                            case 8:
                                salir7 = true;
                                break;


                            default:
                                System.out.println("Opcion invalida.");
                        }

                    }
                        break;


                case 8:

                    int verificarSalida;
                        System.out.println("--------------");
                        System.out.println("Estas a punto de cerrar sesion, estas seguro? ");
                        System.out.println("1. Si. ");
                        System.out.println("2. No. ");
                        System.out.println("--------------");
                        verificarSalida = scan.nextInt();
                        scan.nextLine();

                        if (verificarSalida == 1) {
                            salir = true;
                        }

                        break;

                default:

                    System.out.println("Opcion invalida. ");

                    break;

            }
        }




    }





}
