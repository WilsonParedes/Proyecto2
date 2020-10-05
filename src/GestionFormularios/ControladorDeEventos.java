package GestionFormularios;
import Modulos.Herramientas.VariblesFormGlobales;
import Modulos.DataSistema.Productos;
import Modulos.DataSistema.Clientes;
import Modulos.DataSistema.ClienteIndividual;
import Modulos.DataSistema.ClienteEmpresa;
import Modulos.Herramientas.Usuarios;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import sun.misc.JavaObjectInputStreamReadString;

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
        String genero1 = RadioButtonFemeninoMasculino();
        String EstadoCivil = RadioButtonEstadoCivil();
        if ((txtNIT.getText().equals("") || (txtNIT.getLength() <= 1))) {
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
                        arrayempresa.addCliente(new ClienteEmpresa(txtNombreCompleto.getText(), txtNIT.getText(), "fecha", genero1, EstadoCivil, txtRazonSocial.getText(), txtContacto.getText(), 2));
                        JOptionPane.showMessageDialog(null, "EL CLIENTE HA SIDO ALMACENADO CON EXITO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }
            } else {
                if ((txtDPI.getText().equals("")) || (txtNombreCompleto.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null,"NO SE PUEDE ALMACENAR CLIENTE, DEBE LLENAR CAMPO DPI Y NOMBRE COMPLETO");
                    txtDPI.clear();
                    txtNombreCompleto.clear();
                } else {
                    /*CONSTRUCTOR CLIENTES INDIVIDUALES*/
                    arrayclientes.addCliente(new ClienteIndividual(txtDPI.getText(), txtNombreCompleto.getText(), txtNIT.getText(), "String fecha", genero1, EstadoCivil));
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
        txtNombreCompleto.clear();
        txtRazonSocial.clear();
        txtContacto.clear();
        cbEmpresa.selectedProperty().setValue(false);
    }

    /*EVENTO PARA SALIR DEL FORMULARIO CLIENTES*/
    public void SalirFormIngresoClientes(){
        Stage StageCerrarFormIngresoC = (Stage)txtNIT.getScene().getWindow();
        StageCerrarFormIngresoC.close();
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN NIT*/
    public void ActivadorValidaNIT(KeyEvent keyEvent){
        if(VALIDAR_NIT_DPI_OTRASCOSAS(txtNIT, 7,8)){
            BotonGuardarCliente.setDisable(false);
            paneDatosClientes.setDisable(false);
            paneDatosEmpresa.setDisable(false);
            paneGenero.setDisable(false);
            paneEstadoCivil.setDisable(false);
            MensajeAdvertenciaNIT.setText("NIT VALIDO");
        }else{
            BotonGuardarCliente.setDisable(true);
            paneDatosClientes.setDisable(true);
            paneDatosEmpresa.setDisable(true);
            paneGenero.setDisable(true);
            paneEstadoCivil.setDisable(true);
            MensajeAdvertenciaNIT.setText("NIT INVALIDO");

        }
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN NIT*/
    public void ActivarValidaDPI(KeyEvent keyEvent){
        if(VALIDAR_NIT_DPI_OTRASCOSAS(txtDPI,13,13)){
            BotonGuardarCliente.setDisable(false);
            txtNombreCompleto.setDisable(false);
            paneDatosEmpresa.setDisable(false);
            paneGenero.setDisable(false);
            paneEstadoCivil.setDisable(false);
            MensajeAlertaDPI.setText("DPI VALIDO");
        }else{
            BotonGuardarCliente.setDisable(true);
            txtNombreCompleto.setDisable(true);
            paneDatosEmpresa.setDisable(true);
            paneGenero.setDisable(false);
            paneEstadoCivil.setDisable(false);
            MensajeAlertaDPI.setText("DPI INVALIDO");

        }
    }

    /*VALIDACION DE TEXTFIELD*/
    public boolean VALIDAR_NIT_DPI_OTRASCOSAS(final TextField txtValidar, final int MINIMO, final int MAXIMO) {

        txtValidar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String valorAnterior, final String valorActual) {
                if (valorActual.length() > valorAnterior.length()) {
                    Pattern permitido = Pattern.compile("[0-9]");
                    Matcher mpermitido = permitido.matcher(valorActual.substring(valorAnterior.length()));

                    if (!mpermitido.find()) {
                        // caracter no permitido, borrarlo
                        txtValidar.setText(valorAnterior);
                        return;
                    }
                    if (txtValidar.getText().length() > MAXIMO) {
                        txtValidar.setText(txtValidar.getText().substring(0, MAXIMO));
                    }if((txtValidar.getLength()>=MINIMO && txtValidar.getLength()<=MAXIMO)){
                        Validacion = true;
                    }else{
                        Validacion = false;
                    }
                }
            }
        });
        return Validacion;
    }

    /*EVENTO QUE CONTROLA LOS RADIO BUTTON FEMENINO Y MASCULINO*/
    public String RadioButtonFemeninoMasculino(){
        String genero = "";
        RadioButton gen = (RadioButton) Genero.getSelectedToggle();
        genero = gen.getText();

    return genero;
    }

    /*EVENTO QUE CONTROLA EL ESTADO*/
    public String RadioButtonEstadoCivil(){
        String estadocivil = "";
        RadioButton civil = (RadioButton) EstadoCivil.getSelectedToggle();
        estadocivil = civil.getText();

        return estadocivil;
    }



    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO INGRESOPRODUCTO.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO INGRESOPRODUCTO.FXML*/
    public void OpcionGuardarProducto(ActionEvent actionEvent) {
        /*CONSTRUCTOR EMPRESAS*/
        String cate = RellenoCategorias();
        if(!(txtNProducto.getText().equals("")|| (txtMarca.getText().equals("") || (txtPrecio.getText().equals(""))))){
            arrayProductos.addProducto(new Productos(cate, txtNProducto.getText(),txtMarca.getText(),
                    Integer.parseInt(txtPrecio.getText())));
            JOptionPane.showMessageDialog(null,"EL PRODUCTO HA SIDO ALMACENADO CON EXITO" ,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"DEBE LLENAR TODOS LOS CAMPOS PARA PODER GUARDAR EL PRODUCTO" ,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
        }

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

    /*RELLEN EL COMBOBOX DE CATEGORIAS*/
    public String RellenoCategorias(){
        String catego = "";
        ObservableList categorias = FXCollections.observableArrayList(categoria);
        ComboBOXCategoria.setItems(categorias);
        catego = ComboBOXCategoria.getValue().toString();
        System.out.println(catego);
        return catego;
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

    /*BUSCAR POR ID CLIENTES*/
    public void BuscarClientes(ActionEvent actionEvent) {
        System.out.println(txtIDCliente);
        int posicion1 = Integer.parseInt(txtIDCliente.getText());
        try {
            ObservableList<Clientes> buscarC = FXCollections.observableArrayList(arrayclientes.getListaClientes().get(posicion1 - 1));
            tablaClientes.setItems(buscarC);
            columid.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("id"));
            columnNIT.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nit"));
            columDPI.setCellValueFactory(new PropertyValueFactory<Clientes, String>("dpi"));
            columNombre.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nombre"));
            columFechaNac.setCellValueFactory(new PropertyValueFactory<Clientes, String>("fecha"));
            columnGenero.setCellValueFactory(new PropertyValueFactory<Clientes, String>("genero"));
            columEstadoCivil.setCellValueFactory(new PropertyValueFactory<Clientes, String>("estadocivil"));
            columnRazonSocial.setCellValueFactory(new PropertyValueFactory<Clientes, String>("razonsocial"));
            columnContacto.setCellValueFactory(new PropertyValueFactory<Clientes, String>("contacto"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"NO EXISTE EL CLIENTE EN LA BDD","INFORMACION",JOptionPane.ERROR_MESSAGE);
        }

    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN PARA INGRESO DE NÚMEROS SOLAMENTE*/
    public void ActivadorValidarIngresoIDCliente(KeyEvent keyEvent){
        if(VALIDAR_NIT_DPI_OTRASCOSAS(txtIDCliente, 1,4)){
            MensajeValidacionIDCliente.setText("ID VALIDO");
            BotonBuscarCliente.setDisable(false);
            BotonFormIngresoClientes.setDisable(false);
        }else{
        }
    }


    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO CONSULTAPRODUCTOS.FXML*/
    /*EVENTO QUE MUESTRA LOS DATOS QUE SE INGRESARON AL FORMULARIO INGRESOPRODUCTO.FXML*/
    public void MostrarContenidoProducto() {
        try {
            ObservableList<Productos> prod = FXCollections.observableArrayList(arrayProductos.getListaProductos());
            tablaProductos.setItems(prod);
            columnIDProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
            columNProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE CARGAR LA BDD","ERROR",JOptionPane.ERROR_MESSAGE);
        }
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

    /*BUSCAR POR ID PRODUCTO*/
    public void BuscarProducto(ActionEvent actionEvent) {
        try {
            int posicion = Integer.parseInt(txtIDProducto.getText());
            ObservableList<Productos> buscar = FXCollections.observableArrayList(arrayProductos.getListaProductos().get((posicion) - 2000));
            tablaProductos.setItems(buscar);
            columnIDProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
            columNProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"NO EXISTE EL PRODUCTO EN LA BDD","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN PARA INGRESO DE NÚMEROS SOLAMENTE*/
    public void ActivadorValidarCodigIngreso(KeyEvent keyEvent){
        if(VALIDAR_NIT_DPI_OTRASCOSAS(txtIDProducto, 3,4)){
            MensajeValidacionIDPRod.setText("ID VALIDO");
            BotonBuscarProducto.setDisable(false);
            OpcionProductos.setDisable(false);
        }else{
            MensajeValidacionIDPRod.setText("ID INVALIDO");
            BotonBuscarProducto.setDisable(true);
            OpcionProductos.setDisable(true);
        }
    }



    /*********************************************************************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MostraContenidoClientes();
        MostrarContenidoProducto();

    }



}

