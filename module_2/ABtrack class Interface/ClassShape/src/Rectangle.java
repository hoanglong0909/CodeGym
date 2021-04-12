public class Rectangle extends Shape {
    protected double width =1.0 ;
    protected double length = 1.0 ;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, Boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length ;
    }

    @Override
    public double getPerimeter() {
        return (length + width )*2 ;
    }

    @Override
    public String toString() {
        return "Area: "
                + getArea()
                +" Perimeter: "
                +getPerimeter()
                + "\n" +super.toString();

    }
}
