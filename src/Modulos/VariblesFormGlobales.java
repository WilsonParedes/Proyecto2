package Modulos;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;

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

    /*ATRIBUTOS DE LA TABLEVIEW*/



    /*public TableColumn <Clientes, String> columDPI = new TableColumn<>("DPI");*/
    public TableView <Clientes> tablaClientes = new TableView<>();
    public TableColumn <Clientes, Integer> columid;
    public TableColumn <Clientes, String>columnNIT ;
    public TableColumn <Clientes, String>columNombre ;
    public TableColumn <Clientes, String>columFechaNac ;
    public TableColumn <Clientes, String>columnGenero ;
    public TableColumn <Clientes, String>columEstadoCivil ;

    /*public TableColumn <Clientes, String>columnRazonSocial = new TableColumn<>("Razon Social");
    public TableColumn <Clientes, String>columnContacto = new TableColumn<>("Contacto Empresa");;*/








}
