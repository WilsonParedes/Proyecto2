package GestionFormularios;

import Modulos.DataSistema;
import Modulos.Usuarios;
import Modulos.VariblesFormGlobales;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

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
    public void GuardarUsuario(){
        dt.addUsuarios(new Usuarios(txtUsuar.getText(), txtContra.getText()));
        JOptionPane.showMessageDialog(null, "USUARIO CREADO CON ÉXITO!", "USUARIO CREADO", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("GUADRA USUARIO A ARRAYLIST DE USUARIOS");
        txtUsuar.clear();
        txtContra.clear();

    }
    /*EVENTO QUE CIERRA EL FORMULARIO*/
    public void cerrar() throws IOException {
        System.out.println(dt.getListaUsuarios().toString());
        Stage StageCrearUsuario = (Stage)txtUsuar.getScene().getWindow();
        StageCrearUsuario.close();
    }
}

