package pageTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.DashboardObjects;
import pageObjects.HomepageObjects;
import pageObjects.NotificationObjects;


public class NotificationPageTests extends BaseTest {

	HomepageObjects homepage ;
	DashboardObjects dashboard ;
	NotificationObjects notification ;

	@BeforeClass
	public void intializeClassObjects() {
		homepage = new HomepageObjects(driver) ;	
		dashboard = new DashboardObjects(driver) ;
		notification = new NotificationObjects(driver) ;
	}

	@Test(priority = 0, enabled = true)
	public void loginTest() {
		homepage.gotoHomepage();
		homepage.doLogin("subh", "Pa$$w0rd")
		.verifyLandingPage();
	}

	@Test(priority = 1, enabled = true)
	public void gotoNotificationPage() {
		dashboard.clickNotificationLink() ;
		notification.verifyLandingPage() ; 				 
	}

	@Test(priority = 2, enabled = true)
	public void addSimpleNotification() {
		notification.clickAddButton()
		.setSimpleNotification("Simple Notification", "HUG", "End Date", "2019", "JAN", "January 1, 2019", "Dry Sign", "Automation") 
		.clickSaveButton()
		.verifySuccessToaster("Notification successfully added\n" + "Operation Success");
	}
	
	@Test(priority = 3, enabled = true)
	public void addActiveReminderNotification() {
		dashboard.clickNotificationLink() ;
		notification.clickAddButton()
		.setActiveReminderNotification("Active Reminder Notification", "HUG", "End Date", "2019", "JAN", "January 1, 2019", "Early Salary", "Automation", "Yes", "2", "Week", "2019", "MAR", "March 1, 2019", "2019", "APR", "April 1, 2019", "Active", "subh", "", "", "Daily") 
		.clickSaveButton()
		.verifySuccessToaster("Notification successfully added\n" + "Operation Success");
	}
	
	@Test(priority = 4, enabled = true)
	public void addOverdueReminderNotification() {
		dashboard.clickNotificationLink() ;
		notification.clickAddButton()
		.setActiveReminderNotification("Overdue Reminder Notification", "HUG", "End Date", "2019", "JAN", "January 1, 2019", "Early Salary", "Automation", "Yes", "2", "Week", "2019", "MAR", "March 1, 2019", "2019", "APR", "April 1, 2019", "Overdue", "subh", "", "", "Three Days") 
		.clickSaveButton()
		.verifySuccessToaster("Notification successfully added\n" + "Operation Success");
	}
	
	@Test(priority = 5, enabled = true)
	public void addDismissedReminderNotification() {
		dashboard.clickNotificationLink() ;
		notification.clickAddButton()
		.setActiveReminderNotification("Dismissed Reminder Notification", "HUG", "End Date", "2019", "JAN", "January 1, 2019", "Early Salary", "Automation", "Yes", "2", "Week", "2019", "MAR", "March 1, 2019", "2019", "APR", "April 1, 2019", "Dismissed", "subh", "", "", "Once a week") 
		.clickSaveButton()
		.verifySuccessToaster("Notification successfully added\n" + "Operation Success");
	}
	
	@Test(priority = 6, enabled = true)
	public void addReminderNotificationWithEveryTwoWeeksFrequency() {
		dashboard.clickNotificationLink() ;
		notification.clickAddButton()
		.setActiveReminderNotification("Every Two Week Frequency Reminder Notification", "HUG", "End Date", "2019", "JAN", "January 1, 2019", "Early Salary", "Automation", "Yes", "2", "Week", "2019", "MAR", "March 1, 2019", "2019", "APR", "April 1, 2019", "Active", "subh", "", "", "Every two weeks") 
		.clickSaveButton()
		.verifySuccessToaster("Notification successfully added\n" + "Operation Success");
	}
	
	@Test(priority = 7, enabled = true)
	public void addReminderNotificationWithEveryMonthFrequency() {
		dashboard.clickNotificationLink() ;
		notification.clickAddButton()
		.setActiveReminderNotification("Every Months Reminder Notification", "HUG", "End Date", "2019", "JAN", "January 1, 2019", "Early Salary", "Automation", "Yes", "2", "Week", "2019", "MAR", "March 1, 2019", "2019", "APR", "April 1, 2019", "Active", "subh", "", "", "Every month") 
		.clickSaveButton()
		.verifySuccessToaster("Notification successfully added\n" + "Operation Success");
	}
}
