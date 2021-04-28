package Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> student = new ArrayList<Student>();
        student.add(new Student("A","Ha Noi"));
        student.add(new Student("B","Lao Cai"));
        student.add(new Student("C","Yen Bai"));
        File file;
        FileOutputStream fos = null;
        try {
             fos = new FileOutputStream("long.txt");
                String line = Student.getHeader()+ "\n";
                byte[] b = line.getBytes();
                fos.write(b);
             for(Student std : student){
                  line = std.getFileLineFormat() + "\n";
                  b = line.getBytes();
                 fos.write(b);
             }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
