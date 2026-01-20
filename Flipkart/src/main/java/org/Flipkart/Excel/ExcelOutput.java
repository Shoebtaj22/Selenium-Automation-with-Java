package org.Flipkart.Excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelOutput {
    public static void writeData(String basePath, List<String[]> linkData) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Results");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Item Name");
        header.createCell(1).setCellValue("Link");

        int rowNum = 1;
        for (String[] data : linkData) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data[0]);
            row.createCell(1).setCellValue(data[1]);
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filePath = "C:\\Users\\2457401\\IdeaProjects\\Flipkart\\src\\main\\java\\org\\Flipkart\\Excel\\excelfile.xlsx";


        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();
        System.out.println("Excel file created.");
        System.out.println("File save at : " + filePath);

    }
}
