package com.example.ordenamiento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ordenamiento/hello-view.fxml"));
        Parent root = loader.load();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        HelloController controller = loader.getController();// para acceder a lavista del home
        controller.setStage(stage);
        stage.setTitle("Ordenamiento");
        stage.show();









    }

    public static void main(String[] args) {
        launch();
    }
}