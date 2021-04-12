public class Circle{
    private double radius;

    public Circle(double radius){
        this.radius = radius ;
    }

    public double getArea(){
        return radius*radius * 3.14 ;
    }
    public double getCircumference(){

        return 3.14 * 2 * radius;
    }

}
