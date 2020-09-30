package Modulos;

import java.util.ArrayList;
public class DataSistema {
    public static ArrayList<Clientes> ListaClientes= new ArrayList<Clientes>(20);
    public static ArrayList<Productos> ListaProductos= new ArrayList<Productos>(20);
    public static int i=0;
    public static String temp="";

    public DataSistema() {

    }

    public void addCliente(Clientes cl){
        ListaClientes.add(cl);
    }
    public void addProducto(Productos pr){
        ListaProductos.add(pr);
    }
    public String toString() {
        for(Clientes tempclientes: ListaClientes){
            i++;
            temp+="\nCliente "+i+" "+tempclientes.toString();

        }
        return temp;
    }


    public String toStringPr() {
        for(Productos temproducto: ListaProductos){
            i++;
            temp+=temproducto.toString();

        }
        return temp;
    }

}
