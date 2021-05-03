package com.customer.service;

import com.customer.dal.CustomerDB;
import com.customer.model.Customer;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class CustomerService {
    public CustomerDB customerDB = new CustomerDB();

    public void add(Customer customer) throws IOException {
        if(CustomerDB.customerMap.containsKey(customer.getPhoneNumber()) && CustomerDB.customerMap.get(customer.getPhoneNumber()).getEmail().equals(customer.getEmail())){
            System.out.println("Khách hàng đã tồn tại hệ thống vừa Update thông tin: " + "\n" +"chọn Menu để tiếp tục thực hiện ");
        }else {
            customerDB.add(customer);
            customerDB.saveFile();
        }
    }



    public Customer find(String phone){
        return CustomerDB.customerMap.get(phone);
    }


    public void updateFile() throws IOException {
        customerDB.saveFile();
    }
    public void loadFile() throws IOException {
        customerDB.readFile();
    }
    public void print(){
        for(Map.Entry<String, Customer> entry : CustomerDB.customerMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }


    public void searchInfor(String phone) {
        if (CustomerDB.customerMap.containsKey(phone)) {
            System.out.println("Ket qua: ");
            System.out.println(CustomerDB.customerMap.get(phone).toStringCSV());
        } else {
            System.out.println("Không tồn tại khách hàng");
        }
    }

    public void getInfor(String phone) {
        if (CustomerDB.customerMap.containsKey(phone)) {
            System.out.println("Thông tin : ");
            System.out.println(CustomerDB.customerMap.get(phone).toString());
        } else {
            System.out.println("Không tồn tại khách hàng");
        }
    }

    public void addNumberOrder(String phone, int n) {
        if (CustomerDB.customerMap.containsKey(phone)) {
            CustomerDB.customerMap.get(phone).setOrder(CustomerDB.customerMap.get(phone).getOrder() + n);
            System.out.println("Thông tin khách hàng sau khi tăng " + n + " đơn hàng");
            System.out.println(CustomerDB.customerMap.get(phone).toString());
        } else {
            System.out.println("không tìm thấy");
        }
    }


    public void display() {
        int count = 0;
        if (CustomerDB.customerMap.isEmpty()) {
            System.out.println("Không có thông tin");
        } else {
            Iterator var2 = CustomerDB.customerMap.entrySet().iterator();

            while(var2.hasNext()) {
                Map.Entry<String, Customer> entry = (Map.Entry)var2.next();
                ++count;
                System.out.print(count + "." + ((Customer)entry.getValue()).toString());
            }
            System.out.println("Tong co " + CustomerDB.customerMap.size() + " Khách hàng trong hệ thống");
        }
    }

}
