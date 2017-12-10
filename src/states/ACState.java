/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import static states.TemperatureState.modes.*;

public class ACState extends TemperatureState{
    @Override
    public void enter() {
        try{
            while(true){
                run();
            }
        }catch (Exception e){
            leave();
        }
    }

    @Override
    public void leave() {
        TemperatureControlUnitContext.instance().changeCurrentState(NoDeviceState.instance());
    }

    @Override
    public void run() {
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
        if (model.getDesiredTemperature() < model.getIndoorTemperature() + 3){
            TemperatureControlUnitContext.instance().setIsWorkingNotIdling(working);
            controller.temperatureFall(2);
        }
        TemperatureControlUnitContext.instance().setIsWorkingNotIdling(idling);
        try {
            Thread.sleep(model.ONE_MINUTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.adjustForOutdoorTemp();
    }
}
