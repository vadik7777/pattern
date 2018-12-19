/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author KonovalovVA
 */
public class AdapterApp {

    public static void main(String[] args) {
        DrawGraphicsInterface dr = new VectorAdapterFromRaster();
        dr.drawLine();
        dr.drawSquare();
        dr = new VectorAdapterFromRaster2(new RasterGraphics());
        dr.drawLine();
        dr.drawSquare();
    }

}

class VectorAdapterFromRaster2 implements DrawGraphicsInterface {

    private VectorAdapterFromRaster2() {
    }
    private RasterGraphics rasterGraphics;

    public VectorAdapterFromRaster2(RasterGraphics rasterGrahpics) {
        this.rasterGraphics = rasterGrahpics;
    }

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();

    }

}

class VectorAdapterFromRaster extends RasterGraphics implements DrawGraphicsInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }

}

interface DrawGraphicsInterface {

    void drawLine();

    void drawSquare();

}

class RasterGraphics {

    void drawRasterLine() {
        System.out.println("Рисую линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисую квадрат");
    }
}
