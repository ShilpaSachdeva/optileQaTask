package com.Dropbox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.utils.WaitUtils;

/**
 * @author Shilpa Sachdeva
 *
 */
public class DropboxLoginPage extends BasicOperations {

	public DropboxLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "login_email")
	private WebElement emailId;

	@FindBy(name = "login_password")
	private WebElement password;

	@FindBy(className = "login-email")
	private WebElement emailError;

	@FindBy(className = "login-password")
	private WebElement passwordError;

	@FindBy(className = "signin-button")
	private WebElement signIn;

	public String getEmailErrorText(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WaitUtils.waitTillElementVisible(driver, emailError);
		return emailError.getText();
	}

	public void enterEmail(String strEmailId) {
		emailId.clear();
		emailId.sendKeys(strEmailId);

	}

	public void enterPassword(String strPassword) {
		password.clear();
		password.sendKeys(strPassword);
	}

	public String getPasswordErrorText(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WaitUtils.waitTillElementVisible(driver, passwordError);
		return passwordError.getText();
	}

	public void signInButtonclick(WebDriver driver) {
		WaitUtils.waitTillElementVisible(driver, signIn);
		signIn.click();
	}

	public void login(WebDriver driver, String strEmailId, String strPassword) {

		enterEmail(strEmailId);
		enterPassword(strPassword);
		WaitUtils.waitTillElementVisible(driver, signIn);
		signIn.click();
	}

	public String verifyBlankEmail(WebDriver driver, String strPassword) throws InterruptedException {
		emailId.clear();
		enterPassword(strPassword);
		WaitUtils.waitTillElementVisible(driver, signIn);
		signIn.click();
		return getEmailErrorText(driver);

	}

	

}
