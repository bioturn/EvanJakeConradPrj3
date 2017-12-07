/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */

package states;
public class TemperatureControlUnitContext {
    public enum States {HEATER_WORKING, AC_WORKING, FAN_WORKING, NO_DEVICE_WORKING}
    private States currentState;
    private static TemperatureControlUnitContext instance;

    private static TemperatureControlUnitContext instance(){
        if (instance == null){
            return instance = new TemperatureControlUnitContext();
        }
        return instance;
    }

    public void stateMethod(States state){
        currentState = state;
    }
}
