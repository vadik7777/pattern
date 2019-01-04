package proxy;
/**
 *
 * @author Вадик
 */
public class ProxyApp {
    public static void main(String[] args) {
        ServiceIF service = new Proxy();
        service.doIt();
    }
}
interface ServiceIF{
    void doIt();
}
class Proxy implements ServiceIF{
    Service service;
    public void doIt() {
        if(service == null){
            service = new Service();
        }
        service.doIt();
    }
}
class Service implements ServiceIF{
    Service(){
        beforeDoIt();
    }
    private void beforeDoIt(){
        System.out.println("Loading...");
    }
    public void doIt() {
        System.out.println("Do it!!!");
    }
}
