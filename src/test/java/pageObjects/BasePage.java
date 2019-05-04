package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	WebDriver driver ;
	WebDriverWait myWait ;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement monthAndYearButton ;

	@FindBy(xpath = "//button[@aria-label='Previous 20 years']")
	WebElement previousButton ;

	@FindBy(xpath = "//button[@aria-label='Next 20 years']")
	WebElement nextButton ;


	//Constructor
	public BasePage (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	//Wait method
	public void waitFor(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	// Select an option from drop down
	public void selectDropdownOption(WebElement element, String value) {
		try {
			waitFor(element);
			element.click();
			WebElement option = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+value+"')]"));
			option.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	// Write text in text fields
	public void writeText(WebElement element, String value) {
		try {
			waitFor(element);
			element.clear();
			element.sendKeys(value);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	// Select location from auto populate
	public void selectLocation(WebElement element, String value) {
		try {
			waitFor(element);
			element.clear();
			element.sendKeys(value);
			Thread.sleep(1000);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


	// Click method
	public void clickElement(WebElement element) {
		try {
			waitFor(element);
			element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	//Select date from calendar
	public void selectDate(WebElement dateFieldLocator, String year, String month, String day) {
		try {
			waitFor(dateFieldLocator);
			dateFieldLocator.click();
			waitFor(monthAndYearButton);
			monthAndYearButton.click();
			WebElement yearElement = driver.findElement(By.xpath("//td[@aria-label='"+year+"']"));
			//waitFor(yearElement);
			yearElement.click();
			WebElement monthElement  = driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]"));
			//waitFor(monthElement);
			monthElement.click();
			WebElement dayElement  = driver.findElement(By.xpath("//td[@aria-label='"+day+"']"));
			//waitFor(dayElement);
			dayElement.click();		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public String readText(WebElement element) {
		try {
			waitFor(element);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return element.getText();
	}
	
	public void assertEquals(WebElement element, String text) {
		waitFor(element);
		Assert.assertEquals(readText(element), text);
	}
}
