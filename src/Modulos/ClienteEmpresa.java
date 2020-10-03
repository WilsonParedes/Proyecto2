package Modulos;

public class ClienteEmpresa extends Clientes {
    public String razonsocial;
    public String contacto;
    public int descuento;

    public ClienteEmpresa(String primernombre, String segundonombre, String primerapellido, String segundoapellido, String nit, String fecha, String genero, String estadocivil, String razonsocial, String contacto, int descuento) {
        super(primernombre, segundonombre, primerapellido, segundoapellido, nit, fecha, genero, estadocivil);
        this.razonsocial = razonsocial;
        this.contacto= contacto;
        this.descuento= descuento;
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nRazon Social: "+razonsocial+"\tContacto: "+contacto+"\tNombre: "+primernombre+" "+segundonombre+"\nApellidos: "+primerapellido+" "+segundoapellido+
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil+"\tID:"+id+"\tDescuento: "+descuento;
    }
}
