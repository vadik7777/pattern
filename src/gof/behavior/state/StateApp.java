package gof.behavior.state;
/**
 *
 * @author Вадик
 */
public class StateApp {
    public static void main(String[] args) {
        Context context = new Context();
        context.changeState();
        context.changeState();
    }
}
class Context {
    Context() {
        currentState = new ConcreteStateA();
    }
    private State currentState;

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    public void changeState() {
        currentState.someMethod(this);
    }
}
interface State {
    void someMethod(Context context);
}
class ConcreteStateA implements State {
    ConcreteStateA() {
        System.out.println("ConcreteStateA");
    }
    public void someMethod(Context context) {
        context.setCurrentState(new ConcreteStateB());
    }
}
class ConcreteStateB implements State {
    ConcreteStateB() {
        System.out.println("ConcreteStateB");
    }
    public void someMethod(Context context) {
        context.setCurrentState(new ConcreteStateA());
    }
}
