package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.MyCalendar;

public class CommercialsObjects {

	WebDriver driver ;
	WebDriverWait myWait ;
	MyCalendar cal ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Commercials')])[1]")
	WebElement commercialsTab ;

	@FindBy(xpath = "((//div[@class='mat-tab-label-content'][contains(text(),'General Terms')])[1]")
	WebElement generalTermsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Standard')])[1]")
	WebElement transactionRateStandardTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Volume')])[1]")
	WebElement transactionRateVolumeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Time')])[1]")
	WebElement timeAndMaterialModelTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed')])[1]")
	WebElement fixedFeeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Minimum')])[1]")
	WebElement minimumBillingTab ;

	@FindBy(xpath = "//mat-select[@formcontrolname='billingFrequencyType']")
	WebElement billingFrequencyDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='creditPeriod']")
	WebElement creditPeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='creditPeriodType']")
	WebElement creditPeriodTypeDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='billingStartDate']")
	WebElement billingStartDateField ;

	@FindBy(xpath = "//input[@formcontrolname='billingEndDate']")
	WebElement billingEndDateField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='billingCurrency']")
	WebElement billingCurrencyDropDown ;

	@FindBy(xpath = "//textarea[@formcontrolname='clause']")
	WebElement clauseField ;

	@FindBy(id="cancel")
	WebElement cancelButton ;

	@FindBy(id="saveAndContinueContractButton")
	WebElement saveAndContinueButton ;

	public CommercialsObjects (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickCommercialsTab() {
		try {
			customWait(commercialsTab);
			commercialsTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void clickGeneralTermsTab() {
		try
		{
			customWait(generalTermsTab);
			generalTermsTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void clickTransactionRateStandardTab() {
		try
		{
			customWait(transactionRateStandardTab);
			transactionRateStandardTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void clickTransactionRateVolumeTab() {
		try
		{
			customWait(transactionRateVolumeTab);
			transactionRateVolumeTab.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setBillingFrequency(String billingFrequency) {
		try {
			customWait(billingFrequencyDropDown);
			billingFrequencyDropDown.click();
			WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+billingFrequency+"')]"));
			element.click();	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setCreditPeriod(String periodValue, String periodType) {
		try
		{
			creditPeriodField.clear();
			creditPeriodField.sendKeys(periodValue);
			creditPeriodTypeDropDown.click();
			WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+periodType+"')]"));
			element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setBillingStartDate(String year, String month, String day) {
		try {
			cal = new MyCalendar(driver);
			cal.setDate(billingStartDateField, year, month, day);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setBillingEndDate(String year, String month, String day) {
		try
		{
			cal = new MyCalendar(driver);
			cal.setDate(billingEndDateField, year, month, day);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setBillingCurrency(String billingCurrency) {
		try
		{
			billingCurrencyDropDown.click();
			WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+billingCurrency+"')]"));
			element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setClause(String clause) {
		try
		{
			clauseField.clear();
			clauseField.sendKeys(clause);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setGeneralTerms(String billingFrequency, String periodValue, String periodType, String syear,String smonth,String sday, String eyear,String emonth,String eday, String billingCurrency, String clause) {
		setBillingFrequency(billingFrequency);
		setCreditPeriod(periodValue, periodType);
		setBillingStartDate(syear, smonth, sday);
		setBillingEndDate(eyear, emonth, eday);
		setBillingCurrency(billingCurrency);
		setClause(clause);
	}
}
