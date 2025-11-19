package Manager;

import Classes.Usuario;
import Manager.Exceptions.IncorrectUserNameOrPasswordException;
import Manager.Exceptions.UserAlreadyExistsException;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Gestora_Usuario {

    private HashSet<Usuario> listaUsuarios;

    public Gestora_Usuario() {
        this.listaUsuarios = new HashSet<>();
    }

    public HashSet<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(HashSet<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public boolean login(String nombreUsuario, String contrasenia) throws IncorrectUserNameOrPasswordException {


        for (Usuario aux : listaUsuarios) {

            if (aux.getNombreUsuario().equals(nombreUsuario)) {

                if(!aux.isActivo())
                {
                    System.out.println("ERROR. El usuario esta dado de baja.");
                }else if(aux.getContrasenia().equals(contrasenia)) {
                        return true;
                } else {
                        throw new IncorrectUserNameOrPasswordException("");
                }

            }
        }

        throw new IncorrectUserNameOrPasswordException("");
    }

    public boolean signUp(String name, String password) throws UserAlreadyExistsException {

        for (Usuario aux : listaUsuarios) {

            if (aux.getNombreUsuario().equals(name)) {
                throw new UserAlreadyExistsException("Invalid name or password");
            }

        }


        Usuario usuario = new Usuario(name, password);
        listaUsuarios.add(usuario);

        return true;
    }


    public void addUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public void crearUsuario() {
        Scanner scan = new Scanner(System.in);
        Usuario u = new Usuario();
        System.out.println("Ingrese un nombre: ");
        u.setNombreUsuario(scan.nextLine());
        System.out.println("Ingrese una contrasenia: ");
        u.setContrasenia(scan.nextLine());
        listaUsuarios.add(u);

    }

    public boolean removeUsuario(String nombreUsuarioAborrar) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuarioAborrar)) {
                listaUsuarios.remove(u);
                u.setActivo(false);
                listaUsuarios.add(u);
                return true;
            }
        }

        return false;
    }

    public String searchUsuario(String nombreUsuario) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return u.toString();
            }
        }
        return "No se ha encontrado un usuario con ese nombre de usuario.";
    }


    public void showUsuarios() {
        for (Usuario u : listaUsuarios) {
            System.out.println("-------------");
            System.out.println(u.toString());
        }
    }


    public void modifyUsuario(String username) {
        Scanner scan = new Scanner(System.in);

        Usuario user = null;

        for (Usuario u : listaUsuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(username)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Modificar todo");
            System.out.println("2. Modificar nombre de usuario");
            System.out.println("3. Modificar contraseña");
            System.out.println("4. Modificar estado activo");
            System.out.println("Seleccione una opción: ");

            try {
                opcion = scan.nextInt();
                scan.nextLine(); // limpiar buffer
                if (opcion >= 1 && opcion <= 4) {
                    opcionValida = true;
                } else {
                    System.out.println("Opción fuera de rango.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                scan.nextLine(); // limpiar buffer
            }
        }

        switch (opcion) {
            case 1:
                while (true) {
                    System.out.println("Nuevo nombre de usuario:");
                    String nuevoNombre = scan.nextLine();
                    if (!nuevoNombre.isEmpty()) {
                        user.setNombreUsuario(nuevoNombre);
                        break;
                    } else {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                }

                while (true) {
                    System.out.println("Nueva contraseña:");
                    String nuevaPass = scan.nextLine();
                    if (!nuevaPass.isEmpty()) {
                        user.setContrasenia(nuevaPass);
                        break;
                    } else {
                        System.out.println("La contraseña no puede estar vacía.");
                    }
                }

                while (true) {
                    System.out.println("¿Está activo? (true/false):");
                    String input = scan.nextLine().trim().toLowerCase();
                    if (input.equals("true")) {
                        user.setActivo(true);
                        break;
                    } else if (input.equals("false")) {
                        user.setActivo(false);
                        break;
                    } else {
                        System.out.println("Debe ingresar true o false.");
                    }
                }

                System.out.println("Usuario modificado completamente.");
                break;

            case 2:
                while (true) {
                    System.out.println("Nuevo nombre de usuario:");
                    String nuevoNombre = scan.nextLine();
                    if (!nuevoNombre.isEmpty()) {
                        user.setNombreUsuario(nuevoNombre);
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
                        user.setContrasenia(nuevaPass);
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
                        user.setActivo(true);
                        break;
                    } else if (input.equals("false")) {
                        user.setActivo(false);
                        break;
                    } else {
                        System.out.println("Debe ingresar true o false.");
                    }
                }
                System.out.println("Estado actualizado.");
                break;
        }
    }

    public boolean esValido(String input) {
        // Esta expresión regular permite solo letras, números y algunos caracteres como guiones bajos o puntos.
        String patron = "^[a-zA-Z0-9._-]+$";
        return input.matches(patron);
    }


}







