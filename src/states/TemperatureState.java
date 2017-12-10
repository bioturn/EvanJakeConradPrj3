/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import controller.Controller;
import events.HeaterEvent;
import model.Model;

import static states.TemperatureState.modes.*;

public abstract class TemperatureState {

    public Model model = Model.instance();
    Controller controller = Controller.instance();

    public enum modes {working, idling, noDevice}
    public modes currentMode = noDevice;

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

    public modes getCurrentMode() {
        return currentMode;
    }
    public void setCurrentMode(modes newMode){
        currentMode = newMode;
    }
    public void handleEvent(HeaterEvent event) {

    }

}
