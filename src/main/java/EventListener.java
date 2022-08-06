//import jdk.internal.event.Event;

public class EventListener extends Thread {

    private String messageToListenFor;
    private String messageToReplyWith;
    private Tracker eventTracker;

    public EventListener(String message, String reply) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = EventTracker.getInstance();
    }

    public EventListener(String message, String reply, Tracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }

    public void run() {
    }

    public Boolean readyToQuit() {
        EventTracker.getInstance();
        return eventTracker.has("quit");
    }

    public Boolean shouldReply() {
        EventTracker.getInstance();
        return eventTracker.has(messageToListenFor);
    }

    public void reply() {
    }
}