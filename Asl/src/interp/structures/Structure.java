package interp;

import parser.*;

import java.util.ArrayList;


public class Structure{

    public double stroke;
    public RGB strokeColor;
    public RGB fillColor;
    public ArrayList<Double> move_x;
    public ArrayList<Double> move_y;
    

    public Structure(){
        stroke = 1;
        fillColor = new RGB(0, 0, 255);
        strokeColor = new RGB(0, 0, 50);
        move_x = new ArrayList<Double>();
        move_y = new ArrayList<Double>();
    }

    public void set_stroke(double s){
        stroke = s;
    }

    public void set_fill_RGB(int r, int g, int b){
        fillColor.set_RGB(r, g, b);
    }
    
    public void set_stroke_RGB(int r, int g, int b){
        strokeColor.set_RGB(r, g, b);
    }
    
    public void set_stroke_RGB(int r, int g, int b, double a){
        strokeColor.set_RGB(r, g, b, a);
    }
    
    public void set_opacity(double a){ 
        fillColor.set_alpha(a);
    }
    
    public void set_stroke_opacity(double a){ 
        strokeColor.set_alpha(a);
    }
    
    public RGB get_fill_RGB(){
        return fillColor;
    }
    
    public RGB get_stroke_RGB(){
        return strokeColor;
    }

    public void add_movement(double x, double y){
        move_x.add(x);
        move_y.add(y);
    }

    public double get_stroke(){
        return stroke;
    }

    public int get_fill_red(){
        return fillColor.get_red();
    }

    public int get_fill_green(){
        return fillColor.get_green();
    }

    public int get_fill_blue(){
        return fillColor.get_blue();
    }
    
    public double get_opacity(){
        return fillColor.get_alpha();
    }
    
    public int get_stroke_red(){
        return strokeColor.get_red();
    }

    public int get_stroke_green(){
        return strokeColor.get_green();
    }

    public int get_stroke_blue(){
        return strokeColor.get_blue();
    }
    
    public double get_stroke_opacity(){
        return strokeColor.get_alpha();
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
    public void setRad(double r){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    
    public void setTwoRadius(double rx, double ry){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    
    public void setWidth(double w){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void setHeight(double h){ throw new UnsupportedOperationException("Unsupported Operation Exception");}

    public void setValues(ArrayList<Double> values){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void setValues(double px, double py, double rx, double ry){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void setValues(double px, double py, double r){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void setValues(String text, double px, double py){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
    public void movePoint(int position, double x, double y){ throw new UnsupportedOperationException("Unsupported Operation Exception");}
}
