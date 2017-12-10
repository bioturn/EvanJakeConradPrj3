/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

public class ACState extends TemperatureState{
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
        if (model.getDesiredTemperature() < model.getIndoorTemperature() + 3){
            controller.temperatureFall(2);
        }
        try {
            Thread.sleep(model.ONE_MINUTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.adjustForOutdoorTemp();
    }
}
