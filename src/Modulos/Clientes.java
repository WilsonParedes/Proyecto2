package Modulos;

public class Clientes implements Utilerias{
    private static int sigIdCliente=1;
    public int id;
    public String primernombre;
    public String segundonombre;
    public String primerapellido;
    public String segundoapellido;
    public String nit;
    public String fecha;
    public String genero;
    public String estadocivil;



    public Clientes() {
        this.id= sigIdCliente++;
    }

    public Clientes(String primernombre, String segundonombre, String primerapellido, String segundoapellido, String nit, String fecha, String genero, String estadocivil) {
        this();
        this.primernombre = primernombre;
        this.segundonombre = segundonombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.nit = nit;
        this.fecha = fecha;
        this.genero = genero;
        this.estadocivil = estadocivil;

    }

    public int getId() {
        return id;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public String getNit() {
        return nit;
    }

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
        return "["+getNombreClase()+"]"+"\nNombre: "+primernombre+" "+segundonombre+"\tApellidos: "+primerapellido+" "+segundoapellido+
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil+"\tID:"+id;
    }





}
