package com.selenium.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
WebDriver driver=null;
//@FindBy(xpath="/html/body/div/div[2]/div/div[4]/div/div/div/div[3]/div[3]/ul")
@FindBy(xpath="/html/body/div/div[2]/div/div[4]/div/div/div/div[3]/div[3]/ul/li/a")
	public WebElement reviewTextLink; 
@FindBy(xpath="//*[@id=\"content\"]")
public WebElement commentBox;
@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/form/div/div[2]/input")
public WebElement titleBox;
@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/form/div/div[2]/ul/li/div[2]")
public WebElement starBox;
@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/form/div/div[2]/ul/li/div[1]/div[4]/a")
public WebElement starBoxValue;
@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/form/div/div[2]/div[2]/p[2]/button/span")
public WebElement sendBtn;
@FindBy(xpath="/html/body/div[2]/div/div/div/p[2]/button")
//@FindBy(xpath="//*[@id=\"product\"]/div[2]/div/div/div/p[2]")
//@FindBy(xpath="/html/body/div[2]/div/div/div/p[2]/button")
//@FindBy(xpath="/html/body/div[2]/div/div/div/p[2]/button/span")
public WebElement okBtn;
public ProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}	
public void productReview() {
	reviewTextLink.click();
	String parent = driver.getWindowHandle();
	System.out.println("the value of parent window is: "+parent);
	Set<String> s = driver.getWindowHandles();
	Iterator<String> s1 = s.iterator();
	while(s1.hasNext()) {
		String childWindow = s1.next();
		
		//String subWindow = s1.next();
	   System.out.println("the value of child window is:"+childWindow);
if(!parent.equalsIgnoreCase(childWindow)) {
		driver.switchTo().window(childWindow);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]")));
	}
	}
}
}

/*public void alertExcept() throws InterruptedException {
	sendBtn.click();
	String parent = driver.getWindowHandle();
	System.out.println("the value of parent window is: "+parent);
	Set<String> s = driver.getWindowHandles();
	Iterator<String> s1 = s.iterator();
	while(s1.hasNext()) {
		String childWindow = s1.next();
		
		//String subWindow = s1.next();
	   System.out.println("the value of child window is:"+childWindow);
if(!parent.equalsIgnoreCase(childWindow)) {
	System.out.println("if condition passed");
		driver.switchTo().window(childWindow);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div/p[2]")));
	}
    okBtn.click();
    System.out.println("the ok button is clicked");
    
	}
	/*Alert a = driver.switchTo().alert();
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.alertIsPresent());
	String name = a.getText();
	System.out.println("the value of name is: "+name);
	Thread.sleep(4000);
	a.accept();*/
	/* try{ 
	        Alert a = new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	        if(a!=null){
	            System.out.println("Alert is present");
	            driver.switchTo().alert().accept();
	        }else{
	            throw new Throwable();
	        }
	    } 
	    catch (Throwable e) {
	        System.err.println("Alert isn't present!!");
	    } */
	




