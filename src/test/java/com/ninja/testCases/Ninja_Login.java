package com.ninja.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninja.testData.Ninja_TestData_Supply;
import com.ninja.testbase.Ninja_Base;

public class Ninja_Login extends Ninja_Base {
	public Ninja_Login() throws Exception {
		super();
		
	}

	public static WebDriver driver;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeAndLaunchBrowser(prop.getProperty("browser1"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	@Test(dataProvider = "TutorialsNinjaLoginTestData", dataProviderClass = Ninja_TestData_Supply.class)
	public void loginWithValidCredentials(String username, String password) {
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		softassert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
				
		
	}

}
