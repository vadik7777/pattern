package gof.structure.adapter;
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
class VectorAdapterFromRaster2 implements DrawGraphicsInterface {
    private VectorAdapterFromRaster2(){}
    private RasterGraphics rasterGraphics;
    public VectorAdapterFromRaster2(RasterGraphics rasterGrahpics){
        this.rasterGraphics = rasterGrahpics;
    }
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements DrawGraphicsInterface {
    public void drawLine() {
        drawRasterLine();
    }
    public void drawSquare() {
        drawRasterSquare();
    }
}