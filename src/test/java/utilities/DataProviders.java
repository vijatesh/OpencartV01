package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";  // taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);     // creating an object for xlUtility
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcols=xlutil.getCellCount("sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];  // created for two dimensional array which can store data
		
		for(int i=1;i<=totalrows;i++)     //1   //Read the data from second row in excel to avoid header part and store in two dimensional array
		{
			for(int j=0;j<totalcols;j++)  //0   // i is row and j is column
			{
				logindata[i-1][j]= xlutil.getCellData("sheet1", i, j);   //1,0
			}
		}
		return logindata;  // returning two dimensional array
		
	}
	
	//DataProvider 2
	
	//DataProvider 3

	//DataProvider 4

	
	
	
	
	
	
	
	
	
}
