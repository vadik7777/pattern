/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

/**
 *
 * @author KonovalovVA
 */
public class AbstractFactoryApp {

    public static void main(String[] args) {
        
        DeviceFactory factory = getDeviceFactory("en");
        Mouse m = factory.getMouse();
        TouchPad t = factory.getTouchPad();
        KeyBoard k = factory.getKeyBoard();
        
        m.click();
        k.println();
        t.track(10, 36);        
    }
    public static DeviceFactory getDeviceFactory(String name){
        switch (name) {
            case "ru":
                return new RuDeviceFactory();
            case "en":
                return new EnDeviceFactory();
        }
        throw new RuntimeException("Не поддерживаем тип страны");
    }
}

interface DeviceFactory {
    Mouse getMouse();
    TouchPad getTouchPad();
    KeyBoard getKeyBoard();
}

class EnDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public TouchPad getTouchPad() {
       return new EnTouchPad();
    }
    
    @Override
    public KeyBoard getKeyBoard() {
        return new EnKeyboard();
    }
    
}
class RuDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public TouchPad getTouchPad() {
       return new RuTouchPad();
    }
    
    @Override
    public KeyBoard getKeyBoard() {
        return new RuKeyboard();
    }
    
}


interface Mouse {
    void click();
    void dbclick();
    void scroll(int direction);
}

interface TouchPad {
    void track(int deltaX, int deltaY);
}

interface KeyBoard {
    void print();
    void println();
}

class EnMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("Mouse click");    
    }

    @Override
    public void dbclick() {
        System.out.println("Mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if(direction>0){
            System.out.println("Scroll Up");
        }else if(direction<0){
            System.out.println("Scroll Down");
        } else {
            System.out.println("No scrolling");
        }
    }
}
class EnTouchPad implements TouchPad{

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        System.out.println("Moved "+s+" pixels");
    }
}
class EnKeyboard implements KeyBoard{

    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("PrintLn");
    }
}
class RuMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("Щелчок мышью");    
    }

    @Override
    public void dbclick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if(direction>0){
            System.out.println("Скролим вверх");
        }else if(direction<0){
            System.out.println("Скролим вниз");
        } else {
            System.out.println("Не скролим");
        }
    }
}
class RuTouchPad implements TouchPad{

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        System.out.println("Передвинулись на "+s+" пикселей");
    }
}
class RuKeyboard implements KeyBoard{

    @Override
    public void print() {
        System.out.println("Печатаем строку");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}

