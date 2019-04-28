package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.InputData;

public class GeneralInfromationObjects {

	WebDriver driver ;
	WebDriverWait myWait ;
	InputData input ;


	@FindBy(xpath = "//div[@class='mat-tab-label-content'][contains(text(),'General Information')]")
	WebElement generalInformationTab ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedContractCategory']")
	WebElement categoryDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedContractSubcategory']")
	WebElement subCategoryDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedBusinessPartner']")
	WebElement businessPartnerDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='contractTitle']")
	WebElement contractTitleField ;

	@FindBy(xpath = "//input[@formcontrolname='location']")
	WebElement locationField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='currencyType']")
	WebElement currencyTypeDropDown ;

	@FindBy(xpath = "//input[@formcontrolname='contractValue']")
	WebElement contractValueField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedLegalEntity']")
	WebElement legalEntityDropDown ;

	@FindBy(id="cancel")
	WebElement cancelButton ;

	@FindBy(id="saveAndContinueContractButton")
	WebElement saveAndContinueButton ;

	public GeneralInfromationObjects (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void setCategory(String category) {
		input = new InputData(driver);
		input.setDropDown(categoryDropDown, category);
	}

	public void setSubCategory(String subCategory) {
		input = new InputData(driver);
		input.setDropDown(subCategoryDropDown, subCategory);
	}

	public void setBusinessPartner(String businessPartner) {
		input = new InputData(driver);
		input.setDropDown(businessPartnerDropDown, businessPartner);
	}

	public void setContractTitle(String contractTitle) {
		input = new InputData(driver);
		input.setDataField(contractTitleField, contractTitle);
	}

	public void setLocation(String location) {
		input = new InputData(driver);
		input.setLocationField(locationField, location);
	}

	public void setCurrencyType(String currencyType) {
		input = new InputData(driver);
		input.setDropDown(currencyTypeDropDown, currencyType);	
	}

	public void setContractValue(String contractValue) {
		input = new InputData(driver);
		input.setDataField(contractValueField, contractValue);
	}

	public void setLegalEntity(String legalEntity) {
		input = new InputData(driver);
		input.setDropDown(legalEntityDropDown, legalEntity);
	}

	public void clickCancelButton() {
		input = new InputData(driver);
		input.clickButton(cancelButton);
	}

	public void clickSaveAndContinueButton() {
		input = new InputData(driver);
		input.clickButton(saveAndContinueButton);
	}
	
	public void setGeneralInfromation(String category, String subCategory, String businessPartner, String contractTitle, String location, String currencyType, String contractValue, String legalEntity) {
		setCategory(category);
		setSubCategory(subCategory);
		setBusinessPartner(businessPartner);
		setContractTitle(contractTitle);
		setLocation(location);
		setCurrencyType(currencyType);
		setContractValue(contractValue);
		setLegalEntity(legalEntity);
		//clickSaveAndContinueButton();
	}
}
