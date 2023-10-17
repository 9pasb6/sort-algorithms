package com.example.ordenamiento;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.List;
import java.util.regex.Pattern;

public class TimSortController {

    @FXML
    private Label seconds;

    @FXML
    private Label minutes;

    @FXML
    private Label hours;

    private HelloController controllerHome;
    private Stage stage;
    private TimSort timSort;

    @FXML
    private Button home;

    @FXML
    private TextField sizeTextField; // Campo de texto para el tamaño del arreglo
    @FXML
    private TextField limitTextField; // Campo de texto para el límite superior

    //private FileHandler fileHandler = new FileHandler();

    private FileHandler fileHandler = new FileHandler();


    public TimSortController() {
        // Constructor sin argumentos
    }

    // Método para inicializar la instancia de TimSort

    @FXML
    public void initialize() {
        this.timSort = new TimSort();

        // Configura la validación para el campo sizeTextField
        Pattern validIntegerText = Pattern.compile("\\d*"); // Expresión regular para números enteros
        TextFormatter<String> sizeTextFormatter = new TextFormatter<>(change ->
        {
            if (validIntegerText.matcher(change.getControlNewText()).matches()) {
                return change;
            } else {
                return null; // No permite la entrada
            }
        });
        sizeTextField.setTextFormatter(sizeTextFormatter);

        // Configura la validación para el campo limitTextField
        TextFormatter<String> limitTextFormatter = new TextFormatter<>(change ->
        {
            if (validIntegerText.matcher(change.getControlNewText()).matches()) {
                return change;
            } else {
                return null; // No permite la entrada
            }
        });
        limitTextField.setTextFormatter(limitTextFormatter);
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

    @FXML
    public void startTimSort(ActionEvent actionEvent) {

        //validaciones
        int size;
        int limit;

        try {
            size = Integer.parseInt(sizeTextField.getText());
            limit = Integer.parseInt(limitTextField.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "Los campos no deben ir vacios y deben contener números enteros positivos.");
            return;
        }


        // una vez pasadas las validaciones continua con la logica de mi algoritmo


        double tiempo = timSort.timSort(size,limit);

        double seconds = tiempo/1000;
        double minutes = seconds /60.0;
        double hours = minutes/60.0;

        this.seconds.setText("Segundos: " + seconds);
        this.minutes.setText("Minutos: " + minutes);
        this.hours.setText("Horas: " + hours);


        // para guardar los datos en el txt

        String Name = "Tim-sort";

        String dataToSave = "Name: " + Name +"\nSize: " + size + "\nLimit: " + limit + "\nSegundos: " + seconds + "\nMinutos: " + minutes + "\nHoras: " + hours;
        fileHandler.writeToFile("C:\\Users\\pasb2\\Desktop\\Cursos\\Java\\IdeaProjects\\ordenamiento\\src\\main\\java\\com\\example\\ordenamiento\\datos", dataToSave);

        // para obtener los datos del txt, convertilos en objetos y poder acceder a sus atributos


        String filePath = "C:\\Users\\pasb2\\Desktop\\Cursos\\Java\\IdeaProjects\\ordenamiento\\src\\main\\java\\com\\example\\ordenamiento\\datos";
        List<DatosTiempo> datosTiemposList = DatosTiempo.readDatosTiemposFromFile(filePath);

        // Ordenar la lista de DatosTiempo de mayor a menor según el tiempo en segundos
        DatosTiempo.ordenarPorSegundosDescendente(datosTiemposList);

        // foreach para acceder a todos los objetos DatosTiempo
        for (DatosTiempo datosTiempo : datosTiemposList) {

            System.out.println("Name: " + datosTiempo.getName());
            System.out.println("Size: " + datosTiempo.getSize());
            System.out.println("Limit: " + datosTiempo.getLimit());
            System.out.println("Segundos: " + datosTiempo.getSegundos());
            System.out.println("Minutos: " + datosTiempo.getMinutos());
            System.out.println("Horas: " + datosTiempo.getHoras());
            System.out.println("----------");
        }

    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}