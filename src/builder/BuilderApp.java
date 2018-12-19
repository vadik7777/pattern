/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

/**
 *
 * @author Вадик
 */
public class BuilderApp {

    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.BuildCar();
        System.out.println(car);
        /*Car car = new CarBuilder().buildMake("волга").buildMaxSpedd(180).buildTransminion(Transmission.РУЧНАЯ).build();
        System.out.println(car);*/
    }

}

enum Transmission {
    РУЧНАЯ, АВТОМАТ
}

class Director {

    AbstactCarBuilder builder;

    public void setBuilder(AbstactCarBuilder builder) {
        this.builder = builder;
    }

    Car BuildCar() {
        builder.createCar();
        builder.buildMake();
        builder.buildMaxSpeed();
        builder.buildTransmition();
        return builder.getCar();
    }
}

abstract class AbstactCarBuilder {

    private Car car;

    abstract void buildTransmition();
    abstract void buildMaxSpeed();
    abstract void buildMake();

    public Car getCar() {
        return car;
    }

    void createCar() {
        car = new Car();
    }
}

class ShevroleBuilder extends AbstactCarBuilder {

    @Override
    void buildTransmition() {
        getCar().setTransmission(Transmission.АВТОМАТ);
    }

    @Override
    void buildMaxSpeed() {
        getCar().setMaxSpeed(230);
    }

    @Override
    void buildMake() {
        getCar().setMake("Шевроле");
    }

}

class SubaruBuilder extends AbstactCarBuilder {

    @Override
    void buildTransmition() {
        getCar().setTransmission(Transmission.РУЧНАЯ);
    }

    @Override
    void buildMaxSpeed() {
        getCar().setMaxSpeed(320);
    }

    @Override
    void buildMake() {
        getCar().setMake("Субару");
    }

}

class Car {

    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "модель " + make + ", коробка передач " + transmission + ", максимальная скорость " + maxSpeed + " км/ч";
    }

}

/*class CarBuilder {

    String m = "mersedec";
    Transmission t = Transmission.РУЧНАЯ;
    int s = 120;

    CarBuilder buildMake(String m) {
        this.m = m;
        return this;
    }

    CarBuilder buildTransminion(Transmission t) {
        this.t = t;
        return this;
    }

    CarBuilder buildMaxSpedd(int s) {
        this.s = s;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setMake(m);
        car.setMaxSpeed(s);
        car.setTransmission(t);
        return car;
    }

}*/
