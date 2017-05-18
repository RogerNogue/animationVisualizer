

package interp;

import parser.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.Set;


public class SVGParser{
    public static void translate(Stack a){
        
        try{
            FileWriter file = new FileWriter("Animation.html");
            file.write("Hola ");
            
            HashMap<String,Data> variables = a.getStack();
            
            
            System.out.print("Hello");
            if(variables.containsKey("q"))
                System.out.print("DW");
            else System.out.print("No DW");
            

            for (Data d : variables.values())
            {
                Structure s = d.getStructure();
                file.write(     "<svg width=\"400\" height=\"180\">  "
                            +   "<rect x=\"50\" y=\"20\" width=\"150\" height=\"150\"  "
                            +   "style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(s.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                            +   "</svg>");
                
                
                /*
                "<svg width="400" height="180">
                <rect x="50" y="20" width="150" height="150"
                style="fill:blue;stroke:pink;stroke-width:5;fill-opacity:0.1;stroke-opacity:0.9" />
                </svg>"
                */
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
