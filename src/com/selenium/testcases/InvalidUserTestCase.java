package com.selenium.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.SignOutPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.SignInPage;
import com.selenium.utils.ExcelReader;

public class InvalidUserTestCase {
	public WebDriver driver=null;
	@BeforeClass
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		//maximize my window
		driver.manage().window().maximize();
	}
	@Test(dataProvider="getLogindetails")
	public void InValidUser(Hashtable<String,String>data) throws InterruptedException {
		SignInPage signin = new SignInPage(driver);
		signin.signInLinkClick();
		LoginPage loginpage =new LoginPage(driver);
		Thread.sleep(3000);
		loginpage.emailBtn.sendKeys(data.get("username"));
		loginpage.passWordBtn.sendKeys(data.get("passward"));
		loginpage.submitBtnclick();
		//HomePage homepage = new HomePage(driver);
		//homepage.singOutClick();
		Thread.sleep(3000);
		String expectedErrorMsg = "There is 1 error";
		String actualErrorMsg = loginpage.errorMsgField.getText();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("invalid credentials");
		
	}
	@DataProvider
	public Object[][] getLogindetails() throws IOException {
		String ProjectPath = System.getProperty("user.dir");//this will return project current directory path 
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath  = ProjectPath +"/src/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "InvalidData";
		return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	}
}
