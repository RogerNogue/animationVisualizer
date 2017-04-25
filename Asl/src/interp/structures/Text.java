package interp;

import parser.*;
import java.util.ArrayList;


public class Text{

    private double x;
    private double y;
    private String tex;

    private void setTextValues(String text, double px, double py){
        tex = text;
        x = px;
        y = py;
    }

    public Text(String text, double px, double py){
        setTextValues(text, px, py);
    }

    public void setValues(String text, double px, double py){
        setTextValues(text, px, py);
    }
}
