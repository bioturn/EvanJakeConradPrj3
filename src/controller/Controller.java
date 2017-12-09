/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import objects.NumberTextField;
import states.HeaterState;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static controller.Controller.events.*;

public class Controller extends Observable{
    private static Controller instance;
    private static HeaterState heaterState;

    public enum events{TEMP_CHANGED_EVENT, HEATER_CALL, AC_CALL, FAN_CALL, NO_DEVICE_CALL};

    public static Controller instance(){
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }

    private List<Observer> observers = new ArrayList<Observer>();

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
            setIndoorTemperature(Integer.parseInt(tempInput.getText()));
            currentTempLabel.setText(String.valueOf(getIndoorTemperature()));
       //     notifyObservers(TEMP_CHANGED_EVENT);

        });
        desiredTemp.setOnAction((event) ->  {
            setDesiredTemperature(Integer.parseInt(tempInput.getText()));
            desiredTempLabel.setText(String.valueOf(getDesiredTemperature()));
         //   notifyObservers(TEMP_CHANGED_EVENT);
        });
        outsideTemp.setOnAction((event) ->  {
            setOutdoorTemperature(Integer.parseInt(tempInput.getText()));
            outsideTempLabel.setText(String.valueOf(getOutdoorTemperature()));
         //   notifyObservers(TEMP_CHANGED_EVENT);
        });
        heat.setOnAction((event) ->  {
            currentDeviceLabel.setText("Heater is Working");
            heaterState = new HeaterState();
            heaterState.run();
            notifyObservers(HEATER_CALL);
        });
        fan.setOnAction((event) ->  {
            currentDeviceLabel.setText("Fan is Working");
            notifyObservers(FAN_CALL);
        });
        ac.setOnAction((event) ->  {
            currentDeviceLabel.setText("AC is Working");
            notifyObservers(AC_CALL);
        });
        none.setOnAction((event) ->  {
            currentDeviceLabel.setText("No Device Selected");
            notifyObservers(NO_DEVICE_CALL);
        });
    }

    public void setCurrentTemp() {
        currentTempLabel.setText(String.valueOf(getIndoorTemperature()));
    }

    public void notifyObservers(Object arg) {
        for (Observer observer: observers) {
            observer.update(this, arg);
        }
    }

    // code to do with temperatures

    public static final long ONE_MINUTE = 1000; //TODO make 60000
    private int desiredTemperature;
    private int indoorTemperature;
    private int outdoorTemperature;


    public int getDesiredTemperature() {
        return desiredTemperature;
    }

    public void setDesiredTemperature(int desiredTemp) {
        desiredTemperature = desiredTemp;
    }

    public int getIndoorTemperature() {
        return indoorTemperature;
    }

    public void setIndoorTemperature(int indoorTemp) {
        indoorTemperature = indoorTemp;
    }

    public int getOutdoorTemperature() {
        return outdoorTemperature;
    }

    public void setOutdoorTemperature(int outdoorTemp) {
        outdoorTemperature = outdoorTemp;
    }
}
