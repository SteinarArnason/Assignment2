package is.ru.honn.rufan.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
