package Manager;

import Classes.Admin;
import Classes.Usuario;
import Manager.Exceptions.IncorrectUserNameOrPasswordException;
import Manager.Exceptions.UserAlreadyExistsException;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Gestora_Admin {
    //atributo
    private HashSet<Admin> listaDeAdmins;

    //Constructor
    public Gestora_Admin() {
        this.listaDeAdmins = new HashSet<>();
    }

    //Getter y Setter
    public HashSet<Admin> getListaDeAdmins() {
        return listaDeAdmins;
    }

    public void setListaDeAdmins(HashSet<Admin> listaDeAdmins) {
        this.listaDeAdmins = listaDeAdmins;
    }

    //Metodos
    //El login es para iniciar sesion como admin
    public boolean login(String nombreUsuario, String contrasenia) throws IncorrectUserNameOrPasswordException
    {

        for (Admin aux : listaDeAdmins)
        {

            if (aux.getNombreAdmin().equals(nombreUsuario))
            {
                if(aux.isActivo()) {
                    if (aux.getContrasenia().equals(contrasenia)) {
                        return true;
                    } else {
                        throw new IncorrectUserNameOrPasswordException("");
                    }
                }else
                {
                    System.out.println("ERROR. El admin esta dado de baja.");
                }

            }

        }

        throw new IncorrectUserNameOrPasswordException("");
    }


    //SignUp no lo usamos
    public boolean signUp (String name, String password) throws UserAlreadyExistsException {

        for (Admin aux : listaDeAdmins){

            if(aux.getNombreAdmin().equals(name)){
                throw new UserAlreadyExistsException("");
            }

        }

        Admin admin = new Admin(name, password);
        listaDeAdmins.add(admin);

        return true;
    }
    //para agregar un admin a la lista
    public void addAdmin (Admin a)
    {
        listaDeAdmins.add(a);
    }
    //crearAdmin sirve para que un admin pueda agregar otro!
    public void crearAdmin() {

        Scanner scan = new Scanner(System.in);
        Admin a = new Admin();

        while (true) {
            System.out.println("Ingrese un nombre: ");
            String nombre = scan.nextLine().trim();
            if (!nombre.isEmpty()) {
                a.setNombreAdmin(nombre);
                break;
            } else {
                System.out.println("El nombre no puede estar vacío.");
            }
        }

        while (true) {
            System.out.println("Ingrese una contraseña: ");
            String contrasenia = scan.nextLine().trim();
            if (!contrasenia.isEmpty()) {
                a.setContrasenia(contrasenia);
                break;
            } else {
                System.out.println("La contraseña no puede estar vacía.");
            }
        }

        while (true) {
            System.out.println("Ingrese el estado: (true/false): ");
            String input = scan.nextLine().trim().toLowerCase();
            if (input.equals("true")) {
                a.setActivo(true);
                break;
            } else if (input.equals("false")) {
                a.setActivo(false);
                break;
            } else {
                System.out.println("Debe ingresar true o false.");
            }
        }

        listaDeAdmins.add(a);
        System.out.println("Admin creado correctamente.");
    }

    public boolean removeAdmin(String nombreAdminAborrar) {
        for (Admin a: listaDeAdmins) {
            if (a.getNombreAdmin().equalsIgnoreCase(nombreAdminAborrar)) {
                listaDeAdmins.remove(a);
                a.setActivo(false);
                listaDeAdmins.add(a);
                return true;
            }
        }

        return false;
    }

    public void modifyAdmin(String username) {

        Scanner scan = new Scanner(System.in);

        Admin admin = null;

        for (Admin a : listaDeAdmins) {
            if (a.getNombreAdmin().equalsIgnoreCase(username)) {
                admin = a;
                break;
            }
        }

        if (admin == null) {
            System.out.println("Administrador no encontrado.");
            return;
        }

        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Modificar todo");
            System.out.println("2. Modificar nombre de administrador");
            System.out.println("3. Modificar contraseña");
            System.out.println("4. Modificar estado activo");
            System.out.println("Seleccione una opción: ");

            try {
                opcion = scan.nextInt();
                scan.nextLine();
                if (opcion >= 1 && opcion <= 4) {
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
                    System.out.println("Nuevo nombre de administrador:");
                    String nuevoNombre = scan.nextLine();
                    if (!nuevoNombre.isEmpty()) {
                        admin.setNombreAdmin(nuevoNombre);
                        break;
                    } else {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                }

                while (true) {
                    System.out.println("Nueva contraseña:");
                    String nuevaPass = scan.nextLine();
                    if (!nuevaPass.isEmpty()) {
                        admin.setContrasenia(nuevaPass);
                        break;
                    } else {
                        System.out.println("La contraseña no puede estar vacía.");
                    }
                }

                while (true) {
                    System.out.println("¿Está activo? (true/false):");
                    String input = scan.nextLine().trim().toLowerCase();
                    if (input.equals("true")) {
                        admin.setActivo(true);
                        break;
                    } else if (input.equals("false")) {
                        admin.setActivo(false);
                        break;
                    } else {
                        System.out.println("Debe ingresar true o false.");
                    }
                }

                System.out.println("Administrador modificado completamente.");
                break;

            case 2:
                while (true) {
                    System.out.println("Nuevo nombre de administrador:");
                    String nuevoNombre = scan.nextLine();
                    if (!nuevoNombre.isEmpty()) {
                        admin.setNombreAdmin(nuevoNombre);
                        break;
                    } else {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                }
                System.out.println("Nombre modificado.");
                break;

            case 3:
                while (true) {
                    System.out.println("Nueva contraseña:");
                    String nuevaPass = scan.nextLine();
                    if (!nuevaPass.isEmpty()) {
                        admin.setContrasenia(nuevaPass);
                        break;
                    } else {
                        System.out.println("La contraseña no puede estar vacía.");
                    }
                }
                System.out.println("Contraseña modificada.");
                break;

            case 4:
                while (true) {
                    System.out.println("¿Está activo? (true/false):");
                    String input = scan.nextLine().trim().toLowerCase();
                    if (input.equals("true")) {
                        admin.setActivo(true);
                        break;
                    } else if (input.equals("false")) {
                        admin.setActivo(false);
                        break;
                    } else {
                        System.out.println("Debe ingresar true o false.");
                    }
                }
                System.out.println("Estado actualizado.");
                break;
        }
    }

    //Mostrar la lista de admins
    public void showAdmins ()
    {
        for (Admin a : listaDeAdmins)
        {
            System.out.println("--------------");
            System.out.println(a.toString());
        }
    }

    public String searchAdmin(String nombreAdmin) {
        for (Admin a : listaDeAdmins) {
            if (a.getNombreAdmin().equalsIgnoreCase(nombreAdmin)) {
                return a.toString();
            }
        }
        return "No se ha encontrado un administrador con ese nombre.";
    }


}
