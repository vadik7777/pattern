package gof.behavior.chain;

/**
 *
 * @author Вадик
 */
public class ChainApp2 {

    public static void main(String[] args) {
        Logger info = new ConcreteInfo(Level.INFO);
        Logger debug = new ConcreteDebug(Level.DEBUG);
        Logger error = new ConcreteError(Level.ERROR);
        Logger admin = new ConcreteAdmin(Level.ADMIN);
        
        info.setNext(debug);
        debug.setNext(error);
        error.setNext(admin);
        admin.setNext(info);
        
        admin.writeMessage("some admin information", Level.ADMIN);
        debug.writeMessage("some error information", Level.ERROR);
        error.writeMessage("some debug information", Level.DEBUG);
        debug.writeMessage("some information", Level.INFO);
    }
}
class Level {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
    public static final int ADMIN = 4;
}
abstract class Logger {
    int level;
    private Logger next;
    public Logger(int level) {
        this.level = level;
    }
    abstract void write(String message);
    public void setNext(Logger next) {
        this.next = next;
    }
    public void writeMessage(String message, int level) {
        if (this.level == level) {
            write(message);
            return;
        }
        if (next != null) {
            System.out.print(this.getClass().getSimpleName() + " -->> ");
            next.writeMessage(message, level);
        }
    }
}
class ConcreteInfo extends Logger {
    public ConcreteInfo(int level) {
        super(level);
    }
    public void write(String message){
        System.out.println("ConcreteInfo: " + message);
    }
}
class ConcreteDebug extends Logger {
    public ConcreteDebug(int level) {
        super(level);
    }
    public void write(String message){
        System.out.println("ConcreteDebug: " + message);
    }
}
class ConcreteError extends Logger {
    public ConcreteError(int level) {
        super(level);
    }
    public void write(String message){
        System.out.println("ConcreteError: " + message);
    }
}
class ConcreteAdmin extends Logger {
    public ConcreteAdmin(int level) {
        super(level);
    }
    public void write(String message){
        System.out.println("ConcreteAdmin: " + message);
    }
}
