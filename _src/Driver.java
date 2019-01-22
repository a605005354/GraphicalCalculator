import javax.swing.*;
import java.awt.*;

public class Driver {
    //Temperate class to work as an entry
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        JPanel inputPanel=new JPanel();
        JPanel outputPanel=new JPanel();
        Canvas canvas = new Canvas();

        String input = JOptionPane.showInputDialog("Insert your equation");
        Parser parser=new Parser(input);
        parser.parse();

        FunctionTree result=parser.getFunctionTree();

        JOptionPane.showMessageDialog(null, "Result:" + result.value(10));


        frame.add(outputPanel);
    }
}
