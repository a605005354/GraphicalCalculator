import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qier on 2019/2/12.
 */
public class ExpressionPanel extends JPanel {
    private String inputFunction;
    public Color color = Color.black;
    private int isClea = 0;
    int pieceClick = 1;
    JTextField inputDialog;
    public int flag =0;
    int pieceCount = 0;
    Interval originalInt ;
    float left;
    float right;
    boolean leftOpen;
    boolean rightOpen;
    PiecewisePanel pieces[] ;
    JLabel numAlert = new JLabel("Maximum piecewise : 5");
    JFrame mainPanel;
    JPanel popupPanel;
    JPanel inputPanel;
    Popup popPiece;

    //popup &&&& combox
    PopupFactory popFact;
    JComboBox leftBracket;
    JComboBox rightBracket;
    String [] leftside = {"[","("};
    String [] rightside = {"]",")"};

    ExpressionPanel(final JFrame mainPanel){
        //inputPanel: panel in popup
        inputPanel=new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        this.mainPanel = mainPanel;
        inputPanel.setSize(400,400);
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setLayout(new GridBagLayout());

        //input area:
        JLabel indiclabel = new JLabel("Enter Function here:");
        inputDialog = new JTextField();
        inputDialog.setLayout(new BoxLayout(inputDialog, BoxLayout.X_AXIS));
        inputDialog.setPreferredSize(new Dimension(150, 20));


        //button 1: click to pop the piecewise
        pieces = new PiecewisePanel[5];
        JButton pieceWise = new JButton("+xrange");
        //Component inside the popup: originial components
        JLabel staticLabel = new JLabel("default:");
        JTextField domainLeftIn = new JTextField();
        domainLeftIn.setPreferredSize(new Dimension(50, 20));
        JTextField domainRightIn = new JTextField();
        domainRightIn.setPreferredSize(new Dimension(50, 20));
        /*String [] leftside = {"[","("};
        String [] rightside = {"]",")"};*/
        leftBracket = new JComboBox(leftside);
        leftBracket.setSelectedIndex(0);
        leftBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(leftside[leftBracket.getSelectedIndex()]);
                if(leftBracket.getSelectedIndex() == 0){
                    leftOpen = false;
                }else {
                    leftOpen = true;
                }


            }
        });

        rightBracket = new JComboBox(rightside);
        rightBracket.setSelectedIndex(0);
        rightBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(rightside[rightBracket.getSelectedIndex()]);
                if(leftBracket.getSelectedIndex() == 0){
                    rightOpen = false;
                }else {
                    rightOpen = true;
                }
            }
        });
        //setting pop up
        popFact =new PopupFactory();
        popupPanel = new JPanel();
        popupPanel.setLayout(new BoxLayout(popupPanel,BoxLayout.Y_AXIS));
        //add more pieces func:
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("plus");
                if(pieceCount == 5){
                    numAlert.setText("Already to maximum piecewise function");
                }else{
                    PiecewisePanel piece = new PiecewisePanel(color,pieceCount+1);
                    System.out.println("adding");
                    inputPanel.add(piece);
                    inputPanel.setVisible(true);
                    inputPanel.repaint();
                    pieces[pieceCount++] = piece;
                    mainPanel.pack();
                    mainPanel.repaint();
                    mainPanel.setVisible(true);

                }

            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("---");
                if(pieceCount > 0){
                    inputPanel.remove(pieces[--pieceCount]);
                    pieces[pieceCount] = null;
                    inputPanel.repaint();
                    mainPanel.pack();
                    mainPanel.repaint();
                    mainPanel.setVisible(true);

                }
            }
        });
        popupPanel.setSize(new Dimension(500,600));


        //ExpressionPanel p = new ExpressionPanel();
        /*inputPanel.setLayout(
                new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS)
        );*/
        JPanel basicXrange = new JPanel();
        basicXrange.setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
        constrain.gridx = 5;
        constrain.gridy = 0;
        basicXrange.add(staticLabel,constrain);
        constrain.gridx = 10;
        constrain.gridy = 0;
        basicXrange.add(inputDialog,constrain);
        constrain.gridx = 15;
        constrain.gridy = 0;
        basicXrange.add(leftBracket,constrain);
        constrain.gridx = 25;
        constrain.gridy = 0;
        basicXrange.add(domainLeftIn,constrain);
        constrain.gridx = 35;
        constrain.gridy = 0;
        basicXrange.add(domainRightIn,constrain);
        constrain.gridx = 50;
        constrain.gridy = 0;
        basicXrange.add(rightBracket,constrain);
        /*constrain.gridx = 5;
        constrain.gridy = 1;
        inputPanel.add(plus,constrain);
        constrain.gridx = 10;
        constrain.gridy = 1;
        inputPanel.add(minus,constrain);*/
        //inputPanel.add(staticLabel);
        inputPanel.add(basicXrange);
        popupPanel.add(inputPanel);
        popupPanel.add(plus);
        popupPanel.add(minus);
        popupPanel.add(numAlert);
        popupPanel.setVisible(true);
        popupPanel.repaint();
        mainPanel.repaint();
        mainPanel.setVisible(true);



        //inputPanel.add(domainRightIn);

        pieceWise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println("sdf "+pieceClick);
                if(pieceClick == 1){
                    //popPiece.show();
                    popPiece = popFact.getPopup(mainPanel,popupPanel,200,300);
                    popPiece.show();
                    pieceClick = 0;
                }else {

                    popPiece.hide();
                    pieceClick = 1;
                }
                mainPanel.pack();
                mainPanel.repaint();
                mainPanel.setVisible(true);



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

                switch (setColor.getSelectedIndex()){
                    case 0: color = Color.black;
                        break;
                    case 1: color = Color.cyan;
                        break;
                    case 2: color = Color.red;
                        break;
                    case 3: color = Color.yellow;
                        break;
                }


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
        mainPanel.repaint();
        mainPanel.setVisible(true);


    }

    String getInputFunc(){
        return inputDialog.getText();
    }

    void setInputText(String input){
        inputDialog.setText(input);
    }
    void plotPiece(FunctionPanel functionPanel){
        Parser parser;
        for (int i = 0; i < 5;i++){
            if(pieces[i]== null){
                break;
            }
            //// TODO: 2019/3/1
            //pass interval of each function to backend, backend need to revise function necessary parameter
            parser=new Parser(pieces[i].getInputFunction());
            parser.parse();
            FunctionTree result = parser.getFunctionTree();
            ((FunctionPanel) functionPanel).setFunctionTree(result);
            ((FunctionPanel) functionPanel).functionSet=true;

        }
        functionPanel.repaint();
    }





}
