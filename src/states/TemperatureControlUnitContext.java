/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */

package states;

import controller.Controller;
import states.TemperatureState.modes;
import display.TemperatureDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is the Context, which holds the current states and their mode "idle" or "working"
 */
public class TemperatureControlUnitContext extends Observable
{

    private List<Observer> observers = new ArrayList<Observer>();
    private String workingOrIdling;
    private TemperatureDisplay display;
    private TemperatureState currentState;
    private static TemperatureControlUnitContext instance;

    /**
     * Make it a singleton
     */
    private TemperatureControlUnitContext() {
        currentState = NoDeviceState.instance();
        changeCurrentState(currentState);
        observers.add(Controller.instance());
    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static TemperatureControlUnitContext instance() {
        if (instance == null) {
            instance = new TemperatureControlUnitContext();
        }
        return instance;
    }

    public void setDisplay(TemperatureDisplay display) {
        this.display = display;
    }

    public void changeCurrentState(TemperatureState nextState) {
        currentState = nextState;
    }

    public void setIsWorkingNotIdling(modes newMode) {
        workingOrIdling = newMode.toString();
        //notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this, workingOrIdling);
        }
    }

    public modes getCurrentMode() {
        return currentState.getCurrentMode();
    }

    public TemperatureState getCurrentState() {
        return currentState;
    }
}
