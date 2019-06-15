package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractListObjects extends BasePage{


	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Contract List')]")
	WebElement heading ;

	@FindBy(xpath = "//button[@class='cm-btn primary-btn']")
	WebElement addContractButton ;

	public ContractListObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ContractListObjects verifyLandingPage(){
		assertEquals(heading, "Contract List");
		return this ;
	}	

	public ContractListObjects clickAddContractButton() {
		clickElement(addContractButton);
		return this;
	}

	public void clickEditContractIcon(String contractTitle) {
		try {
		WebElement element = driver.findElement(By.xpath("(//span[@title='"+contractTitle+"']//following::i[@mattooltip='Edit'])[1]"));
		Thread.sleep(1000);
		clickElement(element);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void clickEditContractIcon1(String contractTitle) {
		try {
			Thread.sleep(1000);
			WebElement element  = driver.findElement(By.xpath("(//span[@title='"+contractTitle+"']//following::i[@mattooltip='Edit'])[1]"));
			waitFor(element);
			System.out.println(element.isDisplayed());
			element.click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
