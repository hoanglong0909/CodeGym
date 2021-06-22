
-- câu 1 Đưa ra thông tin gồm mã số, họ tênvà tên khoa của tất cả các giảng viên
select  gv.Magv, gv.Hotengv,k.Tenkhoa 
from tblkhoa k
join tblgiangvien gv
on k.Makhoa = gv.Makhoa ;
-- cau 2:Đưa ra thông tin gồm mã số, họ tênvà tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’
select gv.MAgv, gv.Hotengv,k.Tenkhoa
from tblkhoa k 
join tblgiangvien gv
on k.Makhoa = gv.Makhoa
where k.Tenkhoa = 'dia ly va qltn';
-- cau 3 Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select count(sv.Masv) as so_sv
from tblsinhvien sv
where sv.Makhoa = 'bio';
-- cau 4 Đưa ra danh sách gồm mã số, họ tênvà tuổi của các sinh viên khoa ‘TOAN’
select sv.Masv , sv.hotensv, sv.namsinh 
from tblsinhvien sv
where sv.Makhoa = 'math';
-- cau 5 Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’
select count(gv.Magv) as soluonggiangvien
from tblgiangvien gv
join tblkhoa k
on gv.Makhoa = k.Makhoa
where k.Tenkhoa= 'CONG NGHE SINH HOC';
-- cau6 Cho biết thông tin về sinh viên không tham gia thực tập
select sv.Masv, sv.Hotensv, sv.Makhoa, sv.Namsinh, sv.Quequan 
from tblsinhvien sv
where not exists(
select hd.Masv
from tblhuongdan hd 
where hd.Masv = sv.Masv);
-- cau 7: Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
select k.Makhoa , k.Tenkhoa , count(k.Makhoa) as so_gv 
from tblgiangvien gv
join tblkhoa k 
on  gv.Makhoa = k.Makhoa 
-- liệt kê ma khoa vs ten khoa
group by k.Makhoa , k.Tenkhoa ;
-- cau 8 Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học
select k.Dienthoai,sv.hotensv
 from tblkhoa k
 join tblsinhvien sv
 on k.Makhoa = sv.Makhoa 
 where sv.Hotensv = 'le van son';
 -- phan 2;Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
 select dt.Madt, dt.Tendt 
 from tbldetai dt
 join tblhuongdan hd
on dt.Madt  = hd.Madt
where hd.Magv = 15 ;

-- cau 10 Cho biết tên đề tài không có sinh viên nào thực tập
select dt.Madt,dt.Tendt 
from tbldetai dt
where not exists(select hd.Madt 
from tblhuongdan hd
where hd.Madt = dt.Madt)
group by dt.Madt,dt.Tendt ;
-- cau 11: Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
select gv.Magv,gv.Hotengv,k.tenkhoa  
from tblgiangvien gv
join tblkhoa k 
on gv.Makhoa = k.Makhoa 
where gv.Magv in (select hd.Magv
from tblhuongdan hd 
group by hd.Magv
having count(hd.Masv)>3);
-- cau 12 Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
select  dt.Madt , dt.Tendt 
from tbldetai dt
where dt.Kinhphi = ( select max(dt.Kinhphi) from tbldetai dt);
-- cau 13 Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
select dt.Madt , dt.Tendt 
from tbldetai dt 
where dt.Madt in (select hd.Madt 
from tblhuongdan hd
group by hd.Madt
having count(hd.Madt)>2);
-- cau 14 Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
select sv.Hotensv,sv.Masv,hd.KetQua as điểm
 from tblsinhvien sv
 join tblhuongdan hd
 on sv.Masv = hd.Masv
 join tblkhoa k
 on sv.Makhoa = k.Makhoa
 where k.Tenkhoa = 'Dia ly va QLTN';
 -- cau 15 Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
 select k.Tenkhoa, count(k.Makhoa) as slsv
 from tblkhoa k
 join tblsinhvien sv
 on k.Makhoa = sv.Makhoa 
 group by k.Tenkhoa;
 -- cau 16 Cho biết thông tin về các sinh viên thực tập tại quê nhà
 select * from tblsinhvien sv 
join tblhuongdan hd
on sv.Masv = hd.Masv
join tbldetai dt
on dt.Madt = hd.Madt
where sv.Quequan = dt.Noithuctap;
-- cau 17 Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
select * from tblsinhvien sv
join tblhuongdan hd
on sv.Masv = hd.Masv
where hd.KetQua is null ;
-- câu 18 Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
select * from tblsinhvien sv
join tblhuongdan hd
on sv.Masv = hd.Masv
where hd.KetQua = 0 ;


 