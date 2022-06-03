package com.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void testEquals() {
        MonHoc monHoc = new MonHoc("ctdl", 3, 1);
        MonHoc monHoc1 = new MonHoc("ctdl", 3, 1);
        assertTrue(monHoc.equals(monHoc1));
    }

    @Test
    void getTen() {
        MonHoc monHoc = new MonHoc("ctdl", 3, 1);
        assertEquals("ctdl", monHoc.getTen());
        assertNotEquals("cautrucdl", monHoc.getTen());//k trar veef
        monHoc = new MonHoc(null, 3, 1);
        assertNull(monHoc.getTen());//trar veef null
    }

    @Test
    void getTcLt() {
    }

    @Test
    void testWithCollection() {
        List<MonHoc> list = new ArrayList<>();
        MonHoc monHoc = new MonHoc("ctdl", 3, 1);
        MonHoc monHoc1 = new MonHoc("tdl", 2, 1);
        list.add(monHoc);
        list.add(monHoc1);
        MonHoc monHoc2 = new MonHoc("ctdl", 3, 1);
        assertEquals(0, list.indexOf(monHoc2));
        assertEquals(0, list.indexOf(monHoc));
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {

                return (o1.getTcLT()>o2.getTcLT())?1:((o1.getTcLT()<o2.getTcLT())?-1:0);
            }
        });
        Collections.sort(list,(o1, o2) -> {
            return (o1.getTcLT()>o2.getTcLT())?1:((o1.getTcLT()<o2.getTcLT())?-1:0);

        });
        System.out.println(list);
    }
    @Test
    void getSwwithSet() {
        Set<MonHoc> monHocSet = new HashSet<>();
        MonHoc monHoc = new MonHoc("ctdl", 3, 1);
        MonHoc monHoc1 = new MonHoc("cdl", 3, 1);
        monHocSet.add(monHoc);
        monHocSet.add(monHoc1);
        MonHoc monHoc2 = new MonHoc("ctdl", 3, 1);
        monHocSet.add(monHoc2);
        assertEquals(2,monHocSet.size());
    }


    List<MonHoc> creat(){
        List<MonHoc> list = new ArrayList<>();
        MonHoc monHoc = new MonHoc("ctdl", 3, 2);
        MonHoc monHoc1 = new MonHoc("tdl", 2, 1);
        list.add(monHoc);
        list.add(monHoc1);
  return list;
    }
    @Test
    void testLambda(){
        List<MonHoc> list = creat();
       List<MonHoc> monHocStream = list.stream().filter(mh -> {
            return mh.getTcLT()>=3?true:(mh.getTcLT()>1?true:false);
        }).filter(monHoc -> {
            return monHoc.getTcTH()>1?true:false;
        }).toList();
       //monHocStream.forEach(MonHoc::print);
        System.out.println(monHocStream);
    list.stream().map(monHoc -> {

            Diem diem = new Diem(monHoc, (int) (Math.random()*10));
         //   MonHoc monHoc1 = new MonHoc(monHoc.getTen(),monHoc.getTcLT()+1,monHoc.getTcTH());
            return diem;


    }).forEach(diem->{
        System.out.println(diem);
    });
    }
}