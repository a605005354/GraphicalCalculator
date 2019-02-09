import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.ConstructorProperties;

public class Driver {
    //Temperate class to work as an entry
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        JPanel inputPanel=new JPanel();
        JPanel outputPanel=new JPanel();
        JPanel functionPanel = new FunctionPanel();
        JPanel layout = new JPanel();
        TextArea functionInput = new TextArea();
        Button plotButton = new Button("Plot");

        //operator panel
        JPanel operatorPanel = new JPanel(new BorderLayout());

        //Operator buttons
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");

        //button attribute
        plus.setBounds(10,10,10,10);
        minus.setBounds(10,10,10,10);
        multiply.setBounds(10,10,10,10);
        divide.setBounds(10,10,10,10);

        operatorPanel.add(plus);
        operatorPanel.add(minus);
        operatorPanel.add(multiply);
        operatorPanel.add(divide);

        operatorPanel.setSize(new Dimension(300,200));
        layout.add(operatorPanel);



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
        inputPanel.add(plotButton);
        inputPanel.setSize(new Dimension(300, 400));
        outputPanel.add(functionPanel);
        layout.add(inputPanel);
        layout.add(outputPanel);



        //JOptionPane.showMessageDialog(null, "Result:" + result.value(10));

        frame.add(layout);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }
}


