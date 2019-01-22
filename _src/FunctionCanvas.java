import java.awt.*;

public class FunctionCanvas extends Canvas {
    FunctionTree functionTree;
    int range;

    public void paint(Graphics g){
        for(int i = -range; i < range; i+=5){
            double x = pixelToPoint(new PixelPoint(i, 0)).getX();
            double y=functionTree.value(x);
            int j=pointToPixel(new Point(0,y)).getJ();

            paintPixel(new PixelPoint(i,j), Color.black, g);
        }
    }

    public Point pixelToPoint(PixelPoint pixelPoint){
        //TODO
        return new Point(0,0);
    }
    public PixelPoint pointToPixel(Point point){
        //TODO
        return new PixelPoint(0,0);
    }
    public void paintPixel(PixelPoint pixelPoint, Color color, Graphics g){
        g.fillRect(pixelPoint.getI(),pixelPoint.getJ(),1,1);
    }
}
