package com.customer.dal;

import com.customer.model.Customer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerDB {
    public static HashMap<String, Customer> customerMap = new HashMap<>();

    public CustomerDB(){

    }


    public void saveFile() throws IOException {
        File file = new File("Customer.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream("Customer.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
            bos.write(entry.getValue().toString().getBytes());
        }
        bos.flush();
        bos.close();
        fos.close();
    }


    public void readFile() throws IOException {
        File file = new File("Customer.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fis = new FileReader("Customer.csv");
        BufferedReader bis = new BufferedReader(fis);
        String line;
        while ((line = bis.readLine())!= null){
            String[] arr = line.split(",");
            Customer ct = new Customer(arr[0],arr[1],arr[2],arr[3],arr[4],Integer.parseInt(String.valueOf(arr[5])));
            add(ct);
        }

    }
    public void add(Customer customer){
        customer.setPhoneNumber(customer.phoneNumber);
        customerMap.put(customer.getPhoneNumber(), customer);
    }


}
