package Modulos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClienteIndividual extends Clientes {
    public StringProperty dpi;


    public ClienteIndividual(String dpi, String nombre, String nit, String fecha, String genero, String estadocivil) {
        super(nombre, nit, fecha, genero, estadocivil);
        this.dpi = new SimpleStringProperty(dpi);
    }

    public String getDpi() {
        return dpi.get();
    }

    public StringProperty dpiProperty() {
        return dpi;
    }

    @Override
    public String toString(){
        return "\n["+getNombreClase()+"]"+"\tID:"+id+"\tDPI: "+dpi+"\tNombre: "+ nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil;
    }
}
