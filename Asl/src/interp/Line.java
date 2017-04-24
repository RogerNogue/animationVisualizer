import java.util.ArrayList;

public class Line{

    private ArrayList<double> vals;

    private void setLineValues(ArrayList<double> values){
        vals = values;
    }

    public Line(ArrayList<double> values){
        setLineValues(values);
    }

    public void setValues(ArrayList<double> values){
        setLineValues(values);
    }
}
