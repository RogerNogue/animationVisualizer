package interp;

/**
 * Class to represent data in the interpreter.
 * Each data item has a type and a value. The type can be integer
 * or Boolean. Each operation asserts that the operands have the
 * appropriate types.
 * All the arithmetic and Boolean operations are calculated in-place,
 * i.e., the result is stored in the same data.
 * The type VOID is used to represent void values on function returns.
 */

import parser.*;
import java.util.ArrayList;


public class Data {
    /** Types of data */
    public enum Type {VOID, BOOLEAN, INTEGER, DOUBLE, QUAD, CIRCLE, ELYPSE, LINE, POLYGON, TEXT;}

    /** Type of data*/
    private Type type;

    /** Value of the data */
    private int value;

    private Quad quad;
    private Circle circle;
    private Elypse elypse;
    private Line line;
    private Polygon polygon;
    private Text text;

    /** Constructor for integers */
    Data(int v) { type = Type.INTEGER; value = v; }

    /** Constructor for Booleans */
    Data(boolean b) { type = Type.BOOLEAN; value = b ? 1 : 0; }

    /** Constructor for void data */
    Data() {type = Type.VOID; }

    /** Copy constructor */
    Data(Data d) { type = d.type; value = d.value; }



    Data(ArrayList<Double> vals, String s){
        if(s == "polygon") {type = Type.POLYGON; polygon = new Polygon(vals);}
        else if(s == "line") {type = Type.LINE; line = new Line(vals);}
    }
    Data(double x, double y, double a, double b, String s){
        if(s == "elypse") {type = Type.ELYPSE; elypse = new Elypse(x, y, a, b);}
        else if(s == "quad") {type = Type.QUAD; quad = new Quad(x, y, a, b);}
    }
    Data(double px, double py, double r){ type = Type.CIRCLE; circle = new Circle(px, py, r); }
    Data(String textstr, double px, double py) { type = Type.TEXT; text = new Text(textstr, px, py); }

    /** Returns the type of data */
    public Type getType() { return type; }

    public boolean isBoolean() { return type == Type.BOOLEAN; }
    public boolean isInteger() { return type == Type.INTEGER; }
    public boolean isVoid() { return type == Type.VOID; }
    public boolean isQuad() { return type == Type.QUAD; }
    public boolean isCircle() { return type == Type.CIRCLE; }
    public boolean isElypse() { return type == Type.ELYPSE; }
    public boolean isLine() { return type == Type.LINE; }
    public boolean isPolygon() { return type == Type.POLYGON; }
    public boolean isText() { return type == Type.TEXT; }

    public int getIntegerValue() {
        assert type == Type.INTEGER;
        return value;
    }

    public boolean getBooleanValue() {
        assert type == Type.BOOLEAN;
        return value == 1;
    }

    public Quad getQuad(){
        assert type == Type.QUAD;
        return quad;
    }

    /** Defines a Boolean value for the data */
    public void setValue(boolean b) { type = Type.BOOLEAN; value = b ? 1 : 0; }

    /** Defines an integer value for the data */
    public void setValue(int v) { type = Type.INTEGER; value = v; }

    /** Copies the value from another data */
    public void setData(Data d) { type = d.type; value = d.value; }

    /** Returns a string representing the data in textual form. */
    public String toString() {
        if (type == Type.BOOLEAN) return value == 1 ? "true" : "false";
        return Integer.toString(value);
    }

    /**
     * Checks for zero (for division). It raises an exception in case
     * the value is zero.
     */
    private void checkDivZero(Data d) {
        if (d.value == 0) throw new RuntimeException ("Division by zero");
    }

    /**
     * Evaluation of arithmetic expressions. The evaluation is done
     * "in place", returning the result on the same data.
     * @param op Type of operator (token).
     * @param d Second operand.
     */

    public void evaluateArithmetic (int op, Data d) {
        assert (type == Type.INTEGER || type == Type.DOUBLE) && d.type == Type.INTEGER;
        switch (op) {
            case AslLexer.PLUS: value += d.value; break;
            case AslLexer.MINUS: value -= d.value; break;
            case AslLexer.MUL: value *= d.value; break;
            case AslLexer.DIV: checkDivZero(d); value /= d.value; break;
            case AslLexer.MOD: checkDivZero(d); value %= d.value; break;
            default: assert false;
        }
    }

    /**
     * Evaluation of expressions with relational operators.
     * @param op Type of operator (token).
     * @param d Second operand.
     * @return A Boolean data with the value of the expression.
     */
    public Data evaluateRelational (int op, Data d) {
        assert (type == Type.INTEGER || type == Type.DOUBLE || type == Type.BOOLEAN)
                && type == d.type;
        switch (op) {
            case AslLexer.EQUAL: return new Data(value == d.value);
            case AslLexer.NOT_EQUAL: return new Data(value != d.value);
            case AslLexer.LT: return new Data(value < d.value);
            case AslLexer.LE: return new Data(value <= d.value);
            case AslLexer.GT: return new Data(value > d.value);
            case AslLexer.GE: return new Data(value >= d.value);
            default: assert false;
        }
        return null;
    }
}
