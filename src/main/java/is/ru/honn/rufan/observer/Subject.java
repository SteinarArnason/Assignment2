package is.ru.honn.rufan.observer;

import is.ru.honn.rufan.domain.Player;

import java.util.ArrayList;
import java.util.List;
import is.ru.honn.rufan.observer.Observer;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private Player state;

    public Player getState() {
        return state;
    }

    public void setState(Player state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
