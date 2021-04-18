package com.Long.demoABtrack;

public class fullTime extends NhanVien{
    private  int loaichucvu ;
    private int ngaylamthem ;
    public  fullTime(String ten , int ngaylamthem, int loaichucvu){
        super(ten);
        this.ngaylamthem = ngaylamthem ;
        this.loaichucvu = loaichucvu ;
    }

    @Override
    public String loainhanvien() {
        return this.loaichucvu == Configs.SEP ? "SEP":"LINH" ;
    }

    @Override
    public void tinhLuong() {
        if(loaichucvu == Configs.SEP){
            this.luong = Configs.luongnhanvienSEP + Configs.luonglamthemngay * this.ngaylamthem ;
        }
        if(loaichucvu == Configs.LINH){
            this.luong = Configs.luongnhanvienLINH + Configs.luonglamthemngay * this.ngaylamthem ;
        }
    }
}
