
//import com.sun.corba.se.impl.orbutil.graph.Graph;
//import sun.security.util.Length;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class FunctionPanel extends JPanel {
    private FunctionInfo fninfo;
    int treetracker = 0;
    double defScale = 10;
    private static final int LENGTH=800;
    private static final int HEIGHT=800;
    public boolean functionSet=false;
    double aimx = 0.0;
    double aimy = 0.0;
    int index = 0;
    int line = -1;
    boolean findYflag = false;
    double findYx = 0.0;
    boolean manualscale = false;
    boolean dialog1 = false;


    public FunctionPanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(LENGTH,HEIGHT);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (functionSet) {
            dialog1 = false;
            if (aimx == 0.0 && aimy == 0.0) {
                int fntracker = fninfo.getFunctionTrees().size();
                double start = -defScale / 2;
                double seperate = defScale / LENGTH;
                for (int k = 0; k < fntracker; k++) {
                    if (fninfo.isPieceWise[k] == false) {
                        FunctionTree fnt = fninfo.getFunctionTrees().get(k).get(0);
                        if(fnt == null){
                            continue;
                        }else{
                            //seeded, color does not change.
                            //Color color = fninfo.getColors().get(k);
                            Color color = Color.black;
                            for (int i = 0; i < LENGTH; i += 1) {
                                double x = start + i * seperate;
                                double y = fnt.value(x);
                                double x5 = start + (i + 1) * seperate;
                                double y5 = fnt.value(x5);
                                if (Double.isNaN(y) || Double.isNaN(y5)) {
                                    System.out.println("isnan");
                                    if(dialog1 == false){JOptionPane.showMessageDialog(null,
                                            "Function not defined",
                                            "Invalid input",
                                            JOptionPane.ERROR_MESSAGE);
                                        dialog1 = true;
                                    }
                                    continue;
                                }
                                if (y > y5 && (fnt.value(x) < fnt.value(x + 0.0000001) && fnt.value(x5 - 0.0000001) < fnt.value(x5))) {
                                    int newj = pointToPixel(new Point(x, y)).getJ();
                                    int newj5 = pointToPixel(new Point(x5, y5)).getJ();
                                    drawline(new PixelPoint(i, newj), new PixelPoint(i, 0), color, g);
                                    drawline(new PixelPoint(i + 1, newj5), new PixelPoint(i + 1, 800), color, g);
                                    continue;
                                }
                                if (y < y5 && (fnt.value(x) > fnt.value(x + 0.0000001) && fnt.value(x5 - 0.0000001) > fnt.value(x5))) {
                                    int newj = pointToPixel(new Point(x, y)).getJ();
                                    int newj5 = pointToPixel(new Point(x5, y5)).getJ();
                                    // drawline(new PixelPoint(i, newj), new PixelPoint(i, 800), color, g);
                                    //   drawline(new PixelPoint(i + 1, newj5), new PixelPoint(i + 1, 0), color, g);
                                    continue;
                                }
                                if (Double.isInfinite(y) || Double.isInfinite(y5)) {
                                    continue;
                                }
                                int j = pointToPixel(new Point(x, y)).getJ();
                                int j5 = pointToPixel(new Point(x5, y5)).getJ();
//                paintPixel(new PixelPoint(i,j), Color.black, g);
                                //System.out.println("this is y: " + y + " this is y5: " + y5);
                                drawline(new PixelPoint(i, j), new PixelPoint(i + 1, j5), color, g);
                                // System.out.printf("%d,%d\n",j, j5);
                            }
                        }
                    } else {
                        int piecesamt = fninfo.getFunctionTrees().get(k).size();
                        Color color = fninfo.getColors().get(k);
                        for (int i = 0; i < piecesamt; i++) {
                            FunctionTree fnt = fninfo.getFunctionTrees().get(k).get(i);
                            if(fnt == null){
                                continue;
                            }else {
                                Interval itv = fninfo.getIntervals().get(k).get(i);
                                double left = itv.getLeft();
                                double right = itv.getRight();
                                boolean leftinf = itv.isLeftInfi();
                                boolean rightinf = itv.isRightInfi();
                                if (leftinf) {
                                    left = Double.MIN_VALUE;
                                }
                                if (rightinf) {
                                    left = Double.MAX_VALUE;
                                }
                                for (int m = 0; m < LENGTH; m += 1) {
                                    double x = start + m * seperate;
                                    if (x > left && x < right) {
                                        double y = fnt.value(x);
                                        double x5 = start + (m + 1) * seperate;
                                        double y5 = fnt.value(x5);
                                        if (Double.isNaN(y) || Double.isNaN(y5)) {
                                            continue;
                                        }
                                        if (y > y5 && (fnt.value(x) < fnt.value(x + 0.0000001) && fnt.value(x5 - 0.0000001) < fnt.value(x5))) {
                                            int newj = pointToPixel(new Point(x, y)).getJ();
                                            int newj5 = pointToPixel(new Point(x5, y5)).getJ();
                                            drawline(new PixelPoint(m, newj), new PixelPoint(m, 0), color, g);
                                            drawline(new PixelPoint(m + 1, newj5), new PixelPoint(m + 1, 800), color, g);
                                            continue;
                                        }
                                        if (y < y5 && (fnt.value(x) > fnt.value(x + 0.0000001) && fnt.value(x5 - 0.0000001) > fnt.value(x5))) {
                                            int newj = pointToPixel(new Point(x, y)).getJ();
                                            int newj5 = pointToPixel(new Point(x5, y5)).getJ();
                                            //  drawline(new PixelPoint(m, newj), new PixelPoint(m, 800), color, g);
                                            //drawline(new PixelPoint(m + 1, newj5), new PixelPoint(m + 1, 0), color, g);
                                            continue;
                                        }
                                        if (Double.isInfinite(y) || Double.isInfinite(y5)) {
                                            continue;
                                        }
                                        int j = pointToPixel(new Point(x, y)).getJ();
                                        int j5 = pointToPixel(new Point(x5, y5)).getJ();
//                paintPixel(new PixelPoint(i,j), Color.black, g);
                                        //System.out.println("this is y: " + y + " this is y5: " + y5);
                                        drawline(new PixelPoint(m, j), new PixelPoint(m + 1, j5), color, g);
                                    } else {
                                        continue;
                                    }

                                    // System.out.printf("%d,%d\n",j, j5);
                                }
                            }
                        }
                    }

                    //System.out.println("k = " + k);


                }

                for (int i = 0; i < LENGTH; i++) {
                    paintPixel(new PixelPoint(i, LENGTH / 2), Color.black, g);
                    paintPixel(new PixelPoint(HEIGHT / 2, i), Color.black, g);
                    if (i % 20 == 0) {
                        for (int j = 0; j < HEIGHT; j++) {
                            if (j % 5 == 0) {
                                paintPixel(new PixelPoint(i, j), Color.black, g);
                                paintPixel(new PixelPoint(j, i), Color.black, g);
                            }
                        }
                    }
                }

                for (int i = 0; i < HEIGHT; i++) {
                    if (i % 80 == 0) {
                        double lab = i / (HEIGHT / defScale) - defScale / 2;
                        String Label = Double.toString(lab);
                        if (Label.length() > 3) {
                            lab = Double.parseDouble(String.format("%f", lab));
                            Label = Double.toString(lab);
                        }
                        addLabel(Label, i, HEIGHT / 2, g);
                        addLabel(Label, LENGTH / 2, HEIGHT - i, g);
                    }
                }
                if (line != -1) {
                    drawline(new PixelPoint(line, 0), new PixelPoint(line, 800), Color.black, g);
                    int fntrack = fninfo.getFunctionTrees().size();
                    for (int ii = 0; ii < fntrack; ii++) {
                        if (fninfo.isPieceWise[ii] == false) {
                            FunctionTree fn = fninfo.getFunctionTrees().get(ii).get(0);
                            double x = start + line * seperate - seperate/2;
                            double y = fn.value(x);
                            int j = pointToPixel(new Point(x, y)).getJ();
                            drawdot(y, new PixelPoint(line, j), Color.black, g);
                        }
                        else{
                            int count = fninfo.getFunctionTrees().get(ii).size();
                            for (int a = 0; a < count; a++) {
                                Interval itv = fninfo.getIntervals().get(ii).get(a);
                                double x = start + line * seperate;
                                FunctionTree fn = fninfo.getFunctionTrees().get(ii).get(a);
                                double left = itv.getLeft();
                                double right = itv.getRight();
                                boolean leftinf = itv.isLeftInfi();
                                boolean rightinf = itv.isRightInfi();
                                if (leftinf) {
                                    left = Double.MIN_VALUE;
                                }
                                if (rightinf) {
                                    left = Double.MAX_VALUE;
                                }
                                if(x > left && x < right){
                                    double y = fn.value(x);
                                    int j = pointToPixel(new Point(x, y)).getJ();
                                    drawdot(y, new PixelPoint(line, j), Color.black, g);
                                }
                                else{
                                    continue;
                                }
                            }
                        }
                    }
                }
                if (findYflag == true) {
                    int globj = 0;
                    for (int j = 0; j < LENGTH; j++) {
                        double left = start + j * seperate;
                        double right = start + (j + 1) * seperate;
                        if (findYx >= left && findYx <= right) {
                            drawline(new PixelPoint(j, 0), new PixelPoint(j, 800), Color.black, g);
                            globj = j;
                        }
                    }
                    int fntrack = fninfo.getFunctionTrees().size();
                    for (int ii = 0; ii < fntrack; ii++) {
                        if (fninfo.isPieceWise[ii] == false) {
                            FunctionTree fn = fninfo.getFunctionTrees().get(ii).get(0);
                            double y = fn.value(findYx);
                            int j = pointToPixel(new Point(globj, y)).getJ();
                            drawdot(y, new PixelPoint(globj, j), Color.black, g);
                        } else {
                            int count = fninfo.getFunctionTrees().get(ii).size();
                            for (int a = 0; a < count; a++) {
                                double x = start + findYx * seperate;
                                Interval itv = fninfo.getIntervals().get(ii).get(a);
                                FunctionTree fn = fninfo.getFunctionTrees().get(ii).get(a);
                                double left = itv.getLeft();
                                double right = itv.getRight();
                                boolean leftinf = itv.isLeftInfi();
                                boolean rightinf = itv.isRightInfi();
                                if (leftinf) {
                                    left = Double.MIN_VALUE;
                                }
                                if (rightinf) {
                                    left = Double.MAX_VALUE;
                                }
                                if (x > left && x < right) {
                                    double y = fn.value(findYx);
                                    int j = pointToPixel(new Point(globj, y)).getJ();
                                    //drawdot(y, new PixelPoint(globj, j), Color.black, g);
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                } else {
                    boolean originxPosition = true; // true for originx still in the graph
                    boolean originyPosition = true; // true for originy still in the graph
                    if (aimx > defScale / 2) {
                        originxPosition = false;
                    }
                    if (aimy > defScale / 2) {
                        originyPosition = false;
                    }

                    if (originxPosition == true && originyPosition == true) {// case 1, where zero lies in side graph
                        double separation = defScale / 800;

                    } else if (originxPosition == false && originyPosition == false) { // case 2, where zero lies not in the graph

                    } else if (originxPosition == true && originyPosition == false) {  // case 3, where 0x lies in the graph but y not

                    } else if (originxPosition == false && originyPosition == true) {  // case 4, where 0y lies in graph but x not

                    } else {
                        //something must be wrong here
                    }
                    // and then start drawing the function.

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
        g.setColor(color);
        g.fillRect(pixelPoint.getI(),pixelPoint.getJ(),1,1);
    }
    public void drawline(PixelPoint p1, PixelPoint p2, Color color, Graphics g){
        g.setColor(color);
        g.drawLine(p1.getI(),p1.getJ(),p2.getI(),p2.getJ());
    }
    public void addLabel(String label,int x, int y, Graphics g){
        g.drawString(label, x, y);
    }
    public void setIndex(int index) {
        this.index = index;
    }
    //public void setFunctionTree(FunctionTree functionTree) {
    //    this.functionTree[index] = functionTree;
    //}
    public void setCursorLine(int line){
        this.line = line;
    }
    public void drawdot(double y, PixelPoint p1, Color color, Graphics g){
        g.setColor(color);
        g.fillRect(p1.getI()+1,p1.getJ(),1,1);
        g.fillRect(p1.getI()+1,p1.getJ(),1,1);
        g.fillRect(p1.getI()-1,p1.getJ(),1,1);
        g.fillRect(p1.getI(),p1.getJ()+1,1,1);
        g.fillRect(p1.getI(),p1.getJ()-1,1,1);
        g.fillRect(p1.getI()+1,p1.getJ()+1,1,1);
        g.fillRect(p1.getI()-1,p1.getJ()-1,1,1);
        g.fillRect(p1.getI()-1,p1.getJ()+1,1,1);
        g.fillRect(p1.getI()+1,p1.getJ()-1,1,1);
        // g.setColor(Color.white);
        g.fillRect(p1.getI()+1,p1.getJ(),1,1);
        String yequal = "  y = ";
        String yvalue = Double.toString(y);
        String ytotal = yequal + yvalue;
        //seeded, y = ...won't show up.
        //addLabel(ytotal, p1.getI(),p1.getJ(),g);
    }
    public void findY(double x){
        this.findYflag = true;
        this.findYx = x;
    }
    public void undofindY(){
        this.findYflag = false;
        this.findYx = 0;
    }
    // public void setColor(Color c){
    //    this.color = c;
    //  }
    public void undoCursorLine(){
        this.line = -1;
    }
    public void setscale(double x){
        if(manualscale == true) {
            this.defScale = x;
        }
    }
    public void setscalebool(){
        this.manualscale = true;
    }
    public void resetscalebool(){
        this.manualscale = false;
        //this.defScale = 10;
    }

    public void setFninfo(FunctionInfo fninfo) {
        this.fninfo = fninfo;
    }
}
