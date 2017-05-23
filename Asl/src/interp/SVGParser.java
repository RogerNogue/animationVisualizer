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
            for(int i = 0; i < objects.size(); ++i){
                Structure str = objects.get(i).getStructure();
                System.out.print(names.get(i) + "\n");
                if(objects.get(i).isQuad()){
                    file.write(     "<svg width=\"400\" height=\"180\">  "
                                +   "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                +   "\n</svg>\n");
                } else if(objects.get(i).isCircle()){
                    file.write(     "<svg width=\"400\" height=\"180\">  "
                                +   "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                +   "\n</svg>\n");
                } else if(objects.get(i).isElypse()){
                    file.write(     "<svg width=\"400\" height=\"180\">  "
                                +   "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                +   "\n</svg>\n");
                } else if(objects.get(i).isLine()){
                    file.write(     "<svg width=\"400\" height=\"180\">  "
                                +   "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                +   "\n</svg>\n");
                } else if(objects.get(i).isPolygon()){
                    file.write(     "<svg width=\"400\" height=\"180\">  "
                                +   "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                +   "\n</svg>\n");
                } else if(objects.get(i).isText()){
                    file.write(     "<svg width=\"400\" height=\"180\">  "
                                +   "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:blue;stroke:pink;stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:0.1;stroke-opacity:0.9\" />  "
                                +   "\n</svg>\n");
                }





            }

            file.write("\n" + "</body>\n" + "</html>\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
