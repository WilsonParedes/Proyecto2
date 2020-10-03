package Modulos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clientes implements Utilerias{
    private static int sigIdCliente=1;
    public IntegerProperty id;
    public StringProperty primernombre;
    public StringProperty segundonombre;
    public StringProperty primerapellido;
    public StringProperty segundoapellido;
    public StringProperty nombre;
    public StringProperty nit;
    public StringProperty fecha;
    public StringProperty genero;
    public StringProperty estadocivil;



    public Clientes() {
        this.id = new SimpleIntegerProperty(sigIdCliente++);
    }

    public Clientes(String primernombre, String segundonombre, String primerapellido, String segundoapellido, String nit, String fecha, String genero, String estadocivil) {
        this();
        this.primernombre = new SimpleStringProperty(primernombre);
        this.segundonombre = new SimpleStringProperty(segundonombre);
        this.primerapellido = new SimpleStringProperty(primerapellido);
        this.segundoapellido = new SimpleStringProperty(segundoapellido);
        this.nombre = new SimpleStringProperty(primernombre + " " + segundonombre + " " + primerapellido + " " + segundoapellido);
        this.nit = new SimpleStringProperty(nit);
        this.fecha = new SimpleStringProperty(fecha);
        this.genero = new SimpleStringProperty(genero);
        this.estadocivil = new SimpleStringProperty(estadocivil);

    }


    public int getId() {
        return id.get();
    }

    public String getPrimernombre() {
        return primernombre.get();
    }

    public String getSegundonombre() {
        return segundonombre.get();
    }

    public String getPrimerapellido() {
        return primerapellido.get();
    }

    public String getSegundoapellido() {
        return segundoapellido.get();
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
