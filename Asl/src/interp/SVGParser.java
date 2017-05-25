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
            file.write("<!DOCTYPE html>" + "\n" + "<html>\n" + "<body>\n");
            file.write("<svg height=\"2000\" width=\"2000\">");
            for(int i = 0; i < objects.size(); ++i){
                Structure str = objects.get(i).getStructure();
                String red, green, blue;
                red = Integer.toString(str.get_fill_red());
                green = Integer.toString(str.get_fill_green());
                blue = Integer.toString(str.get_fill_blue());
                System.out.print(names.get(i) + "\n");
                if(objects.get(i).isQuad()){
                    file.write(     "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:rgb(" + red + ","+ green +","+ blue +");stroke:black;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                );
                } else if(objects.get(i).isCircle()){
                    file.write(     "\n       <circle cx=\"" + Double.toString(str.getX())  + "\" cy=\"" + Double.toString(str.getY())
                                +   "\" r=\"" + Double.toString(str.getRad()) + "\""
                                +   "\n        style=\"fill:blue;stroke:black;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                               );
                } else if(objects.get(i).isElypse()){
                    file.write(    "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:black;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                );
                } else if(objects.get(i).isLine()){
                    file.write(     "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:black;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                );
                } else if(objects.get(i).isPolygon()){
                    file.write(     "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:black;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                );
                } else if(objects.get(i).isText()){
                    file.write(     "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:black;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                );
                }





            }
            file.write("</svg>");
            file.write("\n" + "</body>\n" + "</html>\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
