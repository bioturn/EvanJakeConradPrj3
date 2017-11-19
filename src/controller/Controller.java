package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import objects.NumberTextField;

public class Controller {

    @FXML
    private NumberTextField tempInput;

    @FXML
    private Button outsideTemp;

    @FXML
    private Label currentTempLabel;

    @FXML
    private Label desiredTempLabel;

    @FXML
    private Label currentDeviceLabel;

    @FXML
    private Label outsideTempLabel;

    @FXML
    private Button desiredTemp;

    @FXML
    private Button currentTemp;

    @FXML
    private Button heat;

    @FXML
    private Button ac;

    @FXML
    private Button fan;

    @FXML
    private Button none;

    @FXML
    void initialize() {
        currentTemp.setOnAction((event) -> {
            currentTempLabel.setText(tempInput.getText());
        });
        desiredTemp.setOnAction((event) ->  {
            desiredTempLabel.setText(tempInput.getText());
        });
        outsideTemp.setOnAction((event) ->  {
            outsideTempLabel.setText(tempInput.getText());
        });
        heat.setOnAction((event) ->  {
            currentDeviceLabel.setText("Heater is Working");
        });
        fan.setOnAction((event) ->  {
            currentDeviceLabel.setText("Fan is Working");
        });
        ac.setOnAction((event) ->  {
            currentDeviceLabel.setText("AC is Working");
        });
        none.setOnAction((event) ->  {
            currentDeviceLabel.setText("No Device Selected");
        });
    }

}
