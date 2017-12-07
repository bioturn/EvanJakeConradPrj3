/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

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
        //code to spin fan TODO

        //then sleep
        try {
            Thread.sleep(controller.ONE_MINUTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adjustForOutdoorTemp();

    }
}
