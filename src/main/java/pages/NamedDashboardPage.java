package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NamedDashboardPage extends Sales_BaseClass {

	private static final DashboardsPage DashboardsPage = null;


	public NamedDashboardPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath= "//button[text()='Done']")
	private WebElement btn_done;
	
	@FindBy(id = "dismissError")
	private WebElement btn_dismiss;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btn_save;
		
	public NamedDashboardPage click_Errordismiss() {
		btn_dismiss.click();
		return this;
	}
	
	/*public NamedDashboardPage click_done() {
		//WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		//driver.switchTo().frame(0);
		btn_done.click();
		return this;
	}*/
	
	public DashboardsPage click_save() {
		WebElement frame1 = driver.findElement(By.xpath("(//iframe[@title='dashboard'])[3]"));
		driver.switchTo().frame(frame1);
		btn_save.click();
		return DashboardsPage;
	}
}
