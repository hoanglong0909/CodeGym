public class Student {
    private String name;
    private int age ;
    private  int id ;
    private String gender;

    public Student(String name, int age, int id, String gender) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMssv() {
        return id;
    }

    public void setMssv(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Tên " + name + " tuổi " + age +" mssv " + id + " giới tính " +gender ;
    }
    public String tostringCsv(){
        return name +", "+ age +", "+ id +", " +gender + "\n";
    }
}
