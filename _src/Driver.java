import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        inputPanel.setSize(new Dimension(300, 200));
        outputPanel.add(functionPanel);
        layout.add(inputPanel);
        layout.add(outputPanel);



        //JOptionPane.showMessageDialog(null, "Result:" + result.value(10));

        frame.add(layout);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);


    }
}


