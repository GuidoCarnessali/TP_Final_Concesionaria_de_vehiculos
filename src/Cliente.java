public class Cliente {

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private Character sexo;
    private int edad;

    //Constructor


    public Cliente(String nombre, String apellido, String dni, String email, String telefono, Character sexo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.sexo = sexo;
        this.edad = edad;
    }

    public Cliente()
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

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String showCliente() {

        return "Cliente: " +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDNI: " + dni +
                "\nEmail: " + email +
                "\nTelefono: " + telefono +
                "\nSexo: " + sexo +
                "\nEdad: " + edad;
    }

    //Métodos

}
