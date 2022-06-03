package com.example;

import java.util.*;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public LopHoc(String ten, String giaoVien, List<SinhVien> dsLop) {
        this.ten = ten;
        this.giaoVien = giaoVien;
        this.dsLop = dsLop;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<SinhVien> getDsLop() {
        return dsLop;
    }

    public void setDsLop(List<SinhVien> dsLop) {
        this.dsLop = dsLop;
    }

    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }


    public StringBuilder inDiem() {
        StringBuilder str = new StringBuilder("");
        str.append("Danh Sach Diem Lop: " + ten + "\n");
        str.append("Giao Vien Chu Nhiem: " + giaoVien + "\n");
        str.append("STT      MSSV        Ten              Diem TB   XepLoai\n");
        int count = 1;
        for(SinhVien sv : dsLop) {
            str.append(count++ + " " + sv.getMssv() + " " +
                    sv.getTen() + " " + sv.tinhDiemTrungBinh() + " " + sv.xepLoai() +"\n");
        }
        return str;
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        List<SinhVien> list = dsLop;


        Collections.sort(list, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
              return  o1.tinhDiemTrungBinh()>o2.tinhDiemTrungBinh()?1:(o1.tinhDiemTrungBinh()<o2.tinhDiemTrungBinh()?-1:0);
            }
        });

        list = list.subList(list.size() - 10, list.size()).stream().toList();
        return list;
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        List<SinhVien> list =
                dsLop.stream().filter(sinhVien -> sinhVien.xepLoai().equals("YEU") ? true : false).toList();

        return list;
    }
}
