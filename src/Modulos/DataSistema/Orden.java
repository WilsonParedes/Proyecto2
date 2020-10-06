package Modulos.DataSistema;

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
    public int diasenvio;
    public int pCliente;

    public Orden(){
        id=id++;
        total= 0.0;
        fechaorden= new Date();
    }

    public Orden(Date fechaorden){
        this();
    }

    public Orden(int pCliente, Date fechaorden){
        this.pCliente=pCliente;
        this.fechaorden=fechaorden;

        System.out.println("El cliente: "+getVerCliente(pCliente));
        System.out.println("Carga Orden de Compra: ");
        getTotalOrden();
        System.out.print("Indique el tipo de envio: ");
        tipoenvio=leer.nextLine();
        System.out.print("Indique el precio del envio: ");
        precioenvio=leer.nextDouble();
        System.out.print("Indique los dias que tardara el envio: ");
        diasenvio=leer.nextInt();
        System.out.print("Indique el estado de la Orden de Compra: ");
        estado= leer.nextLine();

    }
    //METODO ENCARGADO DE HACER EL CALCULO DE LA OC
    public void getTotalOrden(){
        boolean salida=false;
        String resp="";
        do{
            getTotalItem();
            total+= getTotal();
            String fail=leer.nextLine();
            System.out.print("¿Desea agregar otro producto? Si/No: ");
            resp=leer.nextLine();
            if(resp.equalsIgnoreCase("Si")){
                salida=false;
            }else{
                salida=true;
                System.out.println("EL total actual es: "+total);
            }
        }while(salida!=true);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public void setPrecioenvio(double precioenvio) {
        this.precioenvio = precioenvio;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTipoenvio(String tipoenvio) {
        this.tipoenvio = tipoenvio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDiasenvio(int diasenvio) {
        this.diasenvio = diasenvio;
    }



    @Override
    public String toString(){
        return "\nID " + id + " Datos Cliente\n"+getVerCliente(pCliente)+"\nProducto facturado\n"+getVerProducto(pIdProducto)
                +"\nFecha Orden de compra: "+fechaorden+"\tPrecio del Envio: Q"+precioenvio+"\tSe enviara  por: "+
                tipoenvio+"\tEstado Orden de compra: "+estado+"\tRecibira el producto en: "+diasenvio+" dias"+
                "\nEl total de la Orden de compra sera de: Q"+total;
    }
}
