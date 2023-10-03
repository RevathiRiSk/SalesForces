package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends Sales_BaseClass {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//input[@class='slds-input'])[2]")
	private WebElement inputAccountName;

	@FindBy(xpath = "//button[contains(@aria-label, 'Ownership')]")
	private WebElement btnOwnership;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btn_save;

	public CreateAccountPage enterAccountName(String accountName) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(inputAccountName));
		inputAccountName.sendKeys(accountName);
		return this;
	}
	
	public CreateAccountPage selectOwnership(String input) {
		new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(btnOwnership));
		btnOwnership.click();
		String xpathInput = "//span[text()='"+input+"']";
		driver.findElement(By.xpath(xpathInput)).click();
		return this;
	}

	public void clickOnSave() {
		btn_save.click();
	}

}
