package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(id="email_create")
	public WebElement emailAddressBtn;
@FindBy(name="SubmitCreate")
public WebElement createAccount;
@FindBy(id="email")
public WebElement emailBtn;
@FindBy(id="passwd")
public WebElement passWordBtn;
@FindBy(id="SubmitLogin")
public WebElement submitBtn;
@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/p")
public WebElement errorMsgField;
WebDriver driver = null;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		   PageFactory.initElements(driver,this);
	}
	
	public AccountDetailsPage createAnAccountClick() throws InterruptedException {
		Thread.sleep(5000);
		emailAddressBtn.sendKeys("sriyansh" + System.currentTimeMillis() + "@csn.com");
		createAccount.click();
		return new AccountDetailsPage(driver);
	}
/*public void validUser(String username,String passward) {
	emailBtn.sendKeys("username");
	passWordBtn.sendKeys("passward");
}*/

public SignOutPage submitBtnclick() {
	submitBtn.click();
	return new SignOutPage(driver);
}
}
