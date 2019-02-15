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
        JFrame mainFrame=new JFrame();

        //ALL panel
        //Leftside = GroupInput + operatorPanel
        JPanel LeftSide =  new JPanel(new GridBagLayout());
        //contains all operators
        JPanel operatorPanel = new JPanel(new GridBagLayout());
        //one inputPanel = one textArea + three buttons (color, piecewise, clean)
        JPanel inputPanel=new JPanel(new GridBagLayout());
        //JPanel inputPanel2= new JPanel((new GridBagLayout()));
        //container for all inputPanels; include two buttons (+/-)
        JScrollPane GroupInput = new JScrollPane();
        GroupInput.setPreferredSize(new Dimension(400,200));
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);
        GroupInput.setBorder(border);
        GroupInput.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //rightmost
        JPanel outputPanel=new JPanel();
        JPanel functionPanel = new FunctionPanel();
        JPanel domainPanel = new JPanel();
        JPanel layout = new JPanel();
        JPanel xrangePanel = new JPanel(new GridBagLayout());

        //Input area
        JTextField inputDialog = new JTextField();
        JTextField inputDialog2 = new JTextField();
        inputDialog2.setLayout(new BoxLayout(inputDialog2, BoxLayout.X_AXIS));
        inputDialog2.setPreferredSize(new Dimension(120, 20));

        inputDialog.setLayout(new BoxLayout(inputDialog, BoxLayout.X_AXIS));
        inputDialog.setPreferredSize(new Dimension(120, 20));
        /*JTextField domainLeftIn = new JTextField();
        domainLeftIn.setLayout(new BoxLayout(inputDialog, BoxLayout.X_AXIS));
        domainLeftIn.setPreferredSize(new Dimension(120, 20));
        JTextField domainRightIn = new JTextField();
        domainRightIn.setLayout(new BoxLayout(inputDialog, BoxLayout.X_AXIS));
        domainRightIn.setPreferredSize(new Dimension(120, 20));*/
        JButton plotButton = new JButton("Plot");



        //All Label:
        JLabel inputlabel=new JLabel();
        inputlabel.setText("Enter the function here:");
        //x rage
        JLabel xrange = new JLabel();
        xrange.setText("Indicate x range here:");



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
        FuncFrame newnew = new FuncFrame();


        //ComboBox Info
        /*String [] leftside = {"[","("};
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
        });*/
        //set combobox position:
        GridBagConstraints xR = new GridBagConstraints();
        xR.insets = new Insets(10,10,10,10);
        xR.gridx = 1;
        xR.gridy = 0;
        xrangePanel.add(xrange,xR);
        xR.gridx = 2;
        xR.gridy = 0;
        //xrangePanel.add(leftBracket,xR);
        //xR.gridx = 3;
        //xR.gridy = 0;
        //domainPanel.add(domainLeftIn)
        //xrangePanel.add(domainLeftIn,xR);

        xR.gridx = 4;
        xR.gridy = 0;
        //xrangePanel.add(rightBracket);
       // xrangePanel.add(newnew);
        //domainPanel.add(xrangePanel);


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
        c.gridx = 5;
        c.gridy = 0;
        operatorPanel.add(sinButton, c);
        c.gridx = 1;
        c.gridy = 1;
        operatorPanel.add(cosButton, c);
        c.gridx = 2;
        c.gridy = 1;
        operatorPanel.add(tanButton,c);
        c.gridx = 3;
        c.gridy = 1;
        operatorPanel.add(piButton,c);
        c.gridx = 4;
        c.gridy = 1;
       operatorPanel.add(eButton,c);
       // operatorPanel.add(newnew,c);


        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputDialog.getText();
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
                inputDialog.setText(inputDialog.getText() + "+");
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "-");
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "*");
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "/");
            }
        });

        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "sin()");
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "cos()");
            }
        });

        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "tan()");
            }
        });

        piButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "π");
            }
        });

        eButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog.setText(inputDialog.getText() + "e");
            }
        });

        //construct inputPanel
        inputPanel.add(inputlabel);
        inputPanel.add(inputDialog);
        inputPanel.add(inputDialog2);

        GroupInput.setViewportView(inputPanel);

        //GridBag
        GridBagConstraints c2 = new GridBagConstraints();
        c2.insets = new Insets(10,10,10,10);
        c2.gridx = 0;
        c2.gridy =20;
        //LeftSide.add(operatorPanel, c2);
        LeftSide.add(newnew,c2);


        c2.gridx = 0;
        c2.gridy = 30;
        LeftSide.add(GroupInput, c2);

        c2.gridx = 0;
        c2.gridy =35;
        LeftSide.add(domainPanel, c2);

        //// TODO: 2019/2/11
        //adjust input area for xrange

        c2.gridx = 0;
        c2.gridy =60;
        outputPanel.add(functionPanel,c2);



        layout.add(LeftSide, BorderLayout.WEST);
        layout.add(plotButton);
        layout.add(outputPanel, BorderLayout.EAST);

        //JOptionPane.showMessageDialog(null, "Result:" + result.value(10));
        mainFrame.add(layout);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setVisible(true);

    }
}


