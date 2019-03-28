public class Interval {
    //Represents an interval, open or close, finite or infinite.
    private double left;
    private double right;
//    private boolean leftOpen;
//    private boolean rightOpen;
    private boolean leftInfi;
    private boolean rightInfi;

    public Interval(double left, double right, boolean leftInfi, boolean rightInfi) {
        this.left = left;
        this.right = right;
        this.leftInfi=leftInfi;
        this.rightInfi=rightInfi;
    }

    public static boolean overlap(Interval i1, Interval i2){
//        if (i1.isLeftInfi() && i1.isRightInfi()){
//            return true;
//        }
//        if (i1.isLeftInfi() && !i1.isRightInfi()){
//            if (i2.isLeftInfi()){
//                return true;
//            }
//            else if (i2.getLeft() < i1.getRight()){
//                return true;
//            }
//        }
//        if (!i1.isLeftInfi() && i1.isRightInfi()){
//            if(i2.isRightInfi()){
//                return true;
//            }
//            else if (i2.getRight() > i1.getLeft()){
//                return true;
//            }
//        }
//        if (!i1.isLeftInfi() && !i1.isRightInfi()){
//            if((i1.getLeft()<i2.getLeft() && i1.getRight()>i2.getLeft())
//                    ||(i1.getLeft()<i2.getRight()&&i1.getRight()>i2.getRight())){
//                return true;
//            }
//        }
        return false;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }

//    public boolean isLeftOpen() {
//        return leftOpen;
//    }
//
//    public boolean isRightOpen() {
//        return rightOpen;
//    }

    public boolean isLeftInfi() {
        return leftInfi;
    }

    public boolean isRightInfi() {
        return rightInfi;
    }

    public void setLeft(float left) {
        this.left = left;
    }

//    public void setLeftOpen(boolean leftOpen) {
//        this.leftOpen = leftOpen;
//    }

    public void setRight(float right) {
        this.right = right;
    }

//    public void setRightOpen(boolean rightOpen) {
//        this.rightOpen = rightOpen;
//    }
}
