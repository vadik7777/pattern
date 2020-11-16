package gof.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Вадик
 */
public class ObserverApp {
    public static void main(String[] args) {
        Observable observable = new ConcreteObservable();
        observable.addObserver(new ConcreteObserver());
        observable.addObserver(new ConcreteObserver1());
        System.out.println("--> observable.notifyObserver()");
        observable.notifyObserver();
        System.out.println("--> observable.notifyObserver()");
        observable.notifyObserver();
    }
}
interface Observable{
   void addObserver(Observer o);
   void removeObserver(Observer o);
   void notifyObserver();
}
class ConcreteObservable implements Observable{
    List <Observer> observers = new ArrayList<>();
    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObserver() {
        for(Observer o: observers){
            o.handleEvent();
        }
    }
}
interface Observer{
    void handleEvent();
}
class ConcreteObserver implements Observer{
    public void handleEvent() {
        System.out.println("handleEvent() --> ConcreteObserver");
    }
}
class ConcreteObserver1 implements Observer{
    public void handleEvent() {
        System.out.println("handleEvent() --> ConcreteObserver1");
    }
}

