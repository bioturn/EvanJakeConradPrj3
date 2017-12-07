/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

public class HeaterState extends TemperatureState{
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
        if (controller.getDesiredTemperature() > controller.getIndoorTemperature() + 3){
            temperatureRise();
        }
        try {
            Thread.sleep(controller.ONE_MINUTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adjustForOutdoorTemp();
    }
}
