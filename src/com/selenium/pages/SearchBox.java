package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBox {
	@FindBy(id="search_query_top")
	public WebElement searchTextBox;
	@FindBy(name="submit_search")
	public WebElement searchBtn;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li[5]/div/div[1]/div/a[1]/img")
	public WebElement particularProduct;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li[5]/div/div[2]/div[2]/a[2]")
	public WebElement moreBtn;
	private WebDriver driver;
	
	public SearchBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String searchString) {
		searchTextBox.clear();
		searchTextBox.sendKeys(searchString);
		searchBtn.click();
	}
	
	public void search() {
		searchBtn.click();
	}
	
	public ProductPage selectProduct() {
		Actions action = new Actions(driver);
		action.moveToElement(particularProduct).click(moreBtn).build().perform();
		/*
		 * System.out.println("moved to element"); WebDriverWait wait =new
		 * WebDriverWait(driver,60);
		 * wait.until(ExpectedConditions.elementToBeClickable(moreBtn));
		 * System.out.println("wait over"); action.moveToElement(moreBtn);
		 * System.out.println("move to element more button");
		 * action.click().build().perform();
		 * System.out.println("action click performed");
		 */
		//particularProduct.click();
		/*WebDriverWait wait =new WebDriverWait(driver,60);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated((By) moreBtn));
				
			Actions action = new Actions(driver);
			action.moveToElement(moreBtn).click().build().perform();
		}catch(NoSuchElementException e){
			System.out.println("Printer Element - Not found");
		}*/
		
		return new ProductPage(driver);
	}
	
}
