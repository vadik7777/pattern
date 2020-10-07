package gof.structure.decorator;
/*
 *
 * @author KonovalovVA
 */
public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInteface printer = new QuoteDecorator(new LeftBreakerDecorator(new RightBreakerDecorator(new Printer("hello"))));
        printer.print();
    } 
}

interface PrinterInteface {
    void print();
}

class Printer implements PrinterInteface {
    String value;
    public Printer(String value) {
        this.value = value;
    }
    public void print() {
        System.out.print(value);
    } 
}

abstract class Decorator implements PrinterInteface {
    PrinterInteface component;
    public Decorator(PrinterInteface component) {
        this.component = component;
    }
    public void print() {
        component.print();
    }
}

class LeftBreakerDecorator extends Decorator {
    public LeftBreakerDecorator(PrinterInteface component) {
        super(component);
    }
    public void print() {
        System.out.print("[");
        super.print();
    }
}

class RightBreakerDecorator extends Decorator {
    public RightBreakerDecorator(PrinterInteface component) {
        super(component);
    }
    public void print() {
        super.print();
        System.out.print("]");
    }
}

class QuoteDecorator extends Decorator {
    public QuoteDecorator(PrinterInteface component) {
        super(component);
    }
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
