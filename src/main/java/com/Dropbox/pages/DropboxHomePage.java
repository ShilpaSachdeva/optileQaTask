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
public class DropboxHomePage extends BasicOperations {

	public DropboxHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	// Using page factory FindBy method to find all the elements in this page
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
		// Defining all the user actions (Methods) that can be performed in this page
	
	public void clickSignInLink(WebDriver driver) throws Exception {
		WaitUtils.waitTillElementVisible(driver, signInLink);
		signInLink.click();
		
		
	}
	
}
