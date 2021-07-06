package com.selenium.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountDetailsPage {
	@FindBy(id = "id_gender1")
	public WebElement genderMale;
	@FindBy(id = "id_gender2")
	public WebElement genderFemale;
	@FindBy(id = "customer_firstname")
	public WebElement firstNameBtn;
	@FindBy(id = "customer_lastname")
	public WebElement lastNameBtn;
	@FindBy(id = "passwd")
	public WebElement passWord;
	@FindBy(id = "days")
	public WebElement days;
	@FindBy(id = "months")
	public WebElement months;
	@FindBy(id = "years")
	public WebElement years;
	@FindBy(id = "company")
	public WebElement companyBtn;
	@FindBy(id = "address1")
	public WebElement addressBtn;
	@FindBy(id = "address2")
	public WebElement address2;
	@FindBy(id = "city")
	public WebElement cityBtn;
	@FindBy(id = "id_state")
	public WebElement stateBtn;
	@FindBy(id = "postcode")
	public WebElement postCode;
	@FindBy(id = "id_country")
	public WebElement countryBtn;
	@FindBy(id = "phone_mobile")
	public WebElement phNo;
	@FindBy(id = "alias")
	public WebElement alias;
	@FindBy(id = "submitAccount")
	public WebElement submitBtn;
	WebDriver driver = null;

	public AccountDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void accountDetails(String countryValue,String postCodeValue) throws InterruptedException {
		Thread.sleep(5000);
		Random rnd = new Random();
		boolean isGenderFemale = rnd.nextBoolean();
		WebElement gender = isGenderFemale ? genderFemale : genderMale;
		System.out.println(gender);
		gender.click();
		firstNameBtn.sendKeys("sriyansh");
		lastNameBtn.sendKeys("roy");
		passWord.sendKeys("sudipa123");
		Select day = new Select(days);
		day.selectByValue("16");
		Select month = new Select(months);
		month.selectByValue("4");
		Select year = new Select(years);
		year.selectByValue("2016");
		companyBtn.sendKeys("reliance");
		addressBtn.sendKeys("keranitola,midnapore,721101");
		address2.sendKeys("creative apartment");
		cityBtn.sendKeys("bangalore");
		Select state = new Select(stateBtn);
		state.selectByValue("9");
		Select country = new Select(countryBtn);
		country.selectByVisibleText(countryValue);
		if (!"-".equals(countryValue)) {
			postCode.sendKeys(postCodeValue);
		}
		
		phNo.sendKeys("9474506453");
		alias.sendKeys("midnapore");
	}

	public SignOutPage submitClick() {
		submitBtn.click();
		return new SignOutPage(driver);
	}

}
