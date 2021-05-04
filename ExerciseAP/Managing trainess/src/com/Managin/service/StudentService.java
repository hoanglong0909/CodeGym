package com.Managin.service;

import com.Managin.data.StudentData;
import com.Managin.model.Student;

import java.io.IOException;
import java.util.Map;

public class StudentService {

   public static StudentData studentData = new StudentData();

    public void add(Student student) throws IOException {
        Student.setAutoId(student.getId());
        studentData.add(student);
    }


    public void loadFile() throws IOException {
        studentData.readFile();
    }

    public void updateFile(){
        try {
            studentData.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void find(int id){
        StudentData.studentMap.get(id);
    }
    public void remove(int id){
        studentData.remove(id);
    }

    public void print(Student student){
        for (Map.Entry<Integer,Student> entry : StudentData.studentMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
