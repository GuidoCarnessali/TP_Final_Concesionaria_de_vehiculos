package Manager;

import org.json.JSONTokener;

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
            System.out.printf("1. Iniciar sesion como usuario. ");
            System.out.println("\n2. Registrar usuario. ");
            System.out.println("3. Iniciar sesion como administrador. ");
            System.out.println("4. Salir. ");
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
                    }catch (IncorrectUserNameOrPasswordException e ){
                        System.err.println(e.getMessage());

                    }



                    break;

                case 4: //Salir del sistema

                    int verificarSalida;

                    System.out.println("Estas a punto de salir, estas seguro? ");
                    System.out.println("1. Si. ");
                    System.out.println("2. No. ");
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

    public void desplegarMenuUsuario (Gestora_Usuario gestoraUsuario, Gestora_Factura gestoraFactura, Gestora_Vehiculo gestoraVehiculo, Gestora_Cliente gestoraCliente, Gestora_Empleado gestoraEmpleado, Gestora_JSON gestoraJson, Gestora_Proveedor gestoraProveedor){



        int opcion = -1;
        boolean salir = false;
        Scanner scan = new Scanner(System.in);

        while (!salir)
        {
            System.out.printf("1. Ver vehiculos. ");
            System.out.printf("\n2. Comprar vehiculo. ");
            System.out.println("3. Ver mi facturas. ");
            System.out.println("4. Probar auto. ");

            switch (opcion)
            {
                case 1:



                    break;

                case 2:



                    break;
            }


        }






    }





}
