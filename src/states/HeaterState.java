/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import events.HeaterEvent;
import timer.Notifiable;

import java.util.Observable;
import java.util.Observer;

import static states.TemperatureState.modes.*;

public class HeaterState extends TemperatureState implements Observer {

    private static HeaterState instance;
    private Notifiable client;

    public enum Events {
        HEATER_TICKED_EVENT
    };


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
        try{
       //     while(true){
                run();
        //    }
        }catch (Exception e){
            leave();
        }
    }

    @Override
    public void leave() {
        //TemperatureControlUnitContext.instance().changeCurrentState(NoDeviceState.instance());
    }

    @Override
    public void run() {
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
        while (model.getDesiredTemperature() > model.getIndoorTemperature() + 3) {
            TemperatureControlUnitContext.instance().setIsWorkingNotIdling(working);
            controller.temperatureRise(2);
            try {
                Thread.sleep(model.ONE_MINUTE);
                setChanged();
                notifyObservers(Events.HEATER_TICKED_EVENT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.adjustForOutdoorTemp();

        }
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
    }

    @Override
    public void update(Observable o, Object arg) {
        client.handleEvent(new HeaterEvent());
    }

    @Override
    public void handleEvent(HeaterEvent event) {

    }
}
