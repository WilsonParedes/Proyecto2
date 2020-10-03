package GestionFormularios;

import Modulos.Clientes;
import Modulos.Productos;
import com.sun.xml.internal.bind.v2.runtime.property.PropertyFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sun.misc.Cleaner;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.PropertyPermission;
import java.util.ResourceBundle;

public class GestionVistaPrincipal extends CreacionFormulario {

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
        FormGlobal("/Utilerias/Formularios/IngresoProducto.fxml","INGRESO PRODUCTO", 525, 284);
    }


    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE CONSULTA CLIENTES.FXML*/

    public void OpcionConsultaClientes()throws IOException{
        FormGlobal("/Utilerias/Formularios/ConsultaClientes.fxml","INGRESO PRODUCTO", 1006, 554);
    }

    /*SE CREA EL MÉTODO PARA CREAR LA OPCION DE CONSULTA PRODUCTOS*/
    private ArrayList<Productos> productos = new ArrayList<>();
    public void OpcionConsultaProductos(){
        productos = arrayProductos.getListaProductos();
        for(Productos prod : productos){

            System.out.println(prod.toString());
        }

    }

}
