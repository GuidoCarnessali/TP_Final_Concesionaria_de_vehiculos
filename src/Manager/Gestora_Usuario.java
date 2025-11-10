package Manager;

import java.util.HashSet;
import java.util.Set;

public class Gestora_Usuario
{

    private Set<Usuario> listaUsuarios;

    public Gestora_Usuario() {
        this.listaUsuarios = new HashSet<>();
    }

    public Set<Usuario> getListaUsuarios() {
        return listaUsuarios;
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

    public boolean signUp (String name, String password)throws UserAlreadyExistsException{

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






}




