package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String readStringData(int row, int col, String sheet) throws IOException {
		String filepath = Constant.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();

	}

	public static String readIntegerData(int row, int col, String sheet) throws IOException {
		String filepath = Constant.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
//		int val =   (int) c.getNumericCellValue();  convert double to int using typecasting
//		return String.valueOf(val);   convert int to string using valueOf() method
		// return val;
//Phone numbers are too large for int
//		👉 Example: 9876543210 ❌ (int max = 2,147,483,647)
//
//		So the value becomes incorrect or blank in UI, even though no exception occurs.
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(c); // ⭐ KEY LINE
	}

}
