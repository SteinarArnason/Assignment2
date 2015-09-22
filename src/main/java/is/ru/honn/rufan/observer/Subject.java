package is.ru.honn.rufan.observer;

import is.ru.honn.rufan.domain.Player;

import java.util.ArrayList;
import java.util.List;
import is.ru.honn.rufan.observer.Observer;

/**
 * Subject class that keeps track of our observers
 */
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private Player state;

    /**Gets the player state*/
    public Player getState() {
        return state;
    }

    /**Sets the player state*/
    public void setState(Player state) {
        this.state = state;
        notifyAllObservers();
    }

    /**Adds a custom observer to our observer list*/
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**Makes all observer notify about any update that has happened*/
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
