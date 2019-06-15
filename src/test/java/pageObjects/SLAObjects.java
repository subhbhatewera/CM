package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SLAObjects extends BasePage {

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'SLA')])[1]")
	WebElement SLATab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'TAT')])[1]")
	WebElement TATTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Quality')])[1]")
	WebElement qualityTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Uptime')])[1]")
	WebElement uptimeTab ;

	@FindBy(xpath = "//textarea[@placeholder='Clause']")
	WebElement clauseField ;

	@FindBy(xpath = "//input[@placeholder='Reference No.']")
	WebElement referenceNoField ;

	@FindBy(xpath = "//input[@placeholder='Related Reference No.']")
	WebElement relatedReferenceNoField ;

	@FindBy(xpath = "//mat-select[@placeholder='Status']")
	WebElement statusDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='currency']")
	WebElement currencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Performance Pay']")
	WebElement performancePayField ;

	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Hours']")
	WebElement hoursField ;

	@FindBy(xpath = "//mat-radio-button[@value='YES']")
	WebElement yesRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='NO']")
	WebElement noRadioButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Cancel')]")
	WebElement cancelButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement saveAndContinueButton ;

	@FindBy(xpath = "//input[@placeholder='Pre Shipment']")
	WebElement preShipmentField ;

	@FindBy(xpath = "//input[@placeholder='CAL']")
	WebElement CALField ;

	@FindBy(xpath = "//input[@placeholder='Date Reported']")
	WebElement dateReportedField ;

	@FindBy(xpath = "//input[@placeholder='CQR']")
	WebElement CQRField ;
	
	@FindBy(xpath = "//input[@placeholder='Type']")
	WebElement typeField ;

	@FindBy(xpath = "//input[@placeholder='Uptime Hours']")
	WebElement uptimeHoursField ;		

	public SLAObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public SLAObjects gotoSLATab() {
		clickElement(SLATab);
		return this;
	}

	public SLAObjects gotoTATTab() {
		clickElement(TATTab);
		return this;
	}

	public SLAObjects gotoQualityTab() {
		clickElement(qualityTab);
		return this;
	}

	public SLAObjects gotoUptimeTab() {
		clickElement(uptimeTab);
		return this;
	}

	public SLAObjects setClause(String clause) {
		waitForClickable(clauseField);
		writeText(clauseField, clause);
		return this ;
	}

	public SLAObjects setReferenceNo(String referenceNo) {
		writeText(referenceNoField, referenceNo);
		return this ;
	}

	public SLAObjects setRelatedReferenceNo(String relatedReferenceNo) {
		writeText(relatedReferenceNoField, relatedReferenceNo);
		return this ;
	}

	public SLAObjects setStatus(String status) {
		selectDropdownOption(statusDropDown, status);
		return this ;
	}

	public SLAObjects setCurrency(String currency) {
		selectDropdownOption(currencyDropDown, currency);
		return this ;
	}

	public SLAObjects setPerfomancePay(String performancePay) {
		writeText(performancePayField, performancePay);
		return this ;
	}

	public SLAObjects setTypeDropDown(String type) {
		selectDropdownOption(typeDropDown, type);
		return this ;
	}

	public SLAObjects setHours(String hours) {
		writeText(hoursField, hours);
		return this ;
	}

	public SLAObjects clickRadioButton(String alertOption) {
		switch(alertOption) {
		case "Yes" :
			clickElement(yesRadioButton);
			break ;
		case "No" :
			clickElement(noRadioButton);
			break ;
		}
		return this ;
	}

	public SLAObjects clickCancelButton() {
		clickElement(cancelButton);
		return this ;
	}

	public SLAObjects clickSaveAndContinueButton() {
		clickElement(saveAndContinueButton);
		return this ;
	}

	public SLAObjects setTAT(String clause, String referenceNo, String relatedReferenceNo, String status, String currency, String performancePay, String type, String hours, String alertOption) {
		setClause(clause);
		setReferenceNo(referenceNo);
		setRelatedReferenceNo(relatedReferenceNo);
		setStatus(status);
		setCurrency(currency);
		setPerfomancePay(performancePay);
		setTypeDropDown(type);
		setHours(hours);
		clickRadioButton(alertOption);
		return this;
	}	

	public SLAObjects setPreShipment(String preShipment) {
		writeText(preShipmentField, preShipment);
		return this ;
	}

	public SLAObjects setCAL(String CAL) {
		writeText(CALField, CAL);
		return this ;
	}

	public SLAObjects setDateReported(String reportedYear, String reportedMonth, String reportedDay) {
		selectDate(dateReportedField, reportedYear, reportedMonth, reportedDay);
		return this ;
	}

	public SLAObjects setCQR(String CQR) {
		writeText(CQRField, CQR);
		return this ;
	}
	
	public SLAObjects setTypeField(String type) {
		writeText(typeField, type);
		return this ;
	}

	public SLAObjects setQuality(String clause, String referenceNo, String relatedReferenceNo, String status, String preShipment, String CAL, String reportedYear, String reportedMonth, String reportedDay, String CQR, String type, String currency, String performancePay, String alertOption) {
		setClause(clause);
		setReferenceNo(referenceNo);
		setRelatedReferenceNo(relatedReferenceNo);
		setStatus(status);
		setPreShipment(preShipment);
		setCAL(CAL);
		setDateReported(reportedYear, reportedMonth, reportedDay);
		setCQR(CQR);
		setTypeField(type);
		setCurrency(currency);
		setPerfomancePay(performancePay);
		clickRadioButton(alertOption);
		return this;
	}

	public SLAObjects setUptimeHours(String uptimeHours) {
		writeText(uptimeHoursField, uptimeHours);
		return this ;
	}

	public SLAObjects setUptime(String clause, String referenceNo, String relatedReferenceNo, String status, String uptimeHours, String type, String currency, String performancePay, String alertOption) {
		setClause(clause);
		setReferenceNo(referenceNo);
		setRelatedReferenceNo(relatedReferenceNo);
		setStatus(status);
		setUptimeHours(uptimeHours);
		setTypeField(type);
		setCurrency(currency);
		setPerfomancePay(performancePay);
		clickRadioButton(alertOption);
		return this;
	}
}