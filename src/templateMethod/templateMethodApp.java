package templateMethod;
/**
 *
 * @author KonovalovVA
 */
public class templateMethodApp {
    public static void main(String[] args) {
        AbstractClass concreteClass = new ConcreteClass();
        concreteClass.templateMethod();
        concreteClass = new ConcreteClass1();
        concreteClass.templateMethod();
    }
}
abstract class AbstractClass {
    abstract void subOperation1();
    abstract void subOperation2();
    public void templateMethod(){
        System.out.print("My first name is ");
        subOperation1();
        System.out.print("My last name is ");
        subOperation2();
    }
}
class ConcreteClass extends AbstractClass{
    void subOperation1() {
        System.out.print("Vadim. ");
    }
    void subOperation2() {
        System.out.println("Konovalov.");
    }
}
class ConcreteClass1 extends AbstractClass{
    void subOperation1() {
        System.out.print("John. ");
    }
    void subOperation2() {
        System.out.println("Lenon.");
    }
}
