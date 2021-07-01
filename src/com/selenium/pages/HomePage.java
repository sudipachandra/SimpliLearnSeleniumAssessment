package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(className = "info-account")
	public WebElement successMsg;
	@FindBy(linkText = "Sign out")
	public WebElement signOutBtn;
	
	private SearchBox searchBox;

	// String expectedMsg = "Welcome to your account. Here you can manage all of
	// your personal information and orders.";
	// String actualMsg = successMsg.getText();
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.searchBox = new SearchBox(driver);
	}

	public LoginPage singOutClick() {
		signOutBtn.click();
		return new LoginPage(driver);
	}
	
	public void search(String searchString) {
		searchBox.search(searchString);
	}
	/*
	 * public void accountStatus() { String expectedMsg =
	 * "Welcome to your account. Here you can manage all of your personal information and orders."
	 * ; String actualMsg = successMsg.getText();
	 * if(actualMsg.equalsIgnoreCase(expectedMsg)) {
	 * System.out.println("account created successful!!"); }else {
	 * System.out.println("account created failed"); }
	 */
}
