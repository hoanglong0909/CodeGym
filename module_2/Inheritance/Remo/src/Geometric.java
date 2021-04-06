public class Geometric {
    public static void main(String[] args) {

    }
    /* các trường dữ liệu */
    private String color = " white";
    private String filled = null ;

    public Geometric(String color, String filled) {
        this.color = color;
        this.filled = filled;
    }
    public Geometric(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFilled() {
        return filled;
    }

    public void setFilled(String filled) {
        this.filled = filled;
    }
    public String toString(){
        return "created with \"" + color + "\" color and " + (filled==null ? "no fill" : " filled with\"" + filled + "\"color");
    }
}
