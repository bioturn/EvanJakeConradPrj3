/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 *
 */

package model;

import display.GuiDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * The important data to be put into the GUI, and manipulated by the Controller.
 */
public class Model {
    private static Model instance;

    /**
     * Private to implement the singleton pattern.
     */
    private Model() {
    }

    /**
     * Creates the model if needed and returns it.
     *
     * @return - the only instance of the model
     */
    public static Model instance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    // code to do with temperatures AKA the model in an MVC

    public static final long ONE_MINUTE = 1000; //TODO make 60000
    private int desiredTemperature;
    private int indoorTemperature;
    private int outdoorTemperature;


    public int getDesiredTemperature() {
        return desiredTemperature;
    }

    public void setDesiredTemperature(int desiredTemp) {
        desiredTemperature = desiredTemp;
    }

    public int getIndoorTemperature() {
        return indoorTemperature;
    }

    public void setIndoorTemperature(int indoorTemp) {
        indoorTemperature = indoorTemp;
    }

    public int getOutdoorTemperature() {
        return outdoorTemperature;
    }

    public void setOutdoorTemperature(int outdoorTemp) {
        outdoorTemperature = outdoorTemp;
    }

}
