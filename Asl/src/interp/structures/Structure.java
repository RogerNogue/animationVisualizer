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

    public Structure(){}

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
}
