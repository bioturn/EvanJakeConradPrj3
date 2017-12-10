/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

/*
 * This class is no device state. When we dont want to operate any AC, heat, or fan.
 */
public class NoDeviceState extends TemperatureState{

    private static NoDeviceState instance;

    /**
     * Private constructor to make the class a singleton
     */
    private NoDeviceState() {

    }

    /**
     * Returns the singleton object
     *
     * @return - the only instance of the class
     */
    public static NoDeviceState instance() {
        if (instance == null) {
            instance = new NoDeviceState();
        }
        return instance;
    }

    @Override
    public void enter() {

    }

    @Override
    public void leave() {

    }

    @Override
    public void run() {
    }
}
