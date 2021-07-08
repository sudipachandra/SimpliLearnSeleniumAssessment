package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManufacturerPage {
	@FindBy(xpath ="//*[@id=\"manufacturers_block_left\"]/div/form/div/div/select")
	static public WebElement manufacturerSelectBox;
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	public WebElement productListHeader;
	@FindBy(className="navigation_page")
	public WebElement navigatorBtn;
	
	WebDriver driver =null;
	public ManufacturerPage(WebDriver driver) {
		this.driver=driver;
	   PageFactory.initElements(driver,this);
	}
	
	public void selectManufacturer() throws InterruptedException {
	Thread.sleep(3000);
	Select brand = new Select(manufacturerSelectBox);
    brand.selectByVisibleText("Fashion Manufacturer");
	//String selectValue = manufacturerSelectBox.getText();
	//String selectValue = brand.getFirstSelectedOption().getText();
	//System.out.println("the result is :"+selectValue);
	//return selectValue;
	}
	public void verifyManufacturer() {
		String result = productListHeader.getText();
		if(result.contains(manufacturerSelectBox.getText())) {
			
		}
	}
}
