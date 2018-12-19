/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author KonovalovVA
 */
public class SingletonApp {

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(SingletonApp.class);
    }

}

class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println(this);
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
