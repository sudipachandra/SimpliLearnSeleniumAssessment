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

import com.selenium.pages.AccountDetailsPage;
import com.selenium.pages.SignInPage;
import com.selenium.pages.SignOutPage;
import com.selenium.utils.ExcelReader;

public class CreateAccountTestCase {
	WebDriver driver = null;

	@BeforeMethod
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		// maximize my window
		driver.manage().window().maximize();
	}

	@Test(priority = 1, dataProvider = "getLogindetails")
	public void signIn(Hashtable<String, String> data) throws InterruptedException {
		System.out.println(data);
		SignInPage signin = new SignInPage(driver);
		AccountDetailsPage accountDetailsPage = signin.signInLinkClick().createAnAccountClick();
		accountDetailsPage.fillAccountDetails(data);

		accountDetailsPage.submitClick();
		SignOutPage homePage = new SignOutPage(driver);
		String actualMsg = homePage.successMsg.getText();
		String expectedMsg = "Welcome to your account. Here you can manage all of your personal information and orders.";
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("test pass");
	}

	@Test(priority = 2, dataProvider = "getLogindetails")
	public void createAccountWithoutCountry(Hashtable<String, String> data) throws InterruptedException {
		SignInPage signin = new SignInPage(driver);
		AccountDetailsPage accountDetailsPage = signin.signInLinkClick().createAnAccountClick();

		data.put("country", "-");
		accountDetailsPage.fillAccountDetails(data);

		accountDetailsPage.submitClick();
		SignOutPage homePage = new SignOutPage(driver);
		String actualMsg = homePage.failMsgForCountry.getText();
		String expectedMsg = "id_country is required.";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Test(priority = 3, dataProvider = "getLogindetails")
	public void createAccountWithCountryInvalidPostcode(Hashtable<String, String> data) throws InterruptedException {
		SignInPage signin = new SignInPage(driver);
		AccountDetailsPage accountDetailsPage = signin.signInLinkClick().createAnAccountClick();
		data.put("postcode", "000");
		accountDetailsPage.fillAccountDetails(data);
		accountDetailsPage.submitClick();
		SignOutPage homePage = new SignOutPage(driver);
		String actualMsg = homePage.failMsgForPostcode.getText();
		String expectedMsg = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@DataProvider
	public Object[][] getLogindetails() throws IOException {
		String ProjectPath = System.getProperty("user.dir");// this will return project current directory path
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath = ProjectPath + "/src/main/java/com/selenium/testdata";
		String filename = "LoginData.xlsx";
		String sheetname = "CreateAccount";
		return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
	}

	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.close(); // close current active browser
			driver.quit(); // all open browser launched via script
		}
	}

}
