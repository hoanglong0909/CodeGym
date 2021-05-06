package com.contact.data;

import com.contact.model.Contact;

import java.io.*;
import java.util.ArrayList;


public class ContactDB {
    public static ArrayList<Contact> contactList = new ArrayList<>();

    public void saveFile() throws IOException {
        File file = new File("Contact.scv");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fis = new FileOutputStream("Contact.scv");
        BufferedOutputStream bos = new BufferedOutputStream(fis);
        for (int i = 0; i <contactList.size() ; i++) {
            bos.write(contactList.get(i).toStringCSV().getBytes());
        }
        bos.flush();
        fis.close();
        bos.close();
    }


    public void readFile() throws IOException {
        File file = new File("Contact.scv");
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader reader = new FileReader("Contact.scv");
        BufferedReader brd = new BufferedReader(reader);
        String line ;
        while ((line = brd.readLine()) != null){
            String[] arr = line.split(",");
            Contact contact = new Contact(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
            add(contact);
        }
        brd.close();
    }



    public void add(Contact contact){
        contactList.add(contact);
    }
}
