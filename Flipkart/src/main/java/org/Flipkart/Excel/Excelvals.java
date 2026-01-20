package org.Flipkart.Excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excelvals {

static String filename="C:\\Users\\2457401\\IdeaProjects\\Flipkart\\src\\main\\java\\org\\Flipkart\\Excel\\TestData.xlsx";
static XSSFWorkbook workbook;
static XSSFSheet sheet;
public static String getData() throws IOException {
    FileInputStream file=new FileInputStream(filename);
    workbook= new XSSFWorkbook(file);
    sheet=workbook.getSheetAt(0);
    return sheet.getRow(1).getCell(0).toString();
}
}
