/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */

package states;

import states.TemperatureState.modes;
import display.TemperatureDisplay;

public class TemperatureControlUnitContext
{
    String workingOrIdling;
    TemperatureDisplay display;
    private TemperatureState currentState;
    private static TemperatureControlUnitContext instance;

    /**
     * Make it a singleton
     */
    private TemperatureControlUnitContext() {
        currentState = NoDeviceState.instance();
        changeCurrentState(currentState);
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
    }

    public modes getCurrentMode() {
        return currentState.getCurrentMode();
    }

    public TemperatureState getCurrentState() {
        return currentState;
    }
}
