package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseClass.BaseClass;



public class TestDataImport extends BaseClass {
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static Cell cell;
	FileInputStream inFile;
	FileOutputStream outFile;
	String cellData = "";

	public void readExcel(String sheetName) {
		try {
			log.info("Entered readExcel method");
			inFile = new FileInputStream(excelPath);
			wb = new XSSFWorkbook(inFile);
			sh= wb.getSheet(sheetName);			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("readExcel Failed");
			//log.info(e);
		}
	}
	
	public String getValue(int i, int j) {
		try {
			log.info("Entered getValue method");
			cellData = sh.getRow(i).getCell(j).toString();
		}catch(Exception e){
			cellData = "";
			//log.info(e);
		}
		return cellData;
	}
	
	public void setValue(int row, int col, String value) {
		try {
			outFile =new FileOutputStream(new File(excelPath));
			cell = sh.getRow(row).getCell(col);
			cell.setCellValue(value);          
            wb.write(outFile);
            outFile.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed");
		}
	}
}
