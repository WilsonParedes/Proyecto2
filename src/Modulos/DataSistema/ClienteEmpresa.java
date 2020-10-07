package Modulos.DataSistema;


public class ClienteEmpresa extends Clientes {
    public String razonsocial;
    public String contacto;
    public int descuento;

    public ClienteEmpresa(String nombre, String nit, String fecha, String genero, String estadocivil, String razonsocial, String contacto, int descuento) {
        super(nombre, nit, fecha, genero, estadocivil);
        this.razonsocial = razonsocial;
        this.contacto= contacto;
        this.descuento= descuento;
    }



    public String getRazonsocial() {
        return razonsocial;
    }

    public String getContacto() {
        return contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nID:"+id+"\tRazon Social: "+razonsocial+"\tContacto: "+contacto+"\tNombre: "+ nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil+"\tDescuento: "+descuento;
    }
}
