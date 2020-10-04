package Modulos;

import java.util.Date;


public class Orden extends ItemOrder{

    public int id;
    public Clientes cliente;
    public ItemOrder item1;
    public ItemOrder item2;
    public Date fechaorden;
    public double precioenvio;
    public double total;
    public String tipoenvio;
    public String estado;
    public static int sigIdOrden;
    public int diasenvio;
    public int pCliente;

    public Orden(){
        id=0;
        total= 0.0;
        fechaorden= new Date();
    }

    //CONSTRUCTOR PRINCIPAL
    public Orden(int pCliente, Date fechaorden, int noLinea, int cantidad, int pIdProducto){
        super(noLinea, cantidad, pIdProducto);
        this.pCliente=pCliente;
        this.fechaorden=fechaorden;



        System.out.println("Datos del cliente: \n"+ verCliente(pCliente));
        System.out.println("Item seleccionado: \n"+verProducto(pIdProducto));
        System.out.println("Ingrese la cantidad de producto deseado: ");
        cantidad=leer.nextInt();
        //if(item1==null){
        item1=new ItemOrder(noLinea,cantidad,pIdProducto);//CORRELATIVO, CANTIDAD, NOPRODUCTO
        System.out.println("Se agrega a la orden de compra item1: "+item1);
        //}else if(item1!=null){
        item2=new ItemOrder(noLinea,cantidad,pIdProducto);//CORRELATIVO, CANTIDAD, NOPRODUCTO
        System.out.println("Se agrega a la orden de compra item2: "+item2);
        //}


        System.out.println("Se agrega a la orden de compra: \n"+item1+"\n"+item2);

        total=total+getTotalItem(noLinea,pIdProducto,cantidad);//TOTAL ORDEN DE COMPRA
        System.out.println("El total del producto 1 es: \n"+total);
        System.out.println("Fecha de laorden de Compra: "+fechaorden);


    }
}
