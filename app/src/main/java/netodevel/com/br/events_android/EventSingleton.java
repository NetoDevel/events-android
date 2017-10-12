package netodevel.com.br.events_android;

/**
 * Created by neto on 18/08/17.
 */
public class EventSingleton {

    private static EventSingleton instance;
    private EventListener eventListener;

    public static EventSingleton getInstance() {
        if (instance == null) {
            instance = new EventSingleton();
        }
        return instance;
    }

    public void registerEvent(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void unRegisterEvent() {
        this.eventListener = null;
    }

    public void emitterDone() {
        this.eventListener.done();
    }

}
