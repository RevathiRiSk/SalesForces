package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.AppLauncherPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SalesHomePage;

public class CreateAccounts extends BaseTest {

	@BeforeTest
	public void setValue() {
		filename = "Accounts";
	}
	
	
	@Test(dataProvider = "fetchdata")
	public void TC001_createAccountsTest(String Name, String Oppurtunity) {
		
	//	LoginPage loginP = LoginPage.initialize(driver);
	//	HomePage homeP = new HomePage(driver);
		AppLauncherPage appLauncherP = homeP.clickOnToggle().clickOnViewAll();
		SalesHomePage salesHomeP = appLauncherP.clickOnSales();
		AccountsPage accP = salesHomeP.clickOnAccounts();
		CreateAccountPage createAccP = accP.clickOnNew();
		createAccP.enterAccountName(Name).selectOwnership(Oppurtunity);
		createAccP.clickOnSave();
		accP = salesHomeP.clickOnAccounts();
		String accountNameActual =  accP.getLastCreatedAccountName();
		System.out.println("Actual Result: " + accountNameActual);
		Assert.assertEquals(accountNameActual,Name);
		
	}
}
