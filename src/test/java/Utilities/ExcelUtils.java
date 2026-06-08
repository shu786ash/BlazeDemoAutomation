package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class ExcelUtils {

    static XSSFWorkbook wb;
    static XSSFSheet sheet;

    public static String getCellData(String path, String sheetName, int row, int col) throws Exception {

        FileInputStream fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);

        sheet = wb.getSheet(sheetName);

        String value = sheet.getRow(row).getCell(col).toString();

        wb.close();
        return value;
    }
    public static int getRowCount(String path,
            String sheetName) throws Exception {

FileInputStream fis =
new FileInputStream(path);

Workbook wb =
new XSSFWorkbook(fis);

Sheet sheet =
wb.getSheet(sheetName);
System.out.println("Sheet Name = " + sheetName);
if(sheet == null) {
    System.out.println("Sheet not found : " + sheetName);
}
int rowCount =
sheet.getLastRowNum();

wb.close();

return rowCount;
}

    public static void setCellData(String path, String sheetName, int row, int col, String value) throws Exception {

        FileInputStream fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);

        sheet = wb.getSheet(sheetName);

        // 🔥 FIX 1: If sheet is null
        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        // 🔥 FIX 2: If row is null
        if (sheet.getRow(row) == null) {
            sheet.createRow(row);
        }

        // 🔥 FIX 3: If cell is null
        if (sheet.getRow(row).getCell(col) == null) {
            sheet.getRow(row).createCell(col);
        }

        sheet.getRow(row).getCell(col).setCellValue(value);

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        fos.close();
        wb.close();
    }
}