import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qier on 2019/3/1.
 */
public class PiecewisePanel extends JPanel{
    private String inputFunction;
    public Interval interval;

    Color color;
    JTextField funcPiece;
    JComboBox rightBracket;
    String [] leftside = {"[","("};
    String [] rightside = {"]",")"};
    JLabel name;
    String title;
    JLabel point;
    JLabel label;
    JTextField domainLeftIn;
    JTextField domainRightIn;

    PiecewisePanel(Color color,int Id){


        //name.setText(Integer.toString(Id));
        title = "Piece func"+ Integer.toString(Id);
        label = new JLabel("in");
        name = new JLabel(title);
        point = new JLabel(",");
        this.color = color;
        funcPiece = new JTextField();
        funcPiece.setPreferredSize(new Dimension(60, 20));

        this.setSize(new Dimension(600, 200));
        interval = new Interval(0,0,false,false);
        domainLeftIn = new JTextField();
        domainLeftIn.setPreferredSize(new Dimension(50, 20));
        domainRightIn = new JTextField();
        domainRightIn.setPreferredSize(new Dimension(50, 20));


        /*final JComboBox leftBracket = new JComboBox(leftside);
        leftBracket.setSelectedIndex(0);
        leftBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(leftside[leftBracket.getSelectedIndex()]);
                /*if(leftBracket.getSelectedIndex() == 0){
                    interval.setLeftOpen(false);
                }else {
                    interval.setLeftOpen(true);

                }

            }
        });
        rightBracket = new JComboBox(rightside);
        rightBracket.setSelectedIndex(0);
        rightBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(rightside[rightBracket.getSelectedIndex()]);
                /*if(rightBracket.getSelectedIndex() == 0){
                    interval.setRightOpen(false);
                }else {
                    interval.setRightOpen(true);

                }
            }
        });*/
        GridBagConstraints wholeStyle = new GridBagConstraints();

        wholeStyle.insets = new Insets(10,10,10,10);
        wholeStyle.gridx = 1;
        wholeStyle.gridy = 0;
        this.add(name,wholeStyle);
        wholeStyle.gridx = 1;
        wholeStyle.gridy = 1;
        this.add(funcPiece,wholeStyle);
        wholeStyle.gridx = 2;
        wholeStyle.gridy = 1;
        this.add(label,wholeStyle);
        wholeStyle.gridx = 3;
        wholeStyle.gridy = 1;
        this.add(domainLeftIn,wholeStyle);
        //this.add(leftBracket,wholeStyle);
        wholeStyle.gridx = 4;
        wholeStyle.gridy = 1;
        this.add(point,wholeStyle);
        wholeStyle.gridx = 5;
        wholeStyle.gridy = 1;
        this.add(domainRightIn,wholeStyle);
        //this.add(domainLeftIn,wholeStyle);
        /*wholeStyle.gridx = 1;
        wholeStyle.gridy = 2;
        this.add(domainRightIn,wholeStyle);
        wholeStyle.gridx = 2;
        wholeStyle.gridy = 2;*/
        //this.add(rightBracket,wholeStyle);
        this.setVisible(true);
        this.repaint();



    }

    JTextField getInputFunction(){
        return funcPiece;
    }
    String getLeft(){
        return domainLeftIn.getText();
    }
    String getRight(){
        return domainRightIn.getText();
    }


}

