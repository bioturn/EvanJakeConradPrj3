/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import static states.TemperatureState.modes.idling;
import static states.TemperatureState.modes.working;

public class FanState extends TemperatureState{
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
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
        while (model.getDesiredTemperature() < model.getIndoorTemperature() + 3) {
            TemperatureControlUnitContext.instance().setIsWorkingNotIdling(working);
            controller.temperatureFall(2);
            try {
                Thread.sleep(model.ONE_MINUTE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.adjustForOutdoorTemp();
        }
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
    }
}