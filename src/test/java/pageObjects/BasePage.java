package pageObjects;


import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	JavascriptExecutor js ;	
	Calendar cal ;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement monthAndYearButton ;

	@FindBy(xpath = "//button[@aria-label='Previous 20 years']")
	WebElement previousButton ;

	@FindBy(xpath = "//button[@aria-label='Next 20 years']")
	WebElement nextButton ;

	@FindBy(xpath = "//div[contains(@class,'toast-success')]")
	WebElement successToaster ;

	@FindBy(xpath = "//div[contains(@class,'toast-error')]")
	WebElement errorToaster ;

	@FindBy(xpath = "//div[contains(@class,'toast-info')]")
	WebElement infoToaster ;

	//Constructor
	public BasePage (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	//Wait until visibility of an element 
	public void waitFor(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));		
	}

	//Wait until an element become click able
	public void waitForClickable(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(element));
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

	//Click method for stale element
	public void clickStaleElement(WebElement element) {
		try {
			myWait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
			element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	//Select date from calendar
	public void selectDateNew(WebElement dateFieldLocator, String year, String month, String day) {
		try {
			cal = Calendar.getInstance();
			int currentYear = cal.get(Calendar.YEAR);
			int intYear = Integer.valueOf(year);
			waitFor(dateFieldLocator);
			dateFieldLocator.click();
			waitFor(monthAndYearButton);
			monthAndYearButton.click();
			if(intYear<(currentYear-3)) {
				previousButton.click();
				WebElement yearElement = driver.findElement(By.xpath("//td[@aria-label='"+year+"']"));
				yearElement.click();
			}
			else if(intYear>(currentYear+20)) {
				nextButton.click();
				WebElement yearElement = driver.findElement(By.xpath("//td[@aria-label='"+year+"']"));
				yearElement.click();
			}
			else {
				WebElement yearElement = driver.findElement(By.xpath("//td[@aria-label='"+year+"']"));
				yearElement.click();
			}
			WebElement monthElement  = driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]"));
			monthElement.click();
			WebElement dayElement  = driver.findElement(By.xpath("//td[@aria-label='"+day+"']"));
			dayElement.click();		
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
			yearElement.click();
			WebElement monthElement  = driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]"));
			monthElement.click();
			WebElement dayElement  = driver.findElement(By.xpath("//td[@aria-label='"+day+"']"));
			dayElement.click();		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	//Method for reading text
	public String readText(WebElement element) {
		try {
			waitFor(element);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return element.getText();
	}

	//Switch to child window
	public void switchtoChildWindow() {
		try {
			String mainWindow = driver.getWindowHandle();		
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			while(itr.hasNext()) {
				String childWindow = itr.next();
				if(!mainWindow.equals(childWindow)) {
					driver.switchTo().window(childWindow);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	//Assert Method
	public void assertEquals(WebElement element, String text) {
		waitFor(element);
		Assert.assertEquals(readText(element), text);
	}

	//Verify success message 
	public void verifySuccessToaster(String successMessage) {		
		assertEquals(successToaster, successMessage);

	}

	//Click success message
	public void clickSuccessToaster() {
		clickElement(successToaster);
	}

	//Verify info message
	public void verifyInfoToaster(String infoMessage) {		
		assertEquals(infoToaster, infoMessage);

	}

	//Click info message
	public void clickInfoToaster() {
		clickElement(infoToaster);
	}

	//Verify error message
	public void verifyFieldError(String errorMessage) {
		assertEquals(errorToaster, errorMessage);
		clickElement(errorToaster);	
	}

	//Click error message
	public void clickErrorToaster() {
		clickElement(errorToaster);
	}	

	//Scroll method
	public void scrollIntoView(WebElement element) {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	//Sleep method
	public void sleep(long time) {
		try {
			Thread.sleep(time);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}