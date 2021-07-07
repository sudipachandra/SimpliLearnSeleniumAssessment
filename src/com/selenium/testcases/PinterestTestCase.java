package com.selenium.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.ProductPage;
import com.selenium.pages.SignInPage;
import com.selenium.pages.SignOutPage;
import com.selenium.utils.ExcelReader;

public class PinterestTestCase {
	private WebDriver driver;
	@BeforeMethod
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//searchBox = new SearchBox(driver);
		driver.get("http://automationpractice.com/index.php");
		// maximize my window
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getLogindetails")
	public void pinterestShare(Hashtable<String, String> data) throws InterruptedException {
		SignInPage signin = new SignInPage(driver);
		signin.signInLinkClick();
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(3000);
		loginpage.emailBtn.sendKeys(data.get("username"));
		loginpage.passWordBtn.sendKeys(data.get("passward"));
		loginpage.submitBtnclick();
		SignOutPage signOutPage = new SignOutPage(driver);
		signOutPage.goToHomePage();
		HomePage homePage = new HomePage(driver);
		homePage.Share();
		ProductPage productPage = new ProductPage(driver);
		String userName = data.get("username");
		String passWard = data.get("passward");
		productPage.pinterestShare(userName,passWard);
		String actualMsg = productPage.verifyMsg.getText();
    	String expectedMsg = "Printed Dress";
    	Assert.assertEquals(actualMsg, expectedMsg);
}
	@DataProvider
	public Object[][] getLogindetails() throws IOException {
		String ProjectPath = System.getProperty("user.dir");// this will return project current directory path
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath = ProjectPath + "/src/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "LoginDetails";
		return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
}
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	}
}
