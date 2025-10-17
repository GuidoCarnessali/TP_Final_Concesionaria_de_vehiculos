package Manager;

import Classes.Empleado;

import java.util.HashMap;
import java.util.Map;

public class Gestora_Empleado {

    //Atributos
    private Map<String, Empleado> empleados;             //Hacerlo Hashmap (dni, empleado) ya que no importa el orden y no se repiten
    private Map<String, Empleado> empleadosInactivos;    //Hacerlo Hashmap (dni, empleado) ya que no importa el orden y no se repiten

    //Constructor
    public Gestora_Empleado() {
        this.empleados = new HashMap<>();
        this.empleadosInactivos = new HashMap<>();
    }

    //Getters
    public Map<String, Empleado> getEmpleados() {
        return empleados;
    }

    public Map<String, Empleado> getEmpleadosInactivos() {
        return empleadosInactivos;
    }

    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Empleado
    public boolean addEmpleado(Empleado e)
    {
        if (e != null && !empleados.containsKey(e.getDni())) //Si el empleado no es nulo y no está en la lista de empleados según el dni lo agrego
        {
            empleados.put(e.getDni(), e);                   //Agrego el empleado al mapa con su dni como key y el empleado como valor
            return true;
        }
        return false;
    }

    public boolean removeEmpleado(Empleado e)
    {
        if(e != null && empleados.containsKey(e.getDni())) //Si el empleado no es nulo y está en la lista de empleados según el dni lo elimino
        {
            empleados.remove(e.getDni());                   //Elimino el empleado del mapa según su dni
            empleadosInactivos.put(e.getDni(), e);         //Agrego el empleado a la lista de empleados inactivos
            e.setActivo(false);
            return true;
        }
        return false;
    }

    public void modifyEmpleado(Empleado e, String nombre, String apellido, String dni, double salario, String puesto, int edad, int antiguedad, String email, String telefono, boolean activo)
    {
        if(e != null && empleados.containsKey(e.getDni())) //Si el empleado no es nulo y está en la lista de empleados según el dni lo modifico
        {
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setDni(dni);
            e.setSalario(salario);
            e.setPuesto(puesto);
            e.setEdad(edad);
            e.setAntiguedad(antiguedad);
            e.setEmail(email);
            e.setTelefono(telefono);
            e.setActivo(activo);
        }
    }

    public Empleado searchEmpleado(Empleado e)
    {
        if(e != null && empleados.containsKey(e.getDni())) //Si el empleado no es nulo y está en la lista de empleados según el dni lo devuelvo
        {
            return empleados.get(e.getDni());              //Devuelvo el empleado del mapa según su dni
        }
        return null;
    }

    public void showEmpleados()
    {
        for(Empleado e : empleados.values())              //Recorro el mapa de empleados y muestro los valores (empleados)
        {
            System.out.println("--------------------");
            System.out.println(e.toString());
        }
    }













}
