package ObjectFIle;


import Student.Student;

import java.io.*;
import java.util.ArrayList;

public class ObjectFile {
    public static void main(String[] args) {
        try {
            final String path = "students.txt";
            createFile(path);
            ArrayList<Student> list = new ArrayList<>();
            list.add(new Student("long",12));
            list.add(new Student("khanh",23));
            list.add(new Student("hao",43));
            list.add(new Student("ga",23));
            writeFile(path,list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void createFile(String path){
        File file = new File("Student.txt");
        if (file.exists()) {
            System.out.println("file exists ");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file not fount");
        }
    }
    public static void writeFile(String path , ArrayList<Student>students) throws IOException {
        File file;
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.flush();
        fos.close();



    }
}
