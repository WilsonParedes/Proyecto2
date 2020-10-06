package Modulos.DataSistema;

import Modulos.Herramientas.Utilerias;
import Modulos.Herramientas.VariblesFormGlobales;
import com.jfoenix.controls.JFXTextField;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.*;

public class ItemOrder extends DataSistema implements Utilerias {

    public int noLinea;
    public int cantidad;
    public int pIdProducto;
    public int total;
    Productos producto= new Productos();
    Scanner leer=new Scanner(System.in);


    public ItemOrder(){}

    public ItemOrder(int noLinea, int cantidad, int pIdProducto){
        this.noLinea=noLinea;
        this.cantidad=cantidad;
        this.pIdProducto=pIdProducto;
    }

    public int getTotalItem(int idpro, int canti){

        //System.out.print("Ingresar el id del producto deseado: ");
        pIdProducto = idpro;
        //pIdProducto=leer.nextInt();
        //System.out.print("Ingresar la cantidad del producto requerido: ");
        cantidad = canti;
        //cantidad=leer.nextInt();
        total= getVerPrecio(pIdProducto)*cantidad;
        System.out.println("Producto Seleccionado: "+getVerProducto(pIdProducto));
        /*COLOCAR TODA LA INFO DE LOS PRODUCTOS AQUI*/
        System.out.print("Total del producto es: "+total+"\n");
        return total;
    }

    /*public int getTotal(){
        return total;
    }*/

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\t#Orden de Compra: "+noLinea+"\tCantidad Ordenada: "+cantidad
                +"\tCodigo Producto"+pIdProducto+"\tTotal de la Compra: "+total;
    }





}
