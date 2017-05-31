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
                String red, green, blue, redStroke, greenStroke, blueStroke, fillOpacity, strokeOpacity;
                red = Integer.toString(str.get_fill_red());
                green = Integer.toString(str.get_fill_green());
                blue = Integer.toString(str.get_fill_blue());
                redStroke = Integer.toString(str.get_stroke_red());
                greenStroke = Integer.toString(str.get_stroke_green());
                blueStroke = Integer.toString(str.get_stroke_blue());
                fillOpacity = Double.toString(str.get_opacity());
                strokeOpacity = Double.toString(str.get_stroke_opacity());
                System.out.print(names.get(i) + "\n");
                if(objects.get(i).isQuad()){
                    file.write(     "\n       <rect x=\"" + Double.toString(str.getX1())  + "\" y=\"" + Double.toString(str.getY1())
                                +   "\" width=\"" + Double.toString(str.getX2()) + "\" height=\"" + Double.toString(str.getY2())  + "\"  "
                                +   "\n        style=\"fill:rgb(" + red + ","+ green +","+ blue +");stroke:rgb(" + redStroke + ","+ greenStroke +","+ blueStroke +");stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:" + fillOpacity + ";stroke-opacity:" + strokeOpacity +  "\" />  "
                                );
                } else if(objects.get(i).isCircle()){
                    file.write(     "\n       <circle cx=\"" + Double.toString(str.getX())  + "\" cy=\"" + Double.toString(str.getY())
                                +   "\" r=\"" + Double.toString(str.getRad()) + "\""
                                +   "\n        style=\"fill:rgb(" + red + ","+ green +","+ blue +");;stroke:rgb(" + redStroke + ","+ greenStroke +","+ blueStroke +");stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:" + fillOpacity + ";stroke-opacity:" + strokeOpacity +  "\" />  "
                               );
                } else if(objects.get(i).isElypse()){
                    file.write(    "\n       <ellipse cx=\"" + Double.toString(str.getX())  + "\" cy=\"" + Double.toString(str.getY())
                                +   "\" rx=\"" + Double.toString(str.getRadX())  + "\" ry=\"" + Double.toString(str.getRadY()) + "\""
                                +   "\n        style=\"fill:rgb(" + red + ","+ green +","+ blue +");stroke:rgb(" + redStroke + ","+ greenStroke +","+ blueStroke +");stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity: " + fillOpacity + ";stroke-opacity: " + strokeOpacity +  "\" />  "
                                );
                } else if(objects.get(i).isPolygon()){
                    ArrayList<Double> a = str.getVals();
                    file.write(     "\n       <polygon points=\"");
                    for(int j = 0; j < a.size(); j+= 2){
                        file.write( Double.toString(a.get(j)) + ", " + Double.toString(a.get(j+1)) + " ");
                    }
                    file.write( "\" \n        style=\"fill:rgb(" + red + ","+ green +","+ blue +");stroke:rgb(" + redStroke + ","+ greenStroke +","+ blueStroke 
                                +");stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:" + fillOpacity + ";stroke-opacity:" + strokeOpacity +  "\" />  "
                                );
                } else if(objects.get(i).isLine()){
                    ArrayList<Double> a = str.getVals();
                    file.write(     "\n       <polyline points=\"");
                    for(int j = 0; j < a.size(); j+= 2){
                        file.write( Double.toString(a.get(j)) + ", " + Double.toString(a.get(j+1)) + " ");
                    }
                    file.write( "\" \n        style=\"fill:none;stroke:rgb(" + redStroke + ","+ greenStroke +","+ blueStroke 
                                +");stroke-width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:" + fillOpacity + ";stroke-opacity:" + strokeOpacity +  "\" />  "
                                );
                } else if(objects.get(i).isText()){
                //to do
                    file.write(     "\n       <text x=\"" + Double.toString(str.getX())  + "\" y=\"" + Double.toString(str.getY())
                                +   "\" \n    style=\"fill:rgb(" + red + ","+ green +","+ blue +");stroke:rgb(" + redStroke + ","+ greenStroke +","+ blueStroke +");stroke- width:" + Double.toString(str.get_stroke()) + "5;fill-opacity:" + fillOpacity + ";stroke-opacity:" + strokeOpacity +  "\"> " 
                                + str.getText() + " </text>  "
                                );
                }





            }
            file.write("\n</svg>");
            file.write("\n" + "</body>\n" + "</html>\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
