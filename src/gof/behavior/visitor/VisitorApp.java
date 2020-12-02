package gof.behavior.visitor;

public class VisitorApp {
    public static void main(String[] args) {
        ConcreteElementA concreteElementA = new ConcreteElementA();
        ConcreteElementB concreteElementB = new ConcreteElementB();
        concreteElementA.print();
        concreteElementB.print();

        Visitor concreteVisitor1 = new ConcreteVisitor1();
        concreteVisitor1.visitConcreteElementA(concreteElementA);
        concreteVisitor1.visitConcreteElementB(concreteElementB);

        Visitor concreteVisitor2 = new ConcreteVisitor2();
        concreteVisitor2.visitConcreteElementA(concreteElementA);
        concreteVisitor2.visitConcreteElementB(concreteElementB);

    }
}
interface Visitor {
    void visitConcreteElementA(ConcreteElementA concreteElementA);
    void visitConcreteElementB(ConcreteElementB concreteElementB);
}
interface Element {
    void accept(Visitor visitor);
}
class ConcreteElementA implements Element {
    String toPrint = "in ConcreteElementA";

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }
    void print() {
        System.out.println(toPrint);
    }
}
class ConcreteElementB implements Element {
    String toPrint = "in ConcreteElementB";

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }
    void print() {
        System.out.println(toPrint);
    }
}
class ConcreteVisitor1 implements Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        concreteElementA.toPrint = "From ConcreteVisitor1 in ConcreteElementA";
        concreteElementA.print();
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        concreteElementB.toPrint = "From ConcreteVisitor1 in ConcreteElementB";
        concreteElementB.print();
    }
}
class ConcreteVisitor2 implements Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        concreteElementA.toPrint = "From ConcreteVisitor2 in ConcreteElementA";
        concreteElementA.print();
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        concreteElementB.toPrint = "From ConcreteVisitor2 in ConcreteElementB";
        concreteElementB.print();
    }
}