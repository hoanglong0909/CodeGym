import java.io.*;
import java.util.ArrayList;


public class CreateFile  {
    public static void main(String[] args) {

        try {
            final String path = "students.txt";
            createFile(path);
            ArrayList<Student> list = new ArrayList<>();
            list.add(new Student("long","12"));
            list.add(new Student("khanh","21"));
            list.add(new Student("hao","4"));
            list.add(new Student("ga","22"));

            writeFile(path,list);
            System.out.println(readAll(path).toString());
            list.add(new Student("huy","13"));
            writeFile(path,list);
            System.out.println(readAll(path).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String path){
        File file = new File(path);
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

    public static void writeFile(String path, ArrayList<Student> student) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.close();
        fos.close();
    }

//    public static Student readFile(String path) throws IOException, ClassNotFoundException {
//        File file;
//        FileInputStream fis = new FileInputStream(path);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Student student = null;
//        if(fis.available() > 0){
//            student = (Student) ois.readObject();
//        }
//        return student;
//    }

    public static ArrayList<Student> readAll(String path) throws IOException, ClassNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        if(fis.available()>0){
            studentList = (ArrayList<Student>) ois.readObject();
        }
        ois.close();
        return studentList;
    }
}
