package Modulos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clientes implements Utilerias{
    private static int sigIdCliente=1;
    public IntegerProperty id;
    public StringProperty nombre;
    public StringProperty nit;
    public StringProperty fecha;
    public StringProperty genero;
    public StringProperty estadocivil;

    public Clientes() {
        this.id = new SimpleIntegerProperty(sigIdCliente++);
    }

    public Clientes(String nombre, String nit, String fecha, String genero, String estadocivil) {
        this();
        this.nombre = new SimpleStringProperty(nombre);
        this.nit = new SimpleStringProperty(nit);
        this.fecha = new SimpleStringProperty(fecha);
        this.genero = new SimpleStringProperty(genero);
        this.estadocivil = new SimpleStringProperty(estadocivil);

    }


    public int getId() {
        return id.get();
    }

    public String getNombre(){ return nombre.get();}

    public String getNit() {
        return nit.get();
    }

    public String getFecha() {
        return fecha.get();
    }

    public String getGenero() {
        return genero.get();
    }

    public String getEstadocivil() {
        return estadocivil.get();
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\tID:"+id+"\nNombre Completo:" + nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil;
    }





}
