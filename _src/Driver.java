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
        JPanel LeftSide =  new JPanel(new GridBagLayout());
        JPanel inputPanel=new JPanel();
        JPanel outputPanel=new JPanel();
        JPanel operatorPanel = new JPanel(new GridBagLayout());
        JPanel functionPanel = new FunctionPanel();
        JPanel layout = new JPanel();
        TextArea functionInput = new TextArea();
        JButton plotButton = new JButton("Plot");

        //Operator buttons
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");

        //GridBag
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 0;
        operatorPanel.add(plus, c);
        c.gridx = 2;
        c.gridy = 0;
        operatorPanel.add(minus, c);
        c.gridx = 3;
        c.gridy = 0;
        operatorPanel.add(multiply,c);
        c.gridx = 4;
        c.gridy = 0;
        operatorPanel.add(divide,c);

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

        inputPanel.add(functionInput);
        outputPanel.add(functionPanel);


        //GridBag
        GridBagConstraints c2 = new GridBagConstraints();
        c2.insets = new Insets(10,10,10,10);
        c2.gridx = 0;
        c2.gridy =30;
        LeftSide.add(operatorPanel, c2);

        c2.gridx = 0;
        c2.gridy = 60;
        LeftSide.add(inputPanel, c2);
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


