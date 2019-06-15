package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationObjects extends BasePage{


	@FindBy(xpath = "//div[@class='heading']")
	WebElement heading ;	

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Add')]")
	WebElement addButton ;

	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titleField ;

	@FindBy(xpath = "//mat-select[@placeholder='Business Partner']")
	WebElement businessPartnerDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Date']")
	WebElement dateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Linked contract information']")
	WebElement linkedContractInformationDropDown ;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement descriptionField ;

	@FindBy(xpath = "//mat-radio-button[@value='true']")
	WebElement yesRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='false']")
	WebElement noRadioButton ;

	@FindBy(xpath = "//input[@placeholder='Notice Period']")
	WebElement noticePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='noticePeriodType']")
	WebElement noticePeriodTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Reminder Start Date']")
	WebElement reminderStartDateField ;

	@FindBy(xpath = "//input[@placeholder='Reminder End Date']")
	WebElement reminderEndDateField ;

	@FindBy(xpath = "//mat-radio-button[@value='ACTIVE']")
	WebElement activeRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='OVERDUE']")
	WebElement overdueRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='DISMISSED']")
	WebElement dismissedRadioButton ;

	@FindBy(xpath = "//mat-select[@placeholder='Select Users']")
	WebElement selectUsersDropDown ;

	@FindBy(xpath = "//input[@placeholder='Add Alternate Email Address']")
	WebElement alternateEmailField ;

	@FindBy(xpath = "//input[@placeholder='Send Copy To']")
	WebElement sendCopyToField ;

	@FindBy(xpath = "//i[contains(@class,'plus-circle')]")
	WebElement plusIcon ;

	@FindBy(xpath = "//mat-radio-button[@value='DAILY']")
	WebElement dailyRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='THREE_DAYS']")
	WebElement threeDayRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='WEEKLY']")
	WebElement onceAWeekRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='TWO_WEEKS']")
	WebElement everyTwoWeekRadioButton ;

	@FindBy(xpath = "//mat-radio-button[@value='MONTHLY']")
	WebElement everyMonthRadioButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Cancel')]")
	WebElement cancelButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement saveButton ;


	public NotificationObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public NotificationObjects verifyLandingPage(){
		assertEquals(heading, "Notification");
		return this ;
	}	

	public NotificationObjects clickAddButton() {
		clickElement(addButton);
		return this;
	}

	public NotificationObjects setTitle(String title) {
		writeText(titleField, title) ;
		return this ;
	}

	public NotificationObjects setBusinessPartner(String businessPartner) {
		waitForClickable(businessPartnerDropDown);
		selectDropdownOption(businessPartnerDropDown, businessPartner) ;
		return this ;
	}

	public NotificationObjects setType(String type) {
		selectDropdownOption(typeDropDown, type) ;
		return this ;
	}

	public NotificationObjects setEventDate(String eventYear, String eventMonth, String eventDay) {
		selectDate(dateField, eventYear, eventMonth, eventDay);
		return this ;
	}

	public NotificationObjects setLinkedContractInformation(String linkedContractInformation) {
		selectDropdownOption(linkedContractInformationDropDown, linkedContractInformation) ;
		return this ;
	}

	public NotificationObjects setDescription(String description) {
		writeText(descriptionField, description) ;
		return this ;
	}

	public NotificationObjects setNoticePeriod(String noticePeriod) {
		writeText(noticePeriodField, noticePeriod) ;
		return this ;
	}

	public NotificationObjects setNoticePeriodType(String noticePeriodType) {
		selectDropdownOption(noticePeriodTypeDropDown, noticePeriodType) ;
		return this ;
	}

	public NotificationObjects setReminderStartDate(String reminderStartYear, String reminderStartMonth, String reminderStartDay) {
		selectDate(reminderStartDateField, reminderStartYear, reminderStartMonth, reminderStartDay);
		return this ;
	}

	public NotificationObjects setReminderEndDate(String reminderEndYear, String reminderEndMonth, String reminderEndDay) {
		selectDate(reminderEndDateField, reminderEndYear, reminderEndMonth, reminderEndDay);
		return this ;
	}

	public NotificationObjects selectReminderStatus(String reminderStatus) {
		if(reminderStatus.equalsIgnoreCase("Active")) {
			clickElement(activeRadioButton);
		}
		else if(reminderStatus.equalsIgnoreCase("Overdue")) {
			clickElement(overdueRadioButton);
		}
		else if(reminderStatus.equalsIgnoreCase("Dismissed")) {
			clickElement(dismissedRadioButton);
		}
		return this ;
	}

	public NotificationObjects selectSingleUser(String user) {
		selectDropdownOption(selectUsersDropDown, user) ;
		selectUsersDropDown.sendKeys(Keys.TAB);
		return this ;
	}

	public NotificationObjects setAlternateEmail(String alternateEmail) {
		writeText(alternateEmailField, alternateEmail) ;
		return this ;
	}

	public NotificationObjects setCopyToEmail(String CopyToEmail) {
		writeText(sendCopyToField, CopyToEmail) ;
		clickElement(plusIcon);
		return this ;
	}

	public NotificationObjects clickSaveButton() {
		scrollIntoView(saveButton);
		clickElement(saveButton) ;
		return this ;
	}

	public NotificationObjects clickCancelButton() {
		clickElement(cancelButton) ;
		return this ;
	}

	public NotificationObjects selectReminderFrequency(String reminderFrequency) {
		if(reminderFrequency.equalsIgnoreCase("Daily")) {
			scrollIntoView(dailyRadioButton);
			clickElement(dailyRadioButton);
		}
		else if(reminderFrequency.equalsIgnoreCase("Three days")) {
			scrollIntoView(dailyRadioButton);
			clickElement(threeDayRadioButton);
		}
		else if(reminderFrequency.equalsIgnoreCase("Once a week")) {
			scrollIntoView(dailyRadioButton);
			clickElement(onceAWeekRadioButton);
		}
		else if(reminderFrequency.equalsIgnoreCase("Every two weeks")) {
			scrollIntoView(dailyRadioButton);
			clickElement(everyTwoWeekRadioButton);
		}
		else if(reminderFrequency.equalsIgnoreCase("Every month")) {
			scrollIntoView(dailyRadioButton);
			clickElement(everyMonthRadioButton);
		}
		return this ;
	}

	public NotificationObjects setReminder(String reminder) {
		if(reminder.equalsIgnoreCase("Yes")) {
			clickElement(yesRadioButton);
		}
		else if (reminder.equalsIgnoreCase("No")) {
			clickElement(noRadioButton);
		}
		return this ;
	}

	public NotificationObjects setSimpleNotification(String title, String businessPartner, String type, String eventYear, String eventMonth, String eventDay, String linkedContractInformation, String description) {
		setTitle(title) ;
		setBusinessPartner(businessPartner) ;
		setType(type) ;
		setEventDate(eventYear, eventMonth, eventDay) ;
		setLinkedContractInformation(linkedContractInformation) ;
		setDescription(description) ;
		return this ;
	}

	public NotificationObjects setActiveReminderNotification(String title, String businessPartner, String type, String eventYear, String eventMonth, String eventDay, String linkedContractInformation, String description, String reminder, String noticePeriod, String noticePeriodType, String reminderStartYear, String reminderStartMonth, String reminderStartDay, String reminderEndYear, String reminderEndMonth, String reminderEndDay, String reminderStatus, String user, String alternateEmail, String CopyToEmail, String reminderFrequency) {
		setTitle(title) ;
		setBusinessPartner(businessPartner) ;
		setType(type) ;
		setEventDate(eventYear, eventMonth, eventDay) ;
		setLinkedContractInformation(linkedContractInformation) ;
		setDescription(description) ;
		setReminder(reminder) ;
		setNoticePeriod(noticePeriod) ;
		setNoticePeriodType(noticePeriodType) ;
		setReminderStartDate(reminderStartYear, reminderStartMonth, reminderStartDay) ;
		setReminderEndDate(reminderEndYear, reminderEndMonth, reminderEndDay) ;
		selectReminderStatus(reminderStatus) ;
		selectSingleUser(user) ;
		//setAlternateEmail(alternateEmail) ;
		//setCopyToEmail(CopyToEmail) ;
		selectReminderFrequency(reminderFrequency) ;		
		return this ;
	}

	public NotificationObjects setOverdueReminderNotification(String title, String businessPartner, String type, String eventYear, String eventMonth, String eventDay, String linkedContractInformation, String description, String reminder, String noticePeriod, String noticePeriodType, String reminderStartYear, String reminderStartMonth, String reminderStartDay, String reminderEndYear, String reminderEndMonth, String reminderEndDay, String reminderStatus, String user, String alternateEmail, String CopyToEmail, String reminderFrequency) {
		setTitle(title) ;
		setBusinessPartner(businessPartner) ;
		setType(type) ;
		setEventDate(eventYear, eventMonth, eventDay) ;
		setLinkedContractInformation(linkedContractInformation) ;
		setDescription(description) ;
		setReminder(reminder) ;
		setNoticePeriod(noticePeriod) ;
		setNoticePeriodType(noticePeriodType) ;
		setReminderStartDate(reminderStartYear, reminderStartMonth, reminderStartDay) ;
		setReminderEndDate(reminderEndYear, reminderEndMonth, reminderEndDay) ;
		selectReminderStatus(reminderStatus) ;
		selectSingleUser(user) ;
		//setAlternateEmail(alternateEmail) ;
		//setCopyToEmail(CopyToEmail) ;
		selectReminderFrequency(reminderFrequency) ;		
		return this ;
	}

	public NotificationObjects setDismissedReminderNotification(String title, String businessPartner, String type, String eventYear, String eventMonth, String eventDay, String linkedContractInformation, String description, String reminder, String noticePeriod, String noticePeriodType, String reminderStartYear, String reminderStartMonth, String reminderStartDay, String reminderEndYear, String reminderEndMonth, String reminderEndDay, String reminderStatus, String user, String alternateEmail, String CopyToEmail, String reminderFrequency) {
		setTitle(title) ;
		setBusinessPartner(businessPartner) ;
		setType(type) ;
		setEventDate(eventYear, eventMonth, eventDay) ;
		setLinkedContractInformation(linkedContractInformation) ;
		setDescription(description) ;
		setReminder(reminder) ;
		setNoticePeriod(noticePeriod) ;
		setNoticePeriodType(noticePeriodType) ;
		setReminderStartDate(reminderStartYear, reminderStartMonth, reminderStartDay) ;
		setReminderEndDate(reminderEndYear, reminderEndMonth, reminderEndDay) ;
		selectReminderStatus(reminderStatus) ;
		selectSingleUser(user) ;
		//setAlternateEmail(alternateEmail) ;
		//setCopyToEmail(CopyToEmail) ;
		selectReminderFrequency(reminderFrequency) ;		
		return this ;
	}



}
