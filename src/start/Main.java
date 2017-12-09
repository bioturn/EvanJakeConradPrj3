/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package start;

import javafx.application.Application;
import states.Clock;
import display.GuiDisplay;

public class Main{

    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GuiDisplay.class, null);
            }
        }.start();
    }
}
