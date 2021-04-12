public class Circle extends Shape {

    private  double radius = 1.0 ;
    public Circle(){
        super();

    }
    public Circle(double radius){
        this.radius = radius ;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Circle(double radius,String color,boolean filled){
        super(color, filled);
        this.radius=radius;
    }

    @Override
    public String toString() {
        return
                "Circle{" +
                "radius=" + radius +
                '}' + super.toString();
    }
}
