package com.itheima.health;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

/**
 * @Discription :
 * @Author LTM
 */

public class test {

    @Test
    public void fun() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\hello.xlsx");
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        for (Row cells : sheetAt) {
            for (Cell cell : cells) {
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }
        workbook.close();
    }
    @Test
    public void fun1() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\hello.xlsx");
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        int lastRowNum = sheetAt.getLastRowNum();
        for(int i=0;i<=lastRowNum;i++){
            XSSFRow row = sheetAt.getRow(i);
            short lastCellNum = row.getLastCellNum();
            for (short j=0;j<lastCellNum;j++){
                String value = row.getCell(j).getStringCellValue();
                System.out.println(value);
            }
        }
        workbook.close();
    }
}
