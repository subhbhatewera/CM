package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.InputData;

public class TermObjects {

	WebDriver driver ;
	WebDriverWait myWait ;
	InputData input ;

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
		customWait(termTab);
		termTab.click();		
	}

	public void clickFixedPeriodTab() {
		customWait(fixedPeriodTab);
		fixedPeriodTab.click();		
	}

	public void clickFixedPeriodWithoutRenewalTab() {
		customWait(fixedPeriodWithoutRenewalTab);
		fixedPeriodWithoutRenewalTab.click();
	}

	public void clickOpenEndedContractTab() {
		customWait(openEndedContractsTab);
		openEndedContractsTab.click();
	}

	public void setStartDate(String startYear, String startMonth, String startDay) {
		input = new InputData(driver);
		input.setDate(startDateField, startYear, startMonth, startDay);
	}

	public void setEndDate(String endYear, String endMonth, String endDay) {
		input = new InputData(driver);
		input.setDate(endDateField, endYear, endMonth, endDay);
	}

	public void setContractTerm(String contractTermValue) {
		input = new InputData(driver);
		input.setDataField(contractTermField, contractTermValue);
	}

	public void setContractTermType(String contractTermType) {
		input = new InputData(driver);
		input.setDropDown(contractTermTypeDropDown, contractTermType);
	}

	public void setSignedDate(String signedYear, String signedMonth, String signedDay) {
		input = new InputData(driver);
		input.setDate(signedDateField, signedYear, signedMonth, signedDay);
	}

	public void setRenewalType(String renewalType) {
		input = new InputData(driver);
		input.setDropDown(renewalTypeDropDown, renewalType);
	}

	public void setNoticePeriod(String noticePeriodValue) {
		input = new InputData(driver);
		input.setDataField(noticePeriodField, noticePeriodValue);
	}

	public void setNoticePeriodType(String noticePeriodType) {
		input = new InputData(driver);
		input.setDropDown(noticePeriodTypeDropDown, noticePeriodType);
	}

	public void setGracePeriod(String gracePeriodValue) {
		input = new InputData(driver);
		input.setDataField(gracePeriodField, gracePeriodValue);
	}

	public void setGracePeriodType(String gracePeriodType) {
		input = new InputData(driver);
		input.setDropDown(gracePeriodTypeDropDown, gracePeriodType);
	}

	public void setOptionalPeriod(String optionalPeriodValue) {
		input = new InputData(driver);
		input.setDataField(optionalPeriodField, optionalPeriodValue);
	}

	public void setOptionalPeriodType(String optionalPeriodType) {
		input = new InputData(driver);
		input.setDropDown(optionalPeriodTypeDropDown, optionalPeriodType);
	}

	public void setDescription(String description) {
		input = new InputData(driver);
		input.setDataField(descriptionField, description);
	}

	public void clickCancelButton() {
		input = new InputData(driver);
		input.clickButton(cancelButton);
	}

	public void clickSaveAndContinueButton() {
		input = new InputData(driver);
		input.clickButton(saveAndContinueButton);
	}
	
	public void setFixedPeriod(String startYear, String startMonth, String startDay, String endYear, String endMonth, String endDay, String contractTermValue, String contractTermType, String signedYear, String signedMonth, String signedDay, String renewalType, String noticePeriodValue, String noticePeriodType, String gracePeriodValue, String gracePeriodType, String optionalPeriodValue, String optionalPeriodType, String description) {
		clickTermTab();
		clickFixedPeriodTab();
		setStartDate(startYear, startMonth, startDay);
		setEndDate(endYear, endMonth, endDay);
		setContractTerm(contractTermValue);
		setContractTermType(contractTermType);
		setSignedDate(signedYear, signedMonth, signedDay);
		setRenewalType(renewalType);
		setNoticePeriod(noticePeriodValue);
		setNoticePeriodType(noticePeriodType);
		setGracePeriod(gracePeriodValue);
		setGracePeriodType(gracePeriodType);
		setOptionalPeriod(optionalPeriodValue);
		setOptionalPeriodType(optionalPeriodType);
		setDescription(description);
		//clickSaveAndContinueButton();
	}
	
	public void setFixedPeriodWithoutRenewal(String startYear, String startMonth, String startDay, String endYear, String endMonth, String endDay, String contractTermValue, String contractTermType, String signedYear, String signedMonth, String signedDay, String renewalType, String gracePeriodValue, String gracePeriodType, String optionalPeriodValue, String optionalPeriodType, String description) {
		clickTermTab();
		clickFixedPeriodWithoutRenewalTab();
		setStartDate(startYear, startMonth, startDay);
		setEndDate(endYear, endMonth, endDay);
		setContractTerm(contractTermValue);
		setContractTermType(contractTermType);
		setSignedDate(signedYear, signedMonth, signedDay);
		setRenewalType(renewalType);
		setGracePeriod(gracePeriodValue);
		setGracePeriodType(gracePeriodType);
		setOptionalPeriod(optionalPeriodValue);
		setOptionalPeriodType(optionalPeriodType);
		setDescription(description);
		//clickSaveAndContinueButton();
	}
	
	public void setOpenEndedContracts(String startYear, String startMonth, String startDay, String noticePeriodValue, String noticePeriodType, String contractTermValue, String contractTermType, String signedYear, String signedMonth, String signedDay, String renewalType, String gracePeriodValue, String gracePeriodType, String optionalPeriodValue, String optionalPeriodType, String description) {
		clickTermTab();
		clickOpenEndedContractTab();
		setStartDate(startYear, startMonth, startDay);
		setNoticePeriod(noticePeriodValue);
		setNoticePeriodType(noticePeriodType);
		setContractTerm(contractTermValue);
		setContractTermType(contractTermType);
		setSignedDate(signedYear, signedMonth, signedDay);
		setRenewalType(renewalType);
		setGracePeriod(gracePeriodValue);
		setGracePeriodType(gracePeriodType);
		setOptionalPeriod(optionalPeriodValue);
		setOptionalPeriodType(optionalPeriodType);
		setDescription(description);
		//clickSaveAndContinueButton();
	}
}
