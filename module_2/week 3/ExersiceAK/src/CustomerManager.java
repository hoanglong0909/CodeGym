//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class CustomerManager {
    HashMap<String, Customer> hashMap = new HashMap();

    public CustomerManager() {
    }

    public void add(Customer ct) {
        if (this.hashMap.containsKey(ct.getPhone())) {
            System.out.println("Khach hang da ton tai, He thong vua update thong tin\n");
        } else {
            this.hashMap.put(ct.getPhone(), ct);
            System.out.println("Ban vua them moi < " + ct.getName() + " > Thanh cong");
        }
    }


    public void searchInfor(String phone) {
        System.out.println("He thong dang tim kiem... ");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        if (this.hashMap.containsKey(phone)) {
            System.out.println("Ket qua: ");
            System.out.println(((Customer)this.hashMap.get(phone)).toString2());
        } else {
            System.out.println("Khong ton tai khach hang");
        }

    }

    public void getInfor(String phone) {
        System.out.println("He thong dang tim kiem... ");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        if (this.hashMap.containsKey(phone)) {
            System.out.println("Thong tin : ");
            System.out.println(((Customer)this.hashMap.get(phone)).toString());
        } else {
            System.out.println("Khong ton tai khach hang");
        }

    }

    public void addNumberOrder(String phone, int n) {
        if (this.hashMap.containsKey(phone)) {
            ((Customer)this.hashMap.get(phone)).setOrderNum(((Customer)this.hashMap.get(phone)).getOrderNum() + n);
            System.out.println("thong tin cua khach hang sau khi tang " + n + " don hang");
            System.out.println(((Customer)this.hashMap.get(phone)).toString());
        } else {
            System.out.println("Khong tim thay ");
        }
    }

//    public void sort() {
//        List<Entry<String, Customer>> list = new ArrayList();
//        list.addAll(this.hashMap.entrySet());
//        Collections.sort(list, new 1(this));
//
//        for(int i = 0; i < list.size(); ++i) {
//            System.out.print(((Customer)((Entry)list.get(i)).getValue()).toString());
//        }
//
//    }

    public void display() {
        int count = 0;
        if (this.hashMap.isEmpty()) {
            System.out.println("khong co thong tin");
        } else {
            Iterator var2 = this.hashMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, Customer> entry = (Entry)var2.next();
                ++count;
                System.out.print(count + "." + ((Customer)entry.getValue()).toString());
            }

            System.out.println("Tong co " + this.hashMap.size() + " khach hang trong he thong");
        }

    }
}
