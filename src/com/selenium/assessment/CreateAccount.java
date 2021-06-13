package com.selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
	}

}
