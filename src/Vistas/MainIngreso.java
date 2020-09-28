package Vistas;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainIngreso extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        Pane ingreso = (Pane)FXMLLoader.load(getClass().getResource("/Utilerias/Formularios/ingreso.fxml"));
        Scene escene = new Scene(ingreso, 404, 357);
        stage.setTitle("Menú_Ingreso");
        stage.setScene(escene);
        stage.show();
    }

    public static void main(String args){
        launch(args);


    }


}

