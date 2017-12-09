package timer;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;

public interface Notifiable {
    /**
     * Process timer ticks
     */
    public void handleEvent(TimerTickedEvent event);

    /**
     * Process timer runs out event
     */
    public void handleEvent(TimerRanOutEvent event);
}
