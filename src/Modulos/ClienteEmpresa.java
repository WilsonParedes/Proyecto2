package Modulos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClienteEmpresa extends Clientes {
    public StringProperty razonsocial;
    public StringProperty contacto;
    public IntegerProperty descuento;

    public ClienteEmpresa(String primernombre, String segundonombre, String primerapellido, String segundoapellido, String nit, String fecha, String genero, String estadocivil, String razonsocial, String contacto, int descuento) {
        super(primernombre, segundonombre, primerapellido, segundoapellido, nit, fecha, genero, estadocivil);
        this.razonsocial = new SimpleStringProperty(razonsocial);
        this.contacto= new SimpleStringProperty(contacto);
        this.descuento= new SimpleIntegerProperty(descuento);
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nRazon Social: "+razonsocial+"\tContacto: "+contacto+"\tNombre: "+ nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil+"\tID:"+id+"\tDescuento: "+descuento;
    }
}
