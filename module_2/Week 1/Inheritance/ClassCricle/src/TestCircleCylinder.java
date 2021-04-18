public class TestCircleCylinder {
    public static void main(String[] args) {
        Cricle cricle = new Cricle();

        cricle.setRadius(3.5);
        System.out.println(cricle.toString());
        Cylinder cylinder = new Cylinder();
        cylinder.setRadius(cricle.getRadius());
        cylinder.setHeight(4.5);
        System.out.println(cylinder.toString());
    }
}
