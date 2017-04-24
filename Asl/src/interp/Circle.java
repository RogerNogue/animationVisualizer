public class Circle{

    private double x;
    private double y;
    private double rad;

    private void setCircleValues(double px, double py, double r){
        x = px;
        y = py;
        rad = r;
    }

    public Circle(double px, double py, double r){
        setCircleValues(px, py, r);
    }

    public void setValues(double px, double py, double r){
        setCircleValues(px, py, r);
    }
}
