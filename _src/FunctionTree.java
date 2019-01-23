
public class FunctionTree {
    private Node root;

    public FunctionTree(Node node){
        root=node;
    }

    public double value(double x){

        //should never happen
        if(root==null){
            System.out.println("OOPS null tree");
            return 0;
        }

        //base case
        if(root.isLeaf()){
            if(root.isVariable()){
                return x;
            }
            else {
                return root.getVal();
            }
        }

        //recursive call
        FunctionTree leftChild = new FunctionTree(root.getLeftChild());
        FunctionTree rightChild = new FunctionTree(root.getRightChild());
        switch (root.getOperator()){
            case plus: {
                return leftChild.value(x) + rightChild.value(x);
            }
            case minus:{
                return leftChild.value(x) - rightChild.value(x);
            }
            case multiply:{
                return leftChild.value(x) * rightChild.value(x);
            }
            case divide:{
                return leftChild.value(x) / rightChild.value(x);
            }
            case power:{
                return Math.pow(leftChild.value(x), rightChild.value(x));
            }
            //Can be used as bug
            case log:{
                return Math.log(rightChild.value(x))/Math.log(leftChild.value(x));
            }
            case lg:{
                return Math.log10(leftChild.value(x));
            }
            case ln:{
                return Math.log(leftChild.value(x));
            }
            case sqrt:{
                return Math.sqrt(leftChild.value(x));
            }
            case sin:{
                return Math.sin(leftChild.value(x));
            }
            case cos:{
                return Math.cos(leftChild.value(x));
            }
            case tan:{
                return Math.tan(leftChild.value(x));
            }
            case arcsin:{
                return Math.asin(leftChild.value(x));
            }
            case arccos:{
                return Math.acos(leftChild.value(x));
            }
            case arctan:{
                return Math.atan(leftChild.value(x));
            }
        }

        return 100;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
