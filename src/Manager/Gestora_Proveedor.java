package Manager;

import Classes.Proveedor;
import Enums.Marca;

import java.util.ArrayList;
import java.util.List;

public class Gestora_Proveedor {

    private List<Proveedor> proveedores;                //Hacerlo arraylist ya que no importa el orden y no se repiten
    private List<Proveedor> proveedoresInactivos;       //Hacerlo arraylist ya que no importa el orden y no se repiten

    public Gestora_Proveedor() {
        this.proveedores = new ArrayList<>();
        this.proveedoresInactivos = new ArrayList<>();
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public List<Proveedor> getProveedoresInactivos() {
        return proveedoresInactivos;
    }

    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Proveedor
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
            System.out.println("-------------------");
            System.out.println(p.toString());
        }
    }



}
