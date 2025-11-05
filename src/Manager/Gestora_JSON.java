package Manager;

import Classes.*;
import Enums.Marca;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.*;

public class Gestora_JSON {

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

    public JSONObject serializarmoto (Moto a){
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

                jsonObject.put("vehiculo", serializarmoto((Moto) v));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


    private String nombre;
    private String empresa;
    private String direccion;
    private String telefono;
    private String email;
    private Marca marcaQueProvee;
    private boolean activo;

    //Constructor

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


    //
     //
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
            c.setSexo(jsonObject.getString("sexo").charAt(0));
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
            JSONArray jsonArray = new JSONArray();

            for (Map.Entry<String, Cliente> entry : clientes.entrySet()) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("dni", entry.getKey());

                Cliente cliente = entry.getValue();
                JSONObject clienteJson = serializarCliente(cliente);

                jsonObject.put("cliente", clienteJson);
                jsonArray.put(jsonObject);
            }

            return jsonArray;
        }

    public JSONArray serializarListaEmpleados(Map<String, Empleado> empleados)
    {
        JSONArray jsonArray = new JSONArray();

        for (Map.Entry<String, Empleado> entry : empleados.entrySet()) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("dni", entry.getKey());

            Empleado empleado = entry.getValue();
            JSONObject empleadoJson = serializarEmpleado(empleado);

            jsonObject.put("empleado", empleadoJson);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }


    public JSONArray serializarListaEmpleadosInactivos(Map<String, Empleado> empleadosInactivos) {

        JSONArray jsonArray = new JSONArray();

        for (Map.Entry<String, Empleado> entry : empleadosInactivos.entrySet()) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("dni", entry.getKey());

            Empleado empleado = entry.getValue();
            JSONObject empleadoJson = serializarEmpleado(empleado);

            jsonObject.put("empleado", empleadoJson);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray serializarListaFacturas(Map<Integer, Factura> facturas) {

        JSONArray jsonArray = new JSONArray();

        for (Map.Entry<Integer, Factura> entry : facturas.entrySet()) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("numeroFactura", entry.getKey());

            Factura factura = entry.getValue();
            JSONObject facturaJson = serializarFactura(factura);

            jsonObject.put("factura", facturaJson);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray serializarListaProveedores(List<Proveedor> proveedores) {

        JSONArray jsonArray = new JSONArray();

        for (Proveedor proveedor : proveedores) {

            JSONObject jsonObject = new JSONObject();
            JSONObject proveedorJson = serializarProveedor(proveedor);
            jsonObject.put("proveedor", proveedorJson);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray serializarListaProveedoresInactivos(List<Proveedor> proveedoresInactivos) {

        JSONArray jsonArray = new JSONArray();

        for (Proveedor proveedor : proveedoresInactivos) {

            JSONObject jsonObject = new JSONObject();
            JSONObject proveedorJson = serializarProveedor(proveedor);
            jsonObject.put("proveedor", proveedorJson);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray serializarListaVehiculos(Set<Vehiculo> vehiculos) {

        JSONArray jsonArray = new JSONArray();

        for (Vehiculo vehiculo : vehiculos) {

            JSONObject jsonObject = new JSONObject();

            if (vehiculo instanceof Auto) {
                jsonObject.put("vehiculo", serializarAuto((Auto) vehiculo));
            } else if (vehiculo instanceof Camioneta) {
                jsonObject.put("vehiculo", serializarCamioneta((Camioneta) vehiculo));
            } else if (vehiculo instanceof Camión) {
                jsonObject.put("vehiculo", serializarCamion((Camión) vehiculo));
            } else if (vehiculo instanceof Moto) {
                jsonObject.put("vehiculo", serializarmoto((Moto) vehiculo));
            }

            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray serializarListaNoStockVehiculos(Set<Vehiculo> noStockVehiculos) {

        JSONArray jsonArray = new JSONArray();

        for (Vehiculo vehiculo : noStockVehiculos) {

            JSONObject jsonObject = new JSONObject();

            if (vehiculo instanceof Auto) {
                jsonObject.put("vehiculo", serializarAuto((Auto) vehiculo));
            } else if (vehiculo instanceof Camioneta) {
                jsonObject.put("vehiculo", serializarCamioneta((Camioneta) vehiculo));
            } else if (vehiculo instanceof Camión) {
                jsonObject.put("vehiculo", serializarCamion((Camión) vehiculo));
            } else if (vehiculo instanceof Moto) {
                jsonObject.put("vehiculo", serializarmoto((Moto) vehiculo));
            }

            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    //
     //
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

    public Map<String, Empleado> deserializarListaEmpleados(JSONArray jsonArray) {

        Map<String, Empleado> empleados = new HashMap<>();

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

    public Map<String, Empleado> deserializarListaEmpleadosInactivos(JSONArray jsonArray) {

        Map<String, Empleado> empleadosInactivos = new HashMap<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String dni = jsonObject.getString("dni");
                JSONObject empleadoJson = jsonObject.getJSONObject("empleado");
                Empleado empleado = deserializarEmpleado(empleadoJson);
                empleadosInactivos.put(dni, empleado);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return empleadosInactivos;
    }

    public Map<Integer, Factura> deserializarListaFacturas(JSONArray jsonArray) {

        Map<Integer, Factura> facturas = new HashMap<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int numeroFactura = jsonObject.getInt("numeroFactura");
                JSONObject facturaJson = jsonObject.getJSONObject("factura");
                Factura factura = deserializarFactura(facturaJson);
                facturas.put(numeroFactura, factura);
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

    public List<Proveedor> deserializarListaProveedoresInactivos(JSONArray jsonArray) {

        List<Proveedor> proveedoresInactivos = new ArrayList<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject proveedorJson = jsonObject.getJSONObject("proveedor");
                Proveedor proveedor = deserializarProveedor(proveedorJson);
                proveedoresInactivos.add(proveedor);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return proveedoresInactivos;
    }

    public Set<Vehiculo> deserializarListaVehiculos(JSONArray jsonArray) {

        Set<Vehiculo> vehiculos = new HashSet<>();

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

    public Set<Vehiculo> deserializarListaNoStockVehiculos(JSONArray jsonArray) {

        Set<Vehiculo> noStockVehiculos = new HashSet<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject vehiculoJson = jsonObject.getJSONObject("vehiculo");

                if (vehiculoJson.has("largoCaja")) {
                    noStockVehiculos.add(deserializarCamioneta(vehiculoJson));
                } else if (vehiculoJson.has("largoChasis")) {
                    noStockVehiculos.add(deserializarCamion(vehiculoJson));
                } else if (vehiculoJson.has("pasajeros")) {
                    noStockVehiculos.add(deserializarMoto(vehiculoJson));
                }else{
                    noStockVehiculos.add(deserializarAuto(vehiculoJson));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return noStockVehiculos;
    }







}


