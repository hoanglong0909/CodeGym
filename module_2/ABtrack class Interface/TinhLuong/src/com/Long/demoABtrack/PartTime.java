package com.Long.demoABtrack;

public class PartTime extends NhanVien {
    private int giolamviec;
    public PartTime(String ten, int giolamviec){
        super(ten);
        this.giolamviec = giolamviec ;

    }

    public String loainhanvien(){
        return "Parttime";
    }

    @Override
    public void tinhLuong() {
        this.luong = Configs.luongparttime * giolamviec ;
    }
}
