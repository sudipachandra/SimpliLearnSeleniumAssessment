package com.selenium.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.SignOutPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.ProductPage;
import com.selenium.pages.SearchBox;
import com.selenium.pages.SignInPage;
import com.selenium.utils.ExcelReader;

public class WriteReviewTestCase {
	private WebDriver driver;
	private SearchBox searchBox;

	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		searchBox = new SearchBox(driver);
		driver.get("http://automationpractice.com/index.php");
		// maximize my window
		driver.manage().window().maximize();
	}

	@Test(priority=1, dataProvider = "getLogindetails")
	public void reviewProduct(Hashtable<String, String> data) throws InterruptedException {
		SignInPage signin = new SignInPage(driver);
		signin.signInLinkClick();
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(3000);
		loginpage.emailBtn.sendKeys(data.get("username"));
		loginpage.passWordBtn.sendKeys(data.get("passward"));
		loginpage.submitBtnclick();
		
	}

	@Test(priority=2, dataProvider = "getSearchdetails", dependsOnMethods= {"reviewProduct"})
	public void reviewProduct1(Hashtable<String, String> data1) throws InterruptedException {
		SignOutPage homePage = new SignOutPage(driver);
		System.out.println("the search value is:"+data1.get("SearchName"));
		homePage.search(data1.get("SearchName"));
		Thread.sleep(4000);
		searchBox.selectProduct();
		ProductPage productPage = new ProductPage(driver);
		Thread.sleep(3000);
		productPage.productReview();
		System.out.println("review button clicked");
	}
	@Test(priority=3, dataProvider = "giveReview", dependsOnMethods= {"reviewProduct1"})
	public void writeReview(Hashtable<String,String> data2) throws InterruptedException {
		ProductPage productPage = new ProductPage(driver);
		Thread.sleep(4000);
		productPage.starBoxValue.click();
	productPage.titleBox.sendKeys(data2.get("Title"));
	productPage.commentBox.sendKeys(data2.get("Comment"));
	productPage.sendBtn.click();
	Thread.sleep(4000);
	productPage.okBtn.click();
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

	@DataProvider
	public Object[][] getLogindetails() throws IOException {
		String ProjectPath = System.getProperty("user.dir");// this will return project current directory path
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath = ProjectPath + "/src/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "LoginDetails";
		return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
	}
	@DataProvider
	public Object[][] giveReview() throws IOException {
		String ProjectPath = System.getProperty("user.dir");// this will return project current directory path
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath = ProjectPath + "/src/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "ReviewData";
		return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
	}
}
