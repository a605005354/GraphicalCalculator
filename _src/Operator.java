public enum Operator {
    plus, minus, multiply, divide, power, log, ln, lg, sqrt, sin, cos, tan, arcsin, arccos, arctan;

    public static int precedence(Operator o){
        if(o==plus || o==minus){
            return 1;
        }else if (o==multiply || o==divide) {
            return 2;
        }else if (o == sin || o== cos || o == tan || o==arcsin || o == arccos || o== arctan) {
            return 3;
        }else if (o == power || o == sqrt) {
            return 4;
        }
        return -1;
    }
}
