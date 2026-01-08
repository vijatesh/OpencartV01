package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",  dataProviderClass=DataProviders.class, groups="Datadriven")    // getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("***Stating TC_03_LoginDDT***");
		
		try
		{
		        //HomePage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//Login
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//MyAccount
				MyAccountPage mac=new MyAccountPage(driver);
				boolean targetPage=mac.isMyAccountPageExists();
				
				/*
				Data is valid - login success - test pass - logout
				              - login failed  - test fail
				 */               
				
				if(exp.equalsIgnoreCase("Valid"))   //  This will ignore the case whether the letters are capital or smaller 
				{
					if(targetPage==true)
					{
						mac.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
		
				/*
				Data is invalid - login success - test fail - logout
                - login failed  - test pass
                */
				
				if(exp.equalsIgnoreCase("Invalid"))   //  This will ignore the case whether the letters are capital or smaller 
				{
					if(targetPage==true)
					{
						mac.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		Thread.sleep(5000);
		logger.info("***Finished TC_03_LoginDDT***");
	}

	
}
