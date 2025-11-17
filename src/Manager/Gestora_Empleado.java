package Manager;

import Classes.Empleado;
import Classes.Factura;

import java.util.*;

public class Gestora_Empleado {

    //Atributos
    private Map<String, Empleado> empleados;             //Hacerlo Hashmap (dni, empleado) ya que no importa el orden y no se repite

    //Constructor
    public Gestora_Empleado() {
        this.empleados = new HashMap<>();
    }

    //Getters
    public Map<String, Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Map<String, Empleado> empleados) {
        this.empleados = empleados;
    }

    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Empleado
    public boolean addEmpleado(Empleado e) {
        if (e != null && empleados.containsKey(e.getDni())) //Si el empleado no es nulo y no está en la lista de empleados según el dni lo agrego
        {
            if(e.isActivo() == false)
            {
                empleados.get(e.getDni()).setActivo(true);
                return true;
            }

        }else if(e != null && !empleados.containsKey(e.getDni()))
        {
            empleados.put(e.getDni(), e);
            return true;
        }
        return false;
    }

    public boolean removeEmpleado(Empleado e) {
        if (e != null && empleados.containsKey(e.getDni())) //Si el empleado no es nulo y está en la lista de empleados según el dni lo elimino
        {
            empleados.get(e.getDni()).setActivo(false);
            return true;
        }
        return false;
    }

    public void modifyEmpleado(String dniViejo)
    {
        Scanner scan = new Scanner(System.in);
        Empleado e = new Empleado();

        if (empleados.containsKey(dniViejo)) {


            empleados.remove(dniViejo);

            System.out.println("Ingrese el nombre del empleado: ");
            e.setNombre(scan.nextLine());
            System.out.println("Ingrese el apellido del empleado: ");
            e.setApellido(scan.nextLine());
            System.out.println("Ingrese el DNI del empleado: ");
            e.setDni(scan.nextLine());
            System.out.println("Ingrese el salario del empleado: ");
            e.setSalario(scan.nextDouble());
            scan.nextLine();
            System.out.println("Ingrese el puesto del empleado: ");
            e.setPuesto(scan.nextLine());
            System.out.println("Ingrese la edad del empleado: ");
            e.setEdad(scan.nextInt());
            scan.nextLine();
            System.out.println("Ingrese la antigüedad del empleado (en años): ");
            e.setAntiguedad(scan.nextInt());
            scan.nextLine();
            System.out.println("Ingrese el email del empleado: ");
            e.setEmail(scan.nextLine());
            System.out.println("Ingrese el teléfono del empleado: ");
            e.setTelefono(scan.nextLine());
            System.out.println("¿El empleado está activo? (true/false): ");
            e.setActivo(scan.nextBoolean());
            scan.nextLine();

            empleados.put(e.getDni(), e);
        }else {
            System.err.println("No hay ningun empleado con ese DNI");
        }
    }



    public String searchEmpleado(String dni) {
        if (empleados.containsKey(dni))
        {
            return empleados.get(dni).toString();
        }
        return "No se ha encontrado un empleado con ese DNI";
    }

    public void showEmpleados() {
        for (Empleado e : empleados.values())              //Recorro el mapa de empleados y muestro los valores (empleados)
        {
            System.out.println("--------------------");
            System.out.println(e.toString());
        }
    }


    public void listaDeserializadaToEmpleados (Map<String, Empleado> empleadosB) {

        empleados.putAll(empleadosB);

    }

    public void showEmpleadosActivos() {
        for (Empleado e : empleados.values())              //Recorro el mapa de empleados y muestro los valores (empleados)
        {
            if(e.isActivo()){

                System.out.println("--------------------");
                System.out.println(e.toString());
            }

        }
    }


    public void showEmpleadosInactivos() {
        for (Empleado e : empleados.values())              //Recorro el mapa de empleados y muestro los valores (empleados)
        {
            if(!e.isActivo()){

                System.out.println("--------------------");
                System.out.println(e.toString());
            }

        }
    }

    public Empleado obtenerEmpleadoRandom()
    {

        List<Empleado> lista = new ArrayList<>(empleados.values());

        Random random = new Random();
        int index = random.nextInt(lista.size());

        return lista.get(index);
    }

    public void crearEmpleado ()
    {
        Scanner scan = new Scanner(System.in);

        Empleado e = new Empleado();
        System.out.println("Ingrese el nombre del empleado: ");
        e.setNombre(scan.nextLine());
        System.out.println("Ingrese el apellido del empleado: ");
        e.setApellido(scan.nextLine());
        System.out.println("Ingrese el DNI del empleado: ");
        e.setDni(scan.nextLine());
        System.out.println("Ingrese el salario del empleado: ");
        e.setSalario(scan.nextDouble());
        scan.nextLine();
        System.out.println("Ingrese el puesto del empleado: ");
        e.setPuesto(scan.nextLine());
        System.out.println("Ingrese la edad del empleado: ");
        e.setEdad(scan.nextInt());
        scan.nextLine();
        System.out.println("Ingrese la antigüedad del empleado (en años): ");
        e.setAntiguedad(scan.nextInt());
        scan.nextLine();
        System.out.println("Ingrese el email del empleado: ");
        e.setEmail(scan.nextLine());
        System.out.println("Ingrese el teléfono del empleado: ");
        e.setTelefono(scan.nextLine());
        e.setActivo(true);

        addEmpleado(e);
    }
















}
