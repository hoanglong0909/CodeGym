package com.Long.HashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Long",12,"Huế");
        Student student2 = new Student("Khánh",12,"Huế");
        Student student3 = new Student("Huy",12,"Huế");
        HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);
        System.out.println(studentMap);
       for (Map.Entry<Integer , Student> student:
       studentMap.entrySet()){
           System.out.println(student.toString());
//           System.out.println(entry.getKey()+ "-" + entry.getValue());
       }


        System.out.println("**************************************");
        System.out.println("phần tử có key = 1 là: " + studentMap.get(1));
        System.out.println("**************************************");

       Set<Student> students = new HashSet<Student>();
       students.add(student1);
       students.add(student2);
       students.add(student3);
        System.out.println("Số phần tử của setA: " + students.size());
       for (Student student :
       students){
           System.out.println(student.toString());
       }
    }
}
