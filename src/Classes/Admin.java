package Classes;

import java.util.Objects;

public class Admin {

    private String nombreAdmin;
    private String contrasenia;

    private boolean activo = true;

    public Admin(String nombreAdmin, String contrasenia, boolean activo) {
        this.nombreAdmin = nombreAdmin;
        this.contrasenia = contrasenia;
        this.activo = activo;
    }

    public Admin(String nombreAdmin, String contrasenia) {
        this.nombreAdmin = nombreAdmin;
        this.contrasenia = contrasenia;
        this.activo = true;
    }


    public Admin() {
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
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

    @Override
    public String toString() {
        return "Nombre de admin:" + nombreAdmin + "\n" +
                "Contrasenia:" + contrasenia + "\n" +
                "Activo: " + activo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Admin admin)) return false;
        return Objects.equals(nombreAdmin, admin.nombreAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreAdmin);
    }
}
