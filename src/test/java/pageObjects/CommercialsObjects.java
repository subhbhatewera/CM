package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.InputData;

public class CommercialsObjects {

	WebDriver driver ;
	WebDriverWait myWait ;
	InputData input ;
	JavascriptExecutor js ;

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

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedTierType']")
	WebElement tierTypeDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedVolumeSplit']")
	WebElement volumeSplitDropDown ;

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[2]")
	WebElement lowerTierField ;	
	
	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[3]")
	WebElement upperTierField ;	
	
	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[4]")
	WebElement tRVRateField ;	
	
	@FindBy(xpath = "(//mat-select[starts-with(@id,'mat-select')])[3]")
	WebElement applicableFactorDropDown ;	
	
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
		customWait(commercialsTab);
		commercialsTab.click();		
	}

	public void clickGeneralTermsTab() {
		customWait(generalTermsTab);
		generalTermsTab.click();
	}

	public void clickTransactionRateStandardTab() {
		customWait(transactionRateStandardTab);
		transactionRateStandardTab.click();
	}

	public void clickTransactionRateVolumeTab() {
		customWait(transactionRateVolumeTab);
		transactionRateVolumeTab.click();
	}

	public void setBillingFrequency(String billingFrequency) {
		input = new InputData(driver);
		input.setDropDown(billingFrequencyDropDown, billingFrequency);
	}

	public void setCreditPeriod(String creditPeriodValue) {
		input = new InputData(driver);
		input.setDataField(creditPeriodField, creditPeriodValue);
	}

	public void setCreditPeriodType(String creditPeriodType) {
		input = new InputData(driver);
		input.setDropDown(creditPeriodTypeDropDown, creditPeriodType);
	}

	public void setBillingStartDate(String billingStartYear, String billingStartMonth, String billingStartDay) {
		input = new InputData(driver);
		input.setDate(billingStartDateField, billingStartYear, billingStartMonth, billingStartDay);
	}

	public void setBillingEndDate(String billingEndYear, String billingEndMonth, String billingEndDay) {
		input = new InputData(driver);
		input.setDate(billingEndDateField, billingEndYear, billingEndMonth, billingEndDay);
	}

	public void setBillingCurrency(String billingCurrency) {
		input = new InputData(driver);
		input.setDropDown(billingCurrencyDropDown, billingCurrency);
	}

	public void setClause(String clause) {
		input = new InputData(driver);
		input.setDataField(clauseField, clause);
	}

	public void clickCancelButton() {
		input = new InputData(driver);
		input.clickButton(cancelButton);
	}

	public void clickSaveAndContinueButton() {
		input = new InputData(driver);
		input.clickButton(saveAndContinueButton);
	}

	public void clickAddButton() {
		input = new InputData(driver);
		input.clickButton(addButton);
	} 

	public void setLineItem(String lineItem) {
		input = new InputData(driver);
		input.setDataField(lineItemField, lineItem);		
	}

	public void setCurrency(String currency) {
		input = new InputData(driver);
		input.setDropDown(currencyTypeDropDown, currency);		
	}

	public void setRate(String rate) {
		input = new InputData(driver);
		input.setDataField(rateField, rate);
	}

	public void setUOM(String uomOption) {
		input = new InputData(driver);
		input.setDropDown(uomDropDown, uomOption);
	}

	public void setEffectiveStartDate(String effectiveStartYear,String effectiveStartMonth,String effectiveStartDay) {
		input = new InputData(driver);
		input.setDate(effectiveStartDateField, effectiveStartYear, effectiveStartMonth, effectiveStartDay);		
	}

	public void setEffectiveEndDate(String effectiveEndYear,String effectiveEndMonth,String effectiveEndDay) {
		input = new InputData(driver);
		input.setDate(effectiveEndDateField, effectiveEndYear, effectiveEndMonth, effectiveEndDay);		
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
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView()", serviceDropDown);
		input.setDropDown(linkedOpportunityDropDown, linkedOpportunity);
	}

	public void setPlatformsApplicable(String platformsApplicable) {
		input = new InputData(driver);
		input.setDataField(platformsApplicableField, platformsApplicable);
	}

	public void setService(String service) {
		input = new InputData(driver);
	//	js = (JavascriptExecutor) driver ;
	//	js.executeScript("arguments[0].scrollIntoView()", serviceDropDown);
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
	
	public void setTierType(String tierType) {
		input = new InputData(driver);
		input.setDropDown(tierTypeDropDown, tierType);
	}
	
	public void setVolumeSplit(String volumeSplit) {
		input = new InputData(driver);
		input.setDropDown(volumeSplitDropDown, volumeSplit);
	}

	public void setLowerTier(String lowerTier) {
		input = new InputData(driver);
		input.setDataField(lowerTierField, lowerTier);
	}
	
	public void setUpperTier(String upperTier) {
		input = new InputData(driver);
		input.setDataField(upperTierField, upperTier);
	}
	
	public void setTRVRate(String tRVRate) {
		input = new InputData(driver);
		input.setDataField(tRVRateField, tRVRate);
	}
	
	public void setApplicableFactor(String applicableFactor) {
		input = new InputData(driver);
		input.setDropDown(applicableFactorDropDown, applicableFactor);
	}

	public void setGeneralTerms(String billingFrequency, String creditPeriodValue, String creditPeriodType, String billingStartYear, String billingStartMonth, String billingStartDay, String billingEndYear, String billingEndMonth, String billingEndDay, String billingCurrency, String clause) {
		clickCommercialsTab();
		clickGeneralTermsTab();
		setBillingFrequency(billingFrequency);
		setCreditPeriod(creditPeriodValue);
		setCreditPeriodType(creditPeriodType);
		setBillingStartDate(billingStartYear, billingStartMonth, billingStartDay);
		setBillingEndDate(billingEndYear, billingEndMonth, billingEndDay);
		setBillingCurrency(billingCurrency);
		setClause(clause);
		//clickSaveAndContinueButton();
	}

	public void setTransactionRateStandard(String lineItem, String currency, String rate, String uomOption, String effectiveStartYear, String effectiveStartMonth, String effectiveStartDay, String effectiveEndYear,String effectiveEndMonth, String effectiveEndDay, String refrenceNo, String relatedRefNo, String linkedOpportunity, String platformsApplicable, String service, String subService, String location) {
		clickCommercialsTab();
		clickTransactionRateStandardTab();
		clickAddButton();
		setLineItem(lineItem);
		setCurrency(currency);
		setRate(rate);
		setUOM(uomOption);
		setEffectiveStartDate(effectiveStartYear, effectiveStartMonth, effectiveStartDay);
		setEffectiveEndDate(effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		setReferenceNo(refrenceNo);
		setRelatedReferenceNo(relatedRefNo);
		setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
		//clickSaveAndContinueButton();
	}

	public void setTransactionRateVolume(String lineItem, String tierType, String volumeSplit, String lowerTier, String upperTier, String tRVRate, String applicableFactor, String uomOption, String effectiveStartYear, String effectiveStartMonth, String effectiveStartDay, String effectiveEndYear,String effectiveEndMonth, String effectiveEndDay, String refrenceNo, String relatedRefNo, String linkedOpportunity, String platformsApplicable, String service, String subService, String location) {
		clickCommercialsTab();
		clickTransactionRateVolumeTab();
		clickAddButton();
		setLineItem(lineItem);
		setTierType(tierType);
		setVolumeSplit(volumeSplit);
		setLowerTier(lowerTier);
		setUpperTier(upperTier);
		setTRVRate(tRVRate);
		setApplicableFactor(applicableFactor);
		setUOM(uomOption);
		setEffectiveStartDate(effectiveStartYear, effectiveStartMonth, effectiveStartDay);
		setEffectiveEndDate(effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		setReferenceNo(refrenceNo);
		setRelatedReferenceNo(relatedRefNo);
		setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
		//clickSaveAndContinueButton();
	}
}
