package ControlFormularios;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionVistaPrincipal {
    public void FormVistaPrincipal() throws IOException {
        FXMLLoader principal = new FXMLLoader(getClass().getResource("/Utilerias/Formularios/VistaPrincipal.fxml"));
        Pane pri = (Pane) principal.load();

        Scene scene = new Scene(pri, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("VISTA PRINCIPAL");
        stage.setScene(scene);
        stage.show();

    }
}
