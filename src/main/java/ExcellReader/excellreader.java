package ExcellReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excellreader
{
	
	public static String Filepath=System.getProperty("user.dir")+"/src/main/java/ExcellSheet/CRM.xlsx";
	public static String filename="contacts";
	
	public static Object[][] getExceldata(String Filepath,String filename) throws IOException{
		
	
		File file=new File(Filepath);
		FileInputStream input=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet(filename);
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(row).getLastCellNum();
		
		Object [][]dataset=new Object[row][col];
		
		  for(int i=0;i<row;i++){
			  for(int j=0;j<col;j++){
				  dataset[i][j]=sheet.getRow(i+1).getCell(j).toString(); 
				  
			  }
		  }
		
		
		 
		return dataset;
	
			
		
	}
	
	}
	

	

