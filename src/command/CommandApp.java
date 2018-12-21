package command;

/**
 *
 * @author Вадик
 */
public class CommandApp {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker(new ConcreteStart(receiver), new ConcreteStop(receiver), new ConcreteReset(receiver));
        invoker.start();
        invoker.stop();
        invoker.reset();
    }
}
class Invoker{
    private ConcreteStart start;
    private ConcreteStop stop;
    private ConcreteReset reset;
    public Invoker(ConcreteStart start, ConcreteStop stop, ConcreteReset reset){
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void start(){
        start.execute();
    }
    void stop(){
        stop.execute();
    }
    void reset(){
        reset.execute();
    }
}
interface Command {
    void execute();
}
class ConcreteStart implements Command{
    Receiver receiver;
    public ConcreteStart(Receiver receiver){this.receiver = receiver;}
    public void execute() {
        receiver.start();
    }
}
class ConcreteStop implements Command{
    Receiver receiver;
    public ConcreteStop(Receiver receiver){this.receiver = receiver;}
    public void execute() {
        receiver.stop();
    }
}
class ConcreteReset implements Command{
    Receiver receiver;
    public ConcreteReset(Receiver receiver){this.receiver = receiver;}
    public void execute() {
        receiver.reset();
    }
}
class Receiver {
    void start() {
        System.out.println("Start");
    }
    void stop() {
        System.out.println("Stop");
    }
    void reset() {
        System.out.println("Reset");
    }
}
