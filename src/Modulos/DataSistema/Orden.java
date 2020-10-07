package Modulos.DataSistema;
import Modulos.Herramientas.VariblesFormGlobales;
import com.jfoenix.controls.JFXTextField;

import java.util.Date;

public class Orden extends ItemOrder{
    private static int siIDorden=1;
    public int idOrden;
    public Clientes cliente;
    public ItemOrder item1;
    public ItemOrder item2;
    public Date fechaorden;
    public double precioenvio;
    public double subtotal;
    public double total;
    public String tipoenvio;
    public String estado;
    public int diasenvio;
    public int pCliente;

    public Orden(){
        this.idOrden = siIDorden++;
        total= 0.0;
    }

    public Orden(Date fechaorden){
        this();
    }

    public Orden(int pCliente, Date fechaorden, int pIdCompra, int cantidad, String envio, int precioenvio, int diasenvio){
        this();
        this.pCliente=pCliente;
        this.fechaorden=fechaorden;

        System.out.println("El cliente: "+getVerCliente(pCliente));
        System.out.println("Carga Orden de Compra: ");
        getTotalOrden(pIdCompra,cantidad,precioenvio);
        //System.out.print("Indique el tipo de envio: ");
        tipoenvio = envio;
        //tipoenvio=leer.nextLine();
        //System.out.print("Indique el precio del envio: ");
        this.precioenvio = precioenvio;
        //precioenvio=leer.nextDouble();
        //System.out.print("Indique los dias que tardara el envio: ");
        this.diasenvio = diasenvio;
        //diasenvio=leer.nextInt();
        //System.out.print("Indique el estado de la Orden de Compra: ");
        estado= "En proceso";

    }
    //METODO ENCARGADO DE HACER EL CALCULO DE LA OC
    public void getTotalOrden(int idpro,int cantidad, int precioenvio){
        subtotal = getTotalItem(idpro,cantidad);
        total+= subtotal+precioenvio;
        /*do{
            getTotalItem();

            System.out.print("¿Desea agregar otro producto? Si/No: ");
            resp=leer.nextLine();
            if(resp.equalsIgnoreCase("Si")){
                salida=false;
            }else{
                salida=true;
                System.out.println("EL total actual es: "+total);
            }
        }while(salida!=true);*/
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

    public Date getFechaorden() {
        return fechaorden;
    }

    public double getSubtotal() {
        return subtotal;
    }


    public int getIdOrden() {
        return idOrden;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public ItemOrder getItem1() {
        return item1;
    }

    public ItemOrder getItem2() {
        return item2;
    }

    public double getPrecioenvio() {
        return precioenvio;
    }

    public double getTotal() {
        return total;
    }

    public String getTipoenvio() {
        return tipoenvio;
    }

    public String getEstado() {
        return estado;
    }

    public int getDiasenvio() {
        return diasenvio;
    }

    public int getpCliente() {
        return pCliente;
    }

    @Override
    public String toString(){
        return "\nIDOrden " + idOrden + " Datos Cliente"+getVerCliente(pCliente)+"\nProducto facturado\n"+getVerProducto(pIdProducto)
                +"\nFecha Orden de compra: "+fechaorden+"\tPrecio del Envio: Q"+precioenvio+"\tSe enviara  por: "+
                tipoenvio+"\tEstado Orden de compra: "+estado+"\tRecibira el producto en: "+diasenvio+" dias"+"\tSubtota de la compra: Q"+subtotal+
                "\nEl total de la Orden de compra sera de: Q"+total;
    }
}
