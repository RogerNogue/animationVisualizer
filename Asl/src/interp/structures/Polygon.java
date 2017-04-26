package interp;

import parser.*;
import java.util.ArrayList;


public class Polygon{

    private ArrayList<Double> vals = new ArrayList<Double>();

    private void setPolygonValues(ArrayList<Double> values){
        vals = values;
    }

    public Polygon(ArrayList<Double> values){
        setPolygonValues(values);
    }

    public void setValues(ArrayList<Double> values){
        setPolygonValues(values);
    }

    public ArrayList<Double> getVals(){
        return vals;
    }
}
