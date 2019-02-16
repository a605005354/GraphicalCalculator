import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by qier on 2019/2/12.
 */
public class FuncFrame extends JPanel {
    private String inputFunction;
    public Color color = Color.black;
    private int isClea = 0;
    int pieceClick = 1;
    JTextField inputDialog;
    public int flag =0;

    FuncFrame (){
        JPanel inputPanel=new JPanel(new GridBagLayout());
        inputPanel.setSize(300,50);
        this.setLayout(new GridBagLayout());

        //input area:
        JLabel indiclabel = new JLabel("Enter function here:");
        inputDialog = new JTextField();
        inputDialog.setLayout(new BoxLayout(inputDialog, BoxLayout.X_AXIS));
        inputDialog.setPreferredSize(new Dimension(150, 20));


        //button 1: click to pop the piecewise
        JButton pieceWise = new JButton("+xrange");
        //Component inside the popup
        JTextField domainLeftIn = new JTextField();
        domainLeftIn.setPreferredSize(new Dimension(50, 20));
        JTextField domainRightIn = new JTextField();
        domainRightIn.setPreferredSize(new Dimension(50, 20));
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
        //setting pop up
        PopupFactory popFact =new PopupFactory();
        JPanel popupPanel = new JPanel(new BorderLayout());
        popupPanel.setSize(new Dimension(200,100));
        Popup popPiece;
        popPiece = popFact.getPopup(popupPanel,inputPanel,200,280);
        /*inputPanel.setLayout(
                new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS)
        );*/
        GridBagConstraints constrain = new GridBagConstraints();
        constrain.gridx = 10;
        constrain.gridy = 0;
        inputPanel.add(leftBracket,constrain);
        constrain.gridx = 15;
        constrain.gridy = 0;
        inputPanel.add(domainLeftIn,constrain);
        constrain.gridx = 70;
        constrain.gridy = 0;
        inputPanel.add(domainRightIn,constrain);
        constrain.gridx = 140;
        constrain.gridy = 0;
        inputPanel.add(rightBracket,constrain);
        //inputPanel.add(domainRightIn);

        pieceWise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println("sdf "+pieceClick);
                if(pieceClick == 1){
                    popPiece.show();
                    pieceClick = 0;
                }else {

                    popPiece.hide();
                    pieceClick = 1;
                }



            }
        });
       // popupPanel.setBackground(Color.blue);
        //popupPanel.add(leftBracket);
        //popupPanel.add(rightBracket);

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
                //System.out.println("clean click");
                inputDialog.setText("");

            }
        });
        GridBagConstraints wholeStyle = new GridBagConstraints();
        wholeStyle.insets = new Insets(10,10,10,10);
        wholeStyle.gridx = 1;
        wholeStyle.gridy = 0;
        this.add(setColor,wholeStyle);
        wholeStyle.gridx = 1;
        wholeStyle.gridy = 1;
        this.add(indiclabel,wholeStyle);
        wholeStyle.gridx = 2;
        wholeStyle.gridy = 1;
        this.add(inputDialog,wholeStyle);
        wholeStyle.gridx = 1;
        wholeStyle.gridy = 2;
        this.add(pieceWise,wholeStyle);
        wholeStyle.gridx = 2;
        wholeStyle.gridy = 2;
        this.add(clearInput,wholeStyle);


        //this.pack();
        this.setVisible(true);


    }

    String getInputFunc(){
        return inputDialog.getText();
    }

    void setInputText(String input){
        inputDialog.setText(input);
    }





}
