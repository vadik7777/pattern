package gof.behavior.state;
/**
 *
 * @author Вадик
 */
public class StateApp {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
        context.someMethod();
        context.setCurrentState(new ConcreteStateB());
        context.someMethod();

    }
}
class Context{
    private State currentState;
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    public void someMethod() {
        currentState.someMethod();
    }
}
interface State {
    void someMethod();
}
class ConcreteStateA implements State {
    public void someMethod() {
        System.out.println("In state A");
    }
}
class ConcreteStateB implements State {
    public void someMethod() {
        System.out.println("In state B");
    }
}
