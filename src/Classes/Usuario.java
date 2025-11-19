package Classes;

import java.util.Objects;

public class Usuario {
    //Atributos
    private String nombreUsuario;
    private String contrasenia;
    private boolean activo = true;




    //constructor


    public Usuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.activo = true;
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


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    //Metodos
    @Override
    public String toString() {
        return "Nombre de usuario: " + nombreUsuario + "\n" +
                "Contrasenia: " + contrasenia + "\n" +
                "Activo: " + activo;
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
