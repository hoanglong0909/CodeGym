public class TestMath {
    int id;
    String name;
    float phonghoc;

    public TestMath(int id, String name, float phonghoc) {
        this.id = id;
        this.name = name;
        this.phonghoc = phonghoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPhonghoc() {
        return phonghoc;
    }

    public void setPhonghoc(float phonghoc) {
        this.phonghoc = phonghoc;
    }

    double number1;
    double number2;

    public TestMath(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }
    public double sum(){
        return this.number1 + this.number2;

    }
    public double mutyl(){
        return this.number1 * this.number2;

    }
    public double tru(){
        return this.number1 - this.number2;

    }
    public double devide(){
        return this.number1 / this.number2;
    }


}
