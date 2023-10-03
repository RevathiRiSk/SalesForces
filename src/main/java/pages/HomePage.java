package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Sales_BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);

	}
	

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	private WebElement btn_menu;

	@FindBy(xpath = "//button[text()='View All']")
	private WebElement btn_view;

	public HomePage clickOnToggle() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_menu));
		btn_menu.click();
		return this;

	}

	public AppLauncherPage clickOnViewAll() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_view));
		btn_view.click();
		AppLauncherPage appP = new AppLauncherPage(driver);
		PageFactory.initElements(driver, appP);
		return appP;
	}
	


}
