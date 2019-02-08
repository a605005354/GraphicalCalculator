public class FunctionTreeUnitTest {
    public static void main(String[] args) {
        //Tests for single node
        Node sn1=new Node(5);
        FunctionTree sf1=new FunctionTree(sn1);
        System.out.println("sf1 = " + sf1.value(100));

        Node sn2=new Node(true);
        FunctionTree sf2=new FunctionTree(sn2);
        System.out.println("sf2 = " + sf2.value(100));

        System.out.println("-----------------------------------------------\n");

        //Tests for unary operators
        Node un1=new Node(30);
        Node un2=Node.combineNode(un1, Operator.sin);
        FunctionTree uf1=new FunctionTree(un2);
        System.out.println("uf1 = " + uf1.value(100));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.sin);
        FunctionTree uf2=new FunctionTree(un2);
        System.out.println("uf2 = " + uf2.value(90));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.sin);
        FunctionTree uf3=new FunctionTree(un2);
        System.out.println("uf3 = " + uf3.value(Math.PI/6));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.cos);
        FunctionTree uf4=new FunctionTree(un2);
        System.out.println("uf4 = " + uf4.value(Math.PI/3));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.tan);
        FunctionTree uf5=new FunctionTree(un2);
        System.out.println("uf5 = " + uf5.value(Math.PI/2));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.tan);
        FunctionTree uf6=new FunctionTree(un2);
        System.out.println("uf6 = " + uf6.value(Math.PI/2));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.ln);
        FunctionTree uf7=new FunctionTree(un2);
        System.out.println("uf7 = " + uf7.value(Math.E));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.lg);
        FunctionTree uf8=new FunctionTree(un2);
        System.out.println("uf8 = " + uf8.value(100));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.sqrt);
        FunctionTree uf9=new FunctionTree(un2);
        System.out.println("uf9 = " + uf9.value(81));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.arcsin);
        FunctionTree uf10=new FunctionTree(un2);
        System.out.println("uf10 = " + uf10.value(0.5));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.arccos);
        FunctionTree uf11=new FunctionTree(un2);
        System.out.println("uf11 = " + uf11.value(0.5));

        un1=new Node(true);
        un2=Node.combineNode(un1, Operator.arctan);
        FunctionTree uf12=new FunctionTree(un2);
        System.out.println("uf12 = " + uf12.value(1));

        System.out.println("-----------------------------------------------\n");

        //Tests for binary operators
        Node bn1=new Node(true);
        Node bn2=new Node(2);
        Node bn3;

        bn3=Node.combineNode(bn1, bn2, Operator.plus);
        FunctionTree bf1=new FunctionTree(bn3);
        System.out.println("bf1 = " + bf1.value(10));

        bn3=Node.combineNode(bn1, bn2, Operator.minus);
        FunctionTree bf2=new FunctionTree(bn3);
        System.out.println("bf2 = " + bf2.value(10));

        bn3=Node.combineNode(bn1, bn2, Operator.multiply);
        FunctionTree bf3=new FunctionTree(bn3);
        System.out.println("bf3 = " + bf3.value(10));

        bn3=Node.combineNode(bn1, bn2, Operator.divide);
        FunctionTree bf4=new FunctionTree(bn3);
        System.out.println("bf4 = " + bf4.value(10));

        bn3=Node.combineNode(bn1, bn2, Operator.log);
        FunctionTree bf5=new FunctionTree(bn3);
        System.out.println("bf5 = " + bf5.value(8));

        bn3=Node.combineNode(bn1, bn2, Operator.power);
        FunctionTree bf6=new FunctionTree(bn3);
        System.out.println("bf6 = " + bf6.value(10));

        bn3=Node.combineNode(bn2, bn1, Operator.power);
        FunctionTree bf7=new FunctionTree(bn3);
        System.out.println("bf7 = " + bf7.value(10));

        System.out.println("-----------------------------------------------\n");

        //Tests for complex expressions
        //cf1=(x+1)/2
        Node cn1=new Node(true);
        Node cn2=new Node(1);
        Node cn3=new Node(2);
        Node cn4=Node.combineNode(cn1,cn2,Operator.plus);
        Node cn5=Node.combineNode(cn4,cn3,Operator.divide);
        FunctionTree cf1=new FunctionTree(cn5);
        System.out.println("cf1 = " + cf1.value(11));
        //cf2=log_{3}(x^2)+1
        cn1=new Node(3);
        cn2=new Node(true);
        cn3=new Node(2);
        cn4=new Node(1);
        cn5=Node.combineNode(cn2, cn3, Operator.power);
        Node cn6=Node.combineNode(cn1, cn5, Operator.log);
        Node cn7=Node.combineNode(cn6, cn4, Operator.plus);
        FunctionTree cf2=new FunctionTree(cn5);
        System.out.println("cf2 = " + cf2.value(9));
        //cf3=sin(x)/cos(x)
        cn1=new Node(true);
        cn2=Node.combineNode(cn1, Operator.sin);
        cn3=Node.combineNode(cn1, Operator.cos);
        cn4=Node.combineNode(cn2,cn3,Operator.divide);
        FunctionTree cf3=new FunctionTree(cn4);
        System.out.println("cf3 = " + cf3.value(Math.PI/4));
    }
}
