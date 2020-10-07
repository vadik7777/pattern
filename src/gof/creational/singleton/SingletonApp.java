package gof.creational.singleton;
/**
 *
 * @author KonovalovVA
 */
public class SingletonApp {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        
        
    }
}
class Singleton {
    private Singleton() {}
    private static final Object sync = new Object();
    private static volatile Singleton instance = null;
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (sync) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        System.out.println("instance: " + instance.hashCode());
        return instance;
    }
}