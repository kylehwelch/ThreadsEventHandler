import java.util.HashMap;
import java.util.Map;

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();

    private Map<String, Integer> tracker;

    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public static EventTracker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EventTracker();
        }
        return INSTANCE;
    }

    synchronized public void push(String message) {
        if (tracker.containsKey(message)) {
            tracker.put(message, tracker.get(message) + 1);
        } else {
            tracker.put(message, 1);

        }
    }

    public Map<String, Integer> getTracker(){
        return tracker;
    }

    synchronized public Boolean has(String message) {
        return tracker.containsKey(message);
    }

    synchronized public void handle(String message, EventHandler e) {
        e.handle();
        tracker.put(message, tracker.get(message)-1);
    }

    // Do not use this. This constructor is for tests only
    // Using it breaks the singleton class
    EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }
}
