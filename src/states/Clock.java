/**
 * @author Conrad Thompson, Evan Wall, Jake Flodquist
 * @Copyright (c) 2017
 */
package states;

import java.util.Observable;

/**
 * Implements a clock as a Runnable. Extends Observable to ease communication
 *
 */
public class Clock extends Observable implements Runnable {
    private static Clock instance;

    /**
     * Start the thread
     */
    private Clock() {
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * To get the instance
     *
     * @return returns the clock
     */
    public static Clock instance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    /**
     * Infinite loop to generate the clock ticks Notify all users when clock
     * ticks
     */
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                setChanged();

            }
        } catch (InterruptedException ie) {
        }
    }
}