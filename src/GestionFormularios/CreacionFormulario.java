package GestionFormularios;

import Modulos.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

    public void SalirFormIngresoClientes(){
        Stage StageCerrarFormIngresoC = (Stage)txtNIT.getScene().getWindow();
        StageCerrarFormIngresoC.close();
    }

}

