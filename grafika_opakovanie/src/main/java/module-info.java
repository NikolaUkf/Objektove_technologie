module com.example.opakovanieyas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.opakovanieyas to javafx.fxml;
    exports com.example.opakovanieyas;
}