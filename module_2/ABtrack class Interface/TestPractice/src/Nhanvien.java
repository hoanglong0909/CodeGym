public abstract class Nhanvien {
    protected String name;
    protected long luong;
    public Nhanvien(){

    }
    public Nhanvien(String name) {
        this.name = name;
    }
    protected abstract String loainhanvien();
    public abstract void tinhluong();
    public void xuatthogtin(){
        this.tinhluong();
        System.out.println("name: "
                + this.name
                +"Loại chức vụ"
                + loainhanvien()
                +"lương: "
                + luong);
    }

}
