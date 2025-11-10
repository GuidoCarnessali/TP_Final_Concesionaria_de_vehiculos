package Manager;

import java.util.HashSet;
import java.util.Set;

public class Gestora_Admin {

    private Set<Admin> listaDeAdmins;

    public Gestora_Admin() {
        this.listaDeAdmins = new HashSet<>();
    }

    public boolean login(String nombreUsuario, String contrasenia) throws IncorrectUserNameOrPasswordException
    {

        for (Admin aux : listaDeAdmins)
        {

            if (aux.getNombreAdmin().equals(nombreUsuario))
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

    public boolean signUp (String name, String password) throws UserAlreadyExistsException{

        for (Admin aux : listaDeAdmins){

            if(aux.getNombreAdmin().equals(name)){
                throw new UserAlreadyExistsException("");
            }

        }

        Admin admin = new Admin(name, password);
        listaDeAdmins.add(admin);

        return true;
    }

    public void addAdmin (Admin a)
    {
        listaDeAdmins.add(a);
    }

}
