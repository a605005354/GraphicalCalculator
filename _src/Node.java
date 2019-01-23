public class Node {
    private boolean isLeaf;
    private boolean variable;       //if the value is variable x
    private double val;
    private Operator operator;
    private Node leftChild;
    private Node rightChild;

    public Node(double val) {
        this.variable=false;
        this.val = val;
        isLeaf = true;
        leftChild = null;
        rightChild = null;
    }

    //constructor for a variable leaf
    public Node(boolean variable){
        if(variable == true){
            this.variable=true;
            isLeaf = true;
            leftChild = null;
            rightChild = null;
        }
    }

    public Node(){
    }

    public Node createNode(double x){
        //create a leaf node
        return new Node(x);
    }

    public Node createNode(){
        //create a variable leaf
        return new Node(true);
    }

    public Node combineNode(Node n1, Node n2, Operator operator){
        Node node = new Node();
        node.setVariable(false);
        node.setLeaf(false);
        node.setOperator(operator);
        node.setLeftChild(n1);
        node.setRightChild(n2);
        return node;
    }

    public Node combineNode(Node n1, Operator operator) {
        Node node = new Node();
        node.setVariable(false);
        node.setLeaf(false);
        node.setOperator(operator);
        node.setLeftChild(n1);
        //Can be used for bug
        node.setRightChild(null);
        return node;
    }

    public boolean isVariable() {
        return variable;
    }

    public void setVariable(boolean variable) {
        this.variable = variable;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
