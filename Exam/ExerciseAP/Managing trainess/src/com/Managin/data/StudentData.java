package com.Managin.data;

import com.Managin.model.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentData {
    public static Map<Integer, Student> studentMap = new HashMap<>();

    public void saveFile() throws IOException {
        File file = new File("Student.csv");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fis = new FileOutputStream("Student.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fis);
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()){
            bos.write(entry.getValue().toString().getBytes());
        }
        bos.flush();
        fis.close();
        bos.close();
    }

    public void readFile() throws IOException {
        File file = new File("Student.csv");
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader reader = new FileReader("Student.csv");
        BufferedReader brd = new BufferedReader(reader);
        String line;
        while ((line = brd.readLine()) != null){
            String[] arr = line.split(", ");
            Student st = new Student(arr[0],arr[1],arr[2]);
            add(st);
        }

    }
    public void add(Student student){
        Student.setAutoId(student.getId());
        studentMap.put(student.getId(),student);
    }



    public boolean remove(int id){
        boolean result = studentMap.remove(id) == null ? false:true ;
        return  result ;
    }

}
