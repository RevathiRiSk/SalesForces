package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sales_BaseClass {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public Sales_BaseClass(WebDriver driver) {
		this.driver = driver;
		// new WebDriverWait(driver, 10).wait()
	}

}
