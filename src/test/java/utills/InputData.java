package utills;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputData {

	WebDriver driver ;
	WebDriverWait myWait ;
		
	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement monthAndYearButton ;

	@FindBy(xpath = "//button[@aria-label='Previous 20 years']")
	WebElement previousButton ;

	@FindBy(xpath = "//button[@aria-label='Next 20 years']")
	WebElement nextButton ;

	public InputData (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void setDropDown(WebElement element, String value) {
		try {
			customWait(element);
			element.click();
			WebElement option = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+value+"')]"));
			option.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setDataField(WebElement element, String value) {
		try {
			customWait(element);
			element.clear();
			element.sendKeys(value);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setLocationField(WebElement element, String value) {
		try {
			customWait(element);
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
	
	public void clickButton(WebElement element) {
		try {
			customWait(element);
			element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void setDate(WebElement dateFieldLocator, String year, String month, String day) {
		try {
			customWait(dateFieldLocator);
			dateFieldLocator.click();
			customWait(monthAndYearButton);
			monthAndYearButton.click();
			WebElement yearElement = driver.findElement(By.xpath("//td[@aria-label='"+year+"']"));
			customWait(yearElement);
			yearElement.click();
			WebElement monthElement  = driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]"));
			customWait(monthElement);
			monthElement.click();
			WebElement dayElement  = driver.findElement(By.xpath("//td[@aria-label='"+day+"']"));
			customWait(dayElement);
			dayElement.click();		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
