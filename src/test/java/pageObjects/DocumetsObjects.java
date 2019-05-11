package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumetsObjects extends BasePage {

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Document')])[1]")
	WebElement documentsTab ;

	@FindBy(id = "addDocument")
	WebElement addDocumentButton ;
	
	@FindBy(xpath = "//input[@formcontrolname='inputDocumentTitle']")
	WebElement docNameField ;

	@FindBy(xpath = "//mat-select[@placeholder='Contract Type']")
	WebElement contractTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Upload Date']]")
	WebElement uploadDateField ;

	@FindBy(xpath = "//input[@placeholder='Signed Date']")
	WebElement signedDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Status']")
	WebElement statusDropDown ;

	@FindBy(xpath = "//input[@placeholder='Attachments']")
	WebElement attachmentsField ;

	@FindBy(id = "cancel")
	WebElement cancelButton ;
	
	@FindBy(id = "saveDocumentButtonDialog")
	WebElement saveButton ;

	@FindBy(id = "saveAndContinueContractButton")
	WebElement submitButton ;	
	
	@FindBy(xpath = "(//i[@mattooltip='Edit'])[1]")
	WebElement editIcon ;
	
	@FindBy(xpath = "(//i[@mattooltip='Delete'])[1]")
	WebElement deleteIcon ;

	public DocumetsObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public DocumetsObjects gotoDocumentsTab() {
		clickElement(documentsTab);
		return this;
	}

	public DocumetsObjects clickAddDocumentButtion() {
		clickElement(addDocumentButton);
		return this;
	}
	
	public DocumetsObjects setContractType(String contractType) {
		selectDropdownOption(contractTypeDropDown, contractType);
		return this;
	}

	public DocumetsObjects setUploadDate(String uploadYear, String uploadMonth, String uploadDay) {
		selectDate(uploadDateField, uploadYear, uploadMonth, uploadDay);
		return this;
	}
	
	public DocumetsObjects setSignedDate(String signedYear, String signedMonth, String signedDay) {
		selectDate(signedDateField, signedYear, signedMonth, signedDay);
		return this;
	}
	
	public DocumetsObjects setStatus(String status) {
		selectDropdownOption(statusDropDown, status);
		return this;
	}
	
	public DocumetsObjects clickSaveButton() {
		clickElement(saveButton);
		return this;
	}
	
	public DocumetsObjects clickCancelButton() {
		clickElement(cancelButton);
		return this;
	}
	
	public DocumetsObjects clickSubmitButton() {
		clickElement(submitButton);
		return this;
	}

}
