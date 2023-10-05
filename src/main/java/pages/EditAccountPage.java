package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAccountPage extends Sales_BaseClass {


	public EditAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//button[contains(@aria-label, 'Type')]")
	private WebElement lblType;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Industry')]")
	private WebElement lblIndustry;
	
	@FindBy(xpath = "//textarea[@name='street']")
	private WebElement input_billingAddress;
	
	@FindBy(xpath = "(//textarea[@name='street'])[2]")
	private WebElement input_shippingAddress;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Customer Priority')]")
	private WebElement lblPriority;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'SLA')]")
	private WebElement lbl_SLA;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Active')]")
	private WebElement lbl_active;
	
	@FindBy(xpath = "//input[@name='Phone']")
	private WebElement inputPhone;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Upsell Opportunity')]")
	private WebElement lbl_opportunity;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btn_save;
	
	
	
	public EditAccountPage selectType(String input) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(lblType));
		lblType.click();
		String xpathInput = "//span[text()='"+input+"']";
		driver.findElement(By.xpath(xpathInput)).click();
		return this;
	}
	

	public EditAccountPage selectIndustry(String input) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(lblIndustry));
		lblIndustry.click();
		String xpathInput = "//span[text()='"+input+"']";
		driver.findElement(By.xpath(xpathInput)).click();
		return this;
		
	}
	
	public EditAccountPage enterBillingAddress(String address) {
		input_billingAddress.sendKeys(address);
		return this;
	}
	
	public EditAccountPage enterShippingAddress(String address) {
		input_shippingAddress.sendKeys(address);
		return this;
	}
	
	
	public EditAccountPage selectPriority(String input) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(lblPriority));
		lblPriority.click();
		String xpathInput = "//span[text()='"+input+"']";
		driver.findElement(By.xpath(xpathInput)).click();
		return this;
	}
	
	
	public EditAccountPage selectSLA(String input) {
		lbl_SLA.click();
		String xpathInput = "//span[text()='"+input+"']";
		driver.findElement(By.xpath(xpathInput)).click();
		return this;
		
	}
	
	
	public EditAccountPage selectActive(String input) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lbl_active);
		lbl_active.click();
		String xpathInput = "(//span[text()='"+input+"'])[3]";
		driver.findElement(By.xpath(xpathInput)).click();
		return this;
	}
	
	public EditAccountPage enterPhone(String number) {
		inputPhone.clear();
		inputPhone.sendKeys(number);
		return this;
	}
	
	public EditAccountPage clickOpportunity() {
		
		return this;
	}
	
	public EditAccountPage selectOpportunity(String input) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lbl_opportunity);
		lbl_opportunity.click();
		String xpathInput = "//span[text()='"+input+"']";
		driver.findElement(By.xpath(xpathInput)).click();
		return this;
	}
	
	public AccountsPage clickSave() {
		btn_save.click();
		return new AccountsPage(driver);
		
	}
}
