
  SELECT giaovien.MaGiaovien, bomon.MABM, giaovien.NgaySinh
FROM giaovien
JOIN bomon ON giaovien.DiaChiGiaovien = giaovien.DiaChiGiaovien;
    