public class Nhanvienfulltime extends Nhanvien{
    private int loaichucvu;
    private int ngaylamthem;

    public Nhanvienfulltime(String name, int loaichucvu, int ngaylamthem) {
        super(name);
        this.loaichucvu = loaichucvu;
        this.ngaylamthem = ngaylamthem;
    }

    @Override
    protected String loainhanvien() {
        return this.loaichucvu == Configs.SEP ? "SEP":"LINH" ;
    }

    @Override
    public void tinhluong() {
        if(this.loaichucvu == Configs.SEP){
            luong = Configs.fullLINH + ngaylamthem * Configs.luongday ;
        }
        if(this.loaichucvu == Configs.LINH){
            luong = Configs.fullLINH + ngaylamthem * Configs.luongday ;
        }

    }
}
