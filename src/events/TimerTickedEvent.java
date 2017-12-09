package events;

public class TimerTickedEvent {
    private int timeLeft;

    /**
     * Stores the amount of time left in the Timer.
     *
     * @param value
     *            the amount of time left
     */
    public TimerTickedEvent(int value) {
        this.timeLeft = value;
    }

    /**
     * Needed for display purposes
     */
    public int getTimeLeft() {
        return timeLeft;
    }
}
