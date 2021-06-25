package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {
@FindBy(className="login")
public WebElement signInBtn;
@FindBy(id="search_query_top")
public WebElement searchTextBox;
@FindBy(name="submit_search")
public WebElement searchBtn;
@FindBy(className="heading-counter")
public WebElement resultBox;

//@FindBy(className="page-heading product-listing")
//public WebElement productListHeader;
WebDriver driver =null;
public SignInPage(WebDriver driver) {
	this.driver=driver;
   PageFactory.initElements(driver,this);
}
public void productSearch(String productValue) {
	searchTextBox.sendKeys(productValue);
	searchBtn.click();
	//String resultValue = resultBox.getText();
	
	
}
public LoginPage signInLinkClick() {
	signInBtn.click();
	return new LoginPage(driver);
}
public ManufacturerPage searchClick() {
	searchBtn.click();
	return new ManufacturerPage(driver);
}
/*public void selectManufacturer() throws InterruptedException {
	Thread.sleep(3000);
	Select select = new Select(manufacturerSelectBox);
	select.deselectByVisibleText("Fashion Manufacturer");
}*/
}
