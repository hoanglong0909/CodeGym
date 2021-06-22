package com.MagingTrainess.data;

import com.MagingTrainess.model.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudenDB {
    public static HashMap<Integer, Student> studentHashMap = new HashMap<>();

    public void saveFile() throws IOException {
        File file = new File("Student.csv");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream("Student.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for(Map.Entry<Integer,Student> entry: studentHashMap.entrySet()){
            bos.write(entry.getValue().toString().getBytes());
        }
    }
    public void readFile() throws IOException {
        File file = new File("Student.csv");
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader fos = new FileReader("Student.csv");
        BufferedReader bis = new BufferedReader(fos);
        String line;
        while ((line = bis.readLine()) != null){
            String[] arr = line.split(",");
            Student st = new Student(arr[0],arr[1],arr[2]);
            add(st);
        }
    }
    public void add(Student student){
        Student.setCount(student.getId());
        studentHashMap.put(student.getId(), student) ;
    }
    public boolean remove(int id){
         boolean results = studentHashMap.remove(id) == null ? false : true;
        return results;
    }



}
