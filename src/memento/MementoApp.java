package memento;
/**
 *
 * @author Вадик
 */
public class MementoApp {
    public static void main(String[] args) {
        Originator origin = new Originator();
        origin.setState(new Object());
        System.out.println("current "+origin);

        Caretaker caretaker = new Caretaker();
        System.out.println("create Memento and change state");
        caretaker.setMemento(origin.createMemento());
        origin.setState(new Object());
        System.out.println("current "+origin);

        System.out.println("setMemento");
        origin.setMemento(caretaker.getMemento());
        System.out.println("current "+origin);
    }
}
class Originator {
    private Object state;
    public void setMemento(Memento memento) {
        state = memento.getState();
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public void setState(Object state) {
        this.state = state;
    }
    public String toString() {
        return "state: " + state.hashCode();
    }
}
class Memento {
    private final Object state;
    public Memento(Object state) {
        this.state = state;
    }
    public Object getState() {
        return state;
    }
}
class Caretaker {
    private Memento memento;
    public Memento getMemento() {
        return memento;
    }
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}