package GestionFormularios;
import Modulos.Herramientas.VariblesFormGlobales;
import Modulos.DataSistema.Productos;
import Modulos.DataSistema.Clientes;
import Modulos.DataSistema.ClienteIndividual;
import Modulos.DataSistema.ClienteEmpresa;
import Modulos.Herramientas.Usuarios;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO INGRESOCLIENTES.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO INGRESOCLIENTES.FXML*/
    public void BotonGuardarClientes() {
        System.out.println(nit);
        if ((nit.equals("") || (nit.length() <= 1))) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE ALMACENAR CLIENTE, NIT INVALIDO INTENTE NUEVAMENTE");
            txtNIT.clear();
        } else {
            if ((cbEmpresa.selectedProperty().getValue())) {
                /*CONSTRUCTOR EMPRESAS*/
                if ((txtNombreCompleto.getText().equals("")) || (txtRazonSocial.getText().equals("")) || (txtContacto.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null,"NO SE PUEDE ALMACENAR CLIENTE,NOMBRE COMPLETO, RAZON SOCIAL Y CONTACTO");
                    txtDPI.clear();
                    txtNombreCompleto.clear();
                    txtRazonSocial.clear();
                    txtContacto.clear();
                    } else {
                        arrayempresa.addCliente(new ClienteEmpresa(txtNombreCompleto.getText(), txtNIT.getText(), "fecha", "genero", "estado civil", txtRazonSocial.getText(), txtContacto.getText(), 2));
                        JOptionPane.showMessageDialog(null, "EL CLIENTE HA SIDO ALMACENADO CON EXITO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }
            } else {
                if ((txtDPI.getText().equals("")) || (txtNombreCompleto.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null,"NO SE PUEDE ALMACENAR CLIENTE, DEBE LLENAR CAMPO DPI Y NOMBRE COMPLETO");
                    txtDPI.clear();
                    txtNombreCompleto.clear();
                } else {
                    /*CONSTRUCTOR CLIENTES INDIVIDUALES*/
                    arrayclientes.addCliente(new ClienteIndividual(txtDPI.getText(), txtNombreCompleto.getText(), txtNIT.getText(), "String fecha", "String genero", "String estadocivil"));
                    JOptionPane.showMessageDialog(null, "EL CLIENTE HA SIDO ALMACENADO CON EXITO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    /*EVENTO QUE INHABILITA EL TXTRAZONSOCIAL DEL FORMULARIO INGRESOCLIENTES*/
    public void OpcionEmpresa(ActionEvent actionEvent) {
        if((cbEmpresa.selectedProperty().getValue())){
            txtRazonSocial.setDisable(false);
            txtContacto.setDisable(false);
            txtDPI.setDisable(true);

        }else{
            txtRazonSocial.setDisable(true);
            txtContacto.setDisable(true);
            txtDPI.setDisable(false);
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
    String nit;
    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN NIT*/
    public void ActivadorValidaNIT(KeyEvent keyEvent){
        nit = (ValidarNit(txtNIT,8));
    }

    /*VALIDACION NIT*/
    public String ValidarNit(final TextField NIT, final int MAXIMO) {
        NIT.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String valorAnterior, final String valorActual) {

                if (valorActual.length() > valorAnterior.length()) {
                    Pattern permitido = Pattern.compile("[0-9]");
                    Matcher mpermitido = permitido.matcher(valorActual.substring(valorAnterior.length()));
                    MensajeAdvertenciaNIT.setText("");

                    if (!mpermitido.find()) {
                        // caracter no permitido, borrarlo
                        NIT.setText(valorAnterior);
                        return;
                    }
                    if (NIT.getText().length() > MAXIMO) {
                        NIT.setText(NIT.getText().substring(0, MAXIMO));
                    }if((NIT.getLength()>6 && NIT.getLength()<=8)){
                        BotonGuardarCliente.setDisable(false);
                        paneDatosClientes.setDisable(false);
                        paneDatosEmpresa.setDisable(false);
                        MensajeAdvertenciaNIT.setText("NIT VALIDO");
                    }else{
                        BotonGuardarCliente.setDisable(true);
                        paneDatosClientes.setDisable(true);
                        paneDatosEmpresa.setDisable(true);
                        MensajeAdvertenciaNIT.setText("NIT INVALIDO");
                    }
                }
            }
        });
        return NIT.getText();
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN NIT*/
    public void ActivarValidaDPI(KeyEvent keyEvent){
        ValidarDPI(txtDPI,13);
    }

    /*MÉTODO QUE VALIDA EL DPI*/
    public void ValidarDPI(final @NotNull TextField DPI, final int MAXIMO) {
        DPI.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String valorAnterior, final String valorActual) {

                if (valorActual.length() > valorAnterior.length()) {
                    Pattern permitido = Pattern.compile("^[0-9]");
                    Matcher mpermitido = permitido.matcher(valorActual.substring(valorAnterior.length()));
                    MensajeAlertaDPI.setText("");

                    if (!mpermitido.find()) {
                        // caracter no permitido, borrarlo
                        DPI.setText(valorAnterior);
                        return;
                    }
                    if (DPI.getText().length() > MAXIMO) {
                        DPI.setText(DPI.getText().substring(0, MAXIMO));
                    }if((txtDPI.getLength()==13)){
                        BotonGuardarCliente.setDisable(false);
                        txtNombreCompleto.setDisable(false);
                        paneDatosEmpresa.setDisable(false);
                        MensajeAlertaDPI.setText("DPI VALIDO");
                    }else{
                        BotonGuardarCliente.setDisable(true);
                        txtNombreCompleto.setDisable(true);
                        paneDatosEmpresa.setDisable(true);
                        MensajeAlertaDPI.setText("DPI INVALIDO");
                    }
                }
            }
        });
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
        System.out.println(clien.toString());
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

