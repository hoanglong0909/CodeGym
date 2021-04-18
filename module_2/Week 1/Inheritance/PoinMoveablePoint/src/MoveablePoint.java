public class MoveablePoint extends Point {

    private float xSpeed = 0.0f ;
    private float ySpeed = 0.0f ;

    public MoveablePoint(float x , float y, float xSpeed, float ySpeed){
       super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed ;

    }
    public MoveablePoint(){

    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed = xSpeed ;
        this.ySpeed = ySpeed ;
    }
    public float[] getSpeed(float xSpeed, float ySpeed){
        return new float[] {this.xSpeed , this.ySpeed };

    }
    @Override
    public String toString() {
        return "["
                + super.getX()
                + ","
                + super.getY()
                + "]"
                +" = "
                + " [ "
                + this.getxSpeed()
                + ","
                +this.getySpeed()
                + "]";

    }
    public Point move() {
        super.setX(super.getX() + this.xSpeed);
        super.setY(super.getY() + this.ySpeed);
        return this;
    }



    }

