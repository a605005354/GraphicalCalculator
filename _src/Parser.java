public class Parser {
    private String input;
    private FunctionTree functionTree;
    Parser(String input){
        this.input=input;
    }

    //TODO
    void parse(){

        functionTree=new FunctionTree(null);
    }

    public FunctionTree getFunctionTree() {
        return functionTree;
    }
}