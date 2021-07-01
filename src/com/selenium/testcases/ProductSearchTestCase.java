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

import com.selenium.pages.SearchBox;
import com.selenium.pages.SignInPage;
import com.selenium.utils.ExcelReader;

public class ProductSearchTestCase {
	private WebDriver driver;
	private SearchBox searchBox;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		searchBox = new SearchBox(driver);
		driver.get("http://automationpractice.com/index.php");
		//maximize my window
		driver.manage().window().maximize();
	}
	@Test(dataProvider="getSearchdetails")
	public void searchProduct(Hashtable<String,String> data) throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		Thread.sleep(3000);
		searchBox.search(data.get("searchvalue"));
		String actualResult = signInPage.resultBox.getText();
		System.out.println("the expected result is: "+ actualResult);
		String expectResult = data.get("expectedno");
		System.out.println("the actual result is: "+ expectResult);
		Assert.assertEquals(actualResult, expectResult);
	}
	@DataProvider
	public Object[][] getSearchdetails() throws IOException {
		String ProjectPath = System.getProperty("user.dir");//this will return project current directory path 
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath  = ProjectPath +"/src/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "SearchValue";
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
