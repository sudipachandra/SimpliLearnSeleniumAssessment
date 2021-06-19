package com.selenium.assessment;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement signInBtn = driver.findElement(By.className("login"));
		signInBtn.click();
		WebElement emailAddressBtn = driver.findElement(By.id("email_create"));
		emailAddressBtn.sendKeys("sriyansh" + System.currentTimeMillis() + "@csn.com");
		WebElement createAccount = driver.findElement(By.name("SubmitCreate"));
		createAccount.click();
		/*
		 * List<WebElement> genderList = driver.findElements(By.className("top"));
		 * for(WebElement gender:genderList) {
		 * if(gender.getAttribute("id").equals("uniform-id_gender1")) {
		 * if(!gender.isSelected()) { gender.click(); break; } } }
		 */
		Thread.sleep(3000);
		Random rnd = new Random();
		int genderSuffix = rnd.nextInt(1) + 1;
		WebElement gender = driver.findElement(By.id("id_gender" + genderSuffix));
		gender.click();
		WebElement firstNameBtn = driver.findElement(By.id("customer_firstname"));
		//firstNameBtn.click();
		firstNameBtn.sendKeys("sriyansh");
		WebElement lastNameBtn = driver.findElement(By.id("customer_lastname"));
		//lastNameBtn.click();
		lastNameBtn.sendKeys("roy");
		WebElement passWord = driver.findElement(By.id("passwd"));
		//passWord.click();
		passWord.sendKeys("sudipa123");
		WebElement days = driver.findElement(By.id("days"));
		Select day = new Select(days);
		day.selectByValue("16");
		WebElement months = driver.findElement(By.id("months"));
	    Select month = new Select(months);
	    month.selectByValue("4");
	    WebElement years = driver.findElement(By.id("years"));
	    Select year = new Select(years);
	    year.selectByValue("2016");
	    WebElement companyBtn = driver.findElement(By.id("company"));
	    //companyBtn.click();
	    companyBtn.sendKeys("reliance");
	    WebElement addressBtn = driver.findElement(By.id("address1"));
	    addressBtn.sendKeys("keranitola,midnapore,721101");
	    WebElement address2 = driver.findElement(By.id("address2"));
	    address2.sendKeys("creative apartment");
	    WebElement cityBtn = driver.findElement(By.id("city"));
	    cityBtn.sendKeys("bangalore");
	    WebElement stateBtn = driver.findElement(By.id("id_state"));
	    Select state = new Select(stateBtn);
	    state.selectByValue("9");
	    driver.findElement(By.id("postcode")).sendKeys("00000");
	    WebElement countryBtn = driver.findElement(By.id("id_country"));
	    Select country = new Select(countryBtn);
	    country.selectByValue("21");
	   // country.selectByVisibleText("-");
	    driver.findElement(By.id("phone_mobile")).sendKeys("9474506453");
	    driver.findElement(By.id("alias")).sendKeys("midnapore");
	    //Thread.sleep(3000);
	    driver.findElement(By.id("submitAccount")).click();
	    
	}

}
