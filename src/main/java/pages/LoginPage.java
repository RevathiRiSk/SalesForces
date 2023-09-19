package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Sales_BaseClass {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "username")
	private WebElement inputUserName;

	@FindBy(id = "password")
	private WebElement inputPassword;

	@FindBy(id = "Login")
	private WebElement btnClick;

	public void enterUserName(String userName) {
		inputUserName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnClick.click();
	}

	public static LoginPage initialize(WebDriver driver) {
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

	public HomePage loginWithValidCredentials(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickLogin();
		HomePage homeP = new HomePage(driver);
		PageFactory.initElements(driver, homeP);
		return homeP;
	}

}