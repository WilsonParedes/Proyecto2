package GestionFormularios;
import Modulos.Herramientas.VariblesFormGlobales;
import Modulos.DataSistema.Productos;
import Modulos.DataSistema.Clientes;
import Modulos.DataSistema.ClienteIndividual;
import Modulos.DataSistema.ClienteEmpresa;
import Modulos.Herramientas.Usuarios;
import com.jfoenix.controls.JFXComboBox;
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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
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
    public void GuardarUsuario() {
        dt.addUsuarios(new Usuarios(txtUsuar.getText(), txtContra.getText()));
        JOptionPane.showMessageDialog(null, "USUARIO CREADO CON ÉXITO!", "USUARIO CREADO", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("GUADRA USUARIO A ARRAYLIST DE USUARIOS");
        Stage StageCrearUsuario = (Stage) txtUsuar.getScene().getWindow();
        StageCrearUsuario.close();
    }

    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO INGRESOCLIENTES.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO INGRESOCLIENTES.FXML*/
    public void BotonGuardarClientes() {
        String genero1 = RadioButtonFemeninoMasculino();
        String EstadoCivil = RadioButtonEstadoCivil();
        if ((txtNIT.getText().equals("") || (txtNIT.getLength() <= 1))) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE ALMACENAR CLIENTE, NIT INVALIDO INTENTE NUEVAMENTE");
            txtNIT.clear();
        } else {
            if ((cbEmpresa.selectedProperty().getValue())) {
                /*CONSTRUCTOR EMPRESAS*/
                if ((txtNombreCompleto.getText().equals("")) || (txtRazonSocial.getText().equals("")) || (txtContacto.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE ALMACENAR CLIENTE,NOMBRE COMPLETO, RAZON SOCIAL Y CONTACTO");
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
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE ALMACENAR CLIENTE, DEBE LLENAR CAMPO DPI Y NOMBRE COMPLETO");
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
        if ((cbEmpresa.selectedProperty().getValue())) {
            txtRazonSocial.setDisable(false);
            txtContacto.setDisable(false);
            txtDPI.setDisable(true);

        } else {
            txtRazonSocial.setDisable(true);
            txtContacto.setDisable(true);
            txtDPI.setDisable(false);
        }
    }

    /*EVENTO QUE LIMPIAR EL FORMULARIO CLIENTES*/
    public void BotonLimpiarForm() {
        txtNIT.clear();
        txtDPI.clear();
        txtNombreCompleto.clear();
        txtRazonSocial.clear();
        txtContacto.clear();
        cbEmpresa.selectedProperty().setValue(false);
    }

    /*EVENTO PARA SALIR DEL FORMULARIO CLIENTES*/
    public void SalirFormIngresoClientes() {
        Stage StageCerrarFormIngresoC = (Stage) txtNIT.getScene().getWindow();
        StageCerrarFormIngresoC.close();
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN NIT*/
    public void ActivadorValidaNIT(KeyEvent keyEvent) {
        if (VALIDAR_NIT_DPI_OTRASCOSAS(txtNIT, 7, 8)) {
            BotonGuardarCliente.setDisable(false);
            paneDatosClientes.setDisable(false);
            paneDatosEmpresa.setDisable(false);
            paneGenero.setDisable(false);
            paneEstadoCivil.setDisable(false);
            MensajeAdvertenciaNIT.setText("NIT VALIDO");
        } else {
            BotonGuardarCliente.setDisable(true);
            paneDatosClientes.setDisable(true);
            paneDatosEmpresa.setDisable(true);
            paneGenero.setDisable(true);
            paneEstadoCivil.setDisable(true);
            MensajeAdvertenciaNIT.setText("NIT INVALIDO");

        }
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN DPI*/
    public void ActivarValidaDPI(KeyEvent keyEvent) {
        if (VALIDAR_NIT_DPI_OTRASCOSAS(txtDPI, 13, 13)) {
            BotonGuardarCliente.setDisable(false);
            txtNombreCompleto.setDisable(false);
            paneDatosEmpresa.setDisable(false);
            paneGenero.setDisable(false);
            paneEstadoCivil.setDisable(false);
            MensajeAlertaDPI.setText("DPI VALIDO");
        } else {
            BotonGuardarCliente.setDisable(true);
            txtNombreCompleto.setDisable(true);
            paneDatosEmpresa.setDisable(true);
            paneGenero.setDisable(false);
            paneEstadoCivil.setDisable(false);
            MensajeAlertaDPI.setText("DPI INVALIDO");

        }
    }

    /*EVENTO QUE CONTROLA LOS RADIO BUTTON FEMENINO Y MASCULINO*/
    public String RadioButtonFemeninoMasculino() {
        String genero = "";
        RadioButton gen = (RadioButton) Genero.getSelectedToggle();
        genero = gen.getText();

        return genero;
    }

    /*EVENTO QUE CONTROLA EL ESTADOCIVIL DE LOS RADIOSBUTTON A TRAVEZ DE UN TOGGLEGRUOP*/
    public String RadioButtonEstadoCivil() {
        String estadocivil = "";
        RadioButton civil = (RadioButton) EstadoCivil.getSelectedToggle();
        estadocivil = civil.getText();

        return estadocivil;
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

    /*EVENTO PARA LLAMAR FORMULARIO INGRESOCLIENTES.FXML*/
    public void LlamarFormIngresoClientes() throws IOException {
        GestionVistaPrincipal gv = new GestionVistaPrincipal();
        gv.OpcionMenuIngresoClientes();
    }

    /*EVENTO QUE CIERRA EL FORMULARIO INGRESOCLIENTES.FXML*/
    public void SalidaConsultaClientes() {
        Stage StageCerrarFormConsultaClientes = (Stage) txtIDCliente.getScene().getWindow();
        StageCerrarFormConsultaClientes.close();
    }

    /*EVENTO PARA BUSCAR POR ID CLIENTES*/
    public void BuscarClientes(ActionEvent actionEvent) {
        try {
            ObservableList<Clientes> buscarC = FXCollections.observableArrayList(arrayclientes.getVerCliente(DevolverPosicionCliente()));
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO EXISTE EL CLIENTE EN LA BDD", "INFORMACION", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*EVENTO QUE ELIMINA AL CLIENTES DEL ARRAY*/
    public void eliminarClientes() {
        try {
            arrayclientes.getEliminarCliente(DevolverPosicionCliente());
            JOptionPane.showMessageDialog(null, "CLIENTE ELIMINADO CON ÉXTIO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO EXISTE EL CLIENTE EN LA BDD", "INFORMACION", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN PARA INGRESO DE NÚMEROS SOLAMENTE*/
    public void ActivadorValidarIngresoIDCliente(KeyEvent keyEvent) {
        if (VALIDAR_NIT_DPI_OTRASCOSAS(txtIDCliente, 1, 4)) {
            MensajeValidacionIDCliente.setText("ID VALIDO");
            BotonBuscarCliente.setDisable(false);
            BotonFormIngresoClientes.setDisable(false);
        } else {
        }
    }
    /*METODO QUE DEVUELVE LA POSICIÓN DE UN CLIENTE DENTRO DEL ARRAYCLIENTES*/
    public int DevolverPosicionCliente() {
        ArrayList<Clientes> c;
        int contador = 0;
        int idnumero;
        c = arrayclientes.getListaClientes();
        if (txtIDCliente.getText().equalsIgnoreCase("")) {
            idnumero = 0;
            for (Clientes cli : c) {
                if (cli.getNit().equalsIgnoreCase(txtNITConsulta.getText())) {
                    break;
                }
                contador++;
            }
        } else {
            idnumero = Integer.parseInt(txtIDCliente.getText());
            for (Clientes cli : c) {
                if (idnumero == cli.getId()) {
                    break;
                }
                contador++;
            }
        }
        return contador;
    }

    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO INGRESOPRODUCTO.FXML*/
    /*EVENTO QUE GUARDA LOS DATOS INGRESADOS AL FORMULARIO INGRESOPRODUCTO.FXML*/
    public void OpcionGuardarProducto(ActionEvent actionEvent) {
        /*CONSTRUCTOR EMPRESAS*/
        String cate = RellenoCategorias();
        if (!(txtNProducto.getText().equals("") || (txtMarca.getText().equals("") || (txtPrecio.getText().equals(""))))) {
            arrayProductos.addProducto(new Productos(cate, txtNProducto.getText(), txtMarca.getText(),
                    Integer.parseInt(txtPrecio.getText())));
            JOptionPane.showMessageDialog(null, "EL PRODUCTO HA SIDO ALMACENADO CON EXITO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS PARA PODER GUARDAR EL PRODUCTO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /*EVENTO QUE LIMPIA EL FORMULARIO PRODUCTOS*/
    public void OpcionLimpiarFormProducto() {
        txtNProducto.clear();
        txtMarca.clear();
        txtPrecio.clear();
    }

    /*EVENTO PARA SALIR DEL FORMULARIO INGRESOPRODUCTOS*/
    public void OpcionSalirProducto() {
        Stage StageCerraFormProducto = (Stage) txtNProducto.getScene().getWindow();
        StageCerraFormProducto.close();
    }

    /*EVENTO QUE RELLENA EL COMBOBOX DE CATEGORIAS*/
    public String RellenoCategorias() {
        String catego = "";
        try {
            ObservableList categorias = FXCollections.observableArrayList(categoria);
            ComboBOXCategoria.setItems(categorias);
            catego = ComboBOXCategoria.getValue().toString();
            System.out.println(catego);
        }catch(Exception e){

        }
        return catego;
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE CARGAR LA BDD", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*EVENTO QUE REALIZA LA LLAMADA AL FORMULARIO INGRESOPRODUCTO.FXML*/
    public void LlamarFormIngresoProducto() throws IOException {
        GestionVistaPrincipal gv = new GestionVistaPrincipal();
        gv.OpcionMenuIngresoProducto();
    }

    /*EVENTO QUE CIERRA EL FORMULARIO CLIENTE*/
    public void SalidaConsultaProducto() {
        Stage StageCerrarFormaConsultaProductos = (Stage) txtIDProducto.getScene().getWindow();
        StageCerrarFormaConsultaProductos.close();
    }

    /*EVENTO ENCARGADO DE BUSCAR POR ID PRODUCTO*/
    public void BuscarProducto(ActionEvent actionEvent) {
        try {
            ObservableList<Productos> buscar = FXCollections.observableArrayList(arrayProductos.getListaProductos().get((DevolverPosicionProducto())));
            tablaProductos.setItems(buscar);
            columnIDProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
            columNProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO EXISTE EL PRODUCTO EN LA BDD", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*EVENTO ENCARGADO DE ACTIVAR LA VALIDACIÓN PARA INGRESO DE NÚMEROS SOLAMENTE*/
    public void ActivadorValidarCodigIngreso(KeyEvent keyEvent) {
        if (VALIDAR_NIT_DPI_OTRASCOSAS(txtIDProducto, 3, 4)) {
            MensajeValidacionIDPRod.setText("ID VALIDO");
            BotonBuscarProducto.setDisable(false);
            OpcionProductos.setDisable(false);
        } else {
            MensajeValidacionIDPRod.setText("ID INVALIDO");
            BotonBuscarProducto.setDisable(true);
            OpcionProductos.setDisable(true);
        }
    }

    /*EVENTO QUE RELLNEA EL COMBOBOX DE CATEGORIASENCONSULTAPRODUCTOS*/
    public String RellenoCategoriasConsulta() {
        String catego = "";
        try {
            ObservableList categorias = FXCollections.observableArrayList(categoria);
            ComboBoxCategoriaConsultaProducto.setItems(categorias);
            catego = ComboBoxCategoriaConsultaProducto.getValue().toString();
            System.out.println(catego);
        }catch(Exception e){

        }
        return catego;
    }

    /*EVENTO QUE ELIMINA UN PRODUCTO DEL ARRAY*/
    public void eliminarProducto() {
        try {
            arrayProductos.getEliminarProducto(DevolverPosicionProducto());
            JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO CON ÉXTIO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO EXISTE EL PRODUCTO EN LA BDD", "INFORMACION", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*METODO QUE DEVUELVE LA POSICIÓN DONDE SE ENCUENTRA UN PRODUCTO DENTRO DEL ARRAY*/
    public int DevolverPosicionProducto(){
        ArrayList <Productos> p;
        int contador=0;
        int idnumero;
        p = arrayclientes.getListaProductos();
        if(txtIDProducto.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null,"FAVOR LLENAR CAMPO IDPRODUCTO","INFORMACIÓN",JOptionPane.INFORMATION_MESSAGE);
            contador--;
        }else{
            idnumero =Integer.parseInt(txtIDProducto.getText());
            for(Productos pro:p){
                if(idnumero == pro.getId()){
                    break;
                }
                contador++;
            }
        }
        return contador;
    }

    /*********************************************************************************************************************/
    /*EVENTOS PARA EL FORMULARIO ORDENCOMPRA.FXML*/
    /*EVENTOS QUE CONTROLAN LA ORDEN DE COMPRA CARGA INFORMACIÓN DE CLIENTE*/
    public void MostrarInfoClienteOrdenCompra(ActionEvent actionEvent) {
        try{

            int ID = Integer.parseInt(txtIDOrdenCompra.getText());
            LayoutNITOrdeCompra.setText(arrayclientes.getVerCliente(ID).getNit());
            LayoutNombreOrdenCompra.setText(arrayclientes.getVerCliente(ID).getNombre());
            LayoutNombreEmpresa.setText("");
            LayoutContacto.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"EL CLIENTE NO EXISTE EN LA BDD", "ERROR",JOptionPane.ERROR_MESSAGE);
        }

    }

    public void MostrarInformacionProductos(ActionEvent actionEvent) {
        try{

            int ID = Integer.parseInt(txtIDOrdenCompra.getText());
            LayoutNITOrdeCompra.setText(arrayclientes.getVerCliente(ID).getNit());
            LayoutNombreOrdenCompra.setText(arrayclientes.getVerCliente(ID).getNombre());
            LayoutNombreEmpresa.setText("");
            LayoutContacto.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"EL CLIENTE NO EXISTE EN LA BDD", "ERROR",JOptionPane.ERROR_MESSAGE);
        }

    }
    /*********************************************************************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MostraContenidoClientes();
        MostrarContenidoProducto();

    }

    /*MÉTODO DE ACCESO MULTILPLE, CONTRALA LA VALIDACIÓN DE NIT, DPI, ID PRODUCTO, ID CLIENTE DE OTROS FORMULARIOS
    A TRAVEZ DE LO INGRESADO EN TEXTFIELD*/
    /*SE SEPARA DEL RESTO DE EVENTOS PARA QUE SE VISUALICE QUE ES UN MÉTODO MULTIPLE INGRESO*/
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
                    }
                    if ((txtValidar.getLength() >= MINIMO && txtValidar.getLength() <= MAXIMO)) {
                        Validacion = true;
                    } else {
                        Validacion = false;
                    }
                }
            }
        });
        return Validacion;
    }


}

