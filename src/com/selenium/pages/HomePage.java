package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img")
public WebElement product1;
@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/div[2]/a[1]")
public WebElement addToCart1;
@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[2]/div/div[1]/div/a[1]/img")
public WebElement product2;
@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[2]/div/div[2]/div[2]/a[1]")
public WebElement addToCart2;
@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[1]/div/a[1]/img")
public WebElement product3;
//@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[2]/div[2]/a[1]")
@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[2]/div[2]/a[1]")
public WebElement addToCart3;
@FindBy(xpath= "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[2]/div[2]/a[2]")
public WebElement moreBtn3;
@FindBy(xpath="/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span")
public WebElement continueBtn;
@FindBy(xpath="/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")
public WebElement proceedToCheckBtn;
@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")
public WebElement proceedToCheckBtn1;
@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/form/p/button")
public WebElement proceedToCheckBtn2;
@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/p/button")
public WebElement proceedToCheckBtn3;
@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input")
public WebElement checkBox;
@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")
public WebElement payByBankWire;
@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/form/p/button")
public WebElement IConfirmMyOrder;
@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/p/strong")
public WebElement confirmMsg;
		
private WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void addCart1() {
	Actions action = new Actions(driver);
	action.moveToElement(product1).click(addToCart1).build().perform();
}
public void addCart2() {
	Actions action = new Actions(driver);
	action.moveToElement(product2).click(addToCart2).build().perform();
}
public void addCart3() {
	Actions action = new Actions(driver);
	action.moveToElement(product3).click(addToCart3).build().perform();
}
public void Share() {
	Actions action = new Actions(driver);
	action.moveToElement(product3).click(moreBtn3).build().perform();
}
	
}
