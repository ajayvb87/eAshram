package com.project.dataproviders;



import org.testng.annotations.DataProvider;


import com.project.readexcel.ReadExcel;

public class LoginDataProviders {

	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(System.getProperty("user.dir")+"\\resources\\Data.xls","Sheet1"); 
	}

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelSheetData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(System.getProperty("user.dir")+"\\resources\\RegData.xls","Sheet2"); 
	}

	@DataProvider(name = "Login-inputs")
	public Object[][] LoginData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(System.getProperty("user.dir")+"\\resources\\LoginTestCredentials.xls","Sheet1"); 
	}

	@DataProvider(name = "inputs")
	public Object[][] Login_Product_Data(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(System.getProperty("user.dir")+"\\resources\\Beverages.xls","Sheet1"); 
	}

}
