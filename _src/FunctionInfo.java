import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FunctionInfo {
    ArrayList<ArrayList<Interval>> intervals;
    ArrayList<ArrayList<FunctionTree>> functionTrees;
    ArrayList<Color> colors;

    public FunctionInfo(ArrayList<ArrayList<Interval>> intervals, ArrayList<ArrayList<FunctionTree>> functionTrees, ArrayList<Color> colors) {
        this.intervals = intervals;
        this.functionTrees = functionTrees;
        this.colors = colors;
    }

    public FunctionInfo() {
        this.intervals=new ArrayList<>();
        this.functionTrees=new ArrayList<>();
        this.colors=new ArrayList<>();
    }

    //The highest level data wrapper of a set of functions, should describe the set of functions in every details.
    //1st index is the number of function, 2nd index is the number of piece for a piecewise function.
}
