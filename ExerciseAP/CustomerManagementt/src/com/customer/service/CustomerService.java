package com.customer.service;

import com.customer.dal.CustomerDB;
import com.customer.model.Customer;

import java.io.IOException;
import java.util.Map;

public class CustomerService {
    public CustomerDB customerDB = new CustomerDB();

    public void add(Customer customer) throws IOException {
        if(this.customerDB.customerMap.containsKey(customer.getPhoneNumber()) && this.customerDB.customerMap.get(customer.getPhoneNumber()).getEmail().equals(customer.getEmail())){
            System.out.println("Khách hàng đã tồn tại hệ thống vừa Update thông tin: " + "\n" +"chọn Menu để tiếp tục thực hiện ");
        }else {
            customerDB.add(customer);
            customerDB.saveFile();
        }
    }
//    public void add(Customer ct){
//        if(CustomerDB.customerMap.containsKey(ct.getPhoneNumber()) && CustomerDB.customerMap.get(ct.getPhoneNumber()).getEmail().equals(ct.getEmail())){
//            System.out.println("Khach hang da ton tai, He thong vua update thong tin\n");
//        }
//        else{
//            CustomerDB.customerMap.put(ct.getPhoneNumber(),ct);
//            System.out.println("Ban vua them moi < "+ct.getName()+" > Thanh cong");
//        }
//    }


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

}
