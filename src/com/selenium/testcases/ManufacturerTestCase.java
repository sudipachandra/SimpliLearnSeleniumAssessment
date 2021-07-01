package com.selenium.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.ManufacturerPage;
import com.selenium.pages.SearchBox;
import com.selenium.pages.SignInPage;
import com.selenium.utils.ExcelReader;

import junit.framework.Assert;

public class ManufacturerTestCase {
	private WebDriver driver;
	private SearchBox searchBox;
	@BeforeClass
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		searchBox = new SearchBox(driver);
		driver.get("http://automationpractice.com/index.php");
		//maximize my window
		driver.manage().window().maximize();
	}
	@Test(dataProvider="getSearchdetails")
	public void Manufacturer(Hashtable<String, String> data1) throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		System.out.println("the search value is:"+data1.get("SearchName"));
		//Thread.sleep(4000);
		searchBox.search(data1.get("SearchName"));
		
		//signInPage.searchTextBox.clear();
		//signInPage.searchTextBox.sendKeys("dress");
		//signInPage.searchBtn.click();
		signInPage.searchClick();
		ManufacturerPage manufacturerPage = new ManufacturerPage(driver);
		manufacturerPage.selectManufacturer();
		Thread.sleep(3000);
		String searchResult = manufacturerPage.productListHeader.getText();
		System.out.println("the value of search result is :"+searchResult);
		//String selectManufacturer = manufacturerPage.selectManufacturer();
		String selectManufacturer = manufacturerPage.navigatorBtn.getText();
	    System.out.println("the value of select manufacturer is :"+selectManufacturer);
	    String manufacturer1 = selectManufacturer.toUpperCase();
        Assert.assertTrue(searchResult.contains(manufacturer1));
    	System.out.println("the assert true method is passed");
	}
	
	@DataProvider
	public Object[][] getSearchdetails() throws IOException {
		String ProjectPath = System.getProperty("user.dir");// this will return project current directory path
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath = ProjectPath + "/src/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "SearchData";
		return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
	}
}
