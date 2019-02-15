import java.util.ArrayList;

public class FunctionTree {
    public Node root;
    ArrayList<ArrayList<String>> nodes;     //for print use only

    public FunctionTree(Node node){
        root=node;
        nodes=new ArrayList<>();
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

    public void print(){

        fillOutTreePrint(nodes,0);
        for (ArrayList<String> e: nodes) {
            String stage = "";
            for (String s: e) {
                stage += s;
                stage += "\t";
            }
            System.out.println(stage);
        }
    }

    //for print use only
    private void fillOutTreePrint(ArrayList<ArrayList<String>> nodes, int lvl){
        if(nodes.size()< lvl){
            System.out.println("ERROR:Fault in FunctionTree.print()");
            return;
        }

        if(nodes.size()==lvl){
            ArrayList<String> arrayList= new ArrayList<>();
            nodes.add(arrayList);
        }

        if(root.isVariable()){
            nodes.get(lvl).add("x");
        }
        else if(root.isLeaf()){
            nodes.get(lvl).add(Double.toString(root.getVal()));
        }
        else{
            nodes.get(lvl).add(root.getOperator().toString());
        }

        if(root.getLeftChild()!=null){
            FunctionTree leftChild=new FunctionTree(root.getLeftChild());
            leftChild.fillOutTreePrint(nodes,lvl+1);
        }
        if(root.getRightChild()!=null){
            FunctionTree rightChild=new FunctionTree(root.getRightChild());
            rightChild.fillOutTreePrint(nodes, lvl+1);
        }
    }

    public Node getRoot() {
        return root;
    }
}
