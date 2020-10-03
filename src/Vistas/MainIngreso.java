package Vistas;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainIngreso extends Application{
    private double X;
    private double Y;

    public void start(Stage stage) throws Exception {
        Pane ingreso = (Pane)FXMLLoader.load(getClass().getResource("/Utilerias/Formularios/ingreso.fxml"));
        ingreso.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                X = event.getSceneX();
                Y = event.getSceneY();

            }
        });
        ingreso.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - X);
                stage.setY(event.getScreenY() - Y);
            }
        });


        Scene escene = new Scene(ingreso, 477, 277);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Menú_Ingreso");
        stage.setScene(escene);
        stage.show();
    }

    public static void main(String args){
        launch(args);


    }


}

