package is.ru.honn.rufan.observer;

public class PlayerObserver extends Observer{

    public PlayerObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("New Player: " + subject.getState());
    }
}
