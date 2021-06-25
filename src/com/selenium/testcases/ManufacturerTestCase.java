package com.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.pages.ManufacturerPage;
import com.selenium.pages.SignInPage;

import junit.framework.Assert;

public class ManufacturerTestCase {
	public WebDriver driver=null;
	@BeforeClass
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		//maximize my window
		driver.manage().window().maximize();
	}
	@Test
	public void Manufacturer() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.searchTextBox.clear();
		signInPage.searchTextBox.sendKeys("dress");
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
}
