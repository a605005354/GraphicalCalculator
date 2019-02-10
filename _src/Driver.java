import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.ConstructorProperties;
import java.security.acl.Group;

public class Driver {
    //Temperate class to work as an entry
    public static void main(String[] args) {
        JFrame frame=new JFrame();

        //ALL panel
        JPanel LeftSide =  new JPanel(new GridBagLayout());
        JPanel inputPanel=new JPanel();
        JPanel outputPanel=new JPanel();
        JPanel operatorPanel = new JPanel(new GridBagLayout());
        JPanel functionPanel = new FunctionPanel();
        JPanel layout = new JPanel();
        JPanel xrangePanel = new JPanel();
        //Input area
        JTextField functionInput = new JTextField();
        functionInput.setLayout(new BoxLayout(functionInput, BoxLayout.X_AXIS));
        functionInput.setPreferredSize(new Dimension(120, 20));
        JTextField domainInput = new JTextField();
        domainInput.setLayout(new BoxLayout(functionInput, BoxLayout.X_AXIS));
        domainInput.setPreferredSize(new Dimension(120, 20));
        JButton plotButton = new JButton("Plot");



        //All Label:
        JLabel inputlabel=new JLabel();
        inputlabel.setText("Enter the function here:");
        //x rage
        JLabel xrange = new JLabel();
        //xrange.setText("Indicate x range here:");
        xrangePanel.add(xrange);


        //Operator buttons
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton sinButton = new JButton("sin");
        JButton cosButton = new JButton("cos");
        JButton tanButton = new JButton("tan");
        JButton piButton = new JButton("π");
        JButton eButton = new JButton("e");


        //GridBag
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 0;
        operatorPanel.add(plusButton, c);
        c.gridx = 2;
        c.gridy = 0;
        operatorPanel.add(minusButton, c);
        c.gridx = 3;
        c.gridy = 0;
        operatorPanel.add(multiplyButton,c);
        c.gridx = 4;
        c.gridy = 0;
        operatorPanel.add(divideButton,c);
        c.gridx = 1;
        c.gridy = 1;
        operatorPanel.add(sinButton, c);
        c.gridx = 2;
        c.gridy = 1;
        operatorPanel.add(cosButton, c);
        c.gridx = 3;
        c.gridy = 1;
        operatorPanel.add(tanButton,c);
        c.gridx = 4;
        c.gridy = 1;
        operatorPanel.add(piButton,c);
        c.gridx = 1;
        c.gridy = 3;
        operatorPanel.add(eButton,c);


        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = functionInput.getText();
                Parser parser=new Parser(input);
                parser.parse();
                FunctionTree result=parser.getFunctionTree();
                ((FunctionPanel) functionPanel).setFunctionTree(result);
                ((FunctionPanel) functionPanel).functionSet=true;
                functionPanel.repaint();
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "+");
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "-");
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "*");
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "/");
            }
        });

        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "sin()");
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "cos()");
            }
        });

        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "tan()");
            }
        });

        piButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "π");
            }
        });

        eButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionInput.setText(functionInput.getText() + "e");
            }
        });

        //GridBag
        GridBagConstraints c2 = new GridBagConstraints();
        c2.insets = new Insets(10,10,10,10);
        c2.gridx = 0;
        c2.gridy =30;
        LeftSide.add(operatorPanel, c2);

        c2.gridx = 0;
        c2.gridy = 40;
        inputPanel.add(inputlabel);
        inputPanel.add(functionInput);
        LeftSide.add(inputPanel, c2);

        c2.gridx = 0;
        c2.gridy =60;
        LeftSide.add(xrangePanel, c2);


        outputPanel.add(functionPanel);



        layout.add(LeftSide, BorderLayout.WEST);
        layout.add(plotButton);
        layout.add(outputPanel, BorderLayout.EAST);

        //JOptionPane.showMessageDialog(null, "Result:" + result.value(10));
        frame.add(layout);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }
}


