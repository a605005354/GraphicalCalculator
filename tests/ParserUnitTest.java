public class ParserUnitTest {
    public static void main(String[] args) {
        //Simple tests
        Parser ps1=new Parser("x+5.322");
        ps1.parse();
        System.out.println("ps1:");
        ps1.getFunctionTree().print();
        Parser ps2=new Parser("log 10");
        ps2.parse();
        System.out.println("ps2:");
        ps2.getFunctionTree().print();
        Parser ps3=new Parser("sin 10");
        ps3.parse();
        System.out.println("ps3:");
        ps3.getFunctionTree().print();

        System.out.println("--------------------------------------");

        //Complex tests
        /*Parser pc1=new Parser("sin(x)+6");
        pc1.parse();
        System.out.println("pc1:");
        pc1.getFunctionTree().print();
        Parser pc2=new Parser("log(sin(x))/0+66^x");
        pc2.parse();
        System.out.println("pc2:");
        pc2.getFunctionTree().print();
        Parser pc3=new Parser("(arctan(x)+x)^(2x)-1/x");
        pc3.parse();
        System.out.println("pc3:");
        pc3.getFunctionTree().print();

        System.out.println("--------------------------------------");

        //Faulty parenthesis tests
        Parser pfp1=new Parser("((x+2)*3");
        pfp1.parse();
        System.out.println("pfp1:");
        pfp1.getFunctionTree().print();
        Parser pfp2=new Parser("x+2)*3");
        pfp2.parse();
        System.out.println("pfp2:");
        pfp2.getFunctionTree().print();

        System.out.println("--------------------------------------");

        //Faulty input tests
        Parser pfi1=new Parser("2x3+1");
        pfi1.parse();
        System.out.println("pfi1:");
        pfi1.getFunctionTree().print();
        Parser pfi2=new Parser("10+5*");
        pfi2.parse();
        System.out.println("pfi2:");
        pfi2.getFunctionTree().print();
        Parser pfi3=new Parser("+3");
        pfi3.parse();
        System.out.println("pfi3:");
        pfi3.getFunctionTree().print();
        Parser pfi4=new Parser("+-*//*");
        pfi4.parse();
        System.out.println("pfi4:");
        pfi4.getFunctionTree().print();*/
    }
}
