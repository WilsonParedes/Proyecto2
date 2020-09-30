package Modulos;

public class ClienteIndividual extends Clientes {
    public int dpi;


    public ClienteIndividual(int dpi,int id, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String nit, String fecha, String genero, String estadocivil) {
        super(id, primernombre, segundonombre, primerapellido, segundoapellido, nit, fecha, genero, estadocivil);
        this.dpi = dpi;
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nDPI: "+dpi+"\tNombre: "+primernombre+" "+segundonombre+"\tApellidos: "+primerapellido+" "+segundoapellido+
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil+"\tID:"+id;
    }
}
