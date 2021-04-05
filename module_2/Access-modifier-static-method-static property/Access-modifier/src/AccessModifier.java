public class AccessModifier {
    public static void main(String[] args) {
    }
    private double radius = 1.0 ;
    private String color = "red" ;

    public AccessModifier(double radius) {
        this.radius = radius;
    }
    public AccessModifier(){

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius() {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return (radius*radius)*Math.PI ;
    }






}
