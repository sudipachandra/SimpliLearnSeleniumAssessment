package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {
	@FindBy(className = "login")
	public WebElement signInBtn;
	@FindBy(className = "heading-counter")
	public WebElement resultBox;

	private SearchBox searchBox;

	WebDriver driver = null;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.searchBox = new SearchBox(driver);
	}

	public void productSearch(String productValue) {
		searchBox.search(productValue);

	}

	public LoginPage signInLinkClick() {
		System.out.println("chekingggg");
		signInBtn.click();
		return new LoginPage(driver);
	}

	public ManufacturerPage searchClick() {
		searchBox.search();
		return new ManufacturerPage(driver);
	}
	/*
	 * public void selectManufacturer() throws InterruptedException {
	 * Thread.sleep(3000); Select select = new Select(manufacturerSelectBox);
	 * select.deselectByVisibleText("Fashion Manufacturer"); }
	 */
}
