public class Parser {
    private String input;
    private FunctionTree functionTree;
    Parser(String input){
        this.input=input;
    }

    //TODO
    void parse(){
        Node cn1=new Node(true);
        Node cn2=new Node(1);
        Node cn3=new Node(2);
        Node cn4=Node.combineNode(cn1,cn2,Operator.plus);
        Node cn5=Node.combineNode(cn4,cn3,Operator.divide);
        functionTree=new FunctionTree(cn5);
    }

    public FunctionTree getFunctionTree() {
        return functionTree;
    }
}
