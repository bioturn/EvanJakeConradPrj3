package events;

/**
 *
 * @author Brahma Dathan
 *
 */
public class HeaterEvent extends FatherEvent{
    private static HeaterEvent instance;

    /**
     * Constructor is private to implement the singleton pattern.
     */
    private HeaterEvent() {
    }

    /**
     * Static method to return the only instance of the class.
     *
     * @return - the only instance
     */
    public static HeaterEvent instance() {
        if (instance == null) {
            instance = new HeaterEvent();
        }
        return instance;
    }

}