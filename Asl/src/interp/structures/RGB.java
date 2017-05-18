package interp;

import parser.*;

import java.util.ArrayList;


public class RGB{

    public int red;
    public int green;
    public int blue;
    public double alpha;
    
    public RGB(){
        
    }
    public RGB(int r, int g, int b, double a){
        set_RGB(r,g,b,a);
    }
    
    public RGB(int r, int g, int b){
        set_RGB(r,g,b,1);
    }
    
    /** Getters */
    public int get_red(){
        return red;
    }

    public int get_green(){
        return green;
    }

    public int get_blue(){
        return blue;
    }
    
    public double get_alpha(){
        return alpha;
    }
    /** Setters */
    public void set_red(int c){
        assert c >= 0;
        assert c <= 255;
        red = c;
    }

    public void set_green(int c){
        assert c >= 0;
        assert c <= 255;
        green = c;
    }

    public void set_blue(int c){
        assert c >= 0;
        assert c <= 255;
        blue = c;
    }
    
    public void set_alpha(double c){
        assert c >= 0;
        assert c <= 1;
        alpha = c;
    }
    
    public void set_RGB(int r, int g, int b, double a){
        assert r >= 0;
        assert r <= 255;
        
        assert g >= 0;
        assert g <= 255;
        
        assert b >= 0;
        assert b <= 255;
        
        assert a >= 0;
        assert a <= 1;
        red = r; green = g; blue = b;alpha = a;
    }
    
    public void set_RGB(int r, int g, int b){
        set_RGB(r,g,b,alpha);
        
    }

}
