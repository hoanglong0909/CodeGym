package Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Long",18));
        students.add(new Student("duy",43));
        students.add(new Student("hwng",48));
        students.add(new Student("can",21));

        File file;
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("Test.txt",true);
            for(Student std : students){
                String line = std.toString();
                byte[] b = line.getBytes();
                fos.write(b);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
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
