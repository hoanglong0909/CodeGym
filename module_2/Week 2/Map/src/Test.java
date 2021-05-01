import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        StudentHasmap st1 = new StudentHasmap();
        StudentDB studentDB  = new StudentDB();
        try {
            studentDB.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentHasmap.print();
        Student binh = new Student("long",23,1,"male");
        Student Huy = new Student("huy",21,2,"male");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        st1.add(binh);
        st1.add(Huy);
//        st1.print();
//        System.out.println("+++++++++++++++++++++++++++++++++++++");
//        st1.remove(1);
//        st1.print();
        try {
            studentDB.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
