package com.selenium.assessment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.utils.ExcelReader;



public class SignIn {
 static WebDriver driver=null;
 @BeforeMethod
	public void LaunchBrowser(){
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://automationpractice.com/index.php");
 }
 @Test(dataProvider="getLogindetails")
 public void enterSignIn(Hashtable<String,String> data) throws InterruptedException {
	 WebElement signInLink=driver.findElement(By.className("login"));
	 signInLink.click();
	 Thread.sleep(3000);
	 WebElement emailBtn=driver.findElement(By.id("email"));
	 emailBtn.sendKeys(data.get("username"));
	 WebElement passWordBtn=driver.findElement(By.id("passwd"));
	 passWordBtn.sendKeys(data.get("passward"));
	 driver.findElement(By.id("SubmitLogin")).click();
	 
}

@DataProvider
public Object[][] getLogindetails() throws IOException {
	String ProjectPath = System.getProperty("user.dir");//this will return project current directory path 
	System.out.println("ProjectPath = " + ProjectPath);
	String filepath  = ProjectPath +"/src/com/selenium/testdata";
	String filename = "LoginData.xlsx";
	String sheetname = "LoginDetails";
	return ExcelReader.ReadExcelDataToObjArray(filepath, filename, sheetname);
}

@AfterMethod
public void closeBrowser() throws InterruptedException {
	Thread.sleep(3000);
	if(driver!=null) {
		driver.close();
		driver.quit();
	}
}

}

