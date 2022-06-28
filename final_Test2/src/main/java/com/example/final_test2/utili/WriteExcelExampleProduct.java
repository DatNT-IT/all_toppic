package com.example.final_test2.utili;

import com.example.final_test2.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WriteExcelExampleProduct {
 public static final int COLUMN_INDEX_ID = 0;
    public static  final int COLUMN_INDEX_NAME = 1;
    public static final int COLUMN_INDEX_PRICE = 2;
    public static final int COLUMN_INDEX_AVAIABLE = 3;
    private static CellStyle cellStyleFormatNumber = null;

    public static void writeExcel(List<Product> products, String excelFilePath) throws IOException {

        Workbook workbook = getWorkbook(excelFilePath);


        Sheet sheet = workbook.createSheet("Product");
        int rowIndex = 0;


        writeHeader(sheet, rowIndex);


        rowIndex++;
        for (Product product : products) {

            Row row = sheet.createRow(rowIndex);

            writeBook(product, row);
            rowIndex++;
        }


        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);


        createOutputFile(workbook, excelFilePath);
        log.info("FILE");

    }


    public static List<Product> getBooks() {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fanal2", "root", "16042002");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id,name,price,avaiable from product ");
            while (rs.next()) {
                list.add(new Product(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getLong(4)));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }


    private static void writeHeader(Sheet sheet, int rowIndex) {

        CellStyle cellStyle = createStyleForHeader(sheet);


        Row row = sheet.createRow(rowIndex);


        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Id");

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("name product");

        cell = row.createCell(COLUMN_INDEX_PRICE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("price product");

        cell = row.createCell(COLUMN_INDEX_AVAIABLE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("con ton kho");


    }


    private static void writeBook(Product product, Row row) {
        if (cellStyleFormatNumber == null) {

            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");

            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(product.getId());

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellValue(product.getName());

        cell = row.createCell(COLUMN_INDEX_PRICE);
        cell.setCellValue(product.getPrice());

        cell = row.createCell(COLUMN_INDEX_AVAIABLE);
        cell.setCellValue(String.valueOf(product.getAvaiable()));


    }


    private static CellStyle createStyleForHeader(Sheet sheet) {

        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.WHITE.getIndex());


        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }


    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}
