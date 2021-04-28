package Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileNP {
    public static void main(String[] args) {
        saveFlie();
    }
    static void readFile(){
        File file;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("student.dat");
            ois = new ObjectInputStream(fis);

            List<Student>  students = (List<Student>) ois.readObject();

            for (Student std : students){
                System.out.println(std);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(ois != null){
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void saveFlie(){
        List<Student> student = new ArrayList<Student>();
        student.add(new Student("A","Ha Noi"));
        student.add(new Student("B","Lao Cai"));
        student.add(new Student("C","Yen Bai"));
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File file;
        try {
            fos = new FileOutputStream("student.dat");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fos != null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
