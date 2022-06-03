package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {

    @Test
    void themDiem() {


    }

    @Test
    void tinhDiemTrungBinh() {
        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),8);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn",2,1),8);
        Set<Diem> diemSet = new HashSet<>();
        diemSet.add(diem1);
        diemSet.add(diem2);
        diemSet.add(diem3);
        SinhVien sv = new SinhVien("ti01","DatIt",diemSet);

        assertEquals(7.0,sv.tinhDiemTrungBinh());
    }

    @Test
    void bangDiem() {

    }

    @Test
    void xepLoai() {
        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),8);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn",2,1),8);
        Set<Diem> diemSet = new HashSet<>();
        diemSet.add(diem1);
        diemSet.add(diem2);
        diemSet.add(diem3);
        SinhVien sv = new SinhVien("ti01","DatIt",diemSet);

        assertEquals("KHA",sv.xepLoai());

    }
}