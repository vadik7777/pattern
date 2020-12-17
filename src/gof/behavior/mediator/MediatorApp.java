package gof.behavior.mediator;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Вадик
 */
public class MediatorApp {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Client concreteAggregate = new ConcreteAggregate(mediator);
        Client concreteAggregate1 = new ConcreteAggregate1(mediator);
        mediator.addClient(concreteAggregate);
        mediator.addClient(concreteAggregate1);
        concreteAggregate.broadcastEvent();
    }
}
interface Client{
    void handleEvent();
    void broadcastEvent();
}
interface Mediator{
    void broadcastEvent();
}
class ConcreteMediator implements Mediator{
    List<Client> clients = new ArrayList<>();
    public void addClient(Client client){
        clients.add(client);
    }
    public void broadcastEvent() {
        for(Client client: clients){
            client.handleEvent();
        }
    }
}
class ConcreteAggregate implements Client{
    private Mediator mediator;
    public ConcreteAggregate(Mediator mediator){this.mediator = mediator;}
    public void handleEvent() {
        System.out.println("ConcreteAggregate handleEvent"); 
    }
    public void broadcastEvent() {
        mediator.broadcastEvent();
    }
}
class ConcreteAggregate1 implements Client{
    private Mediator mediator;
    public ConcreteAggregate1 (Mediator mediator){this.mediator = mediator;}
    public void handleEvent() {
        System.out.println("ConcreteAggregate1 handleEvent"); 
    }
    public void broadcastEvent() {
        mediator.broadcastEvent();
    }
}