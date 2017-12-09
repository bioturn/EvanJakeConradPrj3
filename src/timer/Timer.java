package timer;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;

import java.util.Observable;
import java.util.Observer;

public class Timer implements Observer {
    private int timeValue;
    private Notifiable client;

    /**
     * Sets up the timer for a certain client with an initial time value
     *
     * @param client
     *            the client, a Notifiable object
     * @param timeValue
     *            the initial time value after which the timer runs out of time.
     */
    public Timer(Notifiable client, int timeValue) {
        this.client = client;
        this.timeValue = timeValue;
        Clock.instance().addObserver(this);
    }

    /**
     * The timer value could be changed using this method.
     *
     * @param value
     *            the increment (could be negative) for the time value.
     */
    public void addTimeValue(int value) {
        timeValue += value;
    }

    /**
     * Stops the timer by deleting itself from the list of observers
     */
    public void stop() {
        Clock.instance().deleteObserver(this);
    }

    /**
     * Returns the time value left
     *
     * @return the time value left in the timer
     */
    public int getTimeValue() {
        return timeValue;
    }

    @Override
    public void update(Observable clock, Object value) {
        if (--timeValue <= 0) {
            client.handleEvent(TimerRanOutEvent.instance());
            Clock.instance().deleteObserver(this);
        } else {
            client.handleEvent(new TimerTickedEvent(timeValue));
        }
    }
}