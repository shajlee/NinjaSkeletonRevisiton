package com.ninja.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Ninja_ExtentReporter {
	public static ExtentReports generateExtentReport() throws Exception {
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorials Ninja Skeleton Revision Framewrok Results");
		sparkReporter.config().setDocumentTitle("Tutorials Ninja Skeleton Revision Automation Practice Test");
		sparkReporter.config().setTimeStampFormat("mm/dd/yyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter); 
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\ninja\\propertiesfiles\\configuration.properties");
		prop.load(ip);
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Project Browser", prop.getProperty("browser1"));
		extentReport.setSystemInfo("Valid Username", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("Valid Password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System Version", System.getProperty("os.version"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReport.setSystemInfo("QA Tester Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("QA Tester Country", System.getProperty("user.country"));
		
		return extentReport;
		
		

}
}
