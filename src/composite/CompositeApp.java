/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KonovalovVA
 */
public class CompositeApp {

    public static void main(String[] args) {
        Figure square1 = new Square();
        Figure square2 = new Square();
        Figure square3 = new Square();

        Figure triangle1 = new Triangle();

        Figure circle1 = new Circle();
        Figure circle2 = new Circle();
        Figure circle3 = new Circle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);

        composite1.addComponent(square3);
        composite1.addComponent(circle1);
        composite1.addComponent(circle2);
        composite1.addComponent(circle3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.draw();

    }
}

interface Figure {
    void draw();
}

class Square implements Figure {

    @Override
    public void draw() {
        System.out.println("Привет, я КВАДРАТ");
    }
}

class Triangle implements Figure {

    @Override
    public void draw() {
        System.out.println("Привет, я ТРЕУГОЛЬНИК");
    }
}

class Circle implements Figure {

    @Override
    public void draw() {
        System.out.println("Привет, я КРУГ");
    }
}

class Composite implements Figure {

    private List<Figure> components = new ArrayList<>();

    public void addComponent(Figure component) {
        components.add(component);
    }

    public void removieComponent(Figure component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Figure component : components) {
            component.draw();
        }
    }
}
