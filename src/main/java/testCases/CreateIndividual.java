package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.CreateIndividualPage;
import pages.IndividualsPage;

public class CreateIndividual extends BaseTest{

	@Test
	public void TC009_createIndividual() throws InterruptedException {
		
		String lastname = "Kumar";
		
		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage appLauncherP = homeP.clickOnToggle().clickOnViewAll();
		IndividualsPage individualP = appLauncherP.clickIndividuals();
		CreateIndividualPage createIndividualP = individualP.click_IndividualDD().click_Newindividual();
		createIndividualP.inputLastName(lastname).clickSave();
		String actualName =  individualP.getLastCreatedName();
		System.out.println("Actual Result: " + actualName);
		Assert.assertEquals(actualName, lastname);
	}
}
