package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver;
	public String filename;
	protected HomePage homeP;

	@DataProvider(name = "fetchdata")
	public String[][] sendData() {
		String[][] readExcel = ExcelUtility.readExcelData(filename);
		return readExcel;
	}

	@BeforeMethod
	public void preConditions() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage loginP = LoginPage.initialize(driver);
		homeP= loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
	
	}

	@AfterMethod

	public void afterMethod(ITestResult result) throws IOException {

		if (!result.isSuccess()) {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File src = screenShot.getScreenshotAs(OutputType.FILE);
			File destination = new File("./images/failures.png");
			FileUtils.copyFile(src, destination);

		}
	}

	public void postConditions() {
		driver.quit();
	}

}
