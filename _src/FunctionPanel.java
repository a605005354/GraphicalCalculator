import javax.swing.*;
import java.awt.*;

public class FunctionPanel extends JPanel {
    private FunctionTree functionTree;
    private int range=40;

    private static final int LENGTH=200;
    private static final int HEIGHT=100;
    public boolean functionSet=false;


    public FunctionPanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(LENGTH,HEIGHT);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(functionSet){
            for(int i = -range; i < range; i+=5){
                double x = pixelToPoint(new PixelPoint(i, 0)).getX();
                double y=functionTree.value(x);
                int j=pointToPixel(new Point(0,y)).getJ();

                paintPixel(new PixelPoint(i,j), Color.black, g);
            }
        }

    }

    public Point pixelToPoint(PixelPoint pixelPoint){
        //TODO
        return new Point(0,0);
    }
    public PixelPoint pointToPixel(Point point){
        //TODO
        return new PixelPoint(0,45);
    }
    public void paintPixel(PixelPoint pixelPoint, Color color, Graphics g){
        g.fillRect(pixelPoint.getI(),pixelPoint.getJ(),1,1);
    }

    public void setFunctionTree(FunctionTree functionTree) {
        this.functionTree = functionTree;
    }
}
