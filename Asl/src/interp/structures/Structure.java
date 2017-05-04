package interp;

import parser.*;
import java.util.ArrayList;


public class Structure{
    public double stroke;
    public int red;
    public int green;
    public int blue;
    public ArrayList<Double> move_x;
    public ArrayList<Double> move_y;

    public Structure(){
        stroke = 1;
        red = 0;
        green = 0;
        blue = 255;
    }

    public void set_stroke(double s){
        stroke = s;
    }

    public void set_rgb(int r, int g, int b){
        red = r; green = g; blue = b;
    }

    public void add_movement(double x, double y){
        move_x.add(x);
        move_y.add(y);
    }

    public double get_stroke(){
        return stroke;
    }

    public int get_red(){
        return red;
    }

    public int get_green(){
        return green;
    }

    public int get_blue(){
        return blue;
    }

    public ArrayList<Double> get_move_x(){
        return move_x;
    }

    public ArrayList<Double> get_move_y(){
        return move_y;
    }

    public ArrayList<Double> getVals(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}

    public double getX(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public double getY(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public double getX1(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public double getY1(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public double getX2(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public double getY2(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}

    public String getText(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}

    public double getRadX(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public double getRadY(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public double getRad(){ throw new UnsupportedOperationException("Unsupported Operation Exception");}

    public void setValues(ArrayList<Double> values){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void setValues(double px, double py, double rx, double ry){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void setValues(double px, double py, double r){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void setValues(String text, double px, double py){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
}
