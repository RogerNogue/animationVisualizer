package interp;

import parser.*;
import java.util.ArrayList;


public class Text extends Structure{

    private double x;
    private double y;
    private String tex;

    private void setTextValues(String text, double px, double py){
        tex = text;
        x = px;
        y = py;
    }

    public Text(String text, double px, double py){
        super();
        setTextValues(text, px, py);
    }

    public void setValues(String text, double px, double py){
        setTextValues(text, px, py);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String getText(){
        return tex;
    }
}
