
//import com.sun.corba.se.impl.orbutil.graph.Graph;
//import sun.security.util.Length;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class FunctionPanel extends JPanel {
    private FunctionTree functionTree;
    private double defScale = 100.0;
    private static final int LENGTH=800;
    private static final int HEIGHT=800;
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
            double start = -defScale/2;
            double seperate = defScale/ LENGTH;
            for(int i = 0; i < LENGTH; i+=1){
                /*
                for(int o = 0; o < range; o+=1) {
                    double x = pixelToPoint(new PixelPoint(i, o)).getX();
                    double y = functionTree.value(x);
                    int j = pointToPixel(new Point(x, y)).getJ();
                    paintPixel(new PixelPoint(i, j), Color.black, g);
                }*/
                double x = start + i*seperate;
                double y = functionTree.value(x);
                double x5 = start + (i+2)*seperate;
                double y5 = functionTree.value(x5);
                int j = pointToPixel(new Point(x,y)).getJ();
                int j5 = pointToPixel(new Point(x5,y5)).getJ();
//                paintPixel(new PixelPoint(i,j), Color.black, g);
                drawline(new PixelPoint(i,j), new PixelPoint(i+2,j5),Color.black, g);
            }

            for(int i = 0; i < LENGTH; i++){
                paintPixel(new PixelPoint(i,LENGTH/2), Color.black, g);
                paintPixel(new PixelPoint(HEIGHT/2,i), Color.black, g);
                if(i%20 == 0){
                    for(int j = 0; j < HEIGHT; j++){
                        if(j%5 == 0){
                            paintPixel(new PixelPoint(i,j), Color.black, g);
                            paintPixel(new PixelPoint(j,i), Color.black, g);
                        }
                    }
                }
            }


            for(int i = 0; i < HEIGHT; i++){
                if(i%80 == 0){
                    double lab = i/(HEIGHT/defScale) - defScale/2;
                    String Label = Double.toString(lab);
                    addLabel(Label,i,HEIGHT/2,g);
                    addLabel(Label,LENGTH/2,HEIGHT-i,g);
                }
            }
        }

    }



    public Point pixelToPoint(PixelPoint pixelPoint){
        //TODO
        return new Point(10,10);
    }
    public PixelPoint pointToPixel(Point point){
        double x = point.getX();
        double y = point.getY();
        int i = (int) (x*LENGTH/defScale);
        int j = (int) (y*HEIGHT/-defScale)+(HEIGHT/2);
        return new PixelPoint(i,j);
    }
    public void paintPixel(PixelPoint pixelPoint, Color color, Graphics g){
        g.fillRect(pixelPoint.getI(),pixelPoint.getJ(),1,1);
    }
    public void drawline(PixelPoint p1, PixelPoint p2, Color color, Graphics g){
        g.drawLine(p1.getI(),p1.getJ(),p2.getI(),p2.getJ());
    }
    public void addLabel(String label,int x, int y, Graphics g){
        g.drawString(label, x, y);
    }

    public void setFunctionTree(FunctionTree functionTree) {
        this.functionTree = functionTree;
    }
}
