/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */

package controller;

import display.TemperatureDisplay;

import java.util.Observable;
import java.util.Observer;

import static controller.TemperatureControlUnitContext.States.*;

public class TemperatureControlUnitContext implements Observer {

    public enum States {HEATER_WORKING, AC_WORKING, FAN_WORKING, NO_DEVICE_WORKING}
    private States currentState;
    public static TemperatureControlUnitContext instance;
    TemperatureDisplay display;

    private static TemperatureControlUnitContext instance(){
        if (instance == null){
            return instance = new TemperatureControlUnitContext();
        }
        return instance;
    }

    //currently handling logic that perhaps the controller should? TODO
    @Override
    public void update(Observable o, Object arg) {

        switch (arg.toString()){
            case "HEATER_CALL":
                changeCurrentState(HEATER_WORKING);
                break;
            case "AC_CALL":
                changeCurrentState(AC_WORKING);
                break;
            case "FAN_CALL":
                changeCurrentState(FAN_WORKING);
                break;
            case "NO_DEVICE_CALL":
                changeCurrentState(NO_DEVICE_WORKING);
                break;
        }
    }

    public void setDisplay(TemperatureDisplay display) {
        this.display = display;
    }

    public void changeCurrentState(States state){
        currentState = state;
    }
}
