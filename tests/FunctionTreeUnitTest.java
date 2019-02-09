public class FunctionTreeUnitTest {
    public static void main(String[] args) {
        //Tests for single node
        Node sn1=new Node(5);
        FunctionTree sf1=new FunctionTree(sn1);
        System.out.println("sf1 = " + sf1.value(100));
        Node sn2=new Node(true);
        FunctionTree sf2=new FunctionTree(sn2);
        System.out.println("sf2 = " + sf2.value(100));

        //Tests for unary operators
        Node un1=new Node(30);
        Node un2=
    }
}
