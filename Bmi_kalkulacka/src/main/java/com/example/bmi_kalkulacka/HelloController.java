package com.example.bmi_kalkulacka;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private TextField vyska;

    @FXML
    private TextField vaha;

    @FXML
    private TextField bmi;

    @FXML
    private Text vysledokText;

    @FXML
    private Button vypocitaj;

    @FXML
    private Button resetuj;

    @FXML
    public void initialize() {
        vysledokText.setText("");
        vypocitaj.setOnAction(e -> vypocitajBMI());
        resetuj.setOnAction(e -> resetujPolia());
    }

    private void vypocitajBMI() {
        try {
            double v = Double.parseDouble(vyska.getText());
            double vag = Double.parseDouble(vaha.getText());

            if (v <= 0 || vag <= 0) {
                vysledokText.setText("Zadajte kladné čísla");
                return;
            }

            double vyskaM = v > 3 ? v / 100.0 : v;
            double bmiHodnota = vag / (vyskaM * vyskaM);

            bmi.setText(String.format("%.2f", bmiHodnota));

            String kategoria;
            if (bmiHodnota < 18.5) {
                kategoria = "Podvýživa";
            } else if (bmiHodnota < 25.0) {
                kategoria = "Normálna hmotnosť";
            } else if (bmiHodnota < 30.0) {
                kategoria = "Nadváha";
            } else {
                kategoria = "Obezita";
            }

            vysledokText.setText(kategoria);

        } catch (NumberFormatException ex) {
            vysledokText.setText("Chyba vstupu");
        }
    }

    private void resetujPolia() {
        vyska.clear();
        vaha.clear();
        bmi.clear();
        vysledokText.setText("");
    }
}