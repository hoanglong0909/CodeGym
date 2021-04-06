public class Poin3D extends Poin2D {
    private float z = 0.0f ;
//    public Poin3D(){}

    public Poin3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

//    public Poin3D(float z) {
//        this.z = z;
//    }
    public void setXYZ(float x,float y, float z){
        super.setX(x);
        super.setY(y);
        this.z = z ;
    }
    public float[] getXYZ(){
        return new float[] {this.x,this.y,this.z};
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }
}
