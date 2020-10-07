/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gof.structure.facade;

/**
 *
 * @author KonovalovVA
 */
public class FacadeApp {

    public static void main(String[] args) {

        Computer comp = new Computer();
        comp.copy();
    }
}

class Computer {

    Power power = new Power();
    DVDRoom dvdRoom = new DVDRoom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRoom.load();
        hdd.copyFromDVD(dvdRoom);
    }

}

class Power {

    void on() {
        System.out.println("Включение питания");
    }

    void off() {
        System.out.println("Выключение питания");
    }
}

class DVDRoom {

    private boolean data = false;

    public boolean isData() {
        return data;
    }

    public void load() {
        data = true;
    }

    public void unLoad() {
        data = false;
    }
}

class HDD {

    void copyFromDVD(DVDRoom dvd) {
        if (dvd.isData()) {
            System.out.println("Происходит копирование данных с диска");
        } else {
            System.out.println("Вставте диск с данными");
        }
    }
}
