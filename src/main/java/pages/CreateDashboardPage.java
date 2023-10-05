package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDashboardPage extends Sales_BaseClass{

	public CreateDashboardPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//input[@id='dashboardNameInput']")
	private WebElement input_name;
	
	@FindBy(id ="submitBtn")
	private WebElement btn_create;

	public CreateDashboardPage enterName(String dashboard_name) throws InterruptedException {
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame1);
		
		//((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1];", input_name, dashboard_name);
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(input_name));
		input_name.sendKeys(dashboard_name);
		Thread.sleep(3000);
		return this;
	}
	
	public NamedDashboardPage clickCreate() {
		btn_create.click();
		NamedDashboardPage nameP = new NamedDashboardPage(driver);
		PageFactory.initElements(driver, nameP);
		return nameP;
	}
	
	
	
}
