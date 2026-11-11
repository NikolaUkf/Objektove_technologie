module com.example.zoznamopakovanie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zoznamopakovanie to javafx.fxml;
    exports com.example.zoznamopakovanie;
}