public class NhanvienpartTime extends Nhanvien{
    private int giolamviec;

    public NhanvienpartTime(String name, int giolamviec) {
        super(name);
        this.giolamviec = giolamviec;
    }

    @Override
    protected String loainhanvien() {
        return this.loainhanvien();

    }

    @Override
    public void tinhluong() {
        luong = Configs.parttimeh *giolamviec ;

    }
}
