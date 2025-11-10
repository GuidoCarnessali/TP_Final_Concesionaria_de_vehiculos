package Manager;

import java.util.Objects;

public class Admin {

    private String nombreAdmin;
    private String contrasenia;

    public Admin(String nombreAdmin, String contrasenia) {
        this.nombreAdmin = nombreAdmin;
        this.contrasenia = contrasenia;
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
