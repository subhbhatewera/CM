package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtherCommercialsTermsObjects extends BasePage {

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Other Commercial')])[1]")
	WebElement otherCommercialTermsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'COLA')])[1]")
	WebElement colaTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Incentive')])[1]")
	WebElement incentiveTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Penalty')])[1]")
	WebElement penaltyTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Early Payment')])[1]")
	WebElement earlyPaymentDiscountTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Late Payment')])[1]")
	WebElement latePaymentFeeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Termination')])[1]")
	WebElement terminationTab ;
	
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Limitation')])[1]")
	WebElement limitationOfLiabilityTab ;

	@FindBy(xpath = "//textarea[@placeholder='Clause']")
	WebElement clauseField ;
	
	@FindBy(xpath = "//input[@placeholder='Type']")
	WebElement typeField ;
	
	@FindBy(xpath = "//input[@placeholder='Index Type']")
	WebElement indexTypeField ;
	
	@FindBy(xpath = "//input[@placeholder='Applicable From']")
	WebElement applicableFromField ;
	
	@FindBy(xpath = "//mat-select[@placeholder='Revision Frequency']")
	WebElement revisionFrequencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Notice Period']")
	WebElement noticePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='noticePeriodType']")
	WebElement noticePeriodTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Percentage']")
	WebElement percentageField ;

	@FindBy(xpath = "//mat-select[@placeholder='Status']")
	WebElement statusDropDown ;
	
	@FindBy(xpath = "//input[@placeholder='Reference No.']")
	WebElement referenceNoField ;

	@FindBy(xpath = "//input[@placeholder='Related Reference No.']")
	WebElement relatedReferenceNoField ;
	
	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
	WebElement checkBox ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement cancelButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement saveAndContinueButton ;	
	
	@FindBy(xpath = "//input[@placeholder='Date From']")
	WebElement dateFromField ;
	
	@FindBy(xpath = "//input[@placeholder='Date To']")
	WebElement dateToField ;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='currency']")
	WebElement currencyDropDown ;
		
	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;
	
	@FindBy(xpath = "//input[@placeholder='Value']")
	WebElement valueField ;
	
	@FindBy(xpath = "//input[@placeholder='Billing Cycle']")
	WebElement billingCycleField ;
	
	@FindBy(xpath = "//input[@placeholder='Invoice Date']")
	WebElement invoiceDateField ;
	
	@FindBy(xpath = "//input[@placeholder='Penalty Value']")
	WebElement penaltyValueField ;
	
	@FindBy(xpath = "//mat-select[@placeholder='Term']")
	WebElement termDropDown ;
	
	public OtherCommercialsTermsObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public OtherCommercialsTermsObjects gotoOtherCommercialTermsTab() {
		clickElement(otherCommercialTermsTab);
		return this;
	}

	public OtherCommercialsTermsObjects gotoCOLATab() {
		clickElement(colaTab);
		return this;
	}

	public OtherCommercialsTermsObjects gotoIncentiveTab() {
		clickElement(incentiveTab);
		return this;
	}

	public OtherCommercialsTermsObjects gotoPenaltyTab() {
		clickElement(penaltyTab);
		return this;
	}

	public OtherCommercialsTermsObjects gotoEarlyPaymentDiscountTab() {
		clickElement(earlyPaymentDiscountTab);
		return this;
	}

	public OtherCommercialsTermsObjects gotoLatePaymentFeeTab() {
		clickElement(latePaymentFeeTab);
		return this;
	}

	public OtherCommercialsTermsObjects gotoTerminationTab() {
		clickElement(terminationTab);
		return this;
	}
	
	public OtherCommercialsTermsObjects gotoLimitationOfLiabilityTab() {
		clickElement(limitationOfLiabilityTab);
		return this;
	}

	public OtherCommercialsTermsObjects setClause( String clause) {
		writeText(clauseField, clause);
		return this ;
	}
	
	public OtherCommercialsTermsObjects setType( String type) {
		writeText(typeField, type);
		return this ;
	}
	
	public OtherCommercialsTermsObjects setIndexType( String indexType) {
		writeText(indexTypeField, indexType);
		return this ;
	}
	
	public OtherCommercialsTermsObjects setApplicableFrom(String applicableYear, String applicableMonth, String applicableDay) {
		selectDate(applicableFromField, applicableYear, applicableMonth, applicableDay);
		return this;
	}
	
	public OtherCommercialsTermsObjects setRevisionFrequency(String revisionFrequency) {
		selectDropdownOption(revisionFrequencyDropDown, revisionFrequency);
		return this;
	}
	
	public OtherCommercialsTermsObjects setNoticePeriod(String noticePeriodValue) {
		writeText(noticePeriodField, noticePeriodValue);
		return this;
	}
	
	public OtherCommercialsTermsObjects setNoticePeriodType(String noticePeriodType) {
		selectDropdownOption(noticePeriodTypeDropDown, noticePeriodType);
		return this;
	}
	
	public OtherCommercialsTermsObjects setPercentage(String percentage) {
		writeText(percentageField, percentage);
		return this;
	}
	
	public OtherCommercialsTermsObjects setStatus(String status) {
		selectDropdownOption(statusDropDown, status);
		return this;
	}
	
	public OtherCommercialsTermsObjects setReferenceNo(String referenceNo) {
		writeText(referenceNoField, referenceNo);
		return this;
	}

	public OtherCommercialsTermsObjects setRelatedRefNo(String relatedRefNo) {
		writeText(relatedReferenceNoField, relatedRefNo);
		return this;
	}

	public OtherCommercialsTermsObjects clickSaveAndContinueButton() {
		clickElement(saveAndContinueButton);
		return this;
	}
	
	public OtherCommercialsTermsObjects setCOLA(String clause, String type, String indexType, String applicableStartYear, String applicableStartMonth, String applicableStartDay, String revisionFrequency, String noticePeriodValue, String noticePeriodType, String percentage, String status, String referenceNo, String relatedRefNo) {
		setClause(clause);
		setType(type);
		setIndexType(indexType);
		setApplicableFrom(applicableStartYear, applicableStartMonth, applicableStartDay);
		setRevisionFrequency(revisionFrequency);
		setNoticePeriod(noticePeriodValue);
		setNoticePeriodType(noticePeriodType);
		setPercentage(percentage);
		setStatus(status);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);		
		return this;
	}
	
	public OtherCommercialsTermsObjects setDateFrom(String fromYear, String fromMonth, String fromDay) {
		selectDate(dateFromField, fromYear, fromMonth, fromDay);
		return this;
	}
	
	public OtherCommercialsTermsObjects setDateTo(String toYear, String toMonth, String toDay) {
		selectDate(dateToField, toYear, toMonth, toDay);
		return this;
	}
	
	public OtherCommercialsTermsObjects setIncentive(String clause, String referenceNo, String percentage, String type,String fromYear, String fromMonth, String fromDay,String toYear, String toMonth, String toDay,String status, String noticePeriodValue, String noticePeriodType) {
		setClause(clause);
		setReferenceNo(referenceNo);
		setPercentage(percentage);
		setType(type);
		setDateFrom(fromYear, fromMonth, fromDay);
		setDateTo(toYear, toMonth, toDay);
		setStatus(status);
		setNoticePeriod(noticePeriodValue);
		setNoticePeriodType(noticePeriodType);			
		return this;
	}
	
	public OtherCommercialsTermsObjects setTypeDropDown(String type) {
		selectDropdownOption(typeDropDown, type);
		return this;
	}
	
	public OtherCommercialsTermsObjects setPenalty(String clause, String referenceNo, String relatedRefNo, String percentage,String fromYear, String fromMonth, String fromDay,String toYear, String toMonth, String toDay,String status) {
		setClause(clause);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		setPercentage(percentage);
		//setType(type);
		setDateFrom(fromYear, fromMonth, fromDay);
		setDateTo(toYear, toMonth, toDay);
		setStatus(status);
		return this;
	}
	
	public OtherCommercialsTermsObjects setValue(String value) {
		writeText(valueField, value);
		return this;
	}
	
	public OtherCommercialsTermsObjects setBillingCycle(String billingCycleYear, String billingCycleMonth, String billingCycleDay) {
		selectDate(billingCycleField, billingCycleYear, billingCycleMonth, billingCycleDay);
		return this;
	}
	
	public OtherCommercialsTermsObjects setEarlyPaymentDiscount(String clause, String referenceNo, String relatedRefNo, String percentage, String value,String billingCycleYear, String billingCycleMonth, String billingCycleDay, String fromYear, String fromMonth, String fromDay,String toYear, String toMonth, String toDay,String status) {
		setClause(clause);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		setPercentage(percentage);
		setValue(value);
		setBillingCycle(billingCycleYear, billingCycleMonth, billingCycleDay);
		setDateFrom(fromYear, fromMonth, fromDay);
		setDateTo(toYear, toMonth, toDay);
		setStatus(status);
		return this;
	}
	
	public OtherCommercialsTermsObjects setInvoiceDate(String invoiceYear, String invoiceMonth, String invoiceDay) {
		selectDate(invoiceDateField, invoiceYear, invoiceMonth, invoiceDay);
		return this;
	}	

	public OtherCommercialsTermsObjects setCurrency(String currency) {
		selectDropdownOption(currencyDropDown, currency);
		return this;
	}
	
	public OtherCommercialsTermsObjects setPenaltyValue(String penaltyValue) {
		writeText(penaltyValueField, penaltyValue);
		return this;
	}
	
	public OtherCommercialsTermsObjects setLatePaymentFee(String clause, String referenceNo, String relatedRefNo,String invoiceYear, String invoiceMonth, String invoiceDay,String noticePeriodValue, String noticePeriodType, String currency, String penaltyValue, String status) {
		setClause(clause);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		setInvoiceDate(invoiceYear, invoiceMonth, invoiceDay);
		setNoticePeriod(noticePeriodValue);
		setNoticePeriodType(noticePeriodType);
		setCurrency(currency);
		setPenaltyValue(penaltyValue);
		setStatus(status);
		return this;
	}
	
	public OtherCommercialsTermsObjects setTerm(String term) {
		selectDropdownOption(termDropDown, term);
		return this;
	}
	
	public OtherCommercialsTermsObjects setTermination(String clause, String type, String noticePeriodValue, String noticePeriodType, String term, String status, String referenceNo, String fromYear, String fromMonth, String fromDay, String toYear, String toMonth, String toDay, String currency, String value) {
		setClause(clause);
		setType(type);
		setNoticePeriod(noticePeriodValue);
		setNoticePeriodType(noticePeriodType);
		setTerm(term);
		setStatus(status);
		setReferenceNo(referenceNo);
		setDateFrom(fromYear, fromMonth, fromDay);
		setDateTo(toYear, toMonth, toDay);
		setCurrency(currency);
		setValue(value);
		return this;
	}	
	
	public OtherCommercialsTermsObjects setLimitationOfLiability(String clause, String type, String currency, String value, String referenceNo) {
		setClause(clause);
		setType(type);
		setCurrency(currency);
		setValue(value);
		setReferenceNo(referenceNo);		
		return this;
	}	

}
