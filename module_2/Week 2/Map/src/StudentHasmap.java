import java.util.HashMap;
import java.util.Map;

public class StudentHasmap {
        public static Map<Integer, Student> studentlist;
        public static int count;
        static {
            studentlist = new HashMap<>();
//            Test.Student s1 = new Test.Student("long",18,1,"male");
//            Test.Student s2 = new Test.Student("huy",22,2,"male");
//            Test.Student s3 = new Test.Student("quang",23,3,"male");
//            studentlist.put(1,s1);
//            studentlist.put(2,s2);
//            studentlist.put(3,s3);
            count =0  ;

        }

        public  void add(Student student){
            count ++;
            student.setMssv(count);
            studentlist.put(count,student);

        }
        public boolean remove(int id){
          return studentlist.remove(id) == null ? false : true ;
        }
        public static void print(){
            for (Map.Entry<Integer, Student> entry : studentlist.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue().toString());
            }
        }

}
