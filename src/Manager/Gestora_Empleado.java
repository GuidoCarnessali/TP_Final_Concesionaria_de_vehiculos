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

        if (!empleados.containsKey(dniViejo)) {
            System.err.println("No hay ningún empleado con ese DNI");
            return;
        }

        empleados.remove(dniViejo);

        String nombre;
        while (true) {
            System.out.println("Ingrese el nombre del empleado: ");
            nombre = scan.nextLine();
            if (nombre.matches("[A-Za-z ]+")) break;
            System.out.println(" El nombre solo puede contener letras y espacios.");
        }
        e.setNombre(nombre);

        String apellido;
        while (true) {
            System.out.println("Ingrese el apellido del empleado: ");
            apellido = scan.nextLine();
            if (apellido.matches("[A-Za-z ]+")) break;
            System.out.println("El apellido solo puede contener letras y espacios.");
        }
        e.setApellido(apellido);

        String dni;
        while (true) {
            System.out.println("Ingrese el DNI del empleado: ");
            dni = scan.nextLine();
            if (dni.matches("[0-9]+") && Integer.parseInt(dni) > 0) break;
            System.out.println("El DNI debe ser un número entero positivo mayor a 0.");
        }
        e.setDni(dni);

        Double salario = null;
        while (salario == null) {
            System.out.println("Ingrese el salario del empleado: ");
            String input = scan.nextLine();
            try {
                double s = Double.parseDouble(input);
                if (s > 0) {
                    salario = s;
                } else {
                    System.out.println("El salario debe ser un número mayor a 0.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Debe ingresar un número decimal válido.");
            }
        }
        e.setSalario(salario);

        String puesto;
        while (true) {
            System.out.println("Ingrese el puesto del empleado: ");
            puesto = scan.nextLine();
            if (puesto.matches("[A-Za-z ]+")) break;
            System.out.println("El puesto solo puede contener letras y espacios.");
        }
        e.setPuesto(puesto);

        Integer edad = null;
        while (edad == null) {
            System.out.println("Ingrese la edad del empleado: ");
            String input = scan.nextLine();
            if (input.matches("[0-9]+")) {
                int value = Integer.parseInt(input);
                if (value > 0) edad = value;
                else System.out.println("La edad debe ser mayor a 0.");
            } else {
                System.out.println("La edad debe ser un número entero positivo.");
            }
        }
        e.setEdad(edad);

        Integer antiguedad = null;
        while (antiguedad == null) {
            System.out.println("Ingrese la antigüedad del empleado (en años): ");
            String input = scan.nextLine();
            if (input.matches("[0-9]+")) {
                int value = Integer.parseInt(input);
                if (value >= 0) antiguedad = value;
                else System.out.println("La antigüedad debe ser mayor o igual a 0.");
            } else {
                System.out.println("Debe ingresar un número entero positivo.");
            }
        }
        e.setAntiguedad(antiguedad);


        // --- EMAIL ---
        System.out.println("Ingrese el email del empleado: ");
        e.setEmail(scan.nextLine());

        String telefono;
        while (true) {
            System.out.println("Ingrese el teléfono del empleado: ");
            telefono = scan.nextLine();
            if (telefono.matches("[0-9-]+")) break;
            System.out.println("El teléfono solo puede contener números y guiones.");
        }
        e.setTelefono(telefono);

        Boolean activo = null;
        while (activo == null) {
            System.out.println("¿El empleado está activo? (true/false): ");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("true")) activo = true;
            else if (input.equals("false")) activo = false;
            else System.out.println("Debe ingresar 'true' o 'false'.");
        }
        e.setActivo(activo);


        // --- GUARDAR ---
        empleados.put(e.getDni(), e);
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

    public void crearEmpleado()
    {
        Scanner scan = new Scanner(System.in);
        Empleado e = new Empleado();

        String nombre;
        while (true) {
            System.out.println("Ingrese el nombre del empleado: ");
            nombre = scan.nextLine();
            if (nombre.matches("[A-Za-z ]+")) break;
            System.err.println("El nombre solo puede contener letras y espacios.");
        }
        e.setNombre(nombre);

        String apellido;
        while (true) {
            System.out.println("Ingrese el apellido del empleado: ");
            apellido = scan.nextLine();
            if (apellido.matches("[A-Za-z ]+")) break;
            System.err.println("El apellido solo puede contener letras y espacios.");
        }
        e.setApellido(apellido);

        String dni;
        while (true) {
            System.out.println("Ingrese el DNI del empleado: ");
            dni = scan.nextLine();
            if (dni.matches("[0-9]+") && Integer.parseInt(dni) > 0) break;
            System.err.println("El DNI debe ser un número entero positivo mayor a 0.");
        }
        e.setDni(dni);

        Double salario = null;
        while (salario == null) {
            System.out.println("Ingrese el salario del empleado: ");
            String input = scan.nextLine();
            try {
                double s = Double.parseDouble(input);
                if (s > 0) salario = s;
                else System.err.println("El salario debe ser mayor a 0.");
            } catch (NumberFormatException ex) {
                System.err.println("Ingrese un número decimal válido.");
            }
        }
        e.setSalario(salario);

        String puesto;
        while (true) {
            System.out.println("Ingrese el puesto del empleado: ");
            puesto = scan.nextLine();
            if (puesto.matches("[A-Za-z ]+")) break;
            System.err.println("El puesto solo puede contener letras y espacios.");
        }
        e.setPuesto(puesto);

        Integer edad = null;
        while (edad == null) {
            System.out.println("Ingrese la edad del empleado: ");
            String input = scan.nextLine();
            if (input.matches("[0-9]+")) {
                int value = Integer.parseInt(input);
                if (value > 0) edad = value;
                else System.err.println("La edad debe ser mayor a 0.");
            } else {
                System.err.println("La edad debe ser un número entero positivo.");
            }
        }
        e.setEdad(edad);

        Integer antiguedad = null;
        while (antiguedad == null) {
            System.out.println("Ingrese la antigüedad del empleado (en años): ");
            String input = scan.nextLine();
            if (input.matches("[0-9]+")) {
                int value = Integer.parseInt(input);
                if (value >= 0) antiguedad = value;
                else System.err.println("La antigüedad debe ser mayor o igual a 0.");
            } else {
                System.err.println("Debe ingresar un número entero positivo.");
            }
        }
        e.setAntiguedad(antiguedad);

        System.out.println("Ingrese el email del empleado: ");
        e.setEmail(scan.nextLine());

        String telefono;
        while (true) {
            System.out.println("Ingrese el teléfono del empleado: ");
            telefono = scan.nextLine();
            if (telefono.matches("[0-9-]+")) break;
            System.err.println("El teléfono solo puede contener números y guiones.");
        }
        e.setTelefono(telefono);

        Boolean activo = null;
        while (activo == null) {
            System.out.println("¿El empleado está activo? (true/false): ");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("true")) activo = true;
            else if (input.equals("false")) activo = false;
            else System.err.println("Debe ingresar 'true' o 'false'.");
        }
        e.setActivo(activo);

        addEmpleado(e);
        System.out.println("Empleado creado correctamente.");
    }
















}
