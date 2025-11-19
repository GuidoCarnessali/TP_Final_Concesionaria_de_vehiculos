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

    public boolean removeEmpleado(String dni) {
        if (empleados.containsKey(dni))
        {
            empleados.get(dni).setActivo(false);
            return true;
        }
        return false;
    }

    public void modifyEmpleado(String dniViejo) {
        Scanner scan = new Scanner(System.in);

        if (!empleados.containsKey(dniViejo)) {
            System.err.println("No hay ningún empleado con ese DNI");
            return;
        }

        Empleado e = empleados.get(dniViejo);

        System.out.println("Qué desea modificar?");
        System.out.println("1. Modificar todos los atributos");
        System.out.println("2. Nombre");
        System.out.println("3. Apellido");
        System.out.println("4. DNI");
        System.out.println("5. Salario");
        System.out.println("6. Puesto");
        System.out.println("7. Edad");
        System.out.println("8. Antigüedad");
        System.out.println("9. Email");
        System.out.println("10. Teléfono");
        System.out.println("11. Activo");

        int opcion = 0;
        while (true) {
            try {
                opcion = Integer.parseInt(scan.nextLine());
                if (opcion >= 1 && opcion <= 11) break;
                else System.out.println("Ingrese un número entre 1 y 11.");
            } catch (NumberFormatException ex) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }

        switch (opcion) {
            case 1:
                System.out.println("Modificar todos los atributos");

                String nombre;
                while (true) {
                    System.out.println("Ingrese el nombre del empleado: ");
                    nombre = scan.nextLine();
                    if (nombre.matches("[A-Za-z ]+")) break;
                    System.out.println("El nombre solo puede contener letras y espacios.");
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
                empleados.remove(e.getDni());
                e.setDni(dni);

                Double salario = null;
                while (salario == null) {
                    System.out.println("Ingrese el salario del empleado: ");
                    try {
                        double s = Double.parseDouble(scan.nextLine());
                        if (s > 0) salario = s;
                        else System.out.println("El salario debe ser mayor a 0.");
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
                    try {
                        int value = Integer.parseInt(scan.nextLine());
                        if (value > 0) edad = value;
                        else System.out.println("La edad debe ser mayor a 0.");
                    } catch (NumberFormatException ex) {
                        System.out.println("La edad debe ser un número entero positivo.");
                    }
                }
                e.setEdad(edad);

                Integer antiguedad = null;
                while (antiguedad == null) {
                    System.out.println("Ingrese la antigüedad del empleado (años): ");
                    try {
                        int value = Integer.parseInt(scan.nextLine());
                        if (value >= 0) antiguedad = value;
                        else System.out.println("La antigüedad debe ser mayor o igual a 0.");
                    } catch (NumberFormatException ex) {
                        System.out.println("Debe ingresar un número entero positivo.");
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

                empleados.put(e.getDni(), e);
                break;

            case 2:
                while (true) {
                    System.out.println("Ingrese el nombre del empleado: ");
                    String n = scan.nextLine();
                    if (n.matches("[A-Za-z ]+")) {
                        e.setNombre(n);
                        break;
                    } else System.out.println("El nombre solo puede contener letras y espacios.");
                }
                break;

            case 3:
                while (true) {
                    System.out.println("Ingrese el apellido del empleado: ");
                    String a = scan.nextLine();
                    if (a.matches("[A-Za-z ]+")) {
                        e.setApellido(a);
                        break;
                    } else System.out.println("El apellido solo puede contener letras y espacios.");
                }
                break;

            case 4:
                while (true) {
                    System.out.println("Ingrese el DNI del empleado: ");
                    String d = scan.nextLine();
                    if (d.matches("[0-9]+") && Integer.parseInt(d) > 0) {
                        empleados.remove(e.getDni());
                        e.setDni(d);
                        empleados.put(e.getDni(), e);
                        break;
                    } else System.out.println("El DNI debe ser un número entero positivo mayor a 0.");
                }
                break;

            case 5:
                Double s = null;
                while (s == null) {
                    System.out.println("Ingrese el salario del empleado: ");
                    try {
                        double val = Double.parseDouble(scan.nextLine());
                        if (val > 0) s = val;
                        else System.out.println("El salario debe ser mayor a 0.");
                    } catch (NumberFormatException ex) {
                        System.out.println("Debe ingresar un número decimal válido.");
                    }
                }
                e.setSalario(s);
                break;

            case 6:
                while (true) {
                    System.out.println("Ingrese el puesto del empleado: ");
                    String p = scan.nextLine();
                    if (p.matches("[A-Za-z ]+")) {
                        e.setPuesto(p);
                        break;
                    } else System.out.println("El puesto solo puede contener letras y espacios.");
                }
                break;

            case 7:
                Integer ed = null;
                while (ed == null) {
                    System.out.println("Ingrese la edad del empleado: ");
                    try {
                        int val = Integer.parseInt(scan.nextLine());
                        if (val > 0) ed = val;
                        else System.out.println("La edad debe ser mayor a 0.");
                    } catch (NumberFormatException ex) {
                        System.out.println("La edad debe ser un número entero positivo.");
                    }
                }
                e.setEdad(ed);
                break;

            case 8:
                Integer ant = null;
                while (ant == null) {
                    System.out.println("Ingrese la antigüedad del empleado: ");
                    try {
                        int val = Integer.parseInt(scan.nextLine());
                        if (val >= 0) ant = val;
                        else System.out.println("La antigüedad debe ser mayor o igual a 0.");
                    } catch (NumberFormatException ex) {
                        System.out.println("Debe ingresar un número entero positivo.");
                    }
                }
                e.setAntiguedad(ant);
                break;

            case 9:
                System.out.println("Ingrese el email del empleado: ");
                e.setEmail(scan.nextLine());
                break;

            case 10:
                while (true) {
                    System.out.println("Ingrese el teléfono del empleado: ");
                    String t = scan.nextLine();
                    if (t.matches("[0-9-]+")) {
                        e.setTelefono(t);
                        break;
                    } else System.out.println("El teléfono solo puede contener números y guiones.");
                }
                break;

            case 11:
                Boolean act = null;
                while (act == null) {
                    System.out.println("¿El empleado está activo? (true/false): ");
                    String input = scan.nextLine().toLowerCase();
                    if (input.equals("true")) act = true;
                    else if (input.equals("false")) act = false;
                    else System.out.println("Debe ingresar 'true' o 'false'.");
                }
                e.setActivo(act);
                break;
        }

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
