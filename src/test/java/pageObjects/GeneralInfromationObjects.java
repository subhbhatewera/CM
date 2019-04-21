package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralInfromationObjects {

	WebDriver driver ;
	WebDriverWait myWait ;

	
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
		try {
		customWait(categoryDropDown);
		categoryDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'"+category+"')]"));
		customWait(element);
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setSubCategory(String subCategory) {
		try
		{
		customWait(subCategoryDropDown);
		subCategoryDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'"+subCategory+"')]"));
		customWait(element);
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setBusinessPartner(String businessPartner) {
		try
		{
		customWait(businessPartnerDropDown);
		businessPartnerDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'"+businessPartner+"')]"));
		customWait(element);
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setContractTitle(String cTitle) {
		try
		{
		customWait(contractTitleField);
		contractTitleField.clear();
		contractTitleField.sendKeys(cTitle);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setLocation(String location) {
		try
		{
		customWait(locationField);
		locationField.clear();
		Thread.sleep(1000);
		locationField.sendKeys(location);
		locationField.sendKeys(Keys.ARROW_DOWN);
		locationField.sendKeys(Keys.ENTER);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setCurrencyType(String currencyType) {
		try
		{
		customWait(currencyTypeDropDown);
		currencyTypeDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'"+currencyType+"')]"));
		customWait(element);
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setContractValue(String contractValue) {
		try
		{
		customWait(contractValueField);
		contractValueField.clear();
		contractValueField.sendKeys(contractValue);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setLegalEntity(String legalEntity) {
		try
		{
		customWait(legalEntityDropDown);
		legalEntityDropDown.click();
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'"+legalEntity+"')]"));
		customWait(element);
		element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void setGeneralInformation(String category,String subCategory, String businessPartner, String cTitle, String location, String currencyType, String contractValue, String legalEntity) {
		setCategory(category);
		setSubCategory(subCategory);
		setBusinessPartner(businessPartner);
		setContractTitle(cTitle);
		setLocation(location);
		setCurrencyType(currencyType);
		setContractValue(contractValue);
		setLegalEntity(legalEntity);
	}
}
