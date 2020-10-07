package gof.structure.bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        Implemetator implemetator = new ConcreteImplementatorA();
        Abstraction abstraction = new RefinedAbstraction(implemetator);
        abstraction.operation();
        implemetator = new ConcreteImplementatorB();
        abstraction = new RefinedAbstraction(implemetator);
        abstraction.operation();
    }
}
abstract class Abstraction{

    Implemetator implemetator;

    Abstraction(Implemetator implemetator){
        this.implemetator = implemetator;
    }

    void operation(){
        implemetator.operationImpl();
    }

}
interface Implemetator{
    void operationImpl();
}

class RefinedAbstraction extends Abstraction{

    RefinedAbstraction(Implemetator implemetator) {
        super(implemetator);
    }
}
class ConcreteImplementatorA implements Implemetator{

    @Override
    public void operationImpl() {
        System.out.println("Implementation from A");
    }
}

class ConcreteImplementatorB implements Implemetator{

    @Override
    public void operationImpl() {
        System.out.println("Implementation from B");
    }
}