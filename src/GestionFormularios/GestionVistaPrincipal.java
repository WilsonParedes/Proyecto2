package GestionFormularios;

import Modulos.Clientes;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GestionVistaPrincipal extends CreacionFormulario{

    public void FormCrear() throws IOException {
        FormGlobal("/Utilerias/Formularios/Creacion.fxml","CREACIÓN DE USUARIO", 500, 265);
    }

    public void FormVistaPrincipal() throws IOException {
        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        Stage StageIngresoUsuario = (Stage)txtUsuario.getScene().getWindow();
        StageIngresoUsuario.close();
        FormGlobal("/Utilerias/Formularios/VistaPrincipal.fxml","VISTA PRINCIPAL", 600, 600);

    }
    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE INGRESAR CLIENTES*/
    public void OpcionMenuIngresoClientes()throws IOException{
        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        FormGlobal("/Utilerias/Formularios/IngresoClientes.fxml","INGRESO CLIENTES", 755, 588);
    }

    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE INGRESAR PRODUCTO*/
    public void OpcionMenuIngresoProducto()throws IOException{

        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        FormGlobal("/Utilerias/Formularios/IngresoProducto.fxml","INGRESO PRODUCTO", 400, 300);
    }

    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE INGRESAR CLIENTES*/
    private ArrayList<Clientes> clientes = new ArrayList<>();
    public void OpcionConsultaClientes(){
        clientes = arrayclientes.getListaClientes();
        for(Clientes cli : clientes){

            System.out.println(cli.toString());
        }

    }
}
