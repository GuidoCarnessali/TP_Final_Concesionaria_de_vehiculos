import java.util.*;

public class Concesionaria {

    //Atributos
    private Map<String, Empleado> empleados;             //Hacerlo Hashmap (dni, empleado) ya que no importa el orden y no se repiten
    private Map<String, Empleado> empleadosInactivos;    //Hacerlo Hashmap (dni, empleado) ya que no importa el orden y no se repiten

    private Map<String, Cliente> clientes;               //Hacerlo Hashmap (dni, cliente) ya que no importa el orden y no se repiten

    private List<Proveedor> proveedores;                //Hacerlo arraylist ya que no importa el orden y no se repiten
    private List<Proveedor> proveedoresInactivos;       //Hacerlo arraylist ya que no importa el orden y no se repiten


    private Set<Vehiculo> vehiculos;                    //Hacerlo Hashset ya que no importa el orden y no se repiten
    private Set<Vehiculo> noStockVehiculos;             //Hacerlo Hashset ya que no importa el orden y no se repiten

    private Map<Integer, Factura> facturas;               //Hacerlo TreeMap (numeroFactura, factura) ya que importa el orden (Ordenación) y no se repiten




    //Constructor

    public Concesionaria() {
        this.empleados = new HashMap<>();
        this.empleadosInactivos = new HashMap<>();
        this.clientes = new HashMap<>();
        this.proveedores = new ArrayList<>();
        this.proveedoresInactivos = new ArrayList<>();
        this.vehiculos = new HashSet<>();
        this.noStockVehiculos = new HashSet<>();
        this.facturas = new TreeMap<>();
    }

    //Getters

    public Map<String, Empleado> getEmpleados() {
        return empleados;
    }

    public Map<String, Empleado> getEmpleadosInactivos() {
        return empleadosInactivos;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public List<Proveedor> getProveedoresInactivos() {
        return proveedoresInactivos;
    }

    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Set<Vehiculo> getNoStockVehiculos() {
        return noStockVehiculos;
    }

    public Map<Integer, Factura> getFacturas() {
        return facturas;
    }

    //Métodos

    //-----------------AMBCL-----------------
    //Vehículos
    public boolean addVehiculo(Vehiculo v)
    {
        if(v != null) //Si el vehículo no es nulo lo agrego a la lista de vehículos en stock
        {
            vehiculos.add(v);
            return true;
        }
        return false;


    }

    public boolean removeVehiculo(Vehiculo v)
    {
        if(v != null && vehiculos.contains(v))  //Si el vehículo no es nulo y está en la lista de vehículos en stock lo elimino
        {                                       //Ademas lo paso a la lista de vehículos no en stock
            vehiculos.remove(v);
            noStockVehiculos.add(v);
            v.setEnStock(false);
            return true;
        }
        return false;
    }

    public void modifyVehiculo(Vehiculo v, Marca marca, String modelo, int anio, String color, String precio, boolean enStock)
    {
        if(v != null && vehiculos.contains(v)) //Si el vehículo no es nulo y está en la lista de vehículos en stock lo modifico
        {
            v.setMarca(marca);
            v.setModelo(modelo);
            v.setAnio(anio);
            v.setColor(color);
            v.setPrecio(precio);
            v.setEnStock(enStock);
        }
    }

    public Vehiculo searchVehiculo(Vehiculo v)
    {
        if(v != null && vehiculos.contains(v)) //Si el vehículo no es nulo y está en la lista de vehículos en stock lo devuelvo
        {
            return v;
        }

        return null;

    }

    public void showVehiculos()
    {
        for(Vehiculo v : vehiculos)
        {
            System.out.println(v);
        }
    }


    //Clientes
    public boolean addCliente(Cliente c)
    {
        if(c != null && !clientes.containsKey(c.getDni())) //Si el cliente no es nulo y no está en la lista de clientes según el dni lo agrego
        {
            clientes.put(c.getDni(), c);                   //Agrego el cliente al mapa con su dni como key y el cliente como valor
            return true;
        }

        return false;
    }

    public boolean removeCliente (Cliente c)
    {
        if(c != null && clientes.containsKey(c.getDni())) //Si el cliente no es nulo y está en la lista de clientes según el dni lo elimino
        {
            clientes.remove(c.getDni());                   //Elimino el cliente del mapa según su dni
            return true;
        }

        return false;
    }

    public void modifyCliente(Cliente c, String nombre, String apellido, String dni, String email, String telefono, boolean activo)
    {
        if(c != null && clientes.containsKey(c.getDni())) //Si el cliente no es nulo y está en la lista de clientes según el dni lo modifico
        {
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setDni(dni);
            c.setEmail(email);
            c.setTelefono(telefono);
        }
    }

    public Cliente searchCliente(Cliente c)
    {
        if(c != null && clientes.containsKey(c.getDni())) //Si el cliente no es nulo y está en la lista de clientes según el dni lo devuelvo
        {
            return clientes.get(c.getDni());              //Devuelvo el cliente del mapa según su dni
        }

        return null;
    }

    public void showClientes()
    {
        for(Cliente c : clientes.values())               //Recorro el mapa de clientes y muestro los valores (clientes)
        {
            System.out.println(c.showCliente());
        }
    }

    //Empleados
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
            System.out.println(e.showEmpleado());
        }
    }

    //Proveedores
    public boolean addProveedor(Proveedor p)
    {
        if(p != null && !proveedores.contains(p)) //Si el proveedor no es nulo y no está en la lista de proveedores lo agrego
        {
            proveedores.add(p);                   //Agrego el proveedor a la lista
            p.setActivo(true);
            return true;
        }
        return false;
    }

    public boolean removeProveedor(Proveedor p)
    {
        if(p != null && proveedores.contains(p)) //Si el proveedor no es nulo y está en la lista de proveedores lo elimino
        {
            proveedores.remove(p);               //Elimino el proveedor de la lista
            proveedoresInactivos.add(p);        //Agrego el proveedor a la lista de proveedores inactivos
            p.setActivo(false);
            return true;
        }
        return false;
    }

    public void modifyProveedor(Proveedor p, String nombre, String empresa, String direccion, String telefono, String email, Marca marcaQueProvee, boolean activo)
    {
        if(p != null && proveedores.contains(p)) //Si el proveedor no es nulo y está en la lista de proveedores lo modifico
        {
            p.setNombre(nombre);
            p.setEmpresa(empresa);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            p.setEmail(email);
            p.setMarcaQueProvee(marcaQueProvee);
            p.setActivo(activo);
        }
    }

    public Proveedor searchProveedor(Proveedor p)
    {
        if(p != null && proveedores.contains(p)) //Si el proveedor no es nulo y está en la lista de proveedores lo devuelvo
        {
            return p;
        }
        return null;
    }

    public void showProveedores()
    {
        for(Proveedor p : proveedores)            //Recorro la lista de proveedores y muestro los proveedores
        {
            System.out.println(p.showProveedor());
        }
    }

    //Facturas
    public boolean addFactura(Factura f)
    {
        if(f != null && !facturas.containsKey(f.getNumeroFactura())) //Si la factura no es nula y no está en la lista de facturas según el número de factura lo agrego
        {
            facturas.put(f.getNumeroFactura(), f);                   //Agrego la factura al mapa con su número de factura como key y la factura como valor
            return true;
        }
        return false;
    }

    //Se pueden eliminar facturas, aunque no le vemos un uso cotidiano
    public boolean removeFactura(Factura f)
    {
        if(f != null && facturas.containsKey(f.getNumeroFactura())) //Si la factura no es nula y está en la lista de facturas según el número de factura lo elimino
        {
            facturas.remove(f.getNumeroFactura());                   //Elimino la factura del mapa según su número de factura
            return true;
        }
        return false;
    }

    //No hicimos la modificación de facturas, ya que no le vemos un uso cotidiano a eso



    public Factura searchFactura(Factura f)
    {
        if(f != null && facturas.containsKey(f.getNumeroFactura())) //Si la factura no es nula y está en la lista de facturas según el número de factura lo devuelvo
        {
            return facturas.get(f.getNumeroFactura());              //Devuelvo la factura del mapa según su número de factura
        }
        return null;
    }

    public void showFacturas()
    {

        for (Factura f : facturas.values())
        {
            System.out.println("-------------------");
            System.out.println(f.showFactura());
        }

    }




}
