package com.selenium.testcases;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.pages.AccountDetailsPage;
import com.selenium.pages.HomePage;
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

@Test
public void signIn() throws InterruptedException {
	SignInPage signin = new SignInPage(driver);
	AccountDetailsPage accountDetailsPage = signin.signInLinkClick().createAnAccountClick();
	accountDetailsPage.accountDetails();
	accountDetailsPage.submitClick();
	HomePage homePage = new HomePage(driver);
	String actualMsg = homePage.successMsg.getText();
	String expectedMsg = "Welcome to your account. Here you can manage all of your personal information and orders.";
	Assert.assertEquals(actualMsg, expectedMsg);
   System.out.println("test pass");
}
}
