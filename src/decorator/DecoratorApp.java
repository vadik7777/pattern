/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
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
class Printer implements PrinterInteface{

    String value;  
    public Printer(String value) {
    this.value = value;
    } 
      
    public void print() {
        System.out.print(value);
    }

}
class LeftBreakerDecorator implements PrinterInteface{

    PrinterInteface component;
    public LeftBreakerDecorator(PrinterInteface component) {
        this.component = component;
    }
    public void print() {
        System.out.print("[");
        component.print();
    }
}
class RightBreakerDecorator implements PrinterInteface{

    PrinterInteface component;
    public RightBreakerDecorator(PrinterInteface component) {
        this.component = component;
    }
    public void print() {
        component.print();
        System.out.print("]");
    }
}
class QuoteDecorator implements PrinterInteface{
    PrinterInteface component;

    public QuoteDecorator(PrinterInteface component) {
        this.component = component;
    }
    
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }

}