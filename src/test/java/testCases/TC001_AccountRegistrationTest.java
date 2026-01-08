package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***Starting Test case 1***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Clicked on MyAccount Link...");
		
		AccountRegistrationPage regPg=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regPg.setFirstName(randomString().toUpperCase());
		regPg.setLastName(randomString().toUpperCase());
		regPg.setEmail(randomString()+"@gmail.com");        // randomly generated email
		regPg.setTelephone(randomNumber());                 // randomly generated number
		
		String password=randomAlphaNumber();
		regPg.setPassword(password);
		regPg.setConfirmPassword(password);
		
		regPg.setPrivacyPolicy();
		regPg.clickContinue();
		
		logger.info("Validating expected message...");
		String confmsg=regPg.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("***Finished Test case 1***");
	}
	
	
}
