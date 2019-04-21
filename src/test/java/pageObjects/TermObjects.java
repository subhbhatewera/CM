package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.MyCalendar;

public class TermObjects {

	WebDriver driver ;
	WebDriverWait myWait ;
	MyCalendar cal ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Term')])[1]")
	WebElement termTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed Period')])[1]")
	WebElement fixedPeriodTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed Period Without')])[1]")
	WebElement fixedPeriodWithoutRenewalTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Open Ended')])[1]")
	WebElement openEndedContractsTab ;

	@FindBy(xpath = "//input[@formcontrolname='startDate']")
	WebElement startDateField ;

	@FindBy(xpath = "//input[@formcontrolname='endDate']")
	WebElement endDateField ;

	@FindBy(xpath = "//input[@formcontrolname='contractTerm']")
	WebElement contractTermField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='contractTermType']")
	WebElement contractTermTypeDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='signedDate']")
	WebElement signedDateField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='renewalType']")
	WebElement renewalTypeDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='noticePeriod']")
	WebElement noticePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='noticePeriodType']")
	WebElement noticePeriodTypeDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='gracePeriod']")
	WebElement gracePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='gracePeriodType']")
	WebElement gracePeriodTypeDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='optionalPeriod']")
	WebElement optionalPeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='optionalPeriodType']")
	WebElement optionalPeriodTypeDropDown ;

	@FindBy(xpath = "//textarea[@formcontrolname='gracePeriodDescription']")
	WebElement descriptionField ;

	@FindBy(id="cancel")
	WebElement cancelButton ;

	@FindBy(id="saveAndContinueContractButton")
	WebElement saveAndContinueButton ;

	public TermObjects (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickTermTab() {
		try {
			customWait(termTab);
			termTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void clickFixedPeriodTab() {
		try
		{
			customWait(fixedPeriodTab);
			fixedPeriodTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void clickFixedPeriodWithoutRenewalTab() {
		try
		{
			customWait(fixedPeriodWithoutRenewalTab);
			fixedPeriodWithoutRenewalTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void clickOpenEndedContractTab() {
		try
		{
			customWait(openEndedContractsTab);
			openEndedContractsTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setStartDate(String year, String month, String day) {
		try {
			cal = new MyCalendar(driver);
			cal.setDate(startDateField, year, month, day);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setEndDate(String year, String month, String day) {
		try
		{
			cal = new MyCalendar(driver);
			cal.setDate(endDateField, year, month, day);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setContractTerm(String termValue, String termType) {
		try
		{
			contractTermField.clear();
			contractTermField.sendKeys(termValue);
			contractTermTypeDropDown.click();
			WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+termType+"')]"));
			element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setSignedDate(String year, String month, String day) {
		try
		{
			cal = new MyCalendar(driver);
			cal.setDate(signedDateField, year, month, day);		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setRenewalType(String renewalType) {
		try
		{
		renewalTypeDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+renewalType+"')]"));
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setNoticePeriod(String noticePeriodValue, String noticePeriodType) {
		try
		{
		noticePeriodField.clear();
		noticePeriodField.sendKeys(noticePeriodValue);
		noticePeriodTypeDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+noticePeriodType+"')]"));
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setGracePeriod(String gracePeriodValue, String gracePeriodType) {
		try
		{
		gracePeriodField.clear();
		gracePeriodField.sendKeys(gracePeriodValue);
		gracePeriodTypeDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+gracePeriodType+"')]"));
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setOptionalPeriod(String optionalPeriodValue, String optionalPeriodType) {
		try
		{
		optionalPeriodField.clear();
		optionalPeriodField.sendKeys(optionalPeriodValue);
		optionalPeriodTypeDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+optionalPeriodType+"')]"));
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setDescription(String description) {
		try
		{
		descriptionField.clear();
		descriptionField.sendKeys(description);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setFixedPeriodTab(String sYear, String sMonth, String sDay, String eYear, String eMonth, String eDday, String termValue, String termType,String sigYear, String sigMonth, String sigDay, String renewalType, String noticePeriodValue, String noticePeriodType, String gracePeriodValue, String gracePeriodType,String optionalPeriodValue, String optionalPeriodType, String description) {
		clickTermTab();
		clickFixedPeriodTab();
		setStartDate(sYear, sMonth, sDay);
		setEndDate(eYear, eMonth, eDday);
		setContractTerm(termValue, termType);
		setSignedDate(sigYear, sigMonth, sigDay);
		setRenewalType(renewalType);
		setNoticePeriod(noticePeriodValue, noticePeriodType);
		setGracePeriod(gracePeriodValue, gracePeriodType);
		setOptionalPeriod(optionalPeriodValue, optionalPeriodType);
		setDescription(description);		
	}
	
	public void setFixedPeriodWithoutRenewalTab(String sYear, String sMonth, String sDay, String eYear, String eMonth, String eDday, String termValue, String termType,String sigYear, String sigMonth, String sigDay, String renewalType, String optionalPeriodValue, String optionalPeriodType, String gracePeriodValue, String gracePeriodType, String description) {
		clickTermTab();
		clickFixedPeriodWithoutRenewalTab();
		setStartDate(sYear, sMonth, sDay);
		setEndDate(eYear, eMonth, eDday);
		setContractTerm(termValue, termType);
		setSignedDate(sigYear, sigMonth, sigDay);
		setRenewalType(renewalType);
		setOptionalPeriod(optionalPeriodValue, optionalPeriodType);
		setGracePeriod(gracePeriodValue, gracePeriodType);
		setDescription(description);		
	}
	
	public void setOpenEndedContractTab(String sYear, String sMonth, String sDay, String noticePeriodValue, String noticePeriodType, String termValue, String termType,String sigYear, String sigMonth, String sigDay, String renewalType, String optionalPeriodValue, String optionalPeriodType, String gracePeriodValue, String gracePeriodType, String description) {
		clickTermTab();
		clickOpenEndedContractTab();
		setStartDate(sYear, sMonth, sDay);
		setNoticePeriod(noticePeriodValue, noticePeriodType);
		setContractTerm(termValue, termType);
		setSignedDate(sigYear, sigMonth, sigDay);
		setRenewalType(renewalType);
		setOptionalPeriod(optionalPeriodValue, optionalPeriodType);
		setGracePeriod(gracePeriodValue, gracePeriodType);
		setDescription(description);		
	}
}
