package GestionFormularios;

import Modulos.Usuarios;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestiondeIngreso extends GestionVistaPrincipal implements Initializable  {

    /*EVENTO QUE SIRVE PARA DESHABILITAR LOS BOTONES AL INICIAR EL FORMULARIO INGRESO */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BotonIngreso.setDisable(true);
        BotonCrear.setDisable(true);

    }

    /*EVENTO QUE ESTA AMARRADO A LA CELDA TXTUSUARIO, HABILITA EL BOTON INGRESO MEDIA VEZ SE INGRESA CIERTA CANTIDAD
     * DE CARACTERES EN EL USUARIO*/
    public void ActivarBotonIngreso(KeyEvent keyEvent) {
        txtUsuario.setOnKeyTyped(event -> {
            if(txtUsuario.getLength()>=3){
                BotonIngreso.setDisable(false);
            }else{
                BotonIngreso.setDisable(true);
            }

        });
    }

    private ArrayList<Usuarios> u = new ArrayList<>();
    public void VIngreso(ActionEvent ingreso) throws IOException {

        if (txtUsuario.getText().equalsIgnoreCase("wilson") && txtContraseña.getText().equals("123456")) {
            JOptionPane.showMessageDialog(null, "BIEVENIDO " + txtUsuario.getText(), "Información", JOptionPane.INFORMATION_MESSAGE);

            Stage StageIngreso= (Stage)txtUsuario.getScene().getWindow();
            StageIngreso.close();

            //LLAMADA AL FORMULARIO DE VISTA PRINCIPAL, CONTROLFORMULARIOS.GESTIONVISTAPRINCIPAL
            FormVistaPrincipal();
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
                    JOptionPane.showMessageDialog(null, "BIEVENIDO " + txtUsuario.getText().toUpperCase(), "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO, INGRESE NUEVAMENTE O DE CLICK EN LA OPCIÓN CREAR", "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
                    txtUsuario.clear();
                    txtContraseña.clear();
                }

            }
        }
    }




    public void CerrarTodo(){
        Platform.exit();
    }





}
