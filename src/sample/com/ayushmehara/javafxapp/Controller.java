package sample.com.ayushmehara.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userinputfield;
    @FXML
    public Button convertbutton;

    private static final String c_to_f = "Calcius to Farenheit";
    private static final String f_to_c = "Farenheit to Calcius";

    private boolean isc_to_f = true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        choiceBox.getItems().add(c_to_f);
        choiceBox.getItems().add(f_to_c);

        choiceBox.setValue(c_to_f);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


                    if (newValue.equals(c_to_f)) {
                        isc_to_f = true;
                    } else {
                        isc_to_f = false;

                    }


                });
        convertbutton.setOnAction(event -> {
       convert();
      });

    }

    private void convert() {

        String input = userinputfield.getText();

        float enteredtemperature = 0.0f;

        try {
             enteredtemperature = Float.parseFloat(input);
        }catch (Exception exception){
            warnUser();
            return;

        }
        float newtemp = 0.0f;
        if (isc_to_f) {
            newtemp = (enteredtemperature * 9 / 5) + 32;
        }else {
            newtemp = (enteredtemperature - 32) * 5 / 9;
        }

        display(newtemp);

    }

    private void warnUser() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();
    }



    private void display(float newtemp) {

        String unit = isc_to_f? "F" : "C";

        System.out.println("the new temperature is:" + newtemp + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The New temperature is "+ newtemp + unit);
        alert.show();
    }



}
