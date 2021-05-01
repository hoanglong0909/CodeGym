import java.io.*;
import java.util.Map;
public class StudentDB {


    public void saveFile() throws IOException {
        File file = new File("Test.Student.csv");
        if(!file.exists()){
           file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream("Test.Student.csv");
        BufferedOutputStream bop = new BufferedOutputStream(fos);
        for (Map.Entry<Integer, Student> entry : StudentHasmap.studentlist.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
            bop.write(entry.getValue().toString().getBytes());
        }
        bop.flush();
        fos.close();
        bop.close();

    }
    public void readFile() throws IOException {
        File file;
        FileReader fis = new FileReader("Test.Student.csv");
        BufferedReader  bis = new BufferedReader(fis);
        String line;
        while ((line = bis.readLine()) != null){
            String[] arr = line.split(", ");
            Student st = new Student(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),arr[3]);
            StudentHasmap sv = new StudentHasmap();
            sv.add(st);
        }

    }

    public void CreateFile(){
        File file = new File("Test.Student.csv");
        if(file.exists()){
            System.out.println("file is exist ");
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("file not file");
    }



}
