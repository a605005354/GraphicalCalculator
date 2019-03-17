import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FunctionInfo {
    private ArrayList<ArrayList<Interval>> intervals;
    private ArrayList<ArrayList<FunctionTree>> functionTrees;
    private ArrayList<Color> colors;
    public boolean [] isPieceWise;

    public FunctionInfo(ArrayList<ArrayList<Interval>> intervals, ArrayList<ArrayList<FunctionTree>> functionTrees, ArrayList<Color> colors) {
        this.intervals = intervals ;
        this.functionTrees = functionTrees;
        this.colors = colors;
        isPieceWise = new boolean[10];
    }

    public FunctionInfo() {
        this.intervals=new ArrayList<>();
        this.functionTrees=new ArrayList<>();
        this.colors=new ArrayList<>();
    }

    //add a piece to the last function
    public void addPiece(Interval interval, FunctionTree functionTree){
        int lastIdx=functionTrees.size()-1;
        functionTrees.get(lastIdx).add(functionTree);
        intervals.get(lastIdx).add(interval);
    }

    //add a piece to the functionIdx-th function
    public void addPiece(Interval interval, FunctionTree functionTree, int functionIdx){
        functionTrees.get(functionIdx).add(functionTree);
        intervals.get(functionIdx).add(interval);
    }

    //change the interval and/or functionTree of a piece
    public void editPiece(Interval interval, FunctionTree functionTree, int functionIdx, int pieceIdx){
        functionTrees.get(functionIdx).set(pieceIdx, functionTree);
        intervals.get(functionIdx).set(pieceIdx,interval);
    }

    public void addFunction(Color color, Interval interval, FunctionTree functionTree){
        ArrayList newFunction = new ArrayList<FunctionTree>();
        ArrayList newInterval = new ArrayList<Interval>();
        newFunction.add(functionTree);
        newInterval.add(interval);
        functionTrees.add(newFunction);
        intervals.add(newInterval);
        colors.add(color);
    }
    //The highest level data wrapper of a set of functions, should describe the set of functions in every details.
    //1st index is the number of function, 2nd index is the number of piece for a piecewise function.

    //getters and setters

    public ArrayList<ArrayList<FunctionTree>> getFunctionTrees() {
        return functionTrees;
    }

    public ArrayList<ArrayList<Interval>> getIntervals() {
        return intervals;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }
    public boolean[] getIsPieceWise(){
        return isPieceWise;
    }
}

