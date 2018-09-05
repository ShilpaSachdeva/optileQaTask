package com.Dropbox.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import utils.TestDataProvider;

/**
 * @author Shilpa Sachdeva
 *
 */
public class DroboxTestCases extends BaseScenarios {

	@Test(priority = 0)
	public void verifyBlankEmailIdError() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 1 :: Verify Blank Email Id Error");
			logger.info("Opening dropbox");
			String actualURLHomePage = driver.getCurrentUrl();
			if (configProperty.getProperty("baseUrl") == actualURLHomePage) {
				logger.pass("Dropbox base URL is validated");
			}
			
			String strPassword= "Random";
			logger.info("Click on Signin to an account");			
			homepage.clickSignInLink(driver);
			logger.info("Enter Blank email and some random password");	
			if (loginpage.verifyBlankEmail(driver, strPassword).contains("Please enter your email")) {
				logger.pass("Blank Email Id error is validated");
			}
			else{
				logger.fail("Blank Email Id error is not validated");
			}

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	

	@Test(priority = 1)
	public void verifyInvalidEmailPasswordError() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 2 :: Verify Invalid Email Id and Password Error");

			String strEmailId = "shilpa.sachdeva@gmail.com";
			String strPassword = "Invalid";

			logger.info("Enter Invalid Email and Password");
			loginpage.login(driver, strEmailId, strPassword);
			if (loginpage.getEmailErrorText(driver).contains("Invalid email or password")) {
				logger.pass("Invalid Email password error is validated");
			}
			else{
				logger.fail("Invalid Email password error is not validated");
			}

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 2, dataProvider = "getData", dataProviderClass = TestDataProvider.class, enabled = true)
	public void verifyDropboxLogin(String strEmailId, String strPassword) throws Exception {
		try {
			logger = report.createTest("Test case Id :: 3 :: Verify Successful Login");

			logger.info("Login dropbox with valid emailid and Password");
			loginpage.login(driver, strEmailId, strPassword);

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 4, dependsOnMethods = { "verifyDropboxLogin" })
	public void verifyCreateFolder() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 5 :: Verify Successful Create Folder");
			logger.info("Creating New Folder");
			activitypage.createFolder(driver);
			if (activitypage.checkFolderIsCreated()) {
				logger.pass("Folder is created successfuly");
			}
			else{
				logger.fail("Folder is not created successfuly");
			}

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 3, dependsOnMethods = { "verifyDropboxLogin" })
	public void verifyDropboxUpload() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 4 :: Verify Successful Upload");
			logger.info("Uploading file");
			activitypage.uploadFile(driver);
			if (activitypage.checkFileIsCreated()) {
				logger.pass("File is uploaded successfuly");
			}
			else{
				logger.fail("File is not uploaded successfuly");
			}

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 5, dependsOnMethods = { "verifyDropboxLogin" })
	public void verifyDrobboxLogout() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 6 :: Verify Successful Logout");
			logger.info("Logout Dropbox");
			activitypage.logout(driver);

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

}