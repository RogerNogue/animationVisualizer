package interp;

import parser.*;
import java.util.ArrayList;


public class Polygon extends Structure{

    private ArrayList<Double> vals = new ArrayList<Double>();

    private void setPolygonValues(ArrayList<Double> values){
        vals = values;
    }

    public Polygon(ArrayList<Double> values){
        super();
        setPolygonValues(values);
    }

    public void setValues(ArrayList<Double> values){
        setPolygonValues(values);
    }

    public ArrayList<Double> getVals(){
        return vals;
    }
}
