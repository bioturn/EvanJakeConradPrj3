/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import controller.Controller;

public abstract class TemperatureState {

    Controller controller = Controller.instance();

    /**
     * Initializes the state
     */
    public abstract void enter();

    /**
     * Performs any necessary clean up while leaving the state
     */
    public abstract void leave();

    //actions which must occur. In particular, the outside temperature affecting the inside temperature.
    public abstract void run();

    public void temperatureRise(){
        controller.setIndoorTemperature(controller.getIndoorTemperature()+1);
        controller.setCurrentTemp();
    }
    public void temperatureFall(){
        controller.setIndoorTemperature(controller.getIndoorTemperature()-1);
    }
    public void adjustForOutdoorTemp() {
        if (controller.getIndoorTemperature() < controller.getOutdoorTemperature()){
            temperatureRise();
        }
        else if (controller.getIndoorTemperature() > controller.getOutdoorTemperature()){
            temperatureFall();
        }
    }
}
