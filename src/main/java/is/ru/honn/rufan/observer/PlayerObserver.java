package is.ru.honn.rufan.observer;

/**
 * An observer for playerService, notifies about players being added
 */
public class PlayerObserver extends Observer{

    /**
     * Initiates the observer
     * @param subject the object being updated
     */
    public PlayerObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * Prints out the added player
     */
    @Override
    public void update(){
        System.out.println("New Player: " + subject.getState());
    }
}
