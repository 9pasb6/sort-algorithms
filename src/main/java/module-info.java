module com.example.ordenamiento {
    requires javafx.controls;
    requires javafx.fxml;
            

    opens com.example.ordenamiento to javafx.fxml;

    exports com.example.ordenamiento;
}