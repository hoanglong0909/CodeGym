package com.Long.demoABtrack;

public class Test {
    public static void main(String[] args) {
        NhanVien sep = new fullTime("nam",23,Configs.SEP);
        sep.xuatrathongtin();
        NhanVien linh = new fullTime("long",23,Configs.LINH);
        linh.xuatrathongtin();
        NhanVien parttime = new PartTime("long",23);
        parttime.xuatrathongtin();
    }
}
