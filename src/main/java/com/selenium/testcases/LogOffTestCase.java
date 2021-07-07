package com.selenium.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.LoginPage;
import com.selenium.pages.SignInPage;
import com.selenium.pages.SignOutPage;
import com.selenium.utils.ExcelReader;

public class LogOffTestCase {
	public WebDriver driver = null;

	@BeforeMethod
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		// maximize my window
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getLogindetails")
	public void validUser(Hashtable<String, String> data) throws InterruptedException {
		SignInPage signin = new SignInPage(driver);
		signin.signInLinkClick();
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(3000);
		loginpage.emailBtn.sendKeys(data.get("username"));
		loginpage.passWordBtn.sendKeys(data.get("passward"));
		loginpage.submitBtnclick();
		SignOutPage homepage = new SignOutPage(driver);
		homepage.singOutClick();

	}

	@DataProvider
	public Object[][] getLogindetails() throws IOException {
		String ProjectPath = System.getProperty("user.dir");// this will return project current directory path
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath = ProjectPath + "/src/main/java/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "LoginDetails";
		return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
