package Classes;

import Enums.Marca;

public class Proveedor {

    //Atributos
    private String nombre;
    private String empresa;
    private String direccion;
    private String telefono;
    private String email;
    private Marca marcaQueProvee;
    private boolean activo;

    //Constructor
    public Proveedor(String nombre, String empresa, String direccion, String telefono, String email, Marca marcaQueProvee, boolean activo) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.marcaQueProvee = marcaQueProvee;
        this.activo = activo;
    }

    public Proveedor()
    {}

    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Marca getMarcaQueProvee() {
        return marcaQueProvee;
    }

    public void setMarcaQueProvee(Marca marcaQueProvee) {
        this.marcaQueProvee = marcaQueProvee;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    //Métodos

    public String toString()
    {
       return "Proveedor: " +
                "\nNombre: " + nombre +
                "\nEmpresa: " + empresa +
                "\nDirección: " + direccion +
                "\nTeléfono: " + telefono +
                "\nEmail: " + email +
                "\nMarca que provee: " + marcaQueProvee +
                "\nActivo: " + activo;
    }



}
