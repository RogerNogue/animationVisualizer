package interp;

import parser.*;
import java.util.ArrayList;


public class Elypse extends Structure{

    private double x;
    private double y;
    private double radx;
    private double rady;

    private void setElypseValues(double px, double py, double rx, double ry){
        x = px;
        y = py;
        radx = rx;
        rady = ry;
    }

    public Elypse(double px, double py, double rx, double ry){
        super();
        setElypseValues(px, py, rx, ry);
    }

    public void setValues(double px, double py, double rx, double ry){
        setElypseValues(px, py, rx, ry);
    }
    
    public void setTwoRadius(double rx, double ry){
        radx = rx;
        rady = ry;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getRadX(){
        return radx;
    }

    public double getRadY(){
        return rady;
    }
}
