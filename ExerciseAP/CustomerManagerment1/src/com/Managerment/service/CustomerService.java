package com.Managerment.service;

import com.Managerment.Data.CustomerDB;
import com.Managerment.model.Customer;

import java.io.IOException;
import java.util.Map;

public class CustomerService {
    public static CustomerDB customerDB = new CustomerDB();

    public void addFile(Customer customer) throws IOException {
        if(CustomerDB.customerHashMap.containsKey(customer.getPhone()) && CustomerDB.customerHashMap.get(customer.getPhone()).getEmail().equals(customer.getEmail())){
            System.out.println("Khách hàng đã tồn tại hệ thống vừa Update thông tin: " + "\n" +"chọn Menu để tiếp tục thực hiện ");
        }else {
            customerDB.add(customer);
            customerDB.saveFile();
        }
    }
    public Customer searchInfor(int phone){
        if(CustomerDB.customerHashMap.containsKey(phone)){
            System.out.println("Kết quả");
            System.out.println(CustomerDB.customerHashMap.get(phone).toString());
        }else {
            System.out.println("Không tồn tại khách hàng ! ");
        }
        return null;
    }
    public void moreOder(int phone , int n){
        if(CustomerDB.customerHashMap.containsKey(phone)){
            CustomerDB.customerHashMap.get(phone).setOder(CustomerDB.customerHashMap.get(phone).getOder() + n);
            System.out.println("Tổng số đơn hàng khi tăng " + n + " đơn hàng");
            System.out.println(CustomerDB.customerHashMap.get(phone).toString());
        }else {
            System.out.println("Không tìm thấy khách hàng ");
        }
    }


    public void updateFile(){
        try {
            customerDB.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadFile(){
        try {
            customerDB.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean removeFile(int phone){
        boolean result = customerDB.remove(phone);
        return result;
    }
    public void printFile(){
        if(CustomerDB.customerHashMap.isEmpty()){
            System.out.println("Không có khách hàng nào cả");
        }else {
            int count = 0;
            for (Map.Entry<Integer,Customer> entry: CustomerDB.customerHashMap.entrySet()){
                ++count ;
                System.out.println(count + "." + entry.getValue().toString());
            }
            System.out.println("có tông số " + CustomerDB.customerHashMap.size() + " Khách hang trong danh sách");
        }
    }

}
