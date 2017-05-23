package interp;

import parser.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.Set;
import java.util.LinkedList;
import java.util.ListIterator;


public final class SVGParser{

    private static ArrayList<Data> objects = new ArrayList<Data>();
    private static ArrayList<String> names = new ArrayList<String>();
    /*
    public SVGParser(){
        file= new FileWriter("Animation.html");
        objects = new ArrayList<Structure>();
        names = new ArrayList<String>();
    }
    */
    public static void store(Data str, String funcName){
        objects.add(str);
        names.add(funcName);
    }

    public static void translate(){
    
        
        try{
            FileWriter file = new FileWriter("Animation.html");
            file.write("Hola ");
            
            System.out.print("Hello");
            for(int i = 0; i < objects.size(); ++i){
                Structure str = objects.get(i).getStructure();
                System.out.print(names.get(i));
                if(objects.get(i).isQuad()){
                    
                    file.write(     "<svg width=\"400\" height=\"180\">  "
                                +   "<rect x=\"50\" y=\"20\" width=\"150\" height=\"150\"  "
                                +   "style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                +   "</svg>");
                    break;
                }
 
            }
            
            /*

            for (Data d : variables.values())
            {
                Structure s = d.getStructure();
                file.write(     "<svg width=\"400\" height=\"180\">  "
                            +   "<rect x=\"50\" y=\"20\" width=\"150\" height=\"150\"  "
                            +   "style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(s.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                            +   "</svg>");
                
                
                
                "<svg width="400" height="180">
                <rect x="50" y="20" width="150" height="150"
                style="fill:blue;stroke:pink;stroke-width:5;fill-opacity:0.1;stroke-opacity:0.9" />
                </svg>"
                
            }*/
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
