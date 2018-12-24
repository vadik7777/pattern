/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;
/**
 *
 * @author Вадик
 */
public class StateApp {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateB());
        context.setCurrentState(new ConcreteStateA());
    }
}
class Context{
    private State currentState;
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.someMethod();
    }
}
interface State{
    void someMethod();
}
class ConcreteStateA implements State{
    public void someMethod() {
        System.out.println("now context in state A");
    }
}
class ConcreteStateB implements State{
    public void someMethod() {
        System.out.println("now context in state B");
    }
}
