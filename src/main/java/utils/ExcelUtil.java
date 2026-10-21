package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

	private XSSFSheet sheet;

	public ExcelUtil(String filePath, String sheetName) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getMenusByRole(String role) {

		List<String> menus = new ArrayList<>();

		int rowCount = sheet.getLastRowNum();

//		System.out.println("Row Count = " + rowCount);
		
		for (int i = 1; i <= rowCount; i++) {

			String excelRole = sheet.getRow(i).getCell(0).getStringCellValue();

			String menu = sheet.getRow(i).getCell(1).getStringCellValue();

			if (excelRole.equalsIgnoreCase(role)) {
				menus.add(menu);
			}
//		    System.out.println("Reading Row " + i);

		}
		return menus;
	}

	public List<String> getColumnData(int columnIndex) {

		List<String> data = new ArrayList<>();

		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			data.add(sheet.getRow(i).getCell(columnIndex).getStringCellValue().trim());

		}
		return data;
	}
}