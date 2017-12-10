package timer;

import events.HeaterEvent;

public interface Notifiable {
/**
 * Process heater ticks
 */
public void handleEvent(HeaterEvent event);
}
