package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermObjects extends BasePage{

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Term')])[1]")
	WebElement termTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed Period')])[1]")
	WebElement fixedPeriodTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed Period Without')])[1]")
	WebElement fixedPeriodWithoutRenewalTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Open Ended')])[1]")
	WebElement openEndedContractsTab ;

	@FindBy(xpath = "//input[@placeholder='Start Date']")
	WebElement startDateField ;

	@FindBy(xpath = "//input[@placeholder='End Date']")
	WebElement endDateField ;

	@FindBy(xpath = "//input[@placeholder='Contract Term']")
	WebElement contractTermField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='contractTermType']")
	WebElement contractTermTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Signed Date']")
	WebElement signedDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Renewal Type']")
	WebElement renewalTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Notice Period for Renewal']")
	WebElement noticePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='noticePeriodType']")
	WebElement noticePeriodTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Grace Period']")
	WebElement gracePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='gracePeriodType']")
	WebElement gracePeriodTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Optional Period']")
	WebElement optionalPeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='optionalPeriodType']")
	WebElement optionalPeriodTypeDropDown ;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement descriptionField ;

	@FindBy(id="cancel")
	WebElement cancelButton ;

	@FindBy(id="saveAndContinueContractButton")
	WebElement saveAndContinueButton ;

	public TermObjects (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public TermObjects gotoTermTab() {
		clickElement(termTab);
		return this;
	}

	public TermObjects gotoFixedPeriodTab() {
		clickElement(fixedPeriodTab);
		return this;
	}

	public TermObjects gotoFixedPeriodWithoutRenewalTab() {
		clickElement(fixedPeriodWithoutRenewalTab);
		return this;
	}

	public TermObjects gotoOpenEndedContractTab() {
		clickElement(openEndedContractsTab);
		return this;
	}

	public TermObjects setStartDate(String startYear, String startMonth, String startDay) {
		selectDate(startDateField, startYear, startMonth, startDay);
		return this;
	}

	public TermObjects setEndDate(String endYear, String endMonth, String endDay) {
		selectDate(endDateField, endYear, endMonth, endDay);
		return this;
	}

	public TermObjects setContractTerm(String contractTermValue) {
		writeText(contractTermField, contractTermValue);
		return this;
	}

	public TermObjects setContractTermType(String contractTermType) {
		selectDropdownOption(contractTermTypeDropDown, contractTermType);
		return this;
	}

	public TermObjects setSignedDate(String signedYear, String signedMonth, String signedDay) {
		selectDate(signedDateField, signedYear, signedMonth, signedDay);
		return this;
	}

	public TermObjects setRenewalType(String renewalType) {
		selectDropdownOption(renewalTypeDropDown, renewalType);
		return this;
	}

	public TermObjects setNoticePeriod(String noticePeriodValue) {
		writeText(noticePeriodField, noticePeriodValue);
		return this;
	}

	public TermObjects setNoticePeriodType(String noticePeriodType) {
		selectDropdownOption(noticePeriodTypeDropDown, noticePeriodType);
		return this;
	}

	public TermObjects setGracePeriod(String gracePeriodValue) {
		writeText(gracePeriodField, gracePeriodValue);
		return this;
	}

	public TermObjects setGracePeriodType(String gracePeriodType) {
		selectDropdownOption(gracePeriodTypeDropDown, gracePeriodType);
		return this;
	}

	public TermObjects setOptionalPeriod(String optionalPeriodValue) {
		writeText(optionalPeriodField, optionalPeriodValue);
		return this;
	}

	public TermObjects setOptionalPeriodType(String optionalPeriodType) {
		selectDropdownOption(optionalPeriodTypeDropDown, optionalPeriodType);
		return this;
	}

	public TermObjects setDescription(String description) {
		writeText(descriptionField, description);
		return this;
	}

	public TermObjects clickCancelButton() {
		clickElement(cancelButton);
		return this;
	}

	public TermObjects clickSaveAndContinueButton() {
		clickElement(saveAndContinueButton);
		return this;
	}

	public TermObjects setFixedPeriod(String startYear, String startMonth, String startDay, String endYear, String endMonth, String endDay, String contractTermValue, String contractTermType, String signedYear, String signedMonth, String signedDay, String renewalType, String noticePeriodValue, String noticePeriodType, String gracePeriodValue, String gracePeriodType, String optionalPeriodValue, String optionalPeriodType, String description) {
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
		return this;
	}

	public TermObjects setFixedPeriodWithoutRenewal(String startYear, String startMonth, String startDay, String endYear, String endMonth, String endDay, String contractTermValue, String contractTermType, String signedYear, String signedMonth, String signedDay, String renewalType, String gracePeriodValue, String gracePeriodType, String optionalPeriodValue, String optionalPeriodType, String description) {
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
		return this;
	}

	public TermObjects setOpenEndedContracts(String startYear, String startMonth, String startDay, String noticePeriodValue, String noticePeriodType, String contractTermValue, String contractTermType, String signedYear, String signedMonth, String signedDay, String renewalType, String gracePeriodValue, String gracePeriodType, String optionalPeriodValue, String optionalPeriodType, String description) {
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
		return this;
	}
}