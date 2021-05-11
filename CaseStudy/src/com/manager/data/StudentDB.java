package com.manager.data;

import com.manager.model.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentDB{
    Student student = new Student();
    public HashMap<Integer, Student> map = new HashMap<>();

    public void saveFile() throws IOException {
        File file = new File("student.csv");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fis = new FileOutputStream("student.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fis);
        for (Map.Entry<Integer,Student> entry: map.entrySet()){
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        fis.close();
        bos.close();
    }

    public void readFile() throws IOException {
        File file = new File("student.csv");
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader reader = new FileReader("student.csv");
        BufferedReader brd = new BufferedReader(reader);
        String line;
        while ((line = brd.readLine()) != null){
            String[] arr = line.split(", ");
            Student st = new Student(arr[0],arr[1],arr[2]);
            add(st);
        }
        brd.close();
    }


    public void add(Student student){
        Student.setAutoId(student.getId());
        map.put(student.getId(),student);
    }

}
