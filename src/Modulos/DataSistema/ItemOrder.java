package Modulos.DataSistema;

import Modulos.Herramientas.Utilerias;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.*;
//CLASE ENCARGADA DE REALIZAR EL CALCULO DE LOS PRODUCTOS DE LA ORDEN DE COMPRA
public class ItemOrder extends DataSistema implements Utilerias {

    public int noLinea;
    public int cantidad;
    public int pIdProducto;
    public int total;
    Productos producto= new Productos();
    Scanner leer=new Scanner(System.in);

    //CONSTRUCTOR VACIO
    public ItemOrder(){}

    //CONSTRUCTOR PRINCIPAL QUE RECIBE LOS PARAMETROS PARA EL CALCULO
    public ItemOrder(int noLinea, int cantidad, int pIdProducto){
        this.noLinea=noLinea;
        this.cantidad=cantidad;
        this.pIdProducto=pIdProducto;
    }

    //METODO PRINCIPAL EL CUAL REALIZA EL CALCULO DEL PRODUCTO SELECCIONADO POR EL USUARIO (PRECIO*CANTIDAD)
    public void getTotalItem(){
        System.out.print("Ingresar el id del producto deseado: ");
        pIdProducto=leer.nextInt();
        System.out.print("Ingresar la cantidad del producto requerido: ");
        cantidad=leer.nextInt();
        total= getVerPrecio(pIdProducto)*cantidad;
        System.out.println("Producto Seleccionado: "+getVerProducto(pIdProducto));
        System.out.print("Total del producto es: "+total+"\n");
    }

    public int getTotal(){
        return total;
    }

    //TOSTRING QUE DEVUELVE EN CONSOLA UN FORMATO PARA PRESENTAR LOS DATOS DE LA CLASE
    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\t#Orden de Compra: "+noLinea+"\tCantidad Ordenada: "+cantidad
                +"\tCodigo Producto"+pIdProducto+"\tTotal de la Compra: "+total;
    }





}
