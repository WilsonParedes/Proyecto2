package Modulos.DataSistema;

//CLASE QUE HEREDA TODOS LOS ATRIBUTOS Y METODOS DE CLIENTES
public class ClienteIndividual extends Clientes {
    public String dpi;

    //CONSTRUCTOR PRINCIPAL QUE RECIBE TODOS LOS PARAMETROS DE CLIENTE Y AGREGA EL ATRIBUTO DPI
    public ClienteIndividual(String dpi, String nombre, String nit, String fecha, String genero, String estadocivil){
        super(nombre, nit, fecha, genero, estadocivil);
        this.dpi = dpi;
    }
    //METODO GET
    public String getDpi() {
        return dpi;
    }

    //TO STRING ENCARGADO DE MOSTRAR EN CONSOLA LOS DATOS DE CLIENTEINDIVIDUAL  Y SU CLASE
    @Override
    public String toString(){
        return "\n["+getNombreClase()+"]"+"\tID:"+id+"\tDPI: "+dpi+"\tNombre: "+ nombre +
                "\tNit: "+nit+"\tFecha: "+fecha+"\tGenero: "+genero+"\tEstado Civil: "+estadocivil;
    }
}
