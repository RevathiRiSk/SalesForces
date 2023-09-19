package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPage extends Sales_BaseClass {


	public EditPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//button[contains(@aria-label, 'Type')]")
	private WebElement click_type;
	
	@FindBy(xpath = "//span[text()='Technology Partner']")
	private WebElement select_type;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Industry')]")
	private WebElement click_industry;
	
	@FindBy(xpath = "//span[text()='Healthcare']")
	private WebElement select_industry;
	
	@FindBy(xpath = "//textarea[@name='street']")
	private WebElement input_billingAddress;
	
	@FindBy(xpath = "(//textarea[@name='street'])[2]")
	private WebElement input_shippingAddress;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Customer Priority')]")
	private WebElement click_priority;
	
	@FindBy(xpath = "//span[text()='Low']")
	private WebElement select_priority;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'SLA')]")
	private WebElement click_SLA;
	
	@FindBy(xpath = "//span[text()='Silver']")
	private WebElement select_SLA;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Active')]")
	private WebElement click_active;
	
	@FindBy(xpath = "(//span[text()='No'])[3]")
	private WebElement select_active;
	
	@FindBy(xpath = "//input[@name='Phone']")
	private WebElement inputPhone;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Upsell Opportunity')]")
	private WebElement click_opportunity;
	
	@FindBy(xpath = "//span[text()='No']")
	private WebElement select_opportunity;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btn_save;

	
	public EditPage clickType() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_type));
		click_type.click();
		return this;
	}
	
	public EditPage selectType() {
		select_type.click();
		return this;
	}
	
	public EditPage clickIndustry() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_industry));
		click_industry.click();
		return this;
	}
	
	public EditPage selectIndustry() {
		select_industry.click();
		return this;
	}
	
	public EditPage enterBillingAddress(String address) {
		input_billingAddress.sendKeys(address);
		return this;
	}
	
	public EditPage enterShippingAddress(String address) {
		input_shippingAddress.sendKeys(address);
		return this;
	}
	
	public EditPage clickPriority() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_priority));
		click_priority.click();
		return this;
	}
	
	public EditPage selectPriority() {
		select_priority.click();
		return this;
	}
	
	public EditPage clickSLA() {
		click_SLA.click();
		return this;
	}
	
	public EditPage selectSLA() {
		select_SLA.click();
		return this;
	}
	
	public EditPage clickActive() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_active));
		click_active.click();
		return this;
	}
	
	public EditPage selectActive() {
		select_active.click();
		return this;
	}
	
	public EditPage enterPhone(String number) {
		inputPhone.sendKeys(number);
		return this;
	}
	
	public EditPage clickOpportunity() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_opportunity));
		click_opportunity.click();
		return this;
	}
	
	public EditPage selectOpportunity() {
		select_opportunity.click();
		return this;
	}
	
	public void clickSave() {
		btn_save.click();
		
	}
}
