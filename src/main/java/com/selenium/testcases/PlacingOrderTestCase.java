package com.selenium.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.SearchBox;
import com.selenium.pages.SignInPage;
import com.selenium.pages.SignOutPage;
import com.selenium.utils.ExcelReader;

public class PlacingOrderTestCase {
	private WebDriver driver;
	private SearchBox searchBox;

	@BeforeMethod
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		searchBox = new SearchBox(driver);
		driver.get("http://automationpractice.com/index.php");
		// maximize my window
		driver.manage().window().maximize();
	}

	@Test(priority = 1, dataProvider = "getLogindetails")
	public void reviewProduct(Hashtable<String, String> data) throws InterruptedException {
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
		homePage.addCart1();
		Thread.sleep(4000);
		homePage.continueBtn.click();
		Thread.sleep(4000);
		homePage.addCart2();
		Thread.sleep(3000);
		homePage.continueBtn.click();
		Thread.sleep(4000);
		homePage.addCart3();
		Thread.sleep(5000);
		homePage.proceedToCheckBtn.click();
		Thread.sleep(3000);
		homePage.proceedToCheckBtn1.click();
		Thread.sleep(3000);
		homePage.proceedToCheckBtn2.click();
		Thread.sleep(3000);
		homePage.checkBox.click();
		homePage.proceedToCheckBtn3.click();
		Thread.sleep(3000);
		homePage.payByBankWire.click();
		Thread.sleep(3000);
		homePage.IConfirmMyOrder.click();
		Thread.sleep(3000);
		String actualConfirmMsg = homePage.confirmMsg.getText();
		String expectedConfirmMsg = "Your order on My Store is complete.";
		Assert.assertEquals(actualConfirmMsg, expectedConfirmMsg);

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
