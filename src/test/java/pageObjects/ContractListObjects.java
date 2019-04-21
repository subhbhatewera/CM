package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContractListObjects {

	WebDriver driver ;
	WebDriverWait myWait ;

	@FindBy(xpath = "//button[@class='cm-btn primary-btn']")
	WebElement addContractButton ;

	public ContractListObjects (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickAddContractsButton() {
		customWait(addContractButton);
		addContractButton.click();
	}
	
	public void clicEditContractIcon(String cTitle) {
		WebElement element  = driver.findElement(By.xpath("(//span[@title='"+cTitle+"']//following::i[@mattooltip='Edit'])[1]"));
		customWait(element);
		element.click();
	}

}
