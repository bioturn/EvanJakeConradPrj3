/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 *
 */
package states;

import static states.TemperatureState.modes.*;

/**
 * This state represents an Air Conditioner, which idles when the temperature suffices, and works to cool when it is too warm.
 */
public class ACState extends TemperatureState{
    @Override
    public void enter() {

    }

    @Override
    public void leave() {
        //TemperatureControlUnitContext.instance().changeCurrentState(NoDeviceState.instance());
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
