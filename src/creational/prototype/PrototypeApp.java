/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.prototype;

/**
 *
 * @author Вадик
 */
public class PrototypeApp {

    public static void main(String[] args) {
        Human original = new Human("Вадим", 37);
        System.out.println("original " + original);
        Human copy = (Human) original.copy();
        System.out.println("copy " + copy);
        HumanFactory factory = new HumanFactory();
        factory.setPrororype(new Human("Ксюща", 33));
        Human h1 = factory.makeCopy();
        System.out.println(h1);

    }

}

interface Copyable {
    Object copy();
}

class Human implements Copyable {

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", age=" + age + '}';
    }

    private String name;
    private int age;

    Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        return new Human(name, age);
    }

}

class HumanFactory {

    Human human;

    void setPrororype(Human human) {
        this.human = human;
    }

    Human makeCopy() {
        return (Human) human.copy();
    }

}
