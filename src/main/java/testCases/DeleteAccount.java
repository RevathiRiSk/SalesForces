package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.AppLauncherPage;
import pages.SalesHomePage;

public class DeleteAccount extends BaseTest{

	
	@Test
	public void TC003_deleteAccountTest() throws InterruptedException {
		
		String accountName = "Duplicate";
		String expectedResult = "No items to display.";
/*		LoginPage loginP = LoginPage.initialize(driver);
		HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
*/		AppLauncherPage appP = homeP.clickOnToggle().clickOnViewAll();
		SalesHomePage salesP = appP.clickOnSales();
		AccountsPage accP = salesP.clickOnAccounts().inputInSearch(accountName).clickDropDown().clickDelete().confrm_delete();
		String actualResult = accP.getdelete_msg();
		System.out.println("Actual Result: " + actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
}
