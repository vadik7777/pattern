package gof.behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Вадик
 */
public class MementoApp {
    public static void main(String[] args) {

        Originator origin = new Originator();
        Caretaker caretaker = new Caretaker();
        Memento memento = new Memento();
        System.out.println(origin.toString());

        memento.setState(new Object());
        caretaker.addMemento(origin.createMemento());
        origin.setMemento(memento);
        System.out.println(origin.toString());

        origin.setMemento(caretaker.getMemento(0));
        System.out.println(origin.toString());
    }
}
class Originator {
    private Object state = new Object();
    public void setMemento(Memento memento) {
        state = memento.getState();
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public String toString() {
        return "state: " + state.hashCode();
    }
}
class Memento {
    private Object state;
    Memento(){}
    Memento(Object state) {
        this.state = state;
    }
    public Object getState() {
        return state;
    }
    public void setState(Object state) {
        this.state = state;
    }
}
class Caretaker {
    private List<Memento> memento = new ArrayList<>();
    public Memento getMemento(int index) {
        return memento.get(index);
    }
    public void addMemento(Memento memento) {
        this.memento.add(memento);
    }
}