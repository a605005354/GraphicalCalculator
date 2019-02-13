//import com.sun.corba.se.impl.orbutil.HexOutputStream;

import javax.swing.*;
import java.awt.*;

public class FunctionPanel extends JPanel {
    private FunctionTree functionTree;
    private int range=40;
    private int defScale = 10;
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
            for(int i = -range; i < range; i+=1){
                for(int o = -range; o < range; o+=1) {
                    double x = pixelToPoint(new PixelPoint(i, o)).getX();
                    double y = functionTree.value(x);
                    int j = pointToPixel(new Point(x, y)).getJ();
                    paintPixel(new PixelPoint(i, j), Color.black, g);
                }
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
                    int lab = i/80 - defScale/2;
                    String Label = Integer.toString(lab);
                    addLabel(Label,i,HEIGHT/2,g);
                    addLabel(Label,LENGTH/2,HEIGHT-i,g);
                }
            }
        }

    }



    public Point pixelToPoint(PixelPoint pixelPoint){
        //TODO
        return new Point(0,0);
    }
    public PixelPoint pointToPixel(Point point){
        //TODO
        return new PixelPoint(0,80);
    }
    public void paintPixel(PixelPoint pixelPoint, Color color, Graphics g){
        g.fillRect(pixelPoint.getI(),pixelPoint.getJ(),1,1);
    }
    public void addLabel(String label,int x, int y, Graphics g){
        g.drawString(label, x, y);
    }

    public void setFunctionTree(FunctionTree functionTree) {
        this.functionTree = functionTree;
    }
}
