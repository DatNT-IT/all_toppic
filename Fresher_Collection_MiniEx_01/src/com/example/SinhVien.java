package com.example;

import java.util.*;

public class SinhVien {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public SinhVien(String mssv, String ten, Set<Diem> monDaHoc) {
        this.mssv = mssv;
        this.ten = ten;
        this.monDaHoc = monDaHoc;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<Diem> getMonDaHoc() {
        return monDaHoc;
    }

    public void setMonDaHoc(Set<Diem> monDaHoc) {
        this.monDaHoc = monDaHoc;
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }


    public double tinhDiemTrungBinh() {

        int soDiemTheoTin = 0;
        int soTin = 0;
        int diemTong = 0;
        for(Diem diem: monDaHoc){
            soDiemTheoTin = (diem.getMon().getTcLT() + diem.getMon().getTcTH()) * diem.getDiem() ;
            diemTong = diemTong + soDiemTheoTin;
            soTin += diem.getMon().getTcLT() + diem.getMon().getTcTH();
        }
        double diemTB = diemTong/soTin;
        //...
        return diemTB;

    }



    public String bangDiem() {
        StringBuilder info = new StringBuilder("");
        info.append("MSSV" + " : " + this.mssv + "\n");
        info.append("Ten" + " : " + this.ten + "\n");
        info.append("Danh Sach Diem" + "\n");
        int i = 1;
        int soTin ;
        for(Diem diem: monDaHoc){
            info.append(i + " ");
            soTin = diem.getMon().getTcLT() + diem.getMon().getTcTH();
            info.append(diem.getMon().getTen() + " " + diem.getDiem() + " " + soTin);
            info.append("\n");
            i++;
        }
        info.append("Diem trung binh" + "  " + tinhDiemTrungBinh());
        return info.toString();


    }



    public String xepLoai() {
       String xl = (tinhDiemTrungBinh()>=8?"GIOI":(tinhDiemTrungBinh()>=7?"KHA":(tinhDiemTrungBinh()>=6?"TB-KHA":(tinhDiemTrungBinh()>=5?"TB":"YEU"))));

        return xl;
    }
}
