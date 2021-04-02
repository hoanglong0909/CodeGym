public class Mymath {
    public static void main(String[] args) {
        TestMath math = new TestMath(1,"long",40.3f);
        TestMath math1 = new TestMath(5.3,6.7);

        System.out.println("tổng là"+ math1.sum());
        System.out.println("tổng là"+ math1.mutyl());
        System.out.println("tổng là"+ math1.tru());
        System.out.println("tổng là"+ math1.devide());

        System.out.println("tổng là"+ math.getId());
        System.out.println("tổng là"+ math.getName());
        System.out.println("tổng là"+ math.getPhonghoc());

    }

}
