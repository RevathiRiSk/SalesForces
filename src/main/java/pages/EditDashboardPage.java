package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditDashboardPage extends Sales_BaseClass {

	private static final NamedDashboardPage NamedDashboardPage = null;


	public EditDashboardPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//button[contains(@class,'editProperties')]")
	private WebElement btn_editProperty;
	
	@FindBy(id = "dashboardDescriptionInput")
	private WebElement input_descripition;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btn_save;
	
	@FindBy(id = "dismissError")
	private WebElement btn_dismiss;
	
	
	public void click_editProperty() throws InterruptedException {
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame1);
		btn_editProperty.click();
		Thread.sleep(3000);
		
	}
	
	
	public EditDashboardPage enterDescripition(String detail) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(input_descripition));
		input_descripition.sendKeys(detail);
		return this;
	}
	
	public NamedDashboardPage click_saveEdit() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_save));
		btn_save.click();
		return NamedDashboardPage;
	}
	
	public EditDashboardPage click_Errordismiss() {
		btn_dismiss.click();
		return this;
	}
}
