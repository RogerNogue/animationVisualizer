package interp;

import parser.*;
import java.util.ArrayList;


public class Quad{

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    private void setQuadValues(double px1, double py1, double px2, double py2){
        x1 = px1;
        y1 = py1;
        x2 = px2;
        y2 = py2;
    }

    public Quad(double px1, double py1, double px2, double py2){
        setQuadValues(px1, py1, px2, py2);
    }

    public void setValues(double px1, double py1, double px2, double py2){
        setQuadValues(px1, py1, px2, py2);
    }

    public double getX1(){
        return x1;
    }

    public double getY1(){
        return y1;
    }

    public double getX2(){
        return x2;
    }

    public double getY2(){
        return y2;
    }
}
