package GestionFormularios;

import Modulos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;

public class CreacionFormulario extends VariblesFormGlobales {

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
    DataSistema dt = new DataSistema();
    DataSistema arrayclientes = new DataSistema();
    DataSistema arrayempresa = new DataSistema();
    DataSistema arrayProductos = new DataSistema();
    public void GuardarUsuario(){
        dt.addUsuarios(new Usuarios(txtUsuar.getText(), txtContra.getText()));
        JOptionPane.showMessageDialog(null, "USUARIO CREADO CON ÉXITO!", "USUARIO CREADO", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("GUADRA USUARIO A ARRAYLIST DE USUARIOS");
        Stage StageCrearUsuario = (Stage)txtUsuar.getScene().getWindow();
        StageCrearUsuario.close();
    }
    /*EVENTO QUE CIERRA EL FORMULARIO
    public void cerrar() throws IOException {
        System.out.println(dt.getListaUsuarios().toString());
        Stage StageCrearUsuario = (Stage)txtUsuar.getScene().getWindow();
        StageCrearUsuario.close();
    }*/




    /*EVENTOS PARA EL FORMULARIO INGRESOCLIENTES.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO INGRESOCLIENTES.FXML*/
    public void BotonGuardarClientes() {
        if((cbEmpresa.selectedProperty().getValue())==true){
            /*CONSTRUCTOR EMPRESAS*/
            arrayempresa.addCliente(new ClienteEmpresa(txtPNombre.getText(),txtSNombre.getText(), txtPApellido.getText(),txtSApellido.getText(),
                    txtNIT.getText(), "fecha", "genero", "estado civil", txtRazonSocial.getText(), txtContacto.getText(),
                    2));
        }else{

            /*CONSTRUCTOR CLIENTES INDIVIDUALES*/
            arrayclientes.addCliente(new ClienteIndividual(txtDPI.getText(), txtPNombre.getText(),txtSNombre.getText(), txtPApellido.getText(),
                    txtSApellido.getText(), txtNIT.getText(), "String fecha", "String genero", "String estadocivil"));

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
        txtPNombre.clear();
        txtSNombre.clear();
        txtPApellido.clear();
        txtSApellido.clear();
        txtRazonSocial.clear();
        txtContacto.clear();
        cbEmpresa.selectedProperty().setValue(false);
    }

    /*EVENTO PARA SALIR DEL FORMULARIO CLIENTES*/
    public void SalirFormIngresoClientes(){
        Stage StageCerrarFormIngresoC = (Stage)txtNIT.getScene().getWindow();
        StageCerrarFormIngresoC.close();
    }


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

    /*EVENTO QUE MUESTRA TODOS LOS REGISTROS EN TABLEVIEW DE CLIENTES*/
    public void MostraContenidoClientes() {
        c= arrayclientes.getListaClientes();
        ObservableList<Clientes> clien = FXCollections.observableArrayList(c);
        columid.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("id"));
        columnNIT.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nit"));
        columDPI.setCellValueFactory(new PropertyValueFactory<Clientes, String>("dpi"));
        columNombre.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nombre"));
        columFechaNac.setCellValueFactory(new PropertyValueFactory<Clientes, String>("fecha"));
        columnGenero.setCellValueFactory(new PropertyValueFactory<Clientes, String>("genero"));
        columEstadoCivil.setCellValueFactory(new PropertyValueFactory<Clientes, String>("estadocivil"));
        columnRazonSocial.setCellValueFactory(new PropertyValueFactory<Clientes, String>("razonsocial"));
        columnContacto.setCellValueFactory(new PropertyValueFactory<Clientes, String>("contacto"));

        tablaClientes.setItems(clien);
        System.out.println(clien.toString());

    }
    public void SalidaConsultaClientes(){
        Stage StageCerrarFormConsultaClientes = (Stage)txtIDCliente.getScene().getWindow();
        StageCerrarFormConsultaClientes.close();
    }

    /*EVENTO QUE MUESTRA TODOS LOS REGISTROS EN TABLEVIEW DE CLIENTES*/
    public void MostrarContenidoProducto() {
        p = arrayProductos.getListaProductos();
        ObservableList<Productos> prod = FXCollections.observableArrayList(p);
        columnIDProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
        columNProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tablaProductos.setItems(prod);
        System.out.println(prod.toString());

    }

    public void SalidaConsultaProducto(){
        Stage StageCerrarFormaConsultaProductos = (Stage)txtIDProducto.getScene().getWindow();
        StageCerrarFormaConsultaProductos.close();
    }
}

