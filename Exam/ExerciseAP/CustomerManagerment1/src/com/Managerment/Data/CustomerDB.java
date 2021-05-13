package com.Managerment.Data;

import com.Managerment.model.Customer;

import java.io.*;

import java.util.HashMap;
import java.util.Map;

public class CustomerDB {
    public static HashMap<Integer , Customer> customerHashMap = new HashMap<>();

    public void saveFile() throws IOException {
        File file = new File("Customer.csv");
        if(!file.exists()){
                file.createNewFile();
        }
        FileOutputStream fis = new FileOutputStream("Customer.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fis);
        for(Map.Entry<Integer,Customer> entry : customerHashMap.entrySet()){
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        bos.close();
        fis.close();
    }
    public void readFile() throws IOException {
        File file = new File("Customer.csv");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileReader reader = new FileReader("Customer.csv");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine())!= null){
            String[] arr = line.split(",");
            Customer customer = new Customer(arr[0],Integer.parseInt(arr[1]),arr[2],arr[3],arr[4],Integer.parseInt(arr[5]));
            add(customer);
        }
    }

    public void add(Customer customer){
        if(customerHashMap.containsKey(customer.getPhone()) || customerHashMap.get(customer.getPhone()).getEmail().equals(customer.getEmail())){
            System.out.println("Khách hàng đã tồn tại hệ thống vừa Update thông tin: " + "\n" +"chọn Menu để tiếp tục thực hiện ");
        }else {
            customerHashMap.put(customer.getPhone(), customer);
        }
    }



    public boolean remove(int phone){
        boolean result = customerHashMap.remove(phone) == null ? false: true ;
        return  result ;

    }
}
