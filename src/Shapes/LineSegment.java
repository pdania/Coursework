package Shapes;

public class LineSegment {
    private Dot start;
    private Dot end;
    private double length;


    public LineSegment(double xStart, double yStart, double xEnd, double yEnd, char startName, char endName) {
        start = new Dot(startName, xStart, yStart);
        end = new Dot(endName, xEnd, yEnd);
    }

    public LineSegment(double xStart, double yStart, double xEnd, double yEnd, char startName, char endName, double length) {
        start = new Dot(startName, xStart, yStart);
        end = new Dot(endName, xEnd, yEnd);
        this.length = length;
    }

    public LineSegment(char startName, char endName, double length) {
        start = new Dot(startName);
        end = new Dot(endName);
        this.length = length;
    }
    public LineSegment(char startName, char endName) {
        start = new Dot(startName);
        end = new Dot(endName);
    }

    public LineSegment() { }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Dot getStart() {
        return start;
    }

    public void setStart(Dot start) {
        this.start = start;
    }


    public Dot getEnd() {
        return end;
    }

    public void setEnd(Dot end) {
        this.end = end;
    }
}
