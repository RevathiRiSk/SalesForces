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

	@Test
	public void TC001_createAccountsTest() {
		String accountName = "Revathi";
		LoginPage loginP = LoginPage.initialize(driver);
		HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage appLauncherP = homeP.clickOnToggle().clickOnViewAll();
		SalesHomePage salesHomeP = appLauncherP.clickOnSales();
		AccountsPage accP = salesHomeP.clickOnAccounts();
		CreateAccountPage createAccP = accP.clickOnNew();
		createAccP.enterAccountName(accountName).selectOwnershipAsPublic();
		createAccP.clickOnSave();
		accP = salesHomeP.clickOnAccounts();
		String accountNameActual =  accP.getLastCreatedAccountName();
		Assert.assertEquals(accountNameActual, accountName);
		
	}
}