package Modulos;


import java.util.Scanner;

public class ItemOrder extends DataSistema implements Utilerias {

    public int noLinea;
    public static int pnoLinea=1;//correlativo de la orden
    public int cantidad;
    public int pIdProducto;
    public int total;
    Productos producto= new Productos();
    Scanner leer=new Scanner(System.in);


    public ItemOrder(){noLinea=pnoLinea++;}

    public ItemOrder(int noLinea, int cantidad, int pIdProducto){
        this();
        this.cantidad=cantidad;
        this.pIdProducto=pIdProducto;
    }

    public double getTotalItem(int noLinea,int pIdProducto,int cantidad) {

        if(!ListaProductos.isEmpty()){

            for(Productos forpr: ListaProductos){
                if(ListaProductos.get(pIdProducto).equals(verProducto(pIdProducto))){
                    total= verprecio(pIdProducto)*cantidad;
                    break;
                }
            }//fin del for
        }//fin del ifEmpty
        return total;

    }//fin del metodo

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\t#Orden de Compra: "+noLinea+"\tCantidad Ordenada: "+cantidad
                +"\tCodigo Producto"+pIdProducto;
    }





}
