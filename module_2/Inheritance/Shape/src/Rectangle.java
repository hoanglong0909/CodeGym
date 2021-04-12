public class Rectangle extends Shape {
    private double length = 1.0 ;
    private double width = 1.0 ;
    public Rectangle(){
        super();
    }
    public Rectangle (double length, double width){
        this.length = length;
        this.width = width ;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public Rectangle(double width , double length , String color, boolean filled){
        super(color, filled);
        this.length = length ;
        this.width = width ;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}' + super.toString();
    }
}
