package interp;

import parser.*;

import java.util.ArrayList;


public class RGB{

    public int red;
    public int green;
    public int blue;
    
    public RGB(){
    
    }
    public RGB(int r, int g, int b){
        assert r >= 0;
        assert r < 255;
        
        assert g >= 0;
        assert g < 255;
        
        assert b >= 0;
        assert b < 255;
        red = r; green = g; blue = b;
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
    /** Setters */
    public void set_red(int c){
        assert c >= 0;
        assert c < 255;
        red = c;
    }

    public void set_green(int c){
        assert c >= 0;
        assert c < 255;
        green = c;
    }

    public void set_blue(int c){
        assert c >= 0;
        assert c < 255;
        blue = c;
    }
    public void set_RGB(int r, int g, int b){
        assert r >= 0;
        assert r < 255;
        
        assert g >= 0;
        assert g < 255;
        
        assert b >= 0;
        assert b < 255;
        red = r; green = g; blue = b;
    }

}
