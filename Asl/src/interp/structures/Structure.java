package interp;

import parser.*;

import java.util.ArrayList;


public class Structure{

    public double stroke;
    public RGB strokeColor;
    public RGB fillColor;
    public ArrayList<Double> move_x;
    public ArrayList<Double> move_y;
    //animations
    public boolean animX, animY, animOpacity;
    public double startAnimX, endAnimX, durationAnimX, startAnimY, endAnimY, durationAnimY, startAnimOpacity, endAnimOpacity, durationAnimOpacity;
    //rotations
    public boolean rotation;
    public int firstAngle, secondAngle;
    public double firstX, secondX, firstY, secondY, timeRotation;
    
    public Structure(){
        stroke = 1;
        fillColor = new RGB(0, 0, 255);
        strokeColor = new RGB(0, 0, 50);
        move_x = new ArrayList<Double>();
        move_y = new ArrayList<Double>();
        animX = animY = animOpacity = rotation = false;
    }
    
    public void set_rotation(int angle1, int angle2, double startx, double starty, double endx, double endy, double time){
        rotation = true;
        firstAngle = angle1;
        secondAngle = angle2;
        firstX = startx;
        firstY = starty;
        secondX = endx;
        secondY = endy;
        timeRotation = time;
    }/*
    public ArrayList<int> get_rotation_angles(){
        assert (rotation);
        ArrayList<int> alist = new ArrayList<int>();
        alist.insert(firstAngle);alist.insert(secondAngle);
        return alist;
    }
    public ArrayList<Double> get_rotation_values(){
        assert (rotation);
        ArrayList<Double>() alist = new ArrayList<Double>();
        alist.insert(firstX);alist.insert(secondX);alist.insert(firstY);alist.insert(secondY);alist.insert(timeRotation);
        return alist
    }*/
    
    public void set_animation_x(double start, double end, double duration){
        animX = true;
        startAnimX = start;
        endAnimX = end;
        durationAnimX = duration;
    }
    
    public void set_animation_y(double start, double end, double duration){
        animY = true;
        startAnimY = start;
        endAnimY = end;
        durationAnimY = duration;
    }
    
    public void set_animation_opacity(double start, double end, double duration){
        animOpacity = true;
        startAnimOpacity = start;
        endAnimOpacity = end;
        durationAnimOpacity = duration;
    }
    public double get_start_anim_x(){
        assert (animX);
        return startAnimX;
    }
    public double get_end_anim_x(){
        assert (animX);
        return endAnimX;
    }
    public double get_anim_x_duration(){
        assert (animX);
        return durationAnimX;
    }
    public double get_start_anim_y(){
        assert (animY);
        return startAnimY;
    }
    public double get_end_anim_y(){
        assert (animY);
        return endAnimY;
    }
    public double get_anim_y_duration(){
        assert (animY);
        return durationAnimY;
    }
    public double get_start_anim_opacity(){
        assert (animOpacity);
        return startAnimOpacity;
    }
    public double get_end_anim_opacity(){
        assert (animOpacity);
        return endAnimOpacity;
    }
    public double get_anim_opacity_duration(){
        assert (animOpacity);
        return durationAnimOpacity;
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
