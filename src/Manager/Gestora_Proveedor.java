package Manager;

import Classes.Proveedor;
import Classes.Vehiculo;
import Enums.Marca;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Gestora_Proveedor {

    private List<Proveedor> proveedores;                //Hacerlo arraylist ya que no importa el orden y no se repiten


    public Gestora_Proveedor() {
        this.proveedores = new ArrayList<>();
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    //------------------ABMCL------------------
    //Alta, Baja, Modificación, Consulta, Listado
    //Proveedor
    public boolean addProveedor(Proveedor p)
    {
        if(p != null) //Si el proveedor no es nulo y no está en la lista de proveedores lo agrego
        {

            if (proveedores.contains(p)){

                if (p.isActivo() == false){
                    proveedores.remove(p);
                    p.setActivo(true);
                    proveedores.add(p);
                    return true;
                }


            }else {
                proveedores.add(p);                   //Agrego el proveedor a la lista
                return true;
            }

        }
        return false;
    }

    public boolean removeProveedor(Proveedor p)
    {
        if(p != null && proveedores.contains(p)) //Si el proveedor no es nulo y está en la lista de proveedores lo elimino
        {
            proveedores.remove(p);               //Elimino el proveedor de la lista
            p.setActivo(false);
            proveedores.add(p);
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

    public void listaDeserializadaToProveedores (List<Proveedor> proveedoresB){

        for (Proveedor p: proveedoresB)
        {
            proveedores.add(p); //lo agregamos con el .add(p)
        }
    }

    public void showProveedoresActivos (){

       for (Proveedor p: proveedores)
       {
           if(p.isActivo())
           {
               System.out.println(p.toString());
           }
       }
    }

    public void showProveedoresInactivos (){

        for (Proveedor p: proveedores)
        {
            if(!p.isActivo())
            {
                System.out.println(p.toString());
            }
        }
    }




}
