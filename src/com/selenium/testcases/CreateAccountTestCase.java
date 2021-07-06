package com.selenium.testcases;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.pages.AccountDetailsPage;
import com.selenium.pages.SignOutPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.SignInPage;

public class CreateAccountTestCase {
WebDriver driver=null;
@BeforeClass
public void LaunchBrowser(){
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	//maximize my window
	driver.manage().window().maximize();
}


public void signIn() throws InterruptedException {
	SignInPage signin = new SignInPage(driver);
	AccountDetailsPage accountDetailsPage = signin.signInLinkClick().createAnAccountClick();
	accountDetailsPage.accountDetails("United States","00000");
	accountDetailsPage.submitClick();
	SignOutPage homePage = new SignOutPage(driver);
	String actualMsg = homePage.successMsg.getText();
	String expectedMsg = "Welcome to your account. Here you can manage all of your personal information and orders.";
	Assert.assertEquals(actualMsg, expectedMsg);
   System.out.println("test pass");
}

public void createAccountWithoutCountry() throws InterruptedException {
	SignInPage signin = new SignInPage(driver);
	AccountDetailsPage accountDetailsPage = signin.signInLinkClick().createAnAccountClick();
	accountDetailsPage.accountDetails("-","");
	accountDetailsPage.submitClick();
	SignOutPage homePage = new SignOutPage(driver);
	String actualMsg = homePage.failMsgForCountry.getText();
	String expectedMsg = "id_country is required.";
	Assert.assertEquals(actualMsg, expectedMsg);
}

@Test
public void createAccountWithCountryInvalidPostcode() throws InterruptedException {
	SignInPage signin = new SignInPage(driver);
	AccountDetailsPage accountDetailsPage = signin.signInLinkClick().createAnAccountClick();
	accountDetailsPage.accountDetails("United States","000");
	accountDetailsPage.submitClick();
	SignOutPage homePage = new SignOutPage(driver);
    String actualMsg = homePage.failMsgForPostcode.getText();
	String expectedMsg = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
	Assert.assertEquals(actualMsg, expectedMsg);
}

}
