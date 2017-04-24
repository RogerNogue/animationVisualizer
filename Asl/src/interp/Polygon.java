import java.util.ArrayList;

public class Polygon{

    private ArrayList<double> vals;

    private void setPolygonValues(ArrayList<double> values){
        vals = values;
    }

    public Polygon(ArrayList<double> values){
        setPolygonValues(values);
    }

    public void setValues(ArrayList<double> values){
        setPolygonValues(values);
    }
}
