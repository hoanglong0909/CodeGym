package com.Long.Arraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SoThuc {
    private ArrayList<Double> list; //khai báo aray list
    public void nhap(){
        list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (true){

            Double x = s.nextDouble(); //nhập từ bàn phím
            list.add(x);// thêm phần tử vào aray list

            s.nextLine();
            System.out.println("có nhâp thêm nữa không");
            if(s.nextLine().equals("N")){
                break;
            }
        }

    }
    public void xuat(){
        for(Double x : list){
            System.out.println("x");
        }
    }
}
