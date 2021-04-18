public class Shape {
    public Shape() {

    }

    public static void main(String[] args) {

    }
    private String color = " Blue ";
    private boolean filled = true ;

    public void shape(){

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String toString(){
        return ( getColor() + isFilled() );
    }

}
