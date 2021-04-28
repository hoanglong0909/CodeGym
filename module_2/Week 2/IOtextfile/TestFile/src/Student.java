import java.io.Serializable;

public class Student implements Serializable {
    String name, age ;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}' + "\n";
    }

    public void setAge(String age) {
        this.age = age;
    }

}
