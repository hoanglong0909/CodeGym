
public class Poin2D {
    float x = 0.0f ;
    float y = 0.0f ;

    public Poin2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Poin2D(){

    }

    public float getX() {

        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{this.x,this.y} ;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
