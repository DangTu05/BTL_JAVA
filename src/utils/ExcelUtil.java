package utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static void exportExcel(String[] columns, List<String[]> data, String filename) throws Exception {
		// Tạo workbook và sheet
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Dữ liệu");

		// Tạo dòng tiêu đề
		XSSFRow headerRow = sheet.createRow(0);
		for (int i = 0; i < columns.length; i++) {
			XSSFCell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		// Ghi dữ liệu từ `List<String[]>` vào Excel
		int rowNum = 1;
		for (String[] rowData : data) {
			XSSFRow row = sheet.createRow(rowNum++);
			for (int i = 0; i < rowData.length; i++) {
				row.createCell(i).setCellValue(rowData[i]);
			}
		}

		// Ghi vào file Excel
		try (FileOutputStream fileOut = new FileOutputStream("E:/" + filename+".xlsx")) {
			workbook.write(fileOut);
			workbook.close();
			MessageUtil.showInfo("Xuất file excel thành công!");
		} catch (Exception e) {
			throw new Exception("Đã xảy ra lỗi khi xuất file Excel!!!", e);
		}
	}

}
