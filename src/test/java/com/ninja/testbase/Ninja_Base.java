package com.ninja.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ninja.utilities.Ninja_Utils;

public class Ninja_Base {
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static Properties prop;
	public static Properties dataProp;
	public static FileInputStream ip;
	public static FileInputStream ipF;
	
	public Ninja_Base() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\ninja\\propertiesfiles\\configuration.properties");
		prop.load(ip);
		
		dataProp = new Properties();
		ipF = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\ninja\\propertiesfiles\\data.properties");
		dataProp.load(ipF);
	}
	public WebDriver initializeAndLaunchBrowser(String browserName) {
		if(browserName.equals(prop.getProperty("browser1"))) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			driver = new ChromeDriver(optionsC);
		}else if(browserName.equals(prop.getProperty("browser2"))) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			driver = new FirefoxDriver(optionsF);
		}else if (browserName.equals(prop.getProperty("browser3"))) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			driver = new EdgeDriver(optionsE);
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ninja_Utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Ninja_Utils.PAGELOAD_WAIT_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Ninja_Utils.SCRIPTLOAD_WAIT_TIME));
		driver.manage().deleteAllCookies();
		
		return driver;
		}
	}


