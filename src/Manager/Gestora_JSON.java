package Manager;

import Classes.*;
import Enums.Marca;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.time.LocalDateTime;
import java.util.*;

public class Gestora_JSON {

    private final static String usuariosJSON = "usuarios.json";
    private final static String adminsJSON = "admins.json";
    private final static String vehiculosJSON = "vehiculos.json";
    private final static String clientesJSON = "clientes.json";
    private final static String empleadosJSON = "empleados.json";
    private final static String facturasJSON = "facturas.json";
    private final static String proveedoresJSON = "proveedores.json";


    public JSONObject serializarAuto(Auto a){

        JSONObject jsonObject = null;

        try{
            jsonObject = new JSONObject();
            jsonObject.put("marca", a.getMarca());
            jsonObject.put("modelo",a.getModelo());
            jsonObject.put("anio",a.getAnio());
            jsonObject.put("color", a.getColor());
            jsonObject.put("precio",a.getPrecio());
            jsonObject.put("stock", a.isEnStock());
            jsonObject.put("cilindrada", a.getCilindrada());
            jsonObject.put("puertas",a.getPuertas());
            jsonObject.put("combustible", a.getCombustible());


        }catch (JSONException e){
            e.printStackTrace();
        }


        return jsonObject;
    }

    public JSONObject serializarCamioneta (Camioneta a){
        JSONObject jsonObject = null;

        try{
            jsonObject = new JSONObject();
            jsonObject.put("marca", a.getMarca());
            jsonObject.put("modelo",a.getModelo());
            jsonObject.put("anio",a.getAnio());
            jsonObject.put("color", a.getColor());
            jsonObject.put("precio",a.getPrecio());
            jsonObject.put("stock", a.isEnStock());
            jsonObject.put("cilindrada", a.getCilindrada());
            jsonObject.put("puertas",a.getPuertas());
            jsonObject.put("combustible", a.getCombustible());
            jsonObject.put("largoCaja",a.getLargoCaja());
            jsonObject.put("anchoCaja",a.getAnchoCaja());



        }catch (JSONException e){
            e.printStackTrace();
        }


        return jsonObject;
    }

    public JSONObject serializarCamion (Camión a){
        JSONObject jsonObject = null;

        try{
            jsonObject = new JSONObject();
            jsonObject.put("marca", a.getMarca());
            jsonObject.put("modelo",a.getModelo());
            jsonObject.put("anio",a.getAnio());
            jsonObject.put("color", a.getColor());
            jsonObject.put("precio",a.getPrecio());
            jsonObject.put("stock", a.isEnStock());
            jsonObject.put("cilindrada", a.getCilindrada());
            jsonObject.put("puertas",a.getPuertas());
            jsonObject.put("combustible", a.getCombustible());
            jsonObject.put("largo",a.getLargoChasis());
            jsonObject.put("ancho",a.getAnchoChasis());

        }catch (JSONException e){
            e.printStackTrace();
        }


        return jsonObject;

    }

    public JSONObject serializarMoto (Moto a){
        JSONObject jsonObject = null;

        try{
            jsonObject = new JSONObject();
            jsonObject.put("marca", a.getMarca());
            jsonObject.put("modelo",a.getModelo());
            jsonObject.put("anio",a.getAnio());
            jsonObject.put("color", a.getColor());
            jsonObject.put("precio",a.getPrecio());
            jsonObject.put("stock", a.isEnStock());
            jsonObject.put("cilindrada", a.getCilindrada());
            jsonObject.put("pasajeros",a.getCapacidadPasajeros());

        }catch (JSONException e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    public JSONObject serializarCliente (Cliente c){
        JSONObject jsonObject = null;

        try{

            jsonObject = new JSONObject();
            jsonObject.put("nombre",c.getNombre());
            jsonObject.put("apellido",c.getApellido());
            jsonObject.put("dni",c.getDni());
            jsonObject.put("email",c.getEmail());
            jsonObject.put("telefono", c.getTelefono());
            jsonObject.put("sexo",c.getSexo());
            jsonObject.put("edad",c.getEdad());

        }catch (JSONException e){
            e.printStackTrace();
        }


        return jsonObject;
    }

    public JSONObject serializarEmpleado(Empleado c){
        JSONObject jsonObject = null;

        try {

            jsonObject = new JSONObject();
            jsonObject.put("nombre", c.getNombre());
            jsonObject.put("apellido", c.getApellido());
            jsonObject.put("dni", c.getDni());
            jsonObject.put("salario", c.getSalario());
            jsonObject.put("puesto", c.getPuesto());
            jsonObject.put("edad", c.getEdad());
            jsonObject.put("antiguedad", c.getAntiguedad());
            jsonObject.put("email", c.getEmail());
            jsonObject.put("telefono", c.getTelefono());
            jsonObject.put("activo", c.isActivo());

        }catch (JSONException e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    public JSONObject serializarFactura(Factura f) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject();
            jsonObject.put("numeroFactura", f.getNumeroFactura());
            jsonObject.put("fecha", f.getFecha().toString());
            jsonObject.put("montoTotal", f.getMontoTotal());
            jsonObject.put("cliente", serializarCliente(f.getCliente()));
            jsonObject.put("empleado", serializarEmpleado(f.getEmpleado()));


            Vehiculo v = f.getVehiculo();
            if (v instanceof Auto) {

                jsonObject.put("vehiculo", serializarAuto((Auto) v));
            } else if (v instanceof Camioneta) {

                jsonObject.put("vehiculo", serializarCamioneta((Camioneta) v));
            } else if (v instanceof Camión) {

                jsonObject.put("vehiculo", serializarCamion((Camión) v));
            } else if (v instanceof Moto) {

                jsonObject.put("vehiculo", serializarMoto((Moto) v));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public JSONObject serializarProveedor(Proveedor p){
        JSONObject jsonObject = null;
        try{
            jsonObject=new JSONObject();
            jsonObject.put("nombre",p.getNombre());
            jsonObject.put("empresa",p.getEmpresa());
            jsonObject.put("direccion",p.getDireccion());
            jsonObject.put("telefono",p.getTelefono());
            jsonObject.put("email",p.getEmail());
            jsonObject.put("marcaQueProvee",p.getMarcaQueProvee());
            jsonObject.put("activo",p.isActivo());
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }


     //Deserialización

    public Auto deserializarAuto(JSONObject jsonObject) {
        Auto a = new Auto();

        try {
            a.setMarca(Marca.valueOf(jsonObject.getString("marca")));
            a.setModelo(jsonObject.getString("modelo"));
            a.setAnio(jsonObject.getInt("anio"));
            a.setColor(jsonObject.getString("color"));
            a.setPrecio(jsonObject.getDouble("precio"));
            a.setEnStock(jsonObject.getBoolean("stock"));
            a.setCilindrada(jsonObject.getInt("cilindrada"));
            a.setPuertas(jsonObject.getInt("puertas"));
            a.setCombustible(jsonObject.getString("combustible"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return a;
    }

    public Camioneta deserializarCamioneta(JSONObject jsonObject) {
        Camioneta a = new Camioneta();

        try {
            a.setMarca(Marca.valueOf(jsonObject.getString("marca")));
            a.setModelo(jsonObject.getString("modelo"));
            a.setAnio(jsonObject.getInt("anio"));
            a.setColor(jsonObject.getString("color"));
            a.setPrecio(jsonObject.getDouble("precio"));
            a.setEnStock(jsonObject.getBoolean("stock"));
            a.setCilindrada(jsonObject.getInt("cilindrada"));
            a.setPuertas(jsonObject.getInt("puertas"));
            a.setCombustible(jsonObject.getString("combustible"));
            a.setLargoCaja(jsonObject.getDouble("largoCaja"));
            a.setAnchoCaja(jsonObject.getDouble("anchoCaja"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return a;
    }

    public Camión deserializarCamion(JSONObject jsonObject) {
        Camión a = new Camión();

        try {
            a.setMarca(Marca.valueOf(jsonObject.getString("marca")));
            a.setModelo(jsonObject.getString("modelo"));
            a.setAnio(jsonObject.getInt("anio"));
            a.setColor(jsonObject.getString("color"));
            a.setPrecio(jsonObject.getDouble("precio"));
            a.setEnStock(jsonObject.getBoolean("stock"));
            a.setCilindrada(jsonObject.getInt("cilindrada"));
            a.setPuertas(jsonObject.getInt("puertas"));
            a.setCombustible(jsonObject.getString("combustible"));
            a.setLargoChasis(jsonObject.getDouble("largo"));
            a.setAnchoChasis(jsonObject.getDouble("ancho"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return a;
    }

    public Moto deserializarMoto(JSONObject jsonObject) {
        Moto a = new Moto();

        try {
            a.setMarca(Marca.valueOf(jsonObject.getString("marca")));
            a.setModelo(jsonObject.getString("modelo"));
            a.setAnio(jsonObject.getInt("anio"));
            a.setColor(jsonObject.getString("color"));
            a.setPrecio(jsonObject.getDouble("precio"));
            a.setEnStock(jsonObject.getBoolean("stock"));
            a.setCilindrada(jsonObject.getInt("cilindrada"));
            a.setCapacidadPasajeros(jsonObject.getInt("pasajeros"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return a;
    }

    public Cliente deserializarCliente(JSONObject jsonObject) {
        Cliente c = new Cliente();

        try {
            c.setNombre(jsonObject.getString("nombre"));
            c.setApellido(jsonObject.getString("apellido"));
            c.setDni(jsonObject.getString("dni"));
            c.setEmail(jsonObject.getString("email"));
            c.setTelefono(jsonObject.getString("telefono"));
            c.setSexo(Character.valueOf(jsonObject.getString("sexo").charAt(0)));
            c.setEdad(jsonObject.getInt("edad"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return c;
    }

    public Empleado deserializarEmpleado(JSONObject jsonObject) {
        Empleado c = new Empleado();

        try {
            c.setNombre(jsonObject.getString("nombre"));
            c.setApellido(jsonObject.getString("apellido"));
            c.setDni(jsonObject.getString("dni"));
            c.setSalario(jsonObject.getDouble("salario"));
            c.setPuesto(jsonObject.getString("puesto"));
            c.setEdad(jsonObject.getInt("edad"));
            c.setAntiguedad(jsonObject.getInt("antiguedad"));
            c.setEmail(jsonObject.getString("email"));
            c.setTelefono(jsonObject.getString("telefono"));
            c.setActivo(jsonObject.getBoolean("activo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return c;
    }

    public Factura deserializarFactura(JSONObject jsonObject) {
        Factura f = new Factura();

        try {
            f.setNumeroFactura(jsonObject.getInt("numeroFactura"));
            f.setFecha(LocalDateTime.parse(jsonObject.getString("fecha")));
            f.setMontoTotal(jsonObject.getDouble("montoTotal"));
            f.setCliente(deserializarCliente(jsonObject.getJSONObject("cliente")));
            f.setEmpleado(deserializarEmpleado(jsonObject.getJSONObject("empleado")));

            JSONObject vehiculo = jsonObject.getJSONObject("vehiculo");

            if (vehiculo.has("largoCaja")) {
                f.setVehiculo(deserializarCamioneta(vehiculo));
            } else if (vehiculo.has("largoChasis")) {
                f.setVehiculo(deserializarCamion(vehiculo));
            } else if (vehiculo.has("pasajeros")) {
                f.setVehiculo(deserializarMoto(vehiculo));
            }else{
                f.setVehiculo(deserializarAuto(vehiculo));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return f;
    }

    public Proveedor deserializarProveedor(JSONObject jsonObject) {

        Proveedor p = new Proveedor();

        try {
            p.setNombre(jsonObject.getString("nombre"));
            p.setEmpresa(jsonObject.getString("empresa"));
            p.setDireccion(jsonObject.getString("direccion"));
            p.setTelefono(jsonObject.getString("telefono"));
            p.setEmail(jsonObject.getString("email"));
            p.setMarcaQueProvee(Marca.valueOf(jsonObject.getString("marcaQueProvee"))); // Asegúrate de que la enum Marca esté bien definida
            p.setActivo(jsonObject.getBoolean("activo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return p;
    }

    //
     //
     // Serializar Listas
    //listas: (clientes, empleados(activos e inactivos), facturas, proveedores y vehiculos)

    public JSONArray serializarListaClientes(HashMap<String, Cliente> clientes)
    {
            JSONArray jsonArray = null;

            try{
                jsonArray = new JSONArray();

                for (Map.Entry<String, Cliente> entry : clientes.entrySet()) {

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("dni", entry.getKey());

                    Cliente cliente = entry.getValue();
                    JSONObject clienteJson = serializarCliente(cliente);

                    jsonObject.put("cliente", clienteJson);
                    jsonArray.put(jsonObject);
                }
            }catch (JSONException e)
            {
                e.printStackTrace();
            }

            return jsonArray;
        }

    public JSONArray serializarListaEmpleados(Map<String, Empleado> empleados)
    {
        JSONArray jsonArray = null;

        try{
            jsonArray = new JSONArray();

            for (Map.Entry<String, Empleado> entry : empleados.entrySet()) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("dni", entry.getKey());

                Empleado empleado = entry.getValue();
                JSONObject empleadoJson = serializarEmpleado(empleado);

                jsonObject.put("empleado", empleadoJson);
                jsonArray.put(jsonObject);
            }
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public JSONArray serializarListaFacturas(Map<Integer, Factura> facturas) {

        JSONArray jsonArray = null;

        try{
            jsonArray = new JSONArray();

            for (Map.Entry<Integer, Factura> entry : facturas.entrySet()) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("numeroFactura", entry.getKey());

                Factura factura = entry.getValue();
                JSONObject facturaJson = serializarFactura(factura);

                jsonObject.put("factura", facturaJson);
                jsonArray.put(jsonObject);
            }
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public JSONArray serializarListaProveedores(List<Proveedor> proveedores) {

        JSONArray jsonArray = null;

        try{
            jsonArray = new JSONArray();

            for (Proveedor proveedor : proveedores) {

                JSONObject jsonObject = new JSONObject();
                JSONObject proveedorJson = serializarProveedor(proveedor);
                jsonObject.put("proveedor", proveedorJson);
                jsonArray.put(jsonObject);
            }
        }catch (JSONException e)
        {
            e.printStackTrace();
        }


        return jsonArray;
    }

    public JSONArray serializarListaVehiculos(Set<Vehiculo> vehiculos) {

        JSONArray jsonArray = null;

        try{
            jsonArray = new JSONArray();

            for (Vehiculo vehiculo : vehiculos) {

                JSONObject jsonObject = new JSONObject();

                if (vehiculo instanceof Auto) {
                    jsonObject.put("vehiculo", serializarAuto((Auto) vehiculo));
                } else if (vehiculo instanceof Camioneta) {
                    jsonObject.put("vehiculo", serializarCamioneta((Camioneta) vehiculo));
                } else if (vehiculo instanceof Camión) {
                    jsonObject.put("vehiculo", serializarCamion((Camión) vehiculo));
                } else if (vehiculo instanceof Moto) {
                    jsonObject.put("vehiculo", serializarMoto((Moto) vehiculo));
                }

                jsonArray.put(jsonObject);
            }
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonArray;
    }


     //Deserialización de listas

    public HashMap<String, Cliente> deserializarListaClientes(JSONArray jsonArray) {

        HashMap<String, Cliente> clientes = new HashMap<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String dni = jsonObject.getString("dni");
                JSONObject clienteJson = jsonObject.getJSONObject("cliente");
                Cliente cliente = deserializarCliente(clienteJson);
                clientes.put(dni, cliente);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public HashMap<String, Empleado> deserializarListaEmpleados(JSONArray jsonArray) {

        HashMap<String, Empleado> empleados = new HashMap<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String dni = jsonObject.getString("dni");
                JSONObject empleadoJson = jsonObject.getJSONObject("empleado");
                Empleado empleado = deserializarEmpleado(empleadoJson);
                empleados.put(dni, empleado);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public HashMap<Integer, Factura> deserializarListaFacturas(JSONArray jsonArray) {

        HashMap<Integer, Factura> facturas = new HashMap<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int numeroFactura = jsonObject.getInt("numeroFactura");
                JSONObject facturaJson = jsonObject.getJSONObject("factura");
                Factura factura = deserializarFactura(facturaJson);
                facturas.put(Integer.valueOf(numeroFactura), factura);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return facturas;
    }

    public List<Proveedor> deserializarListaProveedores(JSONArray jsonArray) {

        List<Proveedor> proveedores = new ArrayList<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject proveedorJson = jsonObject.getJSONObject("proveedor");
                Proveedor proveedor = deserializarProveedor(proveedorJson);
                proveedores.add(proveedor);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    public HashSet<Vehiculo> deserializarListaVehiculos(JSONArray jsonArray) {

        HashSet<Vehiculo> vehiculos = new HashSet<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject vehiculoJson = jsonObject.getJSONObject("vehiculo");

                if (vehiculoJson.has("largoCaja")) {
                    vehiculos.add(deserializarCamioneta(vehiculoJson));
                } else if (vehiculoJson.has("largoChasis")) {
                    vehiculos.add(deserializarCamion(vehiculoJson));
                } else if (vehiculoJson.has("pasajeros")) {
                    vehiculos.add(deserializarMoto(vehiculoJson));
                }else{
                    vehiculos.add(deserializarAuto(vehiculoJson));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    public JSONObject serializarUsuario (Usuario u){
        JSONObject jsonObject = null;

        try{

            jsonObject = new JSONObject();
            jsonObject.put("nombreUsuario", u.getNombreUsuario());
            jsonObject.put("contrasenia", u.getContrasenia());

        }catch (JSONException e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    public JSONObject serializarAdmin (Admin a){
        JSONObject jsonObject = null;

        try{

            jsonObject = new JSONObject();
            jsonObject.put("nombreAdmin", a.getNombreAdmin());
            jsonObject.put("contrasenia", a.getContrasenia());

        }catch (JSONException e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    public JSONArray serializarListaUsuarios (HashSet<Usuario> usuarios)
    {
        JSONArray jsonArray = null;

        try{

            jsonArray = new JSONArray();

            for (Usuario u : usuarios)
            {
                jsonArray.put(serializarUsuario(u));
            }
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public JSONArray serializarListaAdmins (HashSet<Admin> admins)
    {
        JSONArray jsonArray = null;

        try{

            jsonArray = new JSONArray();

            for (Admin a : admins)
            {
                jsonArray.put(serializarAdmin(a));
            }

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public Usuario deserializarUsuario (JSONObject jsonObject)
    {
        Usuario u = new Usuario();

        try{

            u.setNombreUsuario(jsonObject.getString("nombreUsuario"));
            u.setContrasenia(jsonObject.getString("contrasenia"));

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return u;
    }

    public Admin deserializarAdmin(JSONObject jsonObject)
    {
        Admin a = new Admin();

        try{

            a.setNombreAdmin(jsonObject.getString("nombreAdmin"));
            a.setContrasenia(jsonObject.getString("contrasenia"));

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return a;
    }

    public HashSet<Usuario> deserializarListaUsuarios (JSONArray jsonArray)
    {
        HashSet<Usuario> listaUsuarios = new HashSet<>();

        try{

            for(int i=0; i<jsonArray.length(); i++)
            {
                Usuario u = deserializarUsuario(jsonArray.getJSONObject(i));
                listaUsuarios.add(u);
            }


        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return listaUsuarios;
    }

    public HashSet<Admin> deserializarListaAdmins (JSONArray jsonArray)
    {
        HashSet<Admin> listaAdmins = new HashSet<>();

        try{

            for(int i=0; i<jsonArray.length(); i++)
            {
                Admin a = deserializarAdmin(jsonArray.getJSONObject(i));
                listaAdmins.add(a);
            }


        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return listaAdmins;
    }

    public void concesionariaToArchivo (Gestora_Usuario gestoraUsuario, Gestora_Factura gestoraFactura, Gestora_Vehiculo gestoraVehiculo, Gestora_Cliente gestoraCliente, Gestora_Empleado gestoraEmpleado, Gestora_Proveedor gestoraProveedor, Gestora_Admin gestoraAdmin)
    {
        OperacionLectoEscritura.writeFile(usuariosJSON, serializarListaUsuarios(gestoraUsuario.getListaUsuarios()));
        OperacionLectoEscritura.writeFile(adminsJSON, serializarListaAdmins(gestoraAdmin.getListaDeAdmins()));
        OperacionLectoEscritura.writeFile(vehiculosJSON, serializarListaVehiculos(gestoraVehiculo.getVehiculos()));
        OperacionLectoEscritura.writeFile(clientesJSON, serializarListaClientes(gestoraCliente.getClientes()));
        OperacionLectoEscritura.writeFile(empleadosJSON, serializarListaEmpleados(gestoraEmpleado.getEmpleados()));
        OperacionLectoEscritura.writeFile(facturasJSON, serializarListaFacturas(gestoraFactura.getFacturas()));
        OperacionLectoEscritura.writeFile(proveedoresJSON, serializarListaProveedores(gestoraProveedor.getProveedores()));


    }


    public void archivoToConcesionaria (Gestora_Usuario gestoraUsuario, Gestora_Factura gestoraFactura, Gestora_Vehiculo gestoraVehiculo, Gestora_Cliente gestoraCliente, Gestora_Empleado gestoraEmpleado, Gestora_Proveedor gestoraProveedor, Gestora_Admin gestoraAdmin)
    {
        JSONTokener jsonTokener1 = OperacionLectoEscritura.readFile(usuariosJSON);
        JSONTokener jsonTokener2 = OperacionLectoEscritura.readFile(adminsJSON);
        JSONTokener jsonTokener3 = OperacionLectoEscritura.readFile(vehiculosJSON);
        JSONTokener jsonTokener4 = OperacionLectoEscritura.readFile(clientesJSON);
        JSONTokener jsonTokener5 = OperacionLectoEscritura.readFile(empleadosJSON);
        JSONTokener jsonTokener6 = OperacionLectoEscritura.readFile(facturasJSON);
        JSONTokener jsonTokener7 = OperacionLectoEscritura.readFile(proveedoresJSON);

        try{

            gestoraUsuario.setListaUsuarios(deserializarListaUsuarios(new JSONArray(jsonTokener1)));
            gestoraAdmin.setListaDeAdmins(deserializarListaAdmins(new JSONArray(jsonTokener2)));
            gestoraVehiculo.setVehiculos(deserializarListaVehiculos(new JSONArray(jsonTokener3)));
            gestoraCliente.setClientes(deserializarListaClientes(new JSONArray(jsonTokener4)));
            gestoraEmpleado.setEmpleados(deserializarListaEmpleados(new JSONArray(jsonTokener5)));
            gestoraFactura.setFacturas(deserializarListaFacturas(new JSONArray(jsonTokener6)));
            gestoraProveedor.setProveedores(deserializarListaProveedores(new JSONArray(jsonTokener7)));


        }catch (JSONException e){
            e.printStackTrace();
        }



    }
}


