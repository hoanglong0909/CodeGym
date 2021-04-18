package com.Long.demoABtrack;

public abstract class NhanVien {
    protected String ten ;
    protected long luong ;

    public NhanVien(){}
    public NhanVien(String ten){
        this.ten = ten;
    }
    protected abstract String loainhanvien();
    public void tinhLuong(){
    }
    public void xuatrathongtin(){
        this.tinhLuong();
        System.out.println("ten" + this.ten + " loại nhân vien" + this.loainhanvien()  + "lương" + this.luong);
    }

}
