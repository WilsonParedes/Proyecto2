package GestionFormularios;

import java.io.IOException;

public class GestionVistaPrincipal extends CreacionFormulario{
    public void FormVistaPrincipal() throws IOException {

        CreacionFormulario cr = new CreacionFormulario();


        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        FormGlobal("/Utilerias/Formularios/VistaPrincipal.fxml","VISTA PRINCIPAL", 600, 600);

    }
    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE INGRESAR CLIENTES*/
    public void OpcionMenuIngresoClientes()throws IOException{

        CreacionFormulario cr = new CreacionFormulario();



        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        FormGlobal("/Utilerias/Formularios/IngresoClientes.fxml","INGRESO CLIENTES", 600, 700);
    }

    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE INGRESAR PRODUCTO*/
    public void OpcionMenuIngresoProducto()throws IOException{

        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        FormGlobal("/Utilerias/Formularios/IngresoProducto.fxml","INGRESO PRODUCTO", 400, 300);
    }
}
