import java.util.*;

public class Parser {
    private String input;
    private FunctionTree functionTree;
    Parser(String input){
        this.input=input;
    }
    private List<String> seperator = new ArrayList<>();
    String extractNumber = "";
    String errMessage = "";

    //TODO

    String getErrMessage() {
        return errMessage;
    }
    boolean isOperator (String operator) {
        if (operator.equals("plus") || operator.equals("minus") || operator.equals("multiply") || operator.equals("divide")
                || operator.equals("sin") || operator.equals("cos") || operator.equals("tan") || operator.equals("log") ||
                operator.equals("power") || operator.equals("ln") || operator.equals("lg") || operator.equals("arccos")
                || operator.equals("arcsin") || operator.equals("arctan")) {
            return true;
        }
        return false;
    }
    boolean isOperands (String operand) {
        return operand.matches("-?\\d+(\\.\\d+)?");
    }

    boolean isVariable(String var) {
        if (var.equals("x")) {
            return true;
        }
        return false;
    }
    void printList(List<String> s) {
        for (int i = 0; i < s.size(); i++) {
            System.out.print(s.get(i) + " ");
        }
        System.out.println();
    }
    int extractNumber(String s, int index) {
        int i = index;
        String number = "";
        while ((Character.isDigit(input.charAt(i)) || input.charAt(i) == '.') && i < s.length()) {
            number += input.charAt(i);
            if(i < s.length()-1){
                i++;
            }else if(i == input.length()-1){
                i++;
                break;
            }
        }
        extractNumber= number;
        return i;
    }
    boolean isBioperator(Operator operator) {
        if (operator == Operator.plus || operator == Operator.minus
                || operator == Operator.multiply || operator == Operator.divide
                || operator == Operator.power)
        {
            return true;
        }
        return false;
    }

    boolean isParenthesis (String s) {
        if (Operator.leftpar.toString().equalsIgnoreCase(s) || Operator.rightpar.toString().equalsIgnoreCase(s)) {
            return true;
        }
        return false;
    }
    boolean checkPar(List<String> list) {
        int countleft = Collections.frequency(seperator, "leftpar");
        int countright = Collections.frequency(seperator, "rightpar");
        if (countleft == countright) {
            return true;
        }
        return false;
    }
    void parse(){
        int i = 0;
        int flag = 0;
        String number = "";
        while (i < input.length()) {
            if (Character.isDigit(input.charAt(i))) {
                i = extractNumber(input, i);
                seperator.add(extractNumber);
                continue;
            }else{
                switch (input.charAt(i)) {
                    case '+':
                        seperator.add("plus");
                        break;
                    case '-':
                        seperator.add("minus");
                        break;
                    case '*':
                        seperator.add("multiply");
                        break;
                    case '/':
                        seperator.add("divide");
                        break;
                    case '^':
                        seperator.add("power");
                        break;
                    case 'a':
                        if (input.indexOf("arcsin") == i) {
                            seperator.add("arcsin");
                        }else if (input.indexOf("arccos") == i) {
                            seperator.add("arccos");
                        }else if (input.indexOf("arctan") == i) {
                            seperator.add("arctan");
                        }
                        i = i + 4;
                        break;
                    case 'l':
                        if (input.indexOf("log") == i) {
                            seperator.add("log");
                            i = i + 2;
                        }else if (input.indexOf("ln") == i) {
                            seperator.add("ln");
                            i = i + 1;
                        }else if (input.indexOf("lg") == i) {
                            seperator.add("lg");
                            i = i + 1;
                        }
                        break;
                    case 's':
                        if (input.indexOf("sin") == i){
                            seperator.add("sin");
                            i = i + 2;
                        }else if (input.indexOf("sqrt") == i) {
                            seperator.add("sqrt");
                            i = i + 3;
                        }
                        break;
                    case 'c':
                        if(input.indexOf("cos") == i) {
                            seperator.add("cos");
                            i = i + 2;
                        }
                        break;
                    case 't':
                        if (input.indexOf("tan") == i) {
                            seperator.add("tan");
                            i = i + 2;
                        }
                        break;
                    case '(':
                        seperator.add("leftpar");
                        break;
                    case  ')':
                        seperator.add("rightpar");
                        break;
                    case 'x':
                        seperator.add("x");
                        break;
                }
            }
            i++;
        }
        printList(seperator);
        if (checkPar(seperator)) {
            ParseList(seperator);
        }else {
            errMessage = "Unbalanced Parenthesis";
            System.out.println("Unbalanced Parenthesis");

        }
        /*Node cn1=new Node(true);
        Node cn2=new Node(1);
        Node cn3=new Node(2);
        Node cn4=Node.combineNode(cn1,cn2,Operator.plus);
        Node cn5=Node.combineNode(cn4,cn3,Operator.divide);
        functionTree=new FunctionTree(cn5);*/
    }
    void ParseList(List<String> list) {
        Stack<Operator> operators = new Stack<>();
        Stack<Node> operands = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            //if it is an operator
            if (isOperator(list.get(i))) {
                Operator newOperator = Operator.valueOf(list.get(i));
                if (!operators.empty()) {
                    if (Operator.precedence(newOperator) <= Operator.precedence(operators.peek())) {
                        if (isBioperator(operators.peek()))
                        {
                            Node rightoperand = operands.pop();
                            Node leftoperand = operands.pop();
                            Node newCombine = Node.combineNode(leftoperand,rightoperand,operators.pop());
                            operands.push(newCombine);
                            operators.push(newOperator);
                        }
                        else
                        {
                            Node newCombine = Node.combineNode(operands.pop(),operators.pop());
                            operands.push(newCombine);
                            operators.push(newOperator);
                        }
                    }
                    else{
                        operators.push(newOperator);
                    }
                } else{
                    operators.push(newOperator);
                }
            }
            //if it is a paranthesis
            else if (isParenthesis(list.get(i))){
                Operator newPar = Operator.valueOf(list.get(i));
                if (newPar == Operator.leftpar){
                    //if newOperator is left parenthesis, insert to the stack
                    operators.push(newPar);
                }else{
                    //if right, while loop until find a left operand
                    if (operators.peek() != Operator.leftpar) {
                        while (operators.peek() != Operator.leftpar) {
                            if (isBioperator(operators.peek())){
                                Node rightoperand = operands.pop();
                                Node leftoperand = operands.pop();
                                Node newCombine = Node.combineNode(leftoperand,rightoperand,operators.pop());
                                operands.push(newCombine);
                            }else{
                                Node combine = Node.combineNode(operands.pop(),operators.pop());
                                operands.push(combine);
                            }
                        }
                    }
                    //pop out left parenthesis
                    if (operators.size() > 1) {
                        operators.pop();
                        if (isBioperator(operators.peek())){
                            Node rightoperand = operands.pop();
                            Node leftoperand = operands.pop();
                            Node newCombine = Node.combineNode(leftoperand,rightoperand,operators.pop());
                            operands.push(newCombine);
                        }else {
                            Node combine = Node.combineNode(operands.pop(),operators.pop());
                            operands.push(combine);
                        }
                    }else {
                        operators.pop();
                    }
                }
            }
            // if it is a number
            else if(isOperands(list.get(i))) {
                Node newOprands = new Node(Double.parseDouble(list.get(i)));
                operands.push(newOprands);
            }
            //if it is a variable
            else if (isVariable(list.get(i))) {
                Node newVar = new Node(true);
                operands.push(newVar);
            }
        }
        while (operators.size() > 0) {

            if (isBioperator(operators.peek())) {
                Node right = operands.pop();
                Node left = operands.pop();
                Node newCombine = Node.combineNode(left, right, operators.pop());
                operands.push(newCombine);
            }else {
                Node newCombine = Node.combineNode(operands.pop(),operators.pop());
                operands.push(newCombine);
            }
        }
        Node finalNode = operands.pop();
        functionTree = new FunctionTree(finalNode);
    }

    public FunctionTree getFunctionTree() {
        return functionTree;
    }
}
