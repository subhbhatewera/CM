package utills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyCalendar {

	WebDriver driver ;
	WebDriverWait myWait ;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement monthAndYearButton ;

	@FindBy(xpath = "//button[@aria-label='Previous 20 years']")
	WebElement previousButton ;

	@FindBy(xpath = "//button[@aria-label='Next 20 years']")
	WebElement nextButton ;


	public MyCalendar (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customWaitOne(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(element));
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
			Thread.sleep(1500);
			customWaitOne(dayElement);
			dayElement.click();		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
