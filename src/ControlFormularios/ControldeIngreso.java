package ControlFormularios;

import Modulos.Usuarios;
import Vistas.MainIngreso;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ControldeIngreso {
    private ArrayList<Usuarios> u = new ArrayList<>();
    public TextField txtUsuario;
    public PasswordField txtContraseña;
    public TextField txtPNombre;
    public TextField txtPApellido;
    public TextField txtUsuar;
    public PasswordField txtContra;


    public void VIngreso(ActionEvent ingreso) throws IOException {
        if (txtUsuario.getText().equalsIgnoreCase("wilson") && txtContraseña.getText().equals("123456")) {
            JOptionPane.showMessageDialog(null, "BIEVENIDO " + txtUsuario.getText(), "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO, INGRESE NUEVAMENTE O DE CLICK EN LA OPCIÓN CREAR", "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            txtUsuario.clear();
            txtContraseña.clear();
        }
    }

    public void VIngresoAlt(ActionEvent ingreso) throws IOException {

        if((u.isEmpty())==true){
            JOptionPane.showMessageDialog(null, "NO EXISTE NINGUN USUARIO PARA INICIAR SESIÓN, DEBE CRERA UNO NUEVO", "ACCESO INCORRECTO", JOptionPane.WARNING_MESSAGE);
        }else {
            for (Usuarios usu : u) {
                if (txtUsuario.getText().equals(usu.getUsuario().toString()) && txtContraseña.getText().equals(usu.getContraseña().toString())) {
                    JOptionPane.showMessageDialog(null, "BIEVENIDO " + txtUsuario.getText(), "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO, INGRESE NUEVAMENTE O DE CLICK EN LA OPCIÓN CREAR", "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
                    txtUsuario.clear();
                    txtContraseña.clear();
                }

            }
        }
    }

    public void VCrear(ActionEvent crear) throws IOException {
         FXMLLoader creacion = new FXMLLoader(getClass().getResource("/Utilerias/Formularios/creacion.fxml"));
         Pane cre = (Pane) creacion.load();

         Scene scene = new Scene(cre, 400, 500);
         Stage stage = new Stage();
         stage.setTitle("CREACIÓN DE USUARIO");
         stage.setScene(scene);
         stage.show();

         /*Stage stageLogin = (Stage)txtUsuario.getScene().getWindow();
         stageLogin.close();*/
    }

    public void GuardarUsuario(){

        u.add(new Usuarios(txtPNombre.getText(),txtPApellido.getText(),txtUsuar.getText(),txtContra.getText()));

        System.out.println(u.toString());

        txtPNombre.clear();
        txtPApellido.clear();
        txtUsuar.clear();
        txtContra.clear();

    }

    public void cerrar(){

        Stage StageCrearUsuario = (Stage)txtUsuar.getScene().getWindow();
        StageCrearUsuario.close();
        
    }
}
