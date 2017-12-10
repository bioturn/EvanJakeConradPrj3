/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import events.HeaterEvent;
import timer.Clock;

import java.util.Observable;
import java.util.Observer;

import static states.TemperatureState.modes.*;

public class HeaterState extends TemperatureState implements Observer {

    private static HeaterState instance;


    /**
     * Private constructor to make the class a singleton
     */
    private HeaterState() {

    }

    /**
     * Returns the singleton object
     *
     * @return - the only instance of the class
     */
    public static HeaterState instance() {
        if (instance == null) {
            instance = new HeaterState();
        }
        return instance;
    }

    @Override
    public void enter() {
        while(true){
            run();
        }
    }

    @Override
    public void leave() {
        TemperatureControlUnitContext.instance().changeCurrentState(NoDeviceState.instance());
    }

    @Override
    public void run() {
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
        while (model.getDesiredTemperature() > model.getIndoorTemperature() + 3) {
            TemperatureControlUnitContext.instance().setIsWorkingNotIdling(working);
            controller.temperatureRise();
            try {
                Thread.sleep(model.ONE_MINUTE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.adjustForOutdoorTemp();
        }
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
    }

    @Override
    public void update(Observable o, Object arg) {
        Clock.instance().addObserver(this);
    }

    @Override
    public void handleEvent(HeaterEvent event) {

    }
}
