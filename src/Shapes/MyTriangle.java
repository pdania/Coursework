package Shapes;

public class MyTriangle implements Shape {
    //Sides of Triangle
    private LineSegment sideA = new LineSegment();
    private LineSegment sideB = new LineSegment();
    private LineSegment sideC = new LineSegment();

    //Angels of triangle
    private float angleA;
    private float angleB;
    private float angleC;

    //parameters
    private double perimeter;
    private double ares;
        //kolo
    private double radiusOpys;
    private double radiusVpys;


    //Heights
    private double heightA;
    private double heightB;
    private double heightC;

    //Bisectors
    private double bisectorA;
    private double bisectorB;
    private double bisectorC;

    //Medians
    private double MedianA;
    private double MedianB;
    private double MedianC;

    private Type triangleType;

    //Constructors
    public MyTriangle(LineSegment sideA, LineSegment sideB, float angleC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleC = angleC;
        sideC.setLength(cosinusTeorem(sideA,sideB,angleC));
        angleB = sinusTeorem(sideC,angleC,sideB);
        angleA = 180 - angleC - angleB;
        triangleType = whichType();

    }
    public MyTriangle(LineSegment sideA, float angleB, float angleC){
        this.sideA = sideA;
        this.angleB = angleB;
        this.angleC = angleC;
        angleA = 180 - angleC - angleB;
        sideB.setLength(sinusTeorem(sideA,angleA,angleB));
        sideC.setLength( sinusTeorem(sideA,angleA,angleC));
        triangleType = whichType();
    }
    public MyTriangle(LineSegment sideA, LineSegment sideB, LineSegment sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        angleA = alpha(sideA,sideB,sideC);
        angleB = sinusTeorem(sideC,angleC,sideB);
        angleC = 180 - angleA - angleB;
        triangleType = whichType();

    }
    public MyTriangle(Type triangleType){
        this.triangleType = triangleType;
    }
    public MyTriangle(){
    }

    // a^{2}=b^{2}+c^{2}-2bc* cos(angleA)
    private double cosinusTeorem(LineSegment b, LineSegment c, float alpha){
    return Math.sqrt(b.getLength()*b.getLength()+c.getLength()*c.getLength()-2*b.getLength()*c.getLength()*Math.cos(alpha));
    }
    //(a/sinA=b/sinB)
    private float sinusTeorem(LineSegment a, float alpha, LineSegment b){
        return (float) (a.getLength()/(Math.sin(alpha)*b.getLength()));
    }
    private double sinusTeorem(LineSegment a, float alpha, float beta){
        return  ((a.getLength()*Math.sin(beta))/Math.sin(alpha));
    }

    private float alpha(LineSegment a, LineSegment b, LineSegment c){
        return (float) Math.acos((b.getLength()*b.getLength()+c.getLength()*c.getLength()-a.getLength()*a.getLength())/(2*b.getLength()*c.getLength()));
    }

    @Override
    public double perimeter() {
        return sideA.getLength()+sideB.getLength()+sideC.getLength();
    }

    @Override
    public double area() {
        double p = perimeter()/2;
        return Math.sqrt(p*(p-sideA.getLength())*(p-sideB.getLength())*(p-sideC.getLength()));
    }

    public double piphagorosC(double a, double b){
        if(triangleType==Type.Pryamokutnyi){
            return Math.sqrt(a*a+b*b);
        }else {
            return 0;
        }
    }
    public double piphagorosA(double c, double b){
        if(triangleType==Type.Pryamokutnyi){
            return Math.sqrt(c*c+b*b);
        }else {
            return 0;
        }
    }

    private float convertToRadians(float angle){
        return (float) ((angle*Math.PI)/180.0);
    }
    //Radius
    public double radiusVpys(){
        return area()/(perimeter()/2);
    }
    public double radiusOpys(){
        return (sideA.getLength()*sideB.getLength()*sideC.getLength())/(4*area());
    }

    public LineSegment getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA.setLength( sideA);
    }

    public double getSideB() {
        if(sideB.getLength()!=0.0) {
            return sideB.getLength();
        }
        else {
            if(perimeter!=0.0&sideA.getLength()!=0.0&sideC.getLength()!=0.0){
                sideB.setLength( perimeter-sideC.getLength()-sideB.getLength());
                return sideB.getLength();
            }
            return 0.0;
        }
    }

    public void setSideB(double sideB) {
        this.sideB.setLength(sideB);
    }

    public double getSideC() {
        return sideC.getLength();
    }

    public void setSideC(double sideC) {
        this.sideC.setLength(sideC);
    }

    public float getAngleA() {
        return angleA;
    }

    public void setAngleA(float angleA) {
        this.angleA = angleA;
    }

    public float getAngleB() {
        return angleB;
    }

    public void setAngleB(float angleB) {
        this.angleB = angleB;
    }

    public float getAngleC() {
        return angleC;
    }

    public void setAngleC(float angleC) {
        this.angleC = angleC;
    }

    public Type getTriangleType() {
        return triangleType;
    }

    public void setTriangleType(Type triangleType) {
        this.triangleType = triangleType;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getAres() {
        return ares;
    }

    public void setAres(double ares) {
        this.ares = ares;
    }

    public double getRadiusOpys() {
        return radiusOpys;
    }

    public void setRadiusOpys(double radiusOpys) {
        this.radiusOpys = radiusOpys;
    }

    public double getRadiusVpys() {
        return radiusVpys;
    }

    public void setRadiusVpys(double radiusVpys) {
        this.radiusVpys = radiusVpys;
    }

    public double getHeightA() {
        return heightA;
    }

    public void setHeightA(double heightA) {
        this.heightA = heightA;
    }

    public double getHeightB() {
        return heightB;
    }

    public void setHeightB(double heightB) {
        this.heightB = heightB;
    }

    public double getHeightC() {
        return heightC;
    }

    public void setHeightC(double heightC) {
        this.heightC = heightC;
    }

    public double getBisectorA() {
        return bisectorA;
    }

    public void setBisectorA(double bisectorA) {
        this.bisectorA = bisectorA;
    }

    public double getBisectorB() {
        return bisectorB;
    }

    public void setBisectorB(double bisectorB) {
        this.bisectorB = bisectorB;
    }

    public double getBisectorC() {
        return bisectorC;
    }

    public void setBisectorC(double bisectorC) {
        this.bisectorC = bisectorC;
    }

    public double getMedianA() {
        return MedianA;
    }

    public void setMedianA(double medianA) {
        MedianA = medianA;
    }

    public double getMedianB() {
        return MedianB;
    }

    public void setMedianB(double medianB) {
        MedianB = medianB;
    }

    public double getMedianC() {
        return MedianC;
    }

    public void setMedianC(double medianC) {
        MedianC = medianC;
    }

    private Type whichType(){
        if(sideA==sideB&&sideB==sideC&&sideA==sideC)
            return Type.Rivnostoroniy;
        if(sideA==sideB||sideB==sideC||sideA==sideC)
            return Type.Rivnobedrenyi;
        if(angleC==90.0||angleA==90.0||angleB==90.0)
            return Type.Pryamokutnyi;
        return Type.Riznostoronni;
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", angleA=" + angleA +
                ", angleB=" + angleB +
                ", angleC=" + angleC +
                ", perimeter=" + perimeter +
                ", ares=" + ares +
                ", radiusOpys=" + radiusOpys +
                ", radiusVpys=" + radiusVpys +
                ", heightA=" + heightA +
                ", heightB=" + heightB +
                ", heightC=" + heightC +
                ", bisectorA=" + bisectorA +
                ", bisectorB=" + bisectorB +
                ", bisectorC=" + bisectorC +
                ", MedianA=" + MedianA +
                ", MedianB=" + MedianB +
                ", MedianC=" + MedianC +
                ", triangleType=" + triangleType +
                '}';
    }
}
enum Type{
    Riznostoronni,
    Rivnobedrenyi,
    Pryamokutnyi,
    Rivnostoroniy
}
