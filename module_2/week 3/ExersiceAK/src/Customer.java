//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Customer {
    public String name;
    public String address;
    public String phone;
    public String email;
    public String gender;
    public int orderNum;

    public Customer(String name, String address, String phone, String email, String gender, int orderNum) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.orderNum = orderNum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString2() {
        return "Khach hang: " + this.name + ", Dia chi: <" + this.address + ">, Email<" + this.email + ">, Sdt: <" + this.phone + ">, Gioi tinh: <" + this.gender + ">\n";
    }

    public String toString() {
        return "Khach hang: " + this.name + ", Dia chi: <" + this.address + ">, Email<" + this.email + ">, Sdt: <" + this.phone + ">, Gioi tinh: <" + this.gender + ">, So don da mua: <" + this.orderNum + ">\n";
    }
}
