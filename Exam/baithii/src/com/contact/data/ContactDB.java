package com.contact.data;

import com.contact.model.Contact;

import java.io.*;
import java.util.ArrayList;

public class ContactDB {
    public static ArrayList<Contact> contactArrayList = new ArrayList<>();

    public  void saveFile() throws IOException {
        File file = new File("Contact.csv");
        FileOutputStream fos = new FileOutputStream("Contact.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for (int i = 0; i < contactArrayList.size(); i++) {
            bos.write(contactArrayList.get(i).toStringCSV().getBytes());
        }
        bos.flush();
    }

    public  void readFile() throws IOException {
        File file = new File("Contact.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader reader = new FileReader("Contact.csv");
        BufferedReader bfr = new BufferedReader(reader);
        String line;
        while ((line = bfr.readLine()) != null){
            String[] arr = line.split(", ");
            Contact contact = new Contact(arr[0],arr[1],arr[2],arr[3],arr[4]);
            add(contact);
        }
        bfr.close();
    }
    public static void add(Contact contact){
        contactArrayList.add(contact);
    }


}
