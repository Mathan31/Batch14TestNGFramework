package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01_Login extends BaseClass{
	
	@Test(priority = 1)
	public void loginElementsValidation() {
		boolean result = new LoginPage().validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2)
	public void loginWithValidateCredential() {
		boolean result = new LoginPage()
		.enterUserName("Mathan")
		.enterPassword("Testing123")
		.clickOnSignInButton()
		.validateHomePage()
		.clickonLogout()
		.validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	//@Test(priority = 3)
	public void loginWithInValidateCredential() {
		
	}

}
