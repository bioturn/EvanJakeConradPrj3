/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import timer.Clock;

import java.util.Observable;
import java.util.Observer;

public class HeaterState extends TemperatureState implements Observer{
    @Override
    public void enter() {
        while(true){
            run();
        }
    }

    @Override
    public void leave() {

    }

    @Override
    public void run() {
        System.out.println("Inside Heater State");
        while (controller.getDesiredTemperature() > controller.getIndoorTemperature() + 3) {
            System.out.println("Inside while loop");
            temperatureRise();
            try {
                Thread.sleep(controller.ONE_MINUTE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            adjustForOutdoorTemp();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Clock.instance().addObserver(this);
    }
}
