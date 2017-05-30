package interp;

import parser.*;
import java.util.ArrayList;


public class Line extends Structure{

    private ArrayList<Double> vals = new ArrayList<Double>();

    private void setLineValues(ArrayList<Double> values){
        vals = values;
    }

    public Line(ArrayList<Double> values){
        super();
        setLineValues(values);
    }

    public void setValues(ArrayList<Double> values){
        setLineValues(values);
    }
    
    public void modifyPoint(int position, double x, double y){
        vals.set(position*2, x);
        vals.set(position*2+1, y);
    }

    public ArrayList<Double> getVals(){
        return vals;
    }
}
