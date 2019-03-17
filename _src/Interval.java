public class Interval {
    //Represents an interval, open or close, finite or infinite.
    private float left;
    private float right;
//    private boolean leftOpen;
//    private boolean rightOpen;
    private boolean leftInfi;
    private boolean rightInfi;

    public Interval(float left, float right, boolean leftInfi, boolean rightInfi) {
        this.left = left;
        this.right = right;
//        this.leftOpen = leftOpen;
//        this.rightOpen = rightOpen;
        this.leftInfi=leftInfi;
        this.rightInfi=rightInfi;
    }

    public boolean overlap(Interval i1, Interval i2){
        if (i1.isLeftInfi() && i1.isRightInfi()){
            return true;
        }
        if (i1.isLeftInfi() && !i1.isRightInfi()){
            if (i2.isLeftInfi()){
                return true;
            }
            else if (i2.getLeft() < i1.getRight()){
                return true;
            }
        }
        if (!i1.isLeftInfi() && i1.isRightInfi()){
            if(i2.isRightInfi()){
                return true;
            }
            else if (i2.getRight() > i1.getLeft()){
                return true;
            }
        }
        if (!i1.isLeftInfi() && !i1.isRightInfi()){
            if((i1.getLeft()<i2.getLeft() && i1.getRight()>i2.getLeft())
                    ||(i1.getLeft()<i2.getRight()&&i1.getRight()>i2.getRight())){
                return true;
            }
        }
        return false;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
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
