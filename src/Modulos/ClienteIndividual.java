package Modulos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClienteIndividual extends Clientes {
    public StringProperty dpi;


    public ClienteIndividual(String dpi, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String nit, String fecha, String genero, String estadocivil) {
        super(primernombre, segundonombre, primerapellido, segundoapellido, nit, fecha, genero, estadocivil);
        this.dpi = new SimpleStringProperty(dpi);
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nDPI: "+dpi+"\tNombre: "+ nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil+"\tID:"+id;
    }
}
