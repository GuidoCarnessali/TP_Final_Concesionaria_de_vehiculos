package Classes;

public class Empleado {

    private String nombre;
    private String apellido;
    private String dni;
    private double salario;
    private String puesto;
    private int edad;
    private int antiguedad;
    private String email;
    private String telefono;
    private boolean activo;

    //Constructor
    public Empleado(String nombre, String apellido, String dni, double salario, String puesto, int edad, int antiguedad, String email, String telefono, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salario = salario;
        this.puesto = puesto;
        this.edad = edad;
        this.antiguedad = antiguedad;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
    }

    public Empleado()
    {}

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
       return "Empleado: " +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDNI: " + dni +
                "\nSalario: " + salario +
                "\nPuesto: " + puesto +
                "\nEdad: " + edad +
                "\nAntiguedad: " + antiguedad +
                "\nEmail: " + email +
                "\nTelefono: " + telefono;

    }



}
