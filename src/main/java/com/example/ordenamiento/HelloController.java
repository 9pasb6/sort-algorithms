package com.example.ordenamiento;
import com.example.ordenamiento.TimSortController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private  Stage stage;

    @FXML
    private Label welcomeText;

    public void show() {

       stage.show();

    }




    @FXML
    private Button timPage;

    @FXML
    void showTimWindow(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ordenamiento/tim-sort.fxml"));
        Parent root = loader.load();
        TimSortController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        controller.init(stage, this);
        stage.show();
        this.stage.close();

    }


    @FXML
    void showCombWindow(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ordenamiento/comb-sort.fxml"));
        Parent root = loader.load();
        CombSortController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        controller.init(stage, this);
        stage.show();
        this.stage.close();

    }

    @FXML
    void showSeleccionWindow(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ordenamiento/seleccion-sort.fxml"));
        Parent root = loader.load();
        SeleccionSortController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        controller.init(stage, this);
        stage.show();
        this.stage.close();

    }

    @FXML
    void showReportWindow(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ordenamiento/report.fxml"));
        Parent root = loader.load();
        ReportController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        controller.init(stage, this);
        stage.show();
        this.stage.close();

    }

    @FXML
    void showTreeWindow(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ordenamiento/tree-sort.fxml"));
        Parent root = loader.load();
        TreeSortController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        controller.init(stage, this);
        stage.show();
        this.stage.close();

    }

    public void setStage(Stage primaryStage) {

        stage = primaryStage;

    }
}
