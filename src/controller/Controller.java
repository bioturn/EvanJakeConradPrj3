/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import objects.NumberTextField;
import states.TemperatureControlUnitContext;

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
        TemperatureControlUnitContext temperatureControlUnitContext = new TemperatureControlUnitContext();

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
            temperatureControlUnitContext.stateMethod(TemperatureControlUnitContext.States.HEATER_WORKING);
        });
        fan.setOnAction((event) ->  {
            currentDeviceLabel.setText("Fan is Working");
           temperatureControlUnitContext.stateMethod(TemperatureControlUnitContext.States.FAN_WORKING);
        });
        ac.setOnAction((event) ->  {
            currentDeviceLabel.setText("AC is Working");
            temperatureControlUnitContext.stateMethod(TemperatureControlUnitContext.States.AC_WORKING);
        });
        none.setOnAction((event) ->  {
            currentDeviceLabel.setText("No Device Selected");
            temperatureControlUnitContext.stateMethod(TemperatureControlUnitContext.States.NO_DEVICE_WORKING);
        });
    }
}
