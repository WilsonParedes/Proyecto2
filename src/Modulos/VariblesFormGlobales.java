package Modulos;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;

import java.util.ArrayList;

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
    public TextField txtNIT;
    public TextField txtDPI;
    public TextField txtPNombre;
    public TextField txtSNombre;
    public TextField txtPApellido;
    public TextField txtSApellido;
    public JFXTextField txtRazonSocial;
    public JFXTextField txtContacto;
    public DatePicker DateFecha;
    public MenuButton MenuEstadoCivil;
    public Button BotonGuardarCliente;
    public Button BotonCancelarCliente;
    public JFXCheckBox cbEmpresa;

    /*ATRIBUTOS DE FORMULARIO INGRESOPRODUCTOS.FXML*/
    public JFXTextField txtNProducto;
    public JFXTextField txtMarca;
    public JFXTextField txtPrecio;

    /*ATRIBUTOS DE LA TABLEVIEW CONSULTACLIENTES.FXML*/
    public TextField txtIDCliente;
    public ArrayList<Clientes> c = new ArrayList<>();
    public TableView <Clientes> tablaClientes = new TableView<>();
    public TableColumn <Clientes, Integer> columid = new TableColumn<Clientes, Integer>("Id");
    public TableColumn <Clientes, String>columnNIT = new TableColumn<Clientes, String>("NIT");
    public TableColumn <Clientes, String> columDPI = new TableColumn<>("DPI");
    public TableColumn <Clientes, String>columNombre = new TableColumn<Clientes, String>("Nombre");
    public TableColumn <Clientes, String>columFechaNac = new TableColumn<Clientes, String>("Fecha Nacimiento");
    public TableColumn <Clientes, String>columnGenero = new TableColumn<Clientes, String>("Genero");
    public TableColumn <Clientes, String>columEstadoCivil = new TableColumn<Clientes, String>("Estado Civil");
    public TableColumn <Clientes, String>columnRazonSocial = new TableColumn<>("Razon Social");
    public TableColumn <Clientes, String>columnContacto = new TableColumn<>("Contacto Empresa");

    /*ATRIBUTOS DE LA TABLEVIEW CONSULTAPRODUTOS.FXML*/
    public TextField txtIDProducto;
    public ArrayList<Productos> p = new ArrayList<>();
    public TableView<Productos> tablaProductos = new TableView<>();
    public TableColumn <Productos,String> columnIDProducto = new TableColumn<>("ID");
    public TableColumn <Productos,String> columNProducto = new TableColumn<>("Nombre Produto");
    public TableColumn <Productos,String> columnMarca = new TableColumn<>("Marca");
    public TableColumn <Productos,String> columnCategoria = new TableColumn<>("Categoria");
    public TableColumn <Productos, Integer> columnPrecio = new TableColumn<>("Precio");








}
