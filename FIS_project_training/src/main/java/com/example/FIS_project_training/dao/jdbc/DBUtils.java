package com.example.FIS_project_training.dao.jdbc;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBUtils {

    public static void main(String[] args) {
        System.out.println(convertLocalDateTimeToDate(LocalDateTime.now()));
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return LocalDateTime.parse(simpleDateFormat.format(date).replace(" ", "T"));
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toLocalDate());
        return null;
    }
}
