package Modulos.Herramientas;

import Modulos.DataSistema.Clientes;
import Modulos.DataSistema.DataSistema;
import Modulos.DataSistema.Productos;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.Arrays;

public class VariblesFormGlobales {
    /*ATRIBUTOS DE FORMULARIO INGRESO.FXML*/
    public TextField txtUsuario;
    public PasswordField txtContraseña;
    public Button BotonIngreso;
    public Button BotonCrear;

    /*ATRIBUTOS DE FORMULARIO CREACION.FXML*/
    public TextField txtUsuar;
    public PasswordField txtContra;
    public Button BotonCrearUsuario;

    /*ATRIBUTOS DE FORMULARIO INGRESOCLIENTES.FXML*/
    public ToggleGroup Genero;
    public ToggleGroup EstadoCivil;
    public Pane paneEstadoCivil;
    public Pane paneGenero;
    public AnchorPane paneDatosClientes;
    public AnchorPane paneDatosEmpresa;
    public AnchorPane paneNIT;
    public Label MensajeAlertaDPI;
    public Label MensajeAdvertenciaNIT;
    public JFXRadioButton RadioFemenino;
    public JFXRadioButton RadioMasculino;
    public JFXRadioButton RadioCasado;
    public JFXTextField txtNIT;
    public JFXTextField txtDPI;
    public JFXTextField txtNombreCompleto;
    public JFXTextField txtRazonSocial;
    public JFXTextField txtContacto;
    public DatePicker DateFecha;
    public Button BotonGuardarCliente;
    public Button BotonCancelarCliente;
    public JFXCheckBox cbEmpresa;

    /*ATRIBUTOS DE FORMULARIO INGRESOPRODUCTOS.FXML*/
    public String categoria [] = {"Aceites y Lubricantes", "Llantas","Accesorios"};
    public JFXComboBox ComboBOXCategoria;
    public JFXTextField txtNProducto;
    public JFXTextField txtMarca;
    public JFXTextField txtPrecio;

    /*ATRIBUTOS DE LA TABLEVIEW CONSULTACLIENTES.FXML*/
    public TextField txtIDCliente;
    public TableView <Clientes> tablaClientes = new TableView<>();
    public TableColumn <Clientes, Integer> columid = new TableColumn<Clientes, Integer>(" ");
    public TableColumn <Clientes, String>columnNIT = new TableColumn<Clientes, String>(" ");
    public TableColumn <Clientes, String> columDPI = new TableColumn<>(" ");
    public TableColumn <Clientes, String>columNombre = new TableColumn<Clientes, String>(" ");
    public TableColumn <Clientes, String>columFechaNac = new TableColumn<Clientes, String>(" ");
    public TableColumn <Clientes, String>columnGenero = new TableColumn<Clientes, String>(" ");
    public TableColumn <Clientes, String>columEstadoCivil = new TableColumn<Clientes, String>(" ");
    public TableColumn <Clientes, String>columnRazonSocial = new TableColumn<>(" ");
    public TableColumn <Clientes, String>columnContacto = new TableColumn<>(" ");

    /*ATRIBUTOS DE LA TABLEVIEW CONSULTAPRODUTOS.FXML*/
    public TextField txtIDProducto;
    public TableView<Productos> tablaProductos = new TableView<>();
    public TableColumn <Productos,String> columnIDProducto = new TableColumn<>(" ");
    public TableColumn <Productos,String> columNProducto = new TableColumn<>(" ");
    public TableColumn <Productos,String> columnMarca = new TableColumn<>(" ");
    public TableColumn <Productos,String> columnCategoria = new TableColumn<>(" ");
    public TableColumn <Productos, Integer> columnPrecio = new TableColumn<>(" ");

    /*ARRAY LIST GLOBA DE DATASISTEMA*/
    public DataSistema dt = new DataSistema();
    public DataSistema arrayclientes = new DataSistema();
    public DataSistema arrayempresa = new DataSistema();
    public DataSistema arrayProductos = new DataSistema();









}