package Shapes;

public class Dot {
    private double x;
    private double y;
    private char name;


    public Dot(char name){
        this.name = name;
    }

    public Dot(char name,double x,double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}
