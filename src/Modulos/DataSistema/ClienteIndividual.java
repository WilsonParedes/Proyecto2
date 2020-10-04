package Modulos.DataSistema;


public class ClienteIndividual extends Clientes {
    public String dpi;


    public ClienteIndividual(String dpi, String nombre, String nit, String fecha, String genero, String estadocivil){
        super(nombre, nit, fecha, genero, estadocivil);
        this.dpi = dpi;
    }

    public String getDpi() {
        return dpi;
    }

    @Override
    public String toString(){
        return "\n["+getNombreClase()+"]"+"\tID:"+id+"\tDPI: "+dpi+"\tNombre: "+ nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil;
    }
}
