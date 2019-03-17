import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Driver {
    //Temperate class to work as an entry
    static int funcCount = 1;
    //ExpressionPanel oriInputPanel;
    static FunctionInfo functionInfo;
    static ExpressionPanel oriInputPanel;
    public static void main(String[] args) {
        final JFrame mainFrame =new JFrame();
        final ExpressionPanel multipleFunc[] = new ExpressionPanel[10];
        functionInfo = new FunctionInfo();
        oriInputPanel = new ExpressionPanel(mainFrame,funcCount);
        multipleFunc[1] = oriInputPanel;


        //ALL panel
        //Leftside = GroupInput + operatorPanel
        JPanel LeftSide =  new JPanel(new GridBagLayout());
        //contains all operators
        JPanel operatorPanel = new JPanel(new GridBagLayout());

        //one inputPanel = one textArea + three buttons (color, piecewise, clean)
        JPanel inputPanel=new JPanel(new GridBagLayout());

        //container for all inputPanels; include two buttons (+/-)
        JScrollPane GroupInput = new JScrollPane();
        final JPanel ContentPanel = new JPanel();
        ContentPanel.setLayout(new BoxLayout(ContentPanel,BoxLayout.Y_AXIS));
        GroupInput.setPreferredSize(new Dimension(350,350));
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        GroupInput.setBorder(border);
        GroupInput.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        GroupInput.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //rightmost
        JPanel outputPanel=new JPanel();
        final JPanel functionPanel = new FunctionPanel();
        JPanel layout = new JPanel();
        final JPanel multifuncPanel = new JPanel();

        //all button:
        JButton plotButton = new JButton("Plot");
        JButton addFunc = new JButton("+Add");
        addFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(funcCount == 5) {
                    return;
                }
                funcCount++;
                ContentPanel.remove(multifuncPanel);
                ExpressionPanel newFunc = new ExpressionPanel(mainFrame,funcCount);
                ContentPanel.add(newFunc);
                multipleFunc[funcCount-1] = newFunc;
                ContentPanel.add(multifuncPanel);
                System.out.println("new funcFrame Array updated");
                mainFrame.pack();
                mainFrame.repaint();

            }
        });
        JButton minusFunc = new JButton(("-Delete"));
        minusFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(funcCount >1) {
                    funcCount--;
                    ContentPanel.remove(multipleFunc[funcCount]);
                    multipleFunc[funcCount] = null;
                    System.out.println("new funcFrame Array updated");
                    mainFrame.pack();
                    mainFrame.repaint();
                }else{
                    //no action
                }
            }
        });
        multifuncPanel.add(addFunc);
        multifuncPanel.add(minusFunc);

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
        JButton logButton = new JButton("log");
        JButton lgButton = new JButton("lg");
        JButton lnButton = new JButton("ln");
        JButton arcsinButton = new JButton("arcsin");
        JButton arccosButton = new JButton("arccos");
        JButton arctanButton = new JButton("arctan");
        JButton sqrtButton = new JButton("sqrt");
        JButton powerButton = new JButton("^");


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
        c.gridx = 5;
        c.gridy = 1;
        operatorPanel.add(logButton, c);
        c.gridx = 1;
        c.gridy = 2;
        operatorPanel.add(lgButton, c);
        c.gridx = 2;
        c.gridy = 2;
        operatorPanel.add(lnButton, c);
        c.gridx = 3;
        c.gridy = 2;
        operatorPanel.add(arccosButton, c);
        c.gridx = 4;
        c.gridy = 2;
        operatorPanel.add(arcsinButton, c);
        c.gridx = 5;
        c.gridy = 2;
        operatorPanel.add(arctanButton, c);
        c.gridx = 1;
        c.gridy = 3;
        operatorPanel.add(sqrtButton, c);
        c.gridx = 2;
        c.gridy = 3;
        operatorPanel.add(powerButton, c);


        //Plot button Action:
        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // String input ;

                //multipleFunc[0].partFunctrees.add(0,parser.getFunctionTree());
                for(int i =0; i < multipleFunc.length;i++){
                    String input ;
                    if(multipleFunc[i] == null){
                        continue;
                    }

                    input = multipleFunc[i].inputDialog.getText();
                    Parser parser=new Parser(input);
                    parser.parse();
                    FunctionTree result = parser.getFunctionTree() ;
                    multipleFunc[i].partFunctrees.add(0,result);
                    functionInfo.getFunctionTrees().add(i,multipleFunc[i].partFunctrees);
                    functionInfo.getIntervals().add(i,multipleFunc[i].partIntervals);
                    functionInfo.getColors().add(i,multipleFunc[i].color);
                    functionInfo.getIsPieceWise()[i] = multipleFunc[i].isPiece;
                }
                ((FunctionPanel)functionPanel).repaint();

                }



        });

        //Operator Button Action:
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "+");
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc()  + "-");
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc()  + "*");
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc()  + "/");
            }
        });

        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc()  + "sin()");
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc()  + "cos()");
            }
        });

        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc()  + "tan()");
            }
        });

        piButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "π");
            }
        });

        eButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc()  + "e");
            }
        });

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "log");
            }
        });

        lgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "lg");
            }
        });

        lnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "ln");
            }
        });

        arcsinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "arcsin()");
            }
        });

        arccosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "arccos()");
            }
        });

        arctanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "arctan()");
            }
        });

        sqrtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "sqrt()");
            }
        });

        powerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oriInputPanel.setInputText(oriInputPanel.getInputFunc() + "^");
            }
        });

        //construct inputPanel
        /*inputPanel.add(oriInputPanel);
        inputPanel.add(addFunc);*/
        ContentPanel.add(oriInputPanel);
        ContentPanel.add(multifuncPanel);


        GroupInput.setViewportView(ContentPanel);

        //GridBag
        GridBagConstraints c2 = new GridBagConstraints();
        c2.insets = new Insets(10,10,10,10);
        c2.gridx = 0;
        c2.gridy =20;
        LeftSide.add(operatorPanel, c2);
       // LeftSide.add(oriInputPanel,c2);


        c2.gridx = 0;
        c2.gridy = 30;
        LeftSide.add(GroupInput, c2);



        //// TODO: 2019/2/11
        //adjust input area for xrange

        c2.gridx = 0;
        c2.gridy =60;
        outputPanel.add(functionPanel,c2);



        layout.add(LeftSide, BorderLayout.WEST);
        layout.add(plotButton);
        layout.add(outputPanel, BorderLayout.EAST);

        mainFrame.add(layout);
        mainFrame.pack();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setVisible(true);

    }
}

/*java.awt.Point[x=107,y=447]
        java.awt.Point[x=391,y=447]*/
