package com.selenium.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage {
	WebDriver driver = null;
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[3]/p[7]/button[2]")
	public WebElement facebookBtn;
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[3]/p[7]/button[3]")
	public WebElement googleBtn;
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[3]/p[7]/button[4]")
	public WebElement pinterestBtn;
	@FindBy(xpath = "/html/body/div/div[2]/div/div[4]/div/div/div/div[3]/div[3]/ul/li/a")
	public WebElement reviewTextLink;
	@FindBy(xpath = "//*[@id=\"content\"]")
	public WebElement commentBox;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/form/div/div[2]/input")
	public WebElement titleBox;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/form/div/div[2]/ul/li/div[2]")
	public WebElement starBox;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/form/div/div[2]/ul/li/div[1]/div[4]/a")
	public WebElement starBoxValue;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/form/div/div[2]/div[2]/p[2]/button/span")
	public WebElement sendBtn;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/p[2]/button")
	public WebElement okBtn;
	@FindBy(xpath = "/html/body/div[1]/div/div/form/div[3]/div[2]/table/tbody/tr/td/button[1]")
	public WebElement cancelBtn;
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[3]/h1")
	public WebElement verifyMsg;

	// /html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")
	public WebElement emailBox;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div[3]/form/div[1]/fieldset/span/div/input")
    public WebElement emailBox_Pinterest;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div[3]/form/div[2]/fieldset/span/div/input")
	public WebElement passwardBox_Pinterest;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")
	public WebElement nextBtn;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void productReview() {
		reviewTextLink.click();
		String parent = driver.getWindowHandle();
		System.out.println("the value of parent window is: " + parent);
		Set<String> s = driver.getWindowHandles();
		Iterator<String> s1 = s.iterator();
		while (s1.hasNext()) {
			String childWindow = s1.next();
			System.out.println("the value of child window is:" + childWindow);
			if (!parent.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]")));

			}
		}
	}

	public void facebookShare() throws InterruptedException {
		facebookBtn.click();
		String parent = driver.getWindowHandle();
		System.out.println("the value of parent window: " + parent);
		Set<String> s = driver.getWindowHandles();
		Iterator<String> s1 = s.iterator();
		while (s1.hasNext()) {
			String childWindow = s1.next();
			System.out.println("the value of child window is:" + childWindow);
			if (!parent.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				Thread.sleep(3000);
				// WebDriverWait wait = new WebDriverWait(driver,30);
				// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/form/div[3]/div[2]/table/tbody/tr/td/button[1]")));
				// cancelBtn.click();
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}

	public void googleShare(String email) throws InterruptedException {
		googleBtn.click();
		String parent = driver.getWindowHandle();
		System.out.println("the value of parent window: " + parent);
		Set<String> s = driver.getWindowHandles();
		Iterator<String> s1 = s.iterator();
		while (s1.hasNext()) {
			String childWindow = s1.next();
			System.out.println("the value of child window is:" + childWindow);
			if (!parent.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")));
				emailBox.sendKeys(email);
				driver.close();
			}
		}
		
	driver.switchTo().window(parent);
	}
	
	public void pinterestShare(String username,String passward) throws InterruptedException {
		pinterestBtn.click();
		String parent = driver.getWindowHandle();
		System.out.println("the value of parent window: " + parent);
		Set<String> s = driver.getWindowHandles();
		Iterator<String> s1 = s.iterator();
		while (s1.hasNext()) {
			String childWindow = s1.next();
			System.out.println("the value of child window is:" + childWindow);
			if (!parent.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div[3]/form/div[1]/fieldset/span/div/input")));
	           emailBox_Pinterest.sendKeys(username);
	           passwardBox_Pinterest.sendKeys(passward);
	           driver.close();
			}
}
		driver.switchTo().window(parent);
	}
}
