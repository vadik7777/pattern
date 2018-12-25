package state;
/**
 *
 * @author Вадик
 */
public class StateApp {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
        context.setCurrentState(new ConcreteStateA());
        context.setCurrentState(new ConcreteStateB());
        context.setCurrentState(new ConcreteStateB());
        context.changeState();
        context.changeState();
    }
}
class Context{
    private State currentState;
    public void setCurrentState(State currentState) {
        if(this.currentState != null && this.currentState.getClass() == currentState.getClass()){
            System.out.println("context already in state "+currentState.getClass().getSimpleName());
            return;
        }
        this.currentState = currentState;
        System.out.println("now context in state "+currentState.getClass().getSimpleName());
    }
    public void changeState() {
        currentState.someMethod(this);
    }
}
interface State{
    void someMethod(Context context);
}
class ConcreteStateA implements State{
    public void someMethod(Context context) {
        context.setCurrentState(new ConcreteStateB());
    }
}
class ConcreteStateB implements State{
    public void someMethod(Context context) {
        context.setCurrentState(new ConcreteStateA());
    }
}
