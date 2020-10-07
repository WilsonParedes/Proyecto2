package Modulos.DataSistema;
import Modulos.Herramientas.Utilerias;
import Modulos.DataSistema.ClienteEmpresa;

//CLASE PADRE LA CUAL ADMINISTRA LA INFORMACION DE LOS CLIENTES REGISTRADOS
public class Clientes implements Utilerias {
    private static int sigIdCliente=1;
    public int id;
    public String nombre;
    public String nit;
    public String fecha;
    public String genero;
    public String estadocivil;

//CONSTRUCTOR VACIO ENCARGADO DE LLEVAR EL CONTADOR DE LOS CLIENTES AGREGADOS
    public Clientes() {
        this.id = sigIdCliente++;
    }

//CONSTRUCTOR PRINCIPAL QUE RECIBE LOS ATRIBUTOS DE LOS CLIENTES
    public Clientes(String nombre, String nit, String fecha, String genero, String estadocivil){
        this();//MANDA A LLAMAR EL CONSTRUCTOR VACIO PARA RECIBIR EL CONTADOR ID
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.genero = genero;
        this.estadocivil = estadocivil;
    }

//METODOS GETTER
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

//METODO TOSTRING QUE MUESTRA LOS DATOS DEL CLIENTE EN CONSOLA Y SU CLASE
    @Override
    public String toString(){
        return "\n["+getNombreClase()+"]"+"\tID:"+id+"\nNombre Completo:" + nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil;
    }


}
