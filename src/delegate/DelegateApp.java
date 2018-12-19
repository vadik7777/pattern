/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delegate;

/**
 *
 * @author KonovalovVA
 */
public class DelegateApp {

    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setDraw(new Rectangle());
        painter.draw();
        painter.setDraw(new Triangle());
        painter.draw();
        painter.setDraw(new Circle());
        painter.draw();
    }
}
class Painter {
    private Draw draw;
    
    public void setDraw(Draw draw) {
        this.draw = draw;
    }
    void draw() {
        draw.draw();
    }
}

interface Draw {

    void draw();
}

class Rectangle implements Draw {

    @Override
    public void draw() {
        System.out.println("Рисую прямоугольник");
    }
}

class Triangle implements Draw {

    @Override
    public void draw() {
        System.out.println("Рисую треугольник");
    }
}

class Circle implements Draw {

    @Override
    public void draw() {
        System.out.println("Рисую круг");
    }
}
