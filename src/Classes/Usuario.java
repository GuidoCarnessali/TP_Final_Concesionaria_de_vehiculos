package Classes;

import java.util.Objects;

public class Usuario {
    //Atributos
    private String nombreUsuario;
    private String contrasenia;
    //constructor
    public Usuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public Usuario() {
    }
    //Getter y Setter
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    //Metodos
    @Override
    public String toString() {
        return "Nombre de usuario: " + nombreUsuario + "\n" +
                "Contrasenia: " + contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(nombreUsuario, usuario.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreUsuario);
    }

}
