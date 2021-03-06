package GestionFormularios;


import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;


public class GestionVistaPrincipal extends ControladorDeEventos {

    public void FormCrear() throws IOException {
        FormGlobal("/Utilerias/Formularios/Creacion.fxml","CREACIÓN DE USUARIO", 500, 265);
    }

    public void FormVistaPrincipal() throws IOException {
        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        Stage StageIngresoUsuario = (Stage)txtUsuario.getScene().getWindow();
        StageIngresoUsuario.close();
        FormGlobal("/Utilerias/Formularios/VistaPrincipal.fxml","VISTA PRINCIPAL", 1050, 650);

    }
    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE INGRESAR CLIENTES*/
    public void OpcionMenuIngresoClientes()throws IOException{
        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        FormGlobal("/Utilerias/Formularios/IngresoClientes.fxml","INGRESO CLIENTES", 762, 401);
    }

    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE INGRESAR PRODUCTO*/
    public void OpcionMenuIngresoProducto()throws IOException{
        /*SE HACE EL LLAMADO A GESTION.FORMULARIOS.CREACIONFORMULARIO.FORMGLOBAL*/
        FormGlobal("/Utilerias/Formularios/IngresoProducto.fxml","INGRESO PRODUCTO", 525, 284);
    }


    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE CONSULTA CLIENTES.FXML*/

    public void OpcionConsultaClientes()throws IOException{
        FormGlobal("/Utilerias/Formularios/ConsultaClientes.fxml","CONSULTA CLIENTES", 1019, 582);
    }

    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE CONSULTA PRODUCTOS*/

    public void OpcionConsultaProductos()throws IOException {
        FormGlobal("/Utilerias/Formularios/ConsultaProductos.fxml","CONSULTA PRODUCTO", 761, 558);

    }

    public void OpcionOrdendeCompra() throws IOException {
        FormGlobal("/Utilerias/Formularios/OrdenCompra.fxml","ORDEN DE COMPRA", 775, 725);
    }

    public void OpcionConsultaOrdenCompra()throws IOException{
        FormGlobal("/Utilerias/Formularios/ConsultaOrdenCompra.fxml","CONSULTA ORDEN COMPRA", 1019, 582);
    }
}
