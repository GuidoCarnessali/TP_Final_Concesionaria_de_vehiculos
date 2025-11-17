package Manager;

import Classes.Proveedor;
import Classes.Vehiculo;
import Enums.Marca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    public boolean removeProveedor(String nombre) {

        for (Proveedor p : proveedores) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {

                proveedores.remove(p);
                p.setActivo(false);
                proveedores.add(p);

                return true;
            }
        }

        return false; // No se encontró ningún proveedor con ese nombre
    }


    public void modifyProveedor(String nombreViejo) {

        Scanner scan = new Scanner(System.in);
        Proveedor p = null;

        for (Proveedor prov : proveedores) {
            if (prov.getNombre().equalsIgnoreCase(nombreViejo)) {
                p = prov;
                proveedores.remove(prov);
            }
        }

        if (p != null) {


            System.out.println("Ingrese el nombre del proveedor: ");
            p.setNombre(scan.nextLine());

            System.out.println("Ingrese la empresa del proveedor: ");
            p.setEmpresa(scan.nextLine());

            System.out.println("Ingrese la dirección del proveedor: ");
            p.setDireccion(scan.nextLine());

            System.out.println("Ingrese el teléfono del proveedor: ");
            p.setTelefono(scan.nextLine());

            System.out.println("Ingrese el email del proveedor: ");
            p.setEmail(scan.nextLine());

            System.out.println("Ingrese la marca que provee: ");
            String marcaInput = scan.nextLine();
            p.setMarcaQueProvee(Marca.valueOf(marcaInput.toUpperCase()));

            System.out.println("¿El proveedor está activo? (true/false): ");
            p.setActivo(scan.nextBoolean());
            scan.nextLine();

            proveedores.add(p);

        } else {
            System.err.println("No se ha encontrado ningún proveedor con ese nombre. ");
        }
    }

    public String searchProveedor(String nombre) {
        for (Proveedor p : proveedores) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p.toString();
            }
        }
        return "No se ha encontrado un proveedor con ese nombre";
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

    public void crearProveedor ()
    {
        Scanner scan = new Scanner(System.in);
        Proveedor p = new Proveedor();

        System.out.println("Ingrese el nombre del proveedor: ");
        p.setNombre(scan.nextLine());

        System.out.println("Ingrese la empresa del proveedor: ");
        p.setEmpresa(scan.nextLine());

        System.out.println("Ingrese la dirección del proveedor: ");
        p.setDireccion(scan.nextLine());

        System.out.println("Ingrese el teléfono del proveedor: ");
        p.setTelefono(scan.nextLine());

        System.out.println("Ingrese el email del proveedor: ");
        p.setEmail(scan.nextLine());

        System.out.println("Ingrese la marca que provee: ");
        String marcaInput = scan.nextLine();
        p.setMarcaQueProvee(Marca.valueOf(marcaInput.toUpperCase()));

        System.out.println("¿El proveedor está activo? (true/false): ");
        p.setActivo(scan.nextBoolean());
        scan.nextLine();

        proveedores.add(p);
    }




}
