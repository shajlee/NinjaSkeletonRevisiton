package com.ninja.testData;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class Ninja_TestData_Supply {
	public static Properties dataProp;
	public static FileInputStream ipF;
	
	public Ninja_TestData_Supply() throws Exception {
		dataProp = new Properties();
		ipF = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\ninja\\propertiesfiles\\data.properties");
		dataProp.load(ipF);
		
	}
	
	@DataProvider(name = "TutorialsNinjaLoginTestData")
	public static Object[][]dataSupplyFrom2DimentionalArray(){
		Object [][] data = {{"shajlee@yahoo.com","Potter1@"},
		                    {"rifi_luver@hotmail.com", "Aniqa1@"},
		                    {"chowdhurygs@rediffmail.com", "Shajlee1@"},
		                    {"chowdhurygsa@gmail.com", "Shajlee123"},
		                    {"chowdhurygs@gmail.com","Shajlee1234"},
		                    {"nawshinaniqa@gmail.com","Kiyaan123"},
		                    {"gkcmono@yahoo.com","poultry13"},
		                    {"golamchodhury@gmail.com","Shajlee123!"}};
		                    
		return data;
		
	}
	
	
	}



