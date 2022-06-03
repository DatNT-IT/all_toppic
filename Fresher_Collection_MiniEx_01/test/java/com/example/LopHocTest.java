package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {

    @Test
    void getTen() {
    }

    @Test
    void setTen() {
    }

    @Test
    void getGiaoVien() {
    }

    @Test
    void setGiaoVien() {
    }

    @Test
    void getDsLop() {
    }

    @Test
    void setDsLop() {
    }

    @Test
    void them() {
    }

    @Test
    void inDiem() {
    }

    @Test
    void top10() {
        Diem diem1 = new Diem(new MonHoc("CTDL", 3, 1), 8);
        Diem diem2 = new Diem(new MonHoc("OOP", 2, 1), 7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn", 2, 1), 8);
        Set<Diem> diemSet = new HashSet<>();
        diemSet.add(diem1);
        diemSet.add(diem2);
        diemSet.add(diem3);
        SinhVien sv = new SinhVien("ti01", "DatIt", diemSet);

        Diem diem4 = new Diem(new MonHoc("Sql", 3, 2), 9);
        Diem diem5 = new Diem(new MonHoc("Java", 3, 1), 4);
        Diem diem6 = new Diem(new MonHoc("C#", 1, 3), 7);
        Set<Diem> diemSet1 = new HashSet<>();
        diemSet.add(diem4);
        diemSet.add(diem5);
        diemSet.add(diem6);
        SinhVien sv1 = new SinhVien("it02", "Xep", diemSet1);

        List<SinhVien> sinhVienList = new ArrayList<>();
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        LopHoc lopHoc = new LopHoc("FIS", "XepTong", sinhVienList);

        List<SinhVien> sinhViens = lopHoc.top10();
        System.out.println(lopHoc.top10());
        assertEquals(10, sinhViens.size());


    }

    @Test
    void sinhVienYeu() {
        Diem diem1 = new Diem(new MonHoc("CTDL", 3, 1), 8);
        Diem diem2 = new Diem(new MonHoc("OOP", 2, 1), 7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn", 2, 1), 8);
        Set<Diem> diemSet = new HashSet<>();
        diemSet.add(diem1);
        diemSet.add(diem2);
        diemSet.add(diem3);
        SinhVien sv = new SinhVien("ti01", "DatIt", diemSet);

        Diem diem4 = new Diem(new MonHoc("Sql", 3, 2), 9);
        Diem diem5 = new Diem(new MonHoc("Java", 3, 1), 4);
        Diem diem6 = new Diem(new MonHoc("C#", 1, 3), 7);
        Set<Diem> diemSet1 = new HashSet<>();
        diemSet.add(diem4);
        diemSet.add(diem5);
        diemSet.add(diem6);
        SinhVien sv1 = new SinhVien("it02", "Xep", diemSet1);

        List<SinhVien> sinhVienList = new ArrayList<>();
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        sinhVienList.add(sv1);
        LopHoc lopHoc = new LopHoc("FIS", "XepTong", sinhVienList);

        List<SinhVien> sinhViens = lopHoc.sinhVienYeu();
        System.out.println(lopHoc.sinhVienYeu());
        assertEquals(1, sinhViens.size());
    }
}