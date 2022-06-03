package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void testEquals() {
        Diem diem = new Diem(new MonHoc("ctdl", 3, 1),8);
        Diem diem1= new Diem(new MonHoc("ctdl", 3, 1),8);

        assertTrue(diem.equals(diem1));//assserttrue = , false !=

    }

    @Test
    void compareTo() {
        List<Diem> list = new ArrayList<>();
        Diem diem = new Diem(new MonHoc("java", 2, 3),8);
        Diem diem1 = new Diem(new MonHoc("c#", 3, 1),9);
        Diem diem2 = new Diem(new MonHoc("python", 1, 2),7);
        list.add(diem);
        list.add(diem1);
        list.add(diem2);
        Collections.sort(list);
        System.out.println(list);

    }


    @Test
    void testHashCode() {
    }

    @Test
    void testClone() {
//        Diem diem = new Diem(new MonHoc("SV",1,2),8);
//        assertEquals(diem,diem.clone());
    }

}