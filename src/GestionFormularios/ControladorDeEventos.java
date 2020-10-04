package GestionFormularios;

import Modulos.*;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorDeEventos extends VariblesFormGlobales implements Initializable {

    public void FormGlobal(String ubicacion, String titulo, int ancho, int alto) throws IOException {
        FXMLLoader in = new FXMLLoader(getClass().getResource(ubicacion));
        Pane pri = (Pane) in.load();
        Scene scene = new Scene(pri, ancho, alto);
        Stage stage = new Stage();
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();

    }

    //EVENTOS PARA TODOS LOS FORMULARIOS

    /*EVENTOS PARA EL FORMULARIO CREACION.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO CREACION.FXML*/
    public void GuardarUsuario(){
        dt.addUsuarios(new Usuarios(txtUsuar.getText(), txtContra.getText()));
        JOptionPane.showMessageDialog(null, "USUARIO CREADO CON ÉXITO!", "USUARIO CREADO", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("GUADRA USUARIO A ARRAYLIST DE USUARIOS");
        Stage StageCrearUsuario = (Stage)txtUsuar.getScene().getWindow();
        StageCrearUsuario.close();
    }

    /*EVENTOS PARA EL FORMULARIO INGRESOCLIENTES.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO INGRESOCLIENTES.FXML*/
    public void BotonGuardarClientes() {
        if((cbEmpresa.selectedProperty().getValue())==true){
            /*CONSTRUCTOR EMPRESAS*/
            arrayempresa.addCliente(new ClienteEmpresa(txtNombreCompleto.getText(),txtNIT.getText(), "fecha", "genero", "estado civil", txtRazonSocial.getText(), txtContacto.getText(),
                    2));
        }else{

            /*CONSTRUCTOR CLIENTES INDIVIDUALES*/
            arrayclientes.addCliente(new ClienteIndividual(txtDPI.getText(), txtNombreCompleto.getText(), txtNIT.getText(), "String fecha", "String genero", "String estadocivil"));

        }

        JOptionPane.showMessageDialog(null,"EL CLIENTE HA SIDO ALMACENADO CON EXITO" ,"INFORMACION", JOptionPane.INFORMATION_MESSAGE);
    }
    /*EVENTO QUE INHABILITA EL TXTRAZONSOCIAL DEL FORMULARIO INGRESOCLIENTES*/
    public void OpcionEmpresa(ActionEvent actionEvent) {
        if((cbEmpresa.selectedProperty().getValue())==true){
            txtRazonSocial.setDisable(false);
            txtContacto.setDisable(false);

        }else{
            txtRazonSocial.setDisable(true);
            txtContacto.setDisable(true);
        }
    }
    /*EVENTO QUE LIMPIAR EL FORMULARIO CLIENTES*/
    public void BotonLimpiarForm(){
        txtNIT.clear();
        txtDPI.clear();
        txtRazonSocial.clear();
        txtContacto.clear();
        cbEmpresa.selectedProperty().setValue(false);
    }

    /*EVENTO PARA SALIR DEL FORMULARIO CLIENTES*/
    public void SalirFormIngresoClientes(){
        Stage StageCerrarFormIngresoC = (Stage)txtNIT.getScene().getWindow();
        StageCerrarFormIngresoC.close();
    }

    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO INGRESOPRODUCTO.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO INGRESOPRODUCTO.FXML*/
    public void OpcionGuardarProducto(ActionEvent actionEvent) {
        /*CONSTRUCTOR EMPRESAS*/
        arrayProductos.addProducto(new Productos("Categoria", txtNProducto.getText(),txtMarca.getText(),
                                    Integer.parseInt(txtPrecio.getText())));
        JOptionPane.showMessageDialog(null,"EL PRODUCTO HA SIDO ALMACENADO CON EXITO" ,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
    }

    /*EVENTO QUE LIMPIA EL FORMULARIO PRODUCTOS*/
    public void OpcionLimpiarFormProducto(){
        txtNProducto.clear();
        txtMarca.clear();
        txtPrecio.clear();
    }

    /*EVENTO PARA SALIR DEL FORMULARIO CLIENTES*/
    public void OpcionSalirProducto(){
        Stage StageCerraFormProducto = (Stage)txtNProducto.getScene().getWindow();
        StageCerraFormProducto.close();
    }


    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO CONSULTACLIENTES.FXML*/
    /*EVENTO QUE MUESTRA LOS DATOS QUE SE INGRESARON AL FORMULARIO INGRESOCLIENTES.FXML*/
    public void MostraContenidoClientes() {
        ObservableList<Clientes> clien = FXCollections.observableArrayList(arrayclientes.getListaClientes());

        tablaClientes.setItems(clien);
        columid.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("id"));
        columnNIT.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nit"));
        columDPI.setCellValueFactory(new PropertyValueFactory<Clientes, String>("dpi"));
        columNombre.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nombre"));
        columFechaNac.setCellValueFactory(new PropertyValueFactory<Clientes, String>("fecha"));
        columnGenero.setCellValueFactory(new PropertyValueFactory<Clientes, String>("genero"));
        columEstadoCivil.setCellValueFactory(new PropertyValueFactory<Clientes, String>("estadocivil"));
        columnRazonSocial.setCellValueFactory(new PropertyValueFactory<Clientes, String>("razonsocial"));
        columnContacto.setCellValueFactory(new PropertyValueFactory<Clientes, String>("contacto"));
    }

    /*LLAMAR FORMULARIO INGRESOCLIENTES.FXML*/
    public void LlamarFormIngresoClientes() throws IOException{
        GestionVistaPrincipal gv = new GestionVistaPrincipal();
        gv.OpcionMenuIngresoClientes();
    }

    /*MÉTODO DE CIERRE FORMULARIO INGRESOCLIENTES.FXML*/
    public void SalidaConsultaClientes(){
        Stage StageCerrarFormConsultaClientes = (Stage)txtIDCliente.getScene().getWindow();
        StageCerrarFormConsultaClientes.close();
    }

    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO CONSULTAPRODUCTOS.FXML*/
    /*EVENTO QUE MUESTRA LOS DATOS QUE SE INGRESARON AL FORMULARIO INGRESOPRODUCTO.FXML*/
    public void MostrarContenidoProducto() {
        ObservableList<Productos> prod = FXCollections.observableArrayList(arrayProductos.getListaProductos());
        tablaProductos.setItems(prod);
        columnIDProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
        columNProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }

    /*LLAMADA AL FORMULARIO INGRESOPRODUCTO.FXML*/
    public void LlamarFormIngresoProducto() throws IOException{
        GestionVistaPrincipal gv = new GestionVistaPrincipal();
        gv.OpcionMenuIngresoProducto();
    }

    /*SE CIERRA EL FORMULARIO CLIENTE*/
    public void SalidaConsultaProducto(){
        Stage StageCerrarFormaConsultaProductos = (Stage)txtIDProducto.getScene().getWindow();
        StageCerrarFormaConsultaProductos.close();
    }

    /*********************************************************************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MostraContenidoClientes();
        MostrarContenidoProducto();
    }
}

