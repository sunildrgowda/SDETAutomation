package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class UtilityMethods extends Base{
	
	  public static void takeScreenshot() throws IOException {
	        File failedScreenShot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String currentDir = System.getProperty("user.dir");
	        FileUtils.copyFile(failedScreenShot, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	    }

	  public static Object[][] readExcelForCustomerData() throws IOException {
	        FileInputStream file = new FileInputStream(".\\src\\main\\java\\TestData\\TestData.xlsx");
	        XSSFWorkbook wb = new XSSFWorkbook(file);
	        XSSFSheet sheet = wb.getSheetAt(0);
	        int rowCount = sheet.getLastRowNum();
	        int column = sheet.getRow(0).getLastCellNum();
	        Object[][] data = new Object[rowCount][column];
	        for (int i = 1; i <= rowCount; i++) {
	            XSSFRow row = sheet.getRow(i);
	            for (int j = 0; j < column; j++) {
	                XSSFCell cell = row.getCell(j);
	                DataFormatter formatter = new DataFormatter();
	                String val = formatter.formatCellValue(cell);
	                data[i - 1][j] = val;
	            }
	        }
	        return data;
	    }
	  
	 public static String getBookingDateTime() {
		    LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);  
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss");  
	        String formatDateTime = now.format(format);  
	        return formatDateTime; 
		    
		   }
}
