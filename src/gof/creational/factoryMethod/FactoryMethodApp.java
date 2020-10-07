/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gof.creational.factoryMethod;

import java.util.Date;

/**
 *
 * @author KonovalovVA
 */
public class FactoryMethodApp {

    public static void main(String[] args) {
        //WatchMacker maker = new DigitalWatchMaker();
        WatchMacker maker = getMackerByName("digital");
        
        
        Watch watch = maker.createWatch();
        watch.showTime();

    }

    public static WatchMacker getMackerByName(String maker) {
        switch (maker) {
            case "digital":
                return new DigitalWatchMaker();
            case "roman":
                return new RomanWatchMaker();
        }
        throw new RuntimeException("Производитель часов не поддерживается");
    }
}

interface WatchMacker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMacker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomanWatchMaker implements WatchMacker {
    @Override
    public Watch createWatch() {
        return new RomanWatch();
    }
}
interface Watch {
    void showTime();
}
class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }

}

class RomanWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("XXI-II");
    }
}
