package com.Dropbox.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.utils.WaitUtils;
/**
 * @author Shilpa Sachdeva
 *
 */
public class DropboxActivitypage extends BasicOperations {

	public DropboxActivitypage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	// Using page factory FindBy method to find all the elements in this page

	@FindBy(linkText = "Files")
	private WebElement files;

	@FindBy(xpath = "//button[contains(., 'Files')]")
	private WebElement uploadfiles;

	@FindBy(className = "uee-AppActionsView-SecondaryActionMenu-text-new-folder")
	private WebElement createNewFolder;

	@FindBy(xpath = "//button[contains(., 'Upload')]")
	private WebElement upload;

	@FindBy(className = "mc-avatar-image")
	private WebElement account;

	@FindBy(linkText = "Sign out")
	private WebElement signOut;

	@FindBy(className = "brws-file-name-element")
	private List<WebElement> folderLocator;

	// Defining all the user actions (Methods) that can be performed in this
	// page

	public void uploadFile(WebDriver driver) {
		try {
			Thread.sleep(2000);
			files.click();
			upload.click();
			uploadfiles.click();

			String currentDir = new java.io.File(".").getCanonicalPath();

			String pathSeparator = File.separator;
			StringSelection stringSelection = new StringSelection(
					currentDir + pathSeparator + "inputFile" + pathSeparator + "TestData.xlsx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();

			String os = System.getProperty("os.name").toLowerCase();

			if (os.contains("mac")) {
				// “Go To Folder” on Mac - Hit Command+Shift+G on a Finder
				// window.
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_META);

				// Paste the clipBoard content - Command ⌘ + V.
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_META);

				// Press Enter (GO - To bring up the file.)
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

			}

			else if (os.contains("windows")) {

				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

			}

			robot.delay(1000 * 3);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000 * 10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createFolder(WebDriver driver) {
		try {
			Thread.sleep(2000);
			files.click();
			WaitUtils.waitTillElementVisible(driver, createNewFolder);
			createNewFolder.click();
			String strFolderName = "TestData";
			StringSelection stringSelection = new StringSelection(strFolderName);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();

			String os = System.getProperty("os.name").toLowerCase();

			if (os.contains("mac")) {
				// Paste the clipBoard content - Command ⌘ + V.
				robot.keyPress(KeyEvent.VK_META);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_META);
			}

			else if (os.contains("windows")) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

			}

			robot.delay(1000 * 4);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.delay(1000 * 10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickFiles() {
		WaitUtils.waitTillElementVisible(driver, files);
		files.click();
	}

	public void logout(WebDriver driver) {
		account.click();
		WaitUtils.waitTillElementVisible(driver, signOut);
		signOut.click();
	}

	public boolean checkFolderIsCreated() {
		boolean flag = false;
		String strFolderName = "TestData";
		for (WebElement element : folderLocator) {
			if (element.getText().contains(strFolderName))
				flag = true;
		}
		return flag;
	}

	public boolean checkFileIsCreated() {
		boolean flag = false;
		String strFileName = "TestData.xlsx";
		for (WebElement element : folderLocator) {
			if (element.getText().contains(strFileName))
				flag = true;
		}
		return flag;
	}

}
