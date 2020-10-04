package Modulos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClienteEmpresa extends Clientes {
    public StringProperty razonsocial;
    public StringProperty contacto;
    public IntegerProperty descuento;

    public ClienteEmpresa(String nombre, String nit, String fecha, String genero, String estadocivil, String razonsocial, String contacto, int descuento) {
        super(nombre, nit, fecha, genero, estadocivil);
        this.razonsocial = new SimpleStringProperty(razonsocial);
        this.contacto= new SimpleStringProperty(contacto);
        this.descuento= new SimpleIntegerProperty(descuento);
    }

    public String getRazonsocial() {
        return razonsocial.get();
    }

    public StringProperty razonsocialProperty() {
        return razonsocial;
    }

    public String getContacto() {
        return contacto.get();
    }

    public StringProperty contactoProperty() {
        return contacto;
    }

    public int getDescuento() {
        return descuento.get();
    }

    public IntegerProperty descuentoProperty() {
        return descuento;
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nID:"+id+"\tRazon Social: "+razonsocial+"\tContacto: "+contacto+"\tNombre: "+ nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil+"\tDescuento: "+descuento;
    }
}
