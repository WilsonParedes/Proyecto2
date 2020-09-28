package ControlFormularios;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

public class ControldeIngreso {
    ArrayList<>

    public TextField txtUsuario;
    public PasswordField txtContraseña;

    public void VIngreso(ActionEvent actionEvent) {
        if(txtUsuario.getText().equalsIgnoreCase("wilson") && txtContraseña.getText().equals("123456")){
            JOptionPane.showMessageDialog(null,"BIEVENIDO " + txtUsuario.getText(),"Información",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"USUARIO O CONTRASEÑA INCORRECTO, INGRESE NUEVAMENTE","ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            txtUsuario.clear();
            txtContraseña.clear();
        }
    }
}
