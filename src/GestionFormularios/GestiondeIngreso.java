package GestionFormularios;

import Modulos.Herramientas.Usuarios;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestiondeIngreso extends GestionVistaPrincipal implements Initializable {

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
            if((txtUsuario.getLength()>=3 && txtUsuario.getLength()<8)){
                BotonIngreso.setDisable(false);
            }else{
                BotonIngreso.setDisable(true);
            }

        });
    }

    public void VIngresoAlt(ActionEvent ingreso) throws IOException {
        if(!txtUsuario.getText().equals("admin") || !txtContrasenia.getText().equals("1234")) {
            if ((dt.getListaUsuarios().isEmpty())) {
                JOptionPane.showMessageDialog(null, "NO EXISTE NINGUN USUARIO PARA INICIAR SESIÓN, DEBE CREAR UN NUEVO USUARIO EN LA OPCIÓN CREAR", "ACCESO DENEGADO", JOptionPane.WARNING_MESSAGE);
                BotonCrear.setDisable(false);
            } else {
                for (Usuarios usu : dt.getListaUsuarios()) {
                    if (!txtUsuario.getText().equals(usu.getUsuario()) || !txtContrasenia.getText().equals(usu.getContraseña())) {
                        JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO, INGRESE NUEVAMENTE O DE CLICK EN LA OPCIÓN CREAR", "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
                        BotonCrear.setDisable(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "BIEVENIDO " + txtUsuario.getText().toUpperCase(), "Información", JOptionPane.INFORMATION_MESSAGE);
                        //LLAMADA AL FORMULARIO DE VISTA PRINCIPAL, CONTROLFORMULARIOS.GESTIONVISTAPRINCIPAL
                        FormVistaPrincipal();
                        break;
                    }

                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "BIEVENIDO ADMINISTRADOR", "Información", JOptionPane.INFORMATION_MESSAGE);
            //LLAMADA AL FORMULARIO DE VISTA PRINCIPAL, CONTROLFORMULARIOS.GESTIONVISTAPRINCIPAL
            FormVistaPrincipal();
        }
    }

    public void CerrarTodo(){
        Platform.exit();
    }

}
