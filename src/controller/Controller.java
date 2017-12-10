/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Model;
import objects.NumberTextField;
import states.HeaterState;
import states.TemperatureControlUnitContext;
import states.TemperatureState;

import java.util.Observable;
import java.util.Observer;

import static controller.Controller.events.*;

public class Controller implements Observer{
    private static Controller instance;
    private static  TemperatureControlUnitContext tcuContext = TemperatureControlUnitContext.instance();
    private static HeaterState heaterState = HeaterState.instance();
    private Model model = Model.instance();

    public enum events{TEMP_CHANGED_EVENT, HEATER_CALL, AC_CALL, FAN_CALL, NO_DEVICE_CALL};

    public static Controller instance(){
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }

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
        //initialize values
        model.setIndoorTemperature(0);
        model.setOutdoorTemperature(0);
        model.setDesiredTemperature(0);
        currentDeviceLabel.setText("We haven't begun");
        currentTemp.setOnAction((event) -> {
            model.setIndoorTemperature(Integer.parseInt(tempInput.getText()));
            currentTempLabel.setText(String.valueOf(model.getIndoorTemperature()));

        });
        desiredTemp.setOnAction((event) ->  {
            model.setDesiredTemperature(Integer.parseInt(tempInput.getText()));
            desiredTempLabel.setText(String.valueOf(model.getDesiredTemperature()));
        });
        outsideTemp.setOnAction((event) ->  {
            model.setOutdoorTemperature(Integer.parseInt(tempInput.getText()));
            outsideTempLabel.setText(String.valueOf(model.getOutdoorTemperature()));
        });
        heat.setOnAction((event) ->  {
            changeState(HEATER_CALL);
            heaterState.run();
            updateDeviceLabel();
            updateCurrentTempLabel();
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

    private void updateCurrentTempLabel() {
        currentTempLabel.setText(String.valueOf(model.getIndoorTemperature()));
    }

    @FXML
    private void updateDeviceLabel() {
        if ( tcuContext.getCurrentState() instanceof HeaterState) {
            currentDeviceLabel.setText("Heater ");
        }
        if (!tcuContext.getCurrentMode().equals(TemperatureState.modes.noDevice)){
            if ( tcuContext.getCurrentMode().equals(TemperatureState.modes.idling)){
                currentDeviceLabel.setText(currentDeviceLabel.getText().concat("idling"));
            }else if ( tcuContext.getCurrentMode().equals(TemperatureState.modes.working)){
                currentDeviceLabel.setText(currentDeviceLabel.getText().concat("working"));
            }
        }
    }

    public void temperatureRise(int amount){
        model.setIndoorTemperature(model.getIndoorTemperature()+amount);
        //updateCurrentTempLabel();
    }
    public void temperatureFall(int amount){
        model.setIndoorTemperature(model.getIndoorTemperature()-amount);
    }
    public void adjustForOutdoorTemp() {
        if (model.getIndoorTemperature() < model.getOutdoorTemperature()){
            temperatureRise(1);
        }
        else if (model.getIndoorTemperature() > model.getOutdoorTemperature()){
            temperatureFall(1);
        }
    }

    private void changeState(events theEvent){
        switch(theEvent){
            case AC_CALL:
                break;
            case FAN_CALL:
                break;
            case HEATER_CALL:
                TemperatureControlUnitContext.instance().changeCurrentState(heaterState);
                break;
            case NO_DEVICE_CALL:
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
       // updateDeviceLabel();
    }
}
