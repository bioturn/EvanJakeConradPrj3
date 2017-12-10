package model;

import java.util.Observable;

/**
 * Created by evanwall on 12/9/17.
 */
public class Model extends Observable {
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
