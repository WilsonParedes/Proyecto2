package Modulos.DataSistema;


import Modulos.Herramientas.Utilerias;

public class Clientes implements Utilerias {
    private static int sigIdCliente=1;
    public int id;
    public String nombre;
    public String nit;
    public String fecha;
    public String genero;
    public String estadocivil;

    public Clientes() {
        this.id = sigIdCliente++;
    }

    public Clientes(String nombre, String nit, String fecha, String genero, String estadocivil){
        this();
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.genero = genero;
        this.estadocivil = estadocivil;
    }


    public int getId() {
        return id;
    }

    public String getNit() {
        return nit;
    }

    public String getNombre() {return nombre;}

    public String getFecha() {
        return fecha;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    @Override
    public String toString(){
        return "\n["+getNombreClase()+"]"+"\tID:"+id+"\nNombre Completo:" + nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil;
    }


}
