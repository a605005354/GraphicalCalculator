import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by qier on 2019/2/12.
 */
public class FuncFrame extends JComponent {
    private String inputFunction;
    public Color color = Color.black;
    private int isClea = 0;
    private int pieceClick = 0;

    FuncFrame (){
        JPanel inputPanel=new JPanel();
        //input area:
        JTextField inputDialog = new JTextField();

        //button 1: click to pop the piecewise
        ImageIcon imageIcon = createImageIcon("../Image/Orange_animated_right_arrow.gif");
        JButton pieceWise = new JButton("piece");

        PopupFactory piecewiseInput =new PopupFactory();
        //popup piecewise info
        String [] leftside = {"[","("};
        String [] rightside = {"]",")"};
        JComboBox leftBracket = new JComboBox(leftside);
        leftBracket.setSelectedIndex(0);
        leftBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(leftside[leftBracket.getSelectedIndex()]);
            }
        });

        JComboBox rightBracket = new JComboBox(rightside);
        rightBracket.setSelectedIndex(0);
        rightBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(rightside[rightBracket.getSelectedIndex()]);
            }
        });

        //button 2: set color:
        String [] colors = {"Black","Blue","Red","Yellow"};
        JComboBox setColor = new JComboBox(colors);
        setColor.setSelectedIndex(0);
        setColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(colors[setColor.getSelectedIndex()]);
            }
        });

        //button 3: clean all setting

        JButton clearInput = new JButton("Clean");
        clearInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clean click");

            }
        });
        inputPanel.add(inputDialog);
        inputPanel.add(pieceWise);
        inputPanel.add(clearInput);
        

    }
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FuncFrame.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }




}
