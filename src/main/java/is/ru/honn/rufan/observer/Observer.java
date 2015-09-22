package is.ru.honn.rufan.observer;

/**
 * Observer for notifying changes made in a service
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
