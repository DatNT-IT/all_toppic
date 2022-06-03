package com.example;

import java.util.Objects;

public class MonHoc implements Comparable<MonHoc>{
    private String ten;
    private int tcLT;
    private int tcTH;

    public MonHoc( String ten, int tcLT, int tcTH) {
        this.ten = ten;
        this.tcLT = tcLT;
        this.tcTH = tcTH;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHoc monHoc = (MonHoc) o;
        return tcLT == monHoc.tcLT && tcTH == monHoc.tcTH && Objects.equals(ten, monHoc.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ten, tcLT, tcTH);
    }

    public String getTen() {
        return ten ;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTcLT() {
        return tcLT;
    }

    public void setTcLT(int tcLT) {
        this.tcLT = tcLT;
    }

    public int getTcTH() {
        return tcTH;
    }

    public void setTcTH(int tcTH) {
        this.tcTH = tcTH;
    }

    @Override
    public int compareTo(MonHoc o) {
      return (this.ten.compareTo(o.ten)>0)?-1:((this.ten.compareTo(o.ten)<0)?1:0);

    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ten='" + ten + '\'' +
                ", tcLT=" + tcLT +
                ", tcTH=" + tcTH +
                '}';
    }
    public String print(){
        return ten + tcTH;
    }
}

//Câu 2: In bảng điểm của sinh viên giống như mẫu trong mã nguồn ( trong lớp SinhVien)
//Câu 3: Xếp loại cho sinh viên, quy tắc xếp loại như trong mã nguồn ( trong lớp SinhVien)
//Câu 4: In bảng điểm cho lớp học như mẫu trong mã nguồn ( trong lớp LopHoc)
//Câu 5: Xây dựng phương thức trả về danh sách 10 sinh viên có điểm lớn nhất lớp (trong lớp LopHoc)
//Câu 6: Xây dựng phương thức trả về danh sách sinh viên xếp loại YEU (trong lớp LopHoc)
