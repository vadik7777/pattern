package gof.structure.flyweight;

import java.util.HashMap;

public class FlyweightApp {
    public static void main(String[] args) {

        FlyweightFactory factory = new FlyweightFactoryImpl();

        Flyweight flyweight = factory.getFlyweight("ConcreteFlyweight");
        flyweight.someOperation(new Object());
        flyweight.someOperation(new Object());

        flyweight = factory.getFlyweight("ConcreteFlyweight2");
        flyweight.someOperation(new Object());
        flyweight.someOperation(new Object());

    }
}

interface FlyweightFactory {
    Flyweight getFlyweight(String key);
}

interface Flyweight {
    void someOperation(Object externalState);
}

class ConcreteFlyweight implements Flyweight {
    Object internalState = new Object();

    @Override
    public void someOperation(Object externalState) {
        System.out.println("internalState: " + internalState +", externalState: " + externalState);
    }
}

class ConcreteFlyweight1 implements Flyweight {
    Object internalState = new Object();

    @Override
    public void someOperation(Object externalState) {
        System.out.println("internalState: " + internalState +", externalState: " + externalState);
    }
}

class FlyweightFactoryImpl implements FlyweightFactory {

    HashMap<String, Flyweight> flyweightList = new HashMap<>();

    @Override
    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightList.get(key);
        if (flyweight == null) {
            switch (key) {
                case "ConcreteFlyweight":
                    flyweight = new ConcreteFlyweight();
                    flyweightList.put("ConcreteFlyweight", flyweight);
                    break;
                case "ConcreteFlyweight1":
                    flyweight = new ConcreteFlyweight1();
                    flyweightList.put("ConcreteFlyweight1", flyweight);
                    break;
                default:
                    throw new RuntimeException("no implementations of Flyweight");
            }
        }
        return flyweight;
    }
}