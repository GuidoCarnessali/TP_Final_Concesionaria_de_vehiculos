package Manager;

import Classes.Usuario;
import Manager.Exceptions.IncorrectUserNameOrPasswordException;
import Manager.Exceptions.UserAlreadyExistsException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Gestora_Usuario
{

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

    public boolean login(String nombreUsuario, String contrasenia) throws IncorrectUserNameOrPasswordException
    {


        for (Usuario aux : listaUsuarios)
        {

            if (aux.getNombreUsuario().equals(nombreUsuario))
            {
                if (aux.getContrasenia().equals(contrasenia))
                {
                    return true;
                }else{
                    throw new IncorrectUserNameOrPasswordException("");
                }
            }
        }

        throw new IncorrectUserNameOrPasswordException("");
    }

    public boolean signUp (String name, String password)throws UserAlreadyExistsException {

        for (Usuario aux : listaUsuarios){

            if(aux.getNombreUsuario().equals(name)){
                throw new UserAlreadyExistsException("Invalid name or password");
            }

        }

        Usuario usuario = new Usuario(name, password);
        listaUsuarios.add(usuario);

        return true;
    }



    public void addUsuario (Usuario u)
    {
        listaUsuarios.add(u);
    }

    public void crearUsuario ()
    {
        Scanner scan = new Scanner(System.in);
        Usuario u = new Usuario();
        System.out.println("Ingrese un nombre: ");
        u.setNombreUsuario(scan.nextLine());
        System.out.println("Ingrese una contrasenia: ");
        u.setContrasenia(scan.nextLine());
        listaUsuarios.add(u);

    }

    public void showUsuarios ()
    {
        for (Usuario u : listaUsuarios)
        {
            System.out.println(u.toString());
        }
    }






}




