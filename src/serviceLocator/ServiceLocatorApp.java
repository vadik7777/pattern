package serviceLocator;
/**
 *
 * @author Вадик
 */
public class ServiceLocatorApp {
    public static void main(String[] args) {
        Service service1 = ServiceLocator.getInstance().getService("service1");
        service1.execute();
        service1.getName();
        
        Service service2 = ServiceLocator.getInstance().getService("service2");
        service2.execute();
        service2.getName();
    }
}
class ServiceLocator {
    private ServiceLocator(){}
    private static final Object sync = new Object();
    private static volatile ServiceLocator instance;
    private static InitialContext context;
    public static ServiceLocator getInstance() {
        if (instance == null) {
            synchronized (sync) {
                if (instance == null) {
                    instance = new ServiceLocator();
                    context = new InitialContext();
                }
            }
        }
        return instance;
    }
    public static Service getService(String jndiName){
        return (Service) new InitialContext().lookup(jndiName);
    }
}
class InitialContext {
    public Object lookup(String jndiName) {
        if (jndiName.equalsIgnoreCase("SERVICE1")){
            return new ServiceFactory1().createService();
        } else if (jndiName.equalsIgnoreCase("SERVICE2")){
            return new ServiceFactory2().createService();
        }
        return null;
    }
}
interface ServiceFactory {
    Service createService();
}
class ServiceFactory1 implements ServiceFactory {
    public Service createService() {
        return new BusinessService1();
    }
}
class ServiceFactory2 implements ServiceFactory {
    public Service createService() {
        return new BusinessService2();
    }
}
interface Service {
    String getName();
    void execute();
}
class BusinessService1 implements Service {
    public String getName() {
        return this.getClass().getSimpleName();
    }
    public void execute() {
        System.out.println("Executing " + this.getClass().getSimpleName());
    }
}
class BusinessService2 implements Service {
    public String getName() {
        return this.getClass().getSimpleName();
    }
    public void execute() {
        System.out.println("Executing " + this.getClass().getSimpleName());
    }
}
