module com.example.bmi_kalkulacka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bmi_kalkulacka to javafx.fxml;
    exports com.example.bmi_kalkulacka;
}