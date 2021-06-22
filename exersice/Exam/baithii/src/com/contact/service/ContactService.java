package com.contact.service;

import com.contact.data.ContactDB;
import com.contact.model.Contact;

import java.io.IOException;

public class ContactService {
    ContactDB contactDB = new ContactDB();

    public void updateFile() throws IOException {
        contactDB.saveFile();
    }
    public void loadFile() throws IOException {
        contactDB.readFile();
    }
    public  void addFile(Contact contact){
        for (int i = 0; i <ContactDB.contactArrayList.size() ; i++) {
            if (ContactDB.contactArrayList.get(i).getPhone().equals(contact.getPhone()) || ContactDB.contactArrayList.get(i).getEmail().equals(contact.getEmail()));
            System.out.println("Hệ thống đã tồn tại ! ");
        }
        ContactDB.add(contact);
        System.out.println("đã thêm thành công khách hàng vào danh sách !");
    }
    public void printFile(){
        int count = 0;
        for (int i = 0; i <ContactDB.contactArrayList.size() ; i++) {
            if(ContactDB.contactArrayList.isEmpty()){
                System.out.println("không có khách hàng! ");
            }else {
                ++count;
                System.out.println(count+ "." + ContactDB.contactArrayList.get(i).toString());
            }
        }
        System.out.println("có tổng cộng " + ContactDB.contactArrayList.size()+ "khách hàng trong danh sách");
    }
    public Contact findPhone(String phone){
        for (int i = 0; i <ContactDB.contactArrayList.size() ; i++) {
            if(ContactDB.contactArrayList.get(i).getPhone().equals(phone)){
                return ContactDB.contactArrayList.get(i);
            }
        }
        return null;
    }
    public void removeFile(String phone){
        if(findPhone(phone) != null){
            ContactDB.contactArrayList.remove(equals(phone));
        }
    }
}
