package interp;

import parser.*;
import java.util.ArrayList;


public class Line{

    private ArrayList<Double> vals = new ArrayList<Double>();

    private void setLineValues(ArrayList<Double> values){
        vals = values;
    }

    public Line(ArrayList<Double> values){
        setLineValues(values);
    }

    public void setValues(ArrayList<Double> values){
        setLineValues(values);
    }
}
