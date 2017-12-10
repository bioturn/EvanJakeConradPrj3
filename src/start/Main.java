/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 * Final submission
 */
package start;

import states.TemperatureControlUnitContext;
import display.TemperatureDisplay;
import javafx.application.Application;
import states.Clock;
import display.GuiDisplay;

/*
* Spins up our program
 */
public class Main{

    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GuiDisplay.class, null);
            }
        }.start();
        try {
            while (GuiDisplay.getInstance() == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {

        }
        TemperatureDisplay display = GuiDisplay.getInstance();
        TemperatureControlUnitContext.instance().setDisplay(display);

    }
}
