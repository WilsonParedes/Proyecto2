package Modulos.Herramientas;

import Modulos.DataSistema.Clientes;
import Modulos.DataSistema.DataSistema;
import Modulos.DataSistema.Productos;
import com.jfoenix.controls.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.Arrays;

public class VariblesFormGlobales {
    public boolean Validacion = false;


    /*ARRAY LIST GLOBA DE DATASISTEMA*/
    public DataSistema dt = new DataSistema();
    public DataSistema arrayclientes = new DataSistema();
    public DataSistema arrayempresa = new DataSistema();
    public DataSistema arrayProductos = new DataSistema();
    public DataSistema arrayListaOrden = new DataSistema();
    public String categoria [] = {"Aceites y Lubricantes", "Llantas","Accesorios"};

    /*ATRIBUTOS DE FORMULARIO INGRESO.FXML*/
    public TextField txtUsuario;
    public PasswordField txtContrasenia;
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

    /*ATRIBUTOS DE LA TABLEVIEW CONSULTACLIENTES.FXML*/
    public JFXTextField txtNuevoGeneroConsultaCliente;
    public JFXTextField txtNuevoNCompletoConsultaCliente;
    public JFXTextField txtNuevoEstadoCivilConsultaCliente;
    public Button BotonBuscarCliente;
    public Button BotonFormIngresoClientes;
    public TextField txtIDCliente;
    public TextField txtNITConsulta;
    public Label MensajeValidacionIDCliente;
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

    /*ATRIBUTOS DE FORMULARIO INGRESOPRODUCTOS.FXML*/
    public Button BotonBuscarProducto;
    public JFXComboBox ComboBOXCategoria;
    public JFXTextField txtNProducto;
    public JFXTextField txtMarca;
    public JFXTextField txtPrecio;

    /*ATRIBUTOS DE LA TABLEVIEW CONSULTAPRODUTOS.FXML*/
    public JFXTextField txtNProductoNuevoFormProd;
    public JFXTextField txtNuevaMarcaConsultaProducto;
    public JFXTextField txtNuevoPrecioConsultaProducto;
    public Button OpcionProductos;
    public Label MensajeValidacionIDPRod;
    public TextField txtIDProducto;
    public TableView<Productos> tablaProductos = new TableView<>();
    public TableColumn <Productos,String> columnIDProducto = new TableColumn<>(" ");
    public TableColumn <Productos,String> columNProducto = new TableColumn<>(" ");
    public TableColumn <Productos,String> columnMarca = new TableColumn<>(" ");
    public TableColumn <Productos,String> columnCategoria = new TableColumn<>(" ");
    public TableColumn <Productos, Integer> columnPrecio = new TableColumn<>(" ");


    /*ATRIBUTOS DE LA ORDEN DE COMPRA*/
    public Label LayoutSubtotalOrdenCompra1;
    public Label LayoutCantidadOrdenCompra;
    public Label LayouNProductoOrdenCompra;
    public Label LayoutPreUnitarioOrdenCompra;
    public Label LayoutIDProductoOrdenCompra;
    public Label LayoutNoOrdenCompra;
    public Label LayoutNITOrdeCompra;
    public Label LayoutNombreOrdenCompra;
    public Label LayoutNombreEmpresa;
    public Label LayoutContacto;
    public Label LayoutFechaOrdenCompra;
    public Label LayoutSubtotalOrdenCompra;
    public Label LayoutDescuentoOrdenCompra;
    public Label LayoutEnvioyOtrosOrdenCompra;
    public Label LayoutTotalOrdenCompra;
    public JFXTextField txtIDOrdenCompra;
    public TextField txtIDConsultaOrdenCompra;
    public JFXTextField txtMedioEnvioOrdenCompra;
    public JFXTextField txtIDProductoOrdenCompra;
    public JFXTextField txtCantidadOrdenCompra;
    public JFXTextField txtPrecioEnvioOrdenCompra;
    public JFXTextField txtDiasEnvioOrdenCompra;
    public Button BotonCargaInfoClienteOrdenCompra;

    /*ATRIBUTOS CONSULTA ORDENCOMPRA*/
    public TableView tablaOrdenCompra = new TableView();
    public TableColumn columnidOrdenCompra = new TableColumn(" ");
    public TableColumn columnFechaOrden = new TableColumn(" ");
    public TableColumn columMEnvioOrdenCompra = new TableColumn(" ");
    public TableColumn columPrecioEnvio = new TableColumn(" ");
    public TableColumn columDiasEnvio = new TableColumn(" ");
    public TableColumn columnSubTotal = new TableColumn(" ");
    public TableColumn columTotalOrdenCompra = new TableColumn(" ");
    public Button BotonSalirFormConsultaOrdenCompra;
    public Button BotonBuscarOrdenCompra;
    public JFXButton BotonModificarClienteConsultaOrdenCompra;
    public JFXButton BotoElminarOrdenCompra;
    public JFXButton BotonFormIngresoOrdenCompra;
    public JFXButton BotonGenerarTablaOrdenCompra;
    public JFXTextField txtNuevoDiasEnvio;
    public JFXTextField txtNuevoMetodoEnvio;





}
