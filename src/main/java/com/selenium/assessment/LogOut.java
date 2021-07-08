package com.selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut {
	static WebDriver driver=null;
	 @BeforeMethod
		public void LaunchBrowser(){
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://automationpractice.com/index.php");
	 }
	 @Test
	 public void enterSignIn() throws InterruptedException {
		 WebElement signInLink=driver.findElement(By.className("login"));
		 signInLink.click();
		 Thread.sleep(3000);
		 WebElement emailBtn=driver.findElement(By.id("email"));
		 emailBtn.sendKeys("sriyansh@csn.com");
		 WebElement passWordBtn=driver.findElement(By.id("passwd"));
		 passWordBtn.sendKeys("sriyansh123");
		 driver.findElement(By.id("SubmitLogin")).click();
		 driver.findElement(By.linkText("Sign out")).click();
	} 
	 
}
