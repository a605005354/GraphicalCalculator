public class Interval {
    //Represents an interval, open or close, finite or infinite.
    private float left;
    private float right;
    private boolean leftOpen;
    private boolean rightOpen;

    public Interval(float left, float right, boolean leftOpen, boolean rightOpen) {
        this.left = left;
        this.right = right;
        this.leftOpen = leftOpen;
        this.rightOpen = rightOpen;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public boolean isLeftOpen() {
        return leftOpen;
    }

    public boolean isRightOpen() {
        return rightOpen;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public void setLeftOpen(boolean leftOpen) {
        this.leftOpen = leftOpen;
    }

    public void setRight(float right) {
        this.right = right;
    }

    public void setRightOpen(boolean rightOpen) {
        this.rightOpen = rightOpen;
    }
}
