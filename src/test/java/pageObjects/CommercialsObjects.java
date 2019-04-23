package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.MyCalendar;
import utills.InputData;

public class CommercialsObjects {

	WebDriver driver ;
	WebDriverWait myWait ;
	MyCalendar cal ;
	InputData input ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Commercials')])[1]")
	WebElement commercialsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'General Terms')])[1]")
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

	@FindBy(id = "add-button")
	WebElement addButton ;

	@FindBy(xpath = "//input[@formcontrolname='inputLineItem']")
	WebElement lineItemField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='currencyType']")
	WebElement currencyTypeDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='rate']")
	WebElement rateField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedUom']")
	WebElement uomDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='effectiveStartDate']")
	WebElement effectiveStartDateField ;

	@FindBy(xpath = "//input[@formcontrolname='effectiveEndDate']")
	WebElement effectiveEndDateField ;

	@FindBy(xpath = "//input[@formcontrolname='inputReferenceNo']")
	WebElement referenceNoField ;

	@FindBy(xpath = "//input[@formcontrolname='inputRelatedRefNo']")
	WebElement relatedReferenceNoField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedLinkedOpportunity']")
	WebElement linkedOpportunityDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedRelatedDoc']")
	WebElement relatedDocDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='inputPlatformsApplicable']")
	WebElement platformsApplicableField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedService']")
	WebElement serviceDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedSubService']")
	WebElement subServiceDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedProject']")
	WebElement projectDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedSubProject']")
	WebElement subProjectDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='location']")
	WebElement locationField ;	

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

	public void clickAddButton() {
		try {
			customWait(addButton);
			addButton.click();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	} 

	public void setLineItem(String lineItem) {
		input = new InputData(driver);
		input.setDataField(lineItemField, lineItem);		
	}

	public void setRate(String currencyType, String rate) {
		input = new InputData(driver);
		input.setDropDown(currencyTypeDropDown, currencyType);
		input.setDataField(rateField, rate);
	}

	public void setUOM(String uomOption) {
		input = new InputData(driver);
		input.setDropDown(uomDropDown, uomOption);
	}

	public void setEffectiveStartDate(String effSYear,String effSMonth,String effSDay) {
		cal = new MyCalendar(driver);
		cal.setDate(effectiveStartDateField, effSYear, effSMonth, effSDay);		
	}

	public void setEffectiveEndDate(String effEYear,String effEMonth,String effEDay) {
		cal = new MyCalendar(driver);
		cal.setDate(effectiveEndDateField, effEYear, effEMonth, effEDay);
	}

	public void setReferenceNo(String refrenceNo) {
		input = new InputData(driver);
		input.setDataField(referenceNoField, refrenceNo);
	}

	public void setRelatedReferenceNo(String relatedRefNo) {
		input = new InputData(driver);
		input.setDataField(relatedReferenceNoField, relatedRefNo);
	}

	public void setLinkedOpportunity(String linkedOpportunity) {
		input = new InputData(driver);
		input.setDropDown(linkedOpportunityDropDown, linkedOpportunity);
	}

	public void setPlatformsApplicable(String platformsApplicable) {
		input = new InputData(driver);
		input.setDataField(platformsApplicableField, platformsApplicable);
	}
	
	public void setService(String service) {
		input = new InputData(driver);
		input.setDropDown(serviceDropDown, service);
	}
	
	public void setSubService(String subService) {
		input = new InputData(driver);
		input.setDropDown(subServiceDropDown, subService);
	}
	
	public void setLocation(String location) {
		input = new InputData(driver);
		input.setLocationField(locationField, location);
	}

	public void setGeneralTerms(String billingFrequency, String periodValue, String periodType, String syear,String smonth,String sday, String eyear,String emonth,String eday, String billingCurrency, String clause) {
		clickCommercialsTab();
		clickGeneralTermsTab();
		setBillingFrequency(billingFrequency);
		setCreditPeriod(periodValue, periodType);
		setBillingStartDate(syear, smonth, sday);
		setBillingEndDate(eyear, emonth, eday);
		setBillingCurrency(billingCurrency);
		setClause(clause);
	}

	public void setTransactionRateStandard(String lineItem, String currencyType, String rate, String uomOption, String effSYear,String effSMonth,String effSDay, String effEYear,String effEMonth,String effEDay, String refrenceNo, String relatedRefNo, String linkedOpportunity, String platformsApplicable, String service, String subService, String location) {
		clickCommercialsTab();
		clickTransactionRateStandardTab();
		clickAddButton();
		setLineItem(lineItem);
		setRate(currencyType, rate);
		setUOM(uomOption);
		setEffectiveStartDate(effSYear, effSMonth, effSDay);
		setEffectiveEndDate(effEYear, effEMonth, effEDay);
		setReferenceNo(refrenceNo);
		setRelatedReferenceNo(relatedRefNo);
		setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
	}
}
