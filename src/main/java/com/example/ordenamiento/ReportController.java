package com.example.ordenamiento;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ReportController {

    @FXML
    private TableView<DatosTiempo> datosTableView;

    @FXML
    private TableView<DatosTiempo> datosOrdenadosTableView;

    private HelloController controllerHome;
    private Stage stage;
    private TimSort timSort;

    @FXML
    private Button home;



    //private FileHandler fileHandler = new FileHandler();

    private FileHandler fileHandler = new FileHandler();


    public ReportController() {
        // Constructor sin argumentos
    }

    // Método para inicializar la instancia de TimSort
    @FXML
    public void initialize() {

        this.timSort = new TimSort();

        // Cargar datos sin ordenar
        String filePath = "C:\\Users\\pasb2\\Desktop\\Cursos\\Java\\IdeaProjects\\ordenamiento\\src\\main\\java\\com\\example\\ordenamiento\\datos";

        List<DatosTiempo> datosSinOrdenar = DatosTiempo.readDatosTiemposFromFile(filePath);
        ObservableList<DatosTiempo> datosSinOrdenarList = FXCollections.observableArrayList(datosSinOrdenar);
        datosTableView.setItems(datosSinOrdenarList);

        // Cargar datos ordenados por tiempo en segundos (descendente)
        List<DatosTiempo> datosOrdenados = new ArrayList<>(datosSinOrdenar);
        DatosTiempo.ordenarPorSegundosDescendente(datosOrdenados);
        ObservableList<DatosTiempo> datosOrdenadosList = FXCollections.observableArrayList(datosOrdenados);
        datosOrdenadosTableView.setItems(datosOrdenadosList);


    }

    public ReportController(TimSort timSort) {
        this.timSort = timSort;
    }

    @FXML
    void backHome(ActionEvent event) {
        controllerHome.show();
        stage.close();
    }

    public void init(Stage stage, HelloController helloController) {
        this.controllerHome = helloController;
        this.stage = stage;
    }


}